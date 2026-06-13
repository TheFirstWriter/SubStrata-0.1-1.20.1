package net.thefirstwriter.substrata.datagen;

//import net.thefirstwriter.substrata.worldgen.biome.SubSCaveBiomes;
import net.minecraft.tags.BiomeTags;
import net.thefirstwriter.substrata.SubStrata;
import net.thefirstwriter.substrata.utils.SubsTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
//import net.minecraft.world.level.biome.Biome;
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
        this.tag(SubsTags.Biomes.IS_ROOTED_CAVES)
                .addTag(BiomeTags.IS_FOREST);

    }
}