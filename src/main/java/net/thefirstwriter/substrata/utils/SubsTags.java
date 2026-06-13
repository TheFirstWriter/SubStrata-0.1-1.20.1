package net.thefirstwriter.substrata.utils;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.biome.Biome;
import net.thefirstwriter.substrata.SubStrata;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;


public class SubsTags {
    public static class Blocks {
        public static final TagKey<Block> ROOTED_CAVES_REPLACEABLE = tag("rooted_caves_replaceables");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(SubStrata.MOD_ID, name));
        }
    }
    public static class Biomes {
        public static final TagKey<Biome> IS_ROOTED_CAVES = tag("is_rooted_caves");
        public static final TagKey<Biome> IS_SURFACE_CAVES = tag("is_surface_caves");

        private static TagKey<Biome> tag(String name) {
            return TagKey.create(Registries.BIOME, new ResourceLocation(SubStrata.MOD_ID, name));}
    }
}
