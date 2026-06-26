package net.thefirstwriter.substrata.worldgen.biome.surface;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraftforge.fml.ModList;

import java.util.ArrayList;
import java.util.List;

public class SubSSurfaceHelper {
    public static class SurfaceCaves{
        @SuppressWarnings("unchecked")
        public static SurfaceRules.RuleSource makeSurfaceCaves() {
            SurfaceRules.ConditionSource aboveStoneLayer = SurfaceRules.yStartCheck(VerticalAnchor.absolute(0),2);

            SurfaceRules.RuleSource PACKED_MUD = makeStateRule(Blocks.PACKED_MUD);
            SurfaceRules.RuleSource MUD = makeStateRule(Blocks.MUD);
            SurfaceRules.RuleSource SANDSTONE = makeStateRule(Blocks.SANDSTONE);
            SurfaceRules.RuleSource SNOW_BLOCK = makeStateRule(Blocks.SNOW_BLOCK);
            SurfaceRules.RuleSource GRAVEL_STONE = makeStateRule(Blocks.ANDESITE);

            List<ResourceKey<Biome>> rootedCaves = buildRootedCavesList();
            List<ResourceKey<Biome>> wetCaves = buildWetCavesList();
            List<ResourceKey<Biome>> dryCaves = buildDryCavesList();
            List<ResourceKey<Biome>> frigidCaves = buildFrigidCavesList();
            List<ResourceKey<Biome>> floodedCaves = buildFloodedCavesList();

            SurfaceRules.ConditionSource isRootedCaves = SurfaceRules.isBiome(rootedCaves.toArray(new ResourceKey[0]));
            SurfaceRules.ConditionSource isWetCaves = SurfaceRules.isBiome(wetCaves.toArray(new ResourceKey[0]));
            SurfaceRules.ConditionSource isDryCaves = SurfaceRules.isBiome(dryCaves.toArray(new ResourceKey[0]));
            SurfaceRules.ConditionSource isFrigidCaves = SurfaceRules.isBiome(frigidCaves.toArray(new ResourceKey[0]));
            SurfaceRules.ConditionSource isFloodedCaves = SurfaceRules.isBiome(floodedCaves.toArray(new ResourceKey[0]));

            return SurfaceRules.ifTrue(
                    aboveStoneLayer,SurfaceRules.sequence(
                            SurfaceRules.ifTrue(isRootedCaves,PACKED_MUD),
                            SurfaceRules.ifTrue(isWetCaves,MUD),
                            SurfaceRules.ifTrue(isDryCaves,SANDSTONE),
                            SurfaceRules.ifTrue(isFrigidCaves,SNOW_BLOCK),
                            SurfaceRules.ifTrue(isFloodedCaves,GRAVEL_STONE)
                    )
            );
        }

