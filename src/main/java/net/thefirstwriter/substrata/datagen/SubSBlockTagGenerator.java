package net.thefirstwriter.substrata.datagen;

import net.minecraft.world.level.block.Blocks;
import net.thefirstwriter.substrata.SubStrata;
import net.thefirstwriter.substrata.utils.SubsTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SubSBlockTagGenerator extends BlockTagsProvider {
    public SubSBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SubStrata.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        this.tag(SubsTags.Blocks.ROOTED_CAVES_REPLACEABLE)
                .addTag(BlockTags.BASE_STONE_OVERWORLD)
                .add(Blocks.PACKED_MUD)
                .add(Blocks.COARSE_DIRT)
                .add(Blocks.DIRT);

    }
}
