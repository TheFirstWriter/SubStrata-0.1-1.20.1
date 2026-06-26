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
        var rootedCaves = this.tag(SubsTags.Biomes.IS_ROOTED_CAVES);
        rootedCaves.add(Biomes.FOREST);rootedCaves.add(Biomes.FLOWER_FOREST);rootedCaves.add(Biomes.BIRCH_FOREST);
        rootedCaves.add(Biomes.DARK_FOREST);rootedCaves.add(Biomes.TAIGA);rootedCaves.add(Biomes.PLAINS);
        rootedCaves.add(Biomes.MEADOW);rootedCaves.add(Biomes.CHERRY_GROVE);rootedCaves.add(Biomes.SUNFLOWER_PLAINS);
        rootedCaves.add(Biomes.OLD_GROWTH_BIRCH_FOREST);rootedCaves.add(Biomes.OLD_GROWTH_PINE_TAIGA);rootedCaves.add(Biomes.OLD_GROWTH_SPRUCE_TAIGA);

        // Terralith
        addOptionalBiome(rootedCaves, "terralith", "alpine_grove");addOptionalBiome(rootedCaves, "terralith", "birch_taiga");
        addOptionalBiome(rootedCaves, "terralith", "lavender_forest");addOptionalBiome(rootedCaves, "terralith", "moonlight_grove");

        // Regions Unexplored
        addOptionalBiome(rootedCaves, "regions_unexplored", "deciduous_forest");addOptionalBiome(rootedCaves, "regions_unexplored", "maple_forest");
        addOptionalBiome(rootedCaves, "regions_unexplored", "flower_fields");

        var andesiteRocks = this.tag(SubsTags.Biomes.IS_ANDESITE_ROCKS);
        andesiteRocks.add(Biomes.DARK_FOREST);andesiteRocks.add(Biomes.TAIGA);andesiteRocks.add(Biomes.MEADOW);
        andesiteRocks.add(Biomes.OLD_GROWTH_PINE_TAIGA);andesiteRocks.add(Biomes.OLD_GROWTH_SPRUCE_TAIGA);
        var calciteRocks = this.tag(SubsTags.Biomes.IS_CALCITE_ROCKS);
        calciteRocks.add(Biomes.BIRCH_FOREST);calciteRocks.add(Biomes.OLD_GROWTH_BIRCH_FOREST);calciteRocks.add(Biomes.MEADOW);calciteRocks.add(Biomes.CHERRY_GROVE);
        var dioriteRocks = this.tag(SubsTags.Biomes.IS_DIORITE_ROCKS);
        dioriteRocks.add(Biomes.BIRCH_FOREST);dioriteRocks.add(Biomes.OLD_GROWTH_BIRCH_FOREST);dioriteRocks.add(Biomes.PLAINS);dioriteRocks.add(Biomes.SUNFLOWER_PLAINS);
        var graniteRocks = this.tag(SubsTags.Biomes.IS_GRANITE_ROCKS);
        graniteRocks.add(Biomes.FOREST);graniteRocks.add(Biomes.FLOWER_FOREST);graniteRocks.add(Biomes.PLAINS);graniteRocks.add(Biomes.SUNFLOWER_PLAINS);
        var tuffRocks = this.tag(SubsTags.Biomes.IS_TUFF_ROCKS);
        tuffRocks.add(Biomes.DARK_FOREST);tuffRocks.add(Biomes.CHERRY_GROVE);
        var stoneRocks = this.tag(SubsTags.Biomes.IS_STONE_ROCKS);
        stoneRocks.add(Biomes.FOREST);stoneRocks.add(Biomes.FLOWER_FOREST);stoneRocks.add(Biomes.BIRCH_FOREST);stoneRocks.add(Biomes.DARK_FOREST);
        stoneRocks.add(Biomes.TAIGA);stoneRocks.add(Biomes.PLAINS);stoneRocks.add(Biomes.SUNFLOWER_PLAINS);stoneRocks.add(Biomes.OLD_GROWTH_BIRCH_FOREST);
        stoneRocks.add(Biomes.OLD_GROWTH_PINE_TAIGA);stoneRocks.add(Biomes.OLD_GROWTH_SPRUCE_TAIGA);
    }

    private void addOptionalBiome(TagAppender<Biome> tagBuilder, String modId, String biomeName) {
        ResourceKey<Biome> biomeKey = ResourceKey.create(
                net.minecraft.core.registries.Registries.BIOME,
                new ResourceLocation(modId, biomeName)
        );
        tagBuilder.addOptional(new ResourceLocation(modId, biomeName));
    }
}
