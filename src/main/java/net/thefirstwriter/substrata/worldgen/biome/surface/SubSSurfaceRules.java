package net.thefirstwriter.substrata.worldgen.biome.surface;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
//import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraftforge.fml.ModList;
//import net.thefirstwriter.substrata.worldgen.biome.SubSCaveBiomes;

import java.util.ArrayList;
import java.util.List;

public class SubSSurfaceRules {
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource PACKED_MUD = makeStateRule(Blocks.PACKED_MUD);
    //private static final SurfaceRules.RuleSource ROOTED_DIRT = makeStateRule(Blocks.ROOTED_DIRT);


    public static SurfaceRules.RuleSource makeRules() {
        //SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
        //SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);
        SurfaceRules.ConditionSource aboveStoneLayer = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(7),4);
        SurfaceRules.ConditionSource abovePreliminarySurface = SurfaceRules.abovePreliminarySurface();
        SurfaceRules.ConditionSource belowPreliminarySurface = SurfaceRules.not(abovePreliminarySurface);
        SurfaceRules.ConditionSource belowSurface = SurfaceRules.not(SurfaceRules.stoneDepthCheck(0,true,0,CaveSurface.FLOOR));

        List<ResourceKey<Biome>> rootedCaves = buildRootedCavesList();

        @ SuppressWarnings("unchecked")
        SurfaceRules.ConditionSource isRooted = SurfaceRules.isBiome(rootedCaves.toArray(new ResourceKey[0]));

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(isRooted, SurfaceRules.sequence(SurfaceRules.ifTrue(belowSurface,SurfaceRules.ifTrue(aboveStoneLayer,PACKED_MUD)),
                        SurfaceRules.ifTrue(belowPreliminarySurface,SurfaceRules.ifTrue(aboveStoneLayer, PACKED_MUD))))
        );
    }
    private static List<ResourceKey<Biome>> buildRootedCavesList() {
        List<ResourceKey<Biome>> biomes = new ArrayList<>();

        // Always add Vanilla
        biomes.add(Biomes.FOREST);
        biomes.add(Biomes.FLOWER_FOREST);
        biomes.add(Biomes.BIRCH_FOREST);
        biomes.add(Biomes.DARK_FOREST);
        biomes.add(Biomes.TAIGA);
        biomes.add(Biomes.PLAINS);
        biomes.add(Biomes.MEADOW);
        biomes.add(Biomes.CHERRY_GROVE);
        biomes.add(Biomes.SUNFLOWER_PLAINS);
        biomes.add(Biomes.OLD_GROWTH_BIRCH_FOREST);
        biomes.add(Biomes.OLD_GROWTH_PINE_TAIGA);
        biomes.add(Biomes.OLD_GROWTH_SPRUCE_TAIGA);

        // Check for Terralith
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

    private static ResourceKey<Biome> createBiomeKey(String modId, String biomeName) {
        return ResourceKey.create(
                net.minecraft.core.registries.Registries.BIOME,
                new ResourceLocation(modId, biomeName)
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
