package net.thefirstwriter.substrata.datagen;

//import net.thefirstwriter.substrata.worldgen.biome.SubSCaveBiomes;
import net.thefirstwriter.substrata.SubStrata;
import net.thefirstwriter.substrata.utils.SubsTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ForgeBiomeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SubSBiomeTagGenerator extends BiomeTagsProvider {
    public SubSBiomeTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SubStrata.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        var tagBuilder = this.tag(SubsTags.Biomes.IS_ROOTED_CAVES);

        // 1. Add Vanilla Biomes (Always Required)
        tagBuilder.add(Biomes.FOREST);
        tagBuilder.add(Biomes.FLOWER_FOREST);
        tagBuilder.add(Biomes.BIRCH_FOREST);
        tagBuilder.add(Biomes.DARK_FOREST);
        tagBuilder.add(Biomes.TAIGA);
        tagBuilder.add(Biomes.PLAINS);
        tagBuilder.add(Biomes.MEADOW);
        tagBuilder.add(Biomes.CHERRY_GROVE);
        tagBuilder.add(Biomes.SUNFLOWER_PLAINS);
        tagBuilder.add(Biomes.OLD_GROWTH_BIRCH_FOREST);
        tagBuilder.add(Biomes.OLD_GROWTH_PINE_TAIGA);
        tagBuilder.add(Biomes.OLD_GROWTH_SPRUCE_TAIGA);

        // Terralith
        addOptionalBiome(tagBuilder, "terralith", "alpine_grove");
        addOptionalBiome(tagBuilder, "terralith", "birch_taiga");
        addOptionalBiome(tagBuilder, "terralith", "lavender_forest");
        addOptionalBiome(tagBuilder, "terralith", "moonlight_grove");

        // Regions Unexplored
        addOptionalBiome(tagBuilder, "regions_unexplored", "deciduous_forest");
        addOptionalBiome(tagBuilder, "regions_unexplored", "maple_forest");
        addOptionalBiome(tagBuilder, "regions_unexplored", "flower_fields");
    }

    private void addOptionalBiome(TagAppender<Biome> tagBuilder, String modId, String biomeName) {
        ResourceKey<Biome> biomeKey = ResourceKey.create(
                net.minecraft.core.registries.Registries.BIOME,
                new ResourceLocation(modId, biomeName)
        );
        tagBuilder.addOptional(new ResourceLocation(modId, biomeName));
    }
}
