package net.thefirstwriter.substrata.worldgen;

import net.thefirstwriter.substrata.SubStrata;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class SubSPlacedFeatures {
    public static final ResourceKey<PlacedFeature> DIRT_PATCHES_PLACED_KEY = registerKey("dirt_patches_placed");
    public static final ResourceKey<PlacedFeature> COARSE_DIRT_PATCHES_PLACED_KEY = registerKey("coarse_dirt_patches_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context,DIRT_PATCHES_PLACED_KEY,configuredFeatures.getOrThrow(SubSConfiguredFeatures.DIRT_PATCHES_KEY),
                SubSOrePlacement.commonOrePlacement(40,
                HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(80))));
        register(context,COARSE_DIRT_PATCHES_PLACED_KEY,configuredFeatures.getOrThrow(SubSConfiguredFeatures.COARSE_DIRT_PATCHES_KEY),
                SubSOrePlacement.commonOrePlacement(20,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(80))));
    }


        private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(SubStrata.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