        public static List<ResourceKey<Biome>> buildRootedCavesList() {
            List<ResourceKey<Biome>> biomes = new ArrayList<>();
            biomes.add(Biomes.FOREST);biomes.add(Biomes.FLOWER_FOREST);biomes.add(Biomes.BIRCH_FOREST);biomes.add(Biomes.DARK_FOREST);biomes.add(Biomes.TAIGA);biomes.add(Biomes.PLAINS);biomes.add(Biomes.MEADOW);
            biomes.add(Biomes.CHERRY_GROVE);biomes.add(Biomes.SUNFLOWER_PLAINS);biomes.add(Biomes.OLD_GROWTH_BIRCH_FOREST);biomes.add(Biomes.OLD_GROWTH_PINE_TAIGA);biomes.add(Biomes.OLD_GROWTH_SPRUCE_TAIGA);
            if (ModList.get().isLoaded("terralith")) {
                biomes.add(createBiomeKey("terralith", "alpine_grove"));
                biomes.add(createBiomeKey("terralith", "birch_taiga"));
                biomes.add(createBiomeKey("terralith", "lavender_forest"));
                biomes.add(createBiomeKey("terralith", "moonlight_grove"));
                // Add other Terralith forest/plains biomes here
            }

            // Check for Regions Unexplored
            if (ModList.get().isLoaded("regions_unexplored")) {
                biomes.add(createBiomeKey("regions_unexplored", "deciduous_forest"));
                biomes.add(createBiomeKey("regions_unexplored", "maple_forest"));
                biomes.add(createBiomeKey("regions_unexplored", "flower_fields"));
                // Add other Regions Unexplored forest/plains biomes here
            }
            // Add checks for other mods (Biomes O' Plenty, etc.) similarly
            return biomes;
        }
        public static List<ResourceKey<Biome>> buildWetCavesList() {
            List<ResourceKey<Biome>> biomes = new ArrayList<>();
            biomes.add(Biomes.SWAMP);biomes.add(Biomes.MANGROVE_SWAMP);biomes.add(Biomes.JUNGLE);biomes.add(Biomes.SPARSE_JUNGLE);biomes.add(Biomes.BAMBOO_JUNGLE);biomes.add(Biomes.MUSHROOM_FIELDS);
            if (ModList.get().isLoaded("terralith")) {
                biomes.add(createBiomeKey("terralith", "alpine_grove"));
                biomes.add(createBiomeKey("terralith", "birch_taiga"));
                biomes.add(createBiomeKey("terralith", "lavender_forest"));
                biomes.add(createBiomeKey("terralith", "moonlight_grove"));
                // Add other Terralith forest/plains biomes here
            }

            // Check for Regions Unexplored
            if (ModList.get().isLoaded("regions_unexplored")) {
                biomes.add(createBiomeKey("regions_unexplored", "deciduous_forest"));
                biomes.add(createBiomeKey("regions_unexplored", "maple_forest"));
                biomes.add(createBiomeKey("regions_unexplored", "flower_fields"));
                // Add other Regions Unexplored forest/plains biomes here
            }

            // Add checks for other mods (Biomes O' Plenty, etc.) similarly

            return biomes;
        }
        public static List<ResourceKey<Biome>> buildDryCavesList() {
            List<ResourceKey<Biome>> biomes = new ArrayList<>();
            biomes.add(Biomes.DESERT);biomes.add(Biomes.SAVANNA);biomes.add(Biomes.SAVANNA_PLATEAU);biomes.add(Biomes.WINDSWEPT_SAVANNA);biomes.add(Biomes.BADLANDS);biomes.add(Biomes.ERODED_BADLANDS);biomes.add(Biomes.ERODED_BADLANDS);
            if (ModList.get().isLoaded("terralith")) {
                biomes.add(createBiomeKey("terralith", "alpine_grove"));
                biomes.add(createBiomeKey("terralith", "birch_taiga"));
                biomes.add(createBiomeKey("terralith", "lavender_forest"));
                biomes.add(createBiomeKey("terralith", "moonlight_grove"));
                // Add other Terralith forest/plains biomes here
            }

            // Check for Regions Unexplored
            if (ModList.get().isLoaded("regions_unexplored")) {
                biomes.add(createBiomeKey("regions_unexplored", "deciduous_forest"));
                biomes.add(createBiomeKey("regions_unexplored", "maple_forest"));
                biomes.add(createBiomeKey("regions_unexplored", "flower_fields"));
                // Add other Regions Unexplored forest/plains biomes here
            }

            // Add checks for other mods (Biomes O' Plenty, etc.) similarly

            return biomes;
        }
        public static List<ResourceKey<Biome>> buildFrigidCavesList() {
            List<ResourceKey<Biome>> biomes = new ArrayList<>();
            biomes.add(Biomes.ICE_SPIKES);biomes.add(Biomes.SNOWY_TAIGA);biomes.add(Biomes.SNOWY_PLAINS);biomes.add(Biomes.SNOWY_SLOPES);biomes.add(Biomes.SNOWY_BEACH);biomes.add(Biomes.WINDSWEPT_HILLS);biomes.add(Biomes.WINDSWEPT_GRAVELLY_HILLS);
            biomes.add(Biomes.WINDSWEPT_FOREST);biomes.add(Biomes.GROVE);biomes.add(Biomes.FROZEN_PEAKS);biomes.add(Biomes.JAGGED_PEAKS);biomes.add(Biomes.STONY_PEAKS);
            if (ModList.get().isLoaded("terralith")) {
                biomes.add(createBiomeKey("terralith", "alpine_grove"));
                biomes.add(createBiomeKey("terralith", "birch_taiga"));
                biomes.add(createBiomeKey("terralith", "lavender_forest"));
                biomes.add(createBiomeKey("terralith", "moonlight_grove"));
                // Add other Terralith forest/plains biomes here
            }

            // Check for Regions Unexplored
            if (ModList.get().isLoaded("regions_unexplored")) {
                biomes.add(createBiomeKey("regions_unexplored", "deciduous_forest"));
                biomes.add(createBiomeKey("regions_unexplored", "maple_forest"));
                biomes.add(createBiomeKey("regions_unexplored", "flower_fields"));
                // Add other Regions Unexplored forest/plains biomes here
            }

            // Add checks for other mods (Biomes O' Plenty, etc.) similarly

            return biomes;
        }
        public static List<ResourceKey<Biome>> buildFloodedCavesList() {
            List<ResourceKey<Biome>> biomes = new ArrayList<>();
            biomes.add(Biomes.OCEAN);biomes.add(Biomes.DEEP_OCEAN);biomes.add(Biomes.WARM_OCEAN);biomes.add(Biomes.LUKEWARM_OCEAN);biomes.add(Biomes.DEEP_LUKEWARM_OCEAN);biomes.add(Biomes.COLD_OCEAN);biomes.add(Biomes.DEEP_COLD_OCEAN);
            biomes.add(Biomes.FROZEN_OCEAN);biomes.add(Biomes.DEEP_FROZEN_OCEAN);biomes.add(Biomes.BEACH);biomes.add(Biomes.STONY_SHORE);
            if (ModList.get().isLoaded("terralith")) {
                biomes.add(createBiomeKey("terralith", "alpine_grove"));
                biomes.add(createBiomeKey("terralith", "birch_taiga"));
                biomes.add(createBiomeKey("terralith", "lavender_forest"));
                biomes.add(createBiomeKey("terralith", "moonlight_grove"));
                // Add other Terralith forest/plains biomes here
            }

            // Check for Regions Unexplored
            if (ModList.get().isLoaded("regions_unexplored")) {
                biomes.add(createBiomeKey("regions_unexplored", "deciduous_forest"));
                biomes.add(createBiomeKey("regions_unexplored", "maple_forest"));
                biomes.add(createBiomeKey("regions_unexplored", "flower_fields"));
                // Add other Regions Unexplored forest/plains biomes here
            }

            // Add checks for other mods (Biomes O' Plenty, etc.) similarly

            return biomes;
        }

        public static ResourceKey<Biome> createBiomeKey(String modId, String biomeName) {
            return ResourceKey.create(
                    net.minecraft.core.registries.Registries.BIOME,
                    new ResourceLocation(modId, biomeName)
            );
        }
        private static SurfaceRules.RuleSource makeStateRule(Block block) {
            return SurfaceRules.state(block.defaultBlockState());
        }
    }

}
