package net.thefirstwriter.substrata.worldgen;

import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.*;
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
                List.of(CountPlacement.of(125), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0),VerticalAnchor.absolute(160)), BiomeFilter.biome())
                );

    }

        private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(SubStrata.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
