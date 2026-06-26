package net.thefirstwriter.substrata.worldgen;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.CaveVines;
import net.minecraft.world.level.block.CaveVinesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.*;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.thefirstwriter.substrata.SubStrata;
import net.thefirstwriter.substrata.utils.SubsTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

//import java.util.List;


public class SubSConfiguredFeatures {
    //Main Patches
    public static final ResourceKey<ConfiguredFeature<?, ?>> DIRT_PATCHES_KEY = registerKey("dirt_patches");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COARSE_DIRT_PATCHES_KEY= registerKey("coarse_dirt_patches");

    //Roof Veg
    public static final ResourceKey<ConfiguredFeature<?, ?>> ROOTED_CEILING_FEATURES_KEY = registerKey("rooted_ceiling_features");

    //Floor Boulders
    public static final ResourceKey<ConfiguredFeature<?, ?>> ANDESITE_ROCKS_KEY = registerKey("andesite_rocks");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CALCITE_ROCKS_KEY = registerKey("calcite_rocks");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DIORITE_ROCKS_KEY = registerKey("diorite_rocks");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GRANITE_ROCKS_KEY = registerKey("granite_rocks");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TUFF_ROCKS_KEY = registerKey("tuff_rocks");
    public static final ResourceKey<ConfiguredFeature<?, ?>> STONE_ROCKS_KEY = registerKey("stone_rocks");

    //Floor Vegetation

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest packedmudReplaceables = new TagMatchTest(SubsTags.Blocks.ROOTED_CAVES_REPLACEABLE);

        //Main Patches
        register(context, DIRT_PATCHES_KEY, Feature.ORE, new OreConfiguration(packedmudReplaceables,
                Blocks.DIRT.defaultBlockState(), 50));
        register(context, COARSE_DIRT_PATCHES_KEY, Feature.ORE, new OreConfiguration(packedmudReplaceables,
                Blocks.COARSE_DIRT.defaultBlockState(), 30));

        //Ceiling Vegetation
        WeightedStateProvider rootVinesBodyProvider = new WeightedStateProvider(
                SimpleWeightedRandomList.<BlockState>builder()
                        .add(Blocks.CAVE_VINES_PLANT.defaultBlockState(), 4)
                        .add((BlockState)Blocks.CAVE_VINES_PLANT.defaultBlockState().setValue(CaveVines.BERRIES, true), 1));
        RandomizedIntStateProvider rootVinesHeadProvider = new RandomizedIntStateProvider(
                new WeightedStateProvider(
                        SimpleWeightedRandomList.<BlockState>builder()
                                .add(Blocks.CAVE_VINES.defaultBlockState(), 4)
                                .add((BlockState)Blocks.CAVE_VINES.defaultBlockState().setValue(CaveVines.BERRIES, true), 1)),
                CaveVinesBlock.AGE, UniformInt.of(23, 25));

        Holder<PlacedFeature> makeRootVine = PlacementUtils.inlinePlaced(Feature.BLOCK_COLUMN, new BlockColumnConfiguration(
                List.of(BlockColumnConfiguration.layer(new WeightedListInt(
                                        SimpleWeightedRandomList.<IntProvider>builder().add(UniformInt.of(0, 19), 2).add(UniformInt.of(0, 2), 3).add(UniformInt.of(0, 6), 10).build()
                                ), rootVinesBodyProvider), BlockColumnConfiguration.layer(ConstantInt.of(1), rootVinesHeadProvider)),
                Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, true));

        Holder<PlacedFeature> makeEmptySpace = PlacementUtils.inlinePlaced(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                BlockStateProvider.simple(Blocks.AIR)));
        Holder<PlacedFeature> makeHangingRoot = PlacementUtils.inlinePlaced(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                BlockStateProvider.simple(Blocks.HANGING_ROOTS)));
        Holder<PlacedFeature> rootedCeilingVegetation= PlacementUtils.inlinePlaced(Feature.RANDOM_SELECTOR,
                new RandomFeatureConfiguration(List.of( new WeightedPlacedFeature(makeRootVine,0.2F),new WeightedPlacedFeature(makeHangingRoot,0.6F)),makeEmptySpace));

        register(context, ROOTED_CEILING_FEATURES_KEY, Feature.VEGETATION_PATCH,
                new VegetationPatchConfiguration(SubsTags.Blocks.ROOTED_CAVES_REPLACEABLE,
                        new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.ROOTED_DIRT.defaultBlockState(), 5).add(Blocks. MOSS_BLOCK.defaultBlockState(), 2)),
                        rootedCeilingVegetation, CaveSurface.CEILING,UniformInt.of(1,2),0.2F,6,0.5F,UniformInt.of(4,7),0.4F));

        //Floor Boulders
        register(context, ANDESITE_ROCKS_KEY, Feature.FOREST_ROCK, new BlockStateConfiguration(Blocks.ANDESITE.defaultBlockState()));
        register(context, CALCITE_ROCKS_KEY, Feature.FOREST_ROCK, new BlockStateConfiguration(Blocks.CALCITE.defaultBlockState()));
        register(context, DIORITE_ROCKS_KEY, Feature.FOREST_ROCK, new BlockStateConfiguration(Blocks.DIORITE.defaultBlockState()));
        register(context, GRANITE_ROCKS_KEY, Feature.FOREST_ROCK, new BlockStateConfiguration(Blocks.GRANITE.defaultBlockState()));
        register(context, TUFF_ROCKS_KEY, Feature.FOREST_ROCK, new BlockStateConfiguration(Blocks.TUFF.defaultBlockState()));

        Holder<PlacedFeature> stoneRocks = PlacementUtils.inlinePlaced(Feature.FOREST_ROCK, new BlockStateConfiguration(Blocks.STONE.defaultBlockState()));
        Holder<PlacedFeature> cobblestoneRocks = PlacementUtils.inlinePlaced(Feature.FOREST_ROCK, new BlockStateConfiguration(Blocks.COBBLESTONE.defaultBlockState()));
        Holder<PlacedFeature> mossyCobblestoneRocks = PlacementUtils.inlinePlaced(Feature.FOREST_ROCK, new BlockStateConfiguration(Blocks.MOSSY_COBBLESTONE.defaultBlockState()));

        register(context, STONE_ROCKS_KEY,Feature.RANDOM_SELECTOR,
                new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(stoneRocks,0.3F),new WeightedPlacedFeature(mossyCobblestoneRocks,0.2F)),cobblestoneRocks));


        //Floor Vegetation


    }
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(SubStrata.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
