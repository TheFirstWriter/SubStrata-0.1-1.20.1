package net.thefirstwriter.substrata.worldgen;

import net.minecraft.core.Direction;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.heightproviders.WeightedListHeight;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.common.Tags;
import net.thefirstwriter.substrata.SubStrata;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.List;

public class SubSPlacedFeatures {
    //Main Patches
    public static final ResourceKey<PlacedFeature> DIRT_PATCHES_PLACED_KEY = registerKey("dirt_patches_placed");
    public static final ResourceKey<PlacedFeature> COARSE_DIRT_PATCHES_PLACED_KEY = registerKey("coarse_dirt_patches_placed");

    //Roof Veg
    public static final ResourceKey<PlacedFeature> ROOTED_CEILING_FEATURES_PLACED_KEY = registerKey("rooted_ceiling_features_placed");

    //Floor Boulders
    public static final ResourceKey<PlacedFeature> ANDESITE_ROCKS_PLACED_KEY = registerKey("andesite_rocks_placed");
    public static final ResourceKey<PlacedFeature> CALCITE_ROCKS_PLACED_KEY = registerKey("calcite_rocks_placed");
    public static final ResourceKey<PlacedFeature> DIORITE_ROCKS_PLACED_KEY = registerKey("diorite_rocks_placed");
    public static final ResourceKey<PlacedFeature> GRANITE_ROCKS_PLACED_KEY = registerKey("granite_rocks_placed");
    public static final ResourceKey<PlacedFeature> TUFF_ROCKS_PLACED_KEY = registerKey("tuff_rocks_placed");
    public static final ResourceKey<PlacedFeature> STONE_ROCKS_PLACED_KEY = registerKey("stone_rocks_placed");


    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        //Main Patches
        register(context,DIRT_PATCHES_PLACED_KEY,configuredFeatures.getOrThrow(SubSConfiguredFeatures.DIRT_PATCHES_KEY),
                SubSOrePlacement.commonOrePlacement(60,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(160))));
        register(context,COARSE_DIRT_PATCHES_PLACED_KEY,configuredFeatures.getOrThrow(SubSConfiguredFeatures.COARSE_DIRT_PATCHES_KEY),
                SubSOrePlacement.commonOrePlacement(30,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(160))));

        //Roof Veg
        register(context,ROOTED_CEILING_FEATURES_PLACED_KEY,configuredFeatures.getOrThrow(SubSConfiguredFeatures.ROOTED_CEILING_FEATURES_KEY),
                List.of(CountPlacement.of(15), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0),VerticalAnchor.absolute(160)), BiomeFilter.biome()));

        //Floor Boulders
        register(context,ANDESITE_ROCKS_PLACED_KEY,configuredFeatures.getOrThrow(SubSConfiguredFeatures.ANDESITE_ROCKS_KEY),
                List.of(CountPlacement.of(10), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0),VerticalAnchor.absolute(60)),
                        BiomeFilter.biome()));
        register(context,CALCITE_ROCKS_PLACED_KEY,configuredFeatures.getOrThrow(SubSConfiguredFeatures.CALCITE_ROCKS_KEY),
                List.of(CountPlacement.of(10), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0),VerticalAnchor.absolute(60)),
                        BiomeFilter.biome()));
        register(context,DIORITE_ROCKS_PLACED_KEY,configuredFeatures.getOrThrow(SubSConfiguredFeatures.DIORITE_ROCKS_KEY),
                List.of(CountPlacement.of(10), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0),VerticalAnchor.absolute(60)),
                        BiomeFilter.biome()));
        register(context,GRANITE_ROCKS_PLACED_KEY,configuredFeatures.getOrThrow(SubSConfiguredFeatures.GRANITE_ROCKS_KEY),
                List.of(CountPlacement.of(10), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0),VerticalAnchor.absolute(60)),
                        BiomeFilter.biome()));
        register(context,TUFF_ROCKS_PLACED_KEY,configuredFeatures.getOrThrow(SubSConfiguredFeatures.TUFF_ROCKS_KEY),
                List.of(CountPlacement.of(10), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0),VerticalAnchor.absolute(60)),
                        BiomeFilter.biome()));
        register(context,STONE_ROCKS_PLACED_KEY,configuredFeatures.getOrThrow(SubSConfiguredFeatures.STONE_ROCKS_KEY),
                List.of(CountPlacement.of(10), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0),VerticalAnchor.absolute(60)),
                        BiomeFilter.biome()));


    }

        private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(SubStrata.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
