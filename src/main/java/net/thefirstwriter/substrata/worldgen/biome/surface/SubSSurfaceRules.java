package net.thefirstwriter.substrata.worldgen.biome.surface;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraftforge.fml.ModList;


import static net.thefirstwriter.substrata.worldgen.biome.surface.SubSSurfaceHelper.SurfaceCaves.makeSurfaceCaves;

public class SubSSurfaceRules {
    private static final SurfaceRules.RuleSource AIR = makeStateRule(Blocks.AIR);
    private static final SurfaceRules.RuleSource BEDROCK = makeStateRule(Blocks.BEDROCK);
    private static final SurfaceRules.RuleSource WHITE_TERRACOTTA = makeStateRule(Blocks.WHITE_TERRACOTTA);
    private static final SurfaceRules.RuleSource ORANGE_TERRACOTTA = makeStateRule(Blocks.ORANGE_TERRACOTTA);
    private static final SurfaceRules.RuleSource TERRACOTTA = makeStateRule(Blocks.TERRACOTTA);
    private static final SurfaceRules.RuleSource RED_SAND = makeStateRule(Blocks.RED_SAND);
    private static final SurfaceRules.RuleSource RED_SANDSTONE = makeStateRule(Blocks.RED_SANDSTONE);
    private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);
    private static final SurfaceRules.RuleSource DEEPSLATE = makeStateRule(Blocks.DEEPSLATE);
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource PODZOL = makeStateRule(Blocks.PODZOL);
    private static final SurfaceRules.RuleSource COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static final SurfaceRules.RuleSource MYCELIUM = makeStateRule(Blocks.MYCELIUM);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource CALCITE = makeStateRule(Blocks.CALCITE);
    private static final SurfaceRules.RuleSource GRAVEL = makeStateRule(Blocks.GRAVEL);
    private static final SurfaceRules.RuleSource SAND = makeStateRule(Blocks.SAND);
    private static final SurfaceRules.RuleSource SANDSTONE = makeStateRule(Blocks.SANDSTONE);
    private static final SurfaceRules.RuleSource PACKED_ICE = makeStateRule(Blocks.PACKED_ICE);
    private static final SurfaceRules.RuleSource SNOW_BLOCK = makeStateRule(Blocks.SNOW_BLOCK);
    private static final SurfaceRules.RuleSource MUD = makeStateRule(Blocks.MUD);
    private static final SurfaceRules.RuleSource POWDER_SNOW = makeStateRule(Blocks.POWDER_SNOW);
    private static final SurfaceRules.RuleSource ICE = makeStateRule(Blocks.ICE);
    private static final SurfaceRules.RuleSource WATER = makeStateRule(Blocks.WATER);
    static boolean hasTectonic = ModList.get().isLoaded("tectonic");
    static boolean hasTerralith = ModList.get().isLoaded("terralith");
    static SurfaceRules.RuleSource finalRule;

    static SurfaceRules.RuleSource below256BadlandsHelper;
    static SurfaceRules.ConditionSource aboveYBadlandsHelper;

    public static SurfaceRules.RuleSource getCustomSurfaceRules() {
        if (hasTectonic && hasTerralith) {  /*finalRule = overworldTerratonic(true, false, true);*/ }
        else if (hasTerralith) { /*finalRule = overworldTerralith(true, false, true); */ }
        else {  finalRule = overworldLike(true, false, true); }
        return finalRule;
    }
    public static SurfaceRules.RuleSource BadlandsHelper1(){
        SurfaceRules.ConditionSource isBlockAboveY256 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(256), 0);
        if (hasTectonic) {  below256BadlandsHelper = SurfaceRules.ifTrue(isBlockAboveY256,SurfaceRules.ifTrue(SurfaceRules.not(isBlockAboveY256), ORANGE_TERRACOTTA));  }
        else{  below256BadlandsHelper = SurfaceRules.ifTrue(isBlockAboveY256, ORANGE_TERRACOTTA);  }
        return below256BadlandsHelper;
    }
    public static SurfaceRules.ConditionSource BadlandsHelper2(){
        if (hasTectonic) {  aboveYBadlandsHelper = SurfaceRules.yStartCheck(VerticalAnchor.absolute(84), 1);  }
        else{  aboveYBadlandsHelper = SurfaceRules.yStartCheck(VerticalAnchor.absolute(74), 1);  }
        return aboveYBadlandsHelper;
    }

    public static SurfaceRules.RuleSource overworldLike(boolean checkAbovePreliminarySurface, boolean bedrockRoof, boolean bedrockFloor)
    {
        SurfaceRules.ConditionSource isBlockAboveY97WithVariationAbove = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(97), 2);
        SurfaceRules.RuleSource below256Badlands = BadlandsHelper1();
        /*Change add helper method */SurfaceRules.ConditionSource isSurfaceAboveY74WithVariationAboveTectonic = BadlandsHelper2();
        SurfaceRules.ConditionSource isSurfaceAbove63WithVariationBelow = SurfaceRules.yStartCheck(VerticalAnchor.absolute(63), -1);
        SurfaceRules.ConditionSource isSurfaceAboveY74WithVariationAbove = SurfaceRules.yStartCheck(VerticalAnchor.absolute(74), 1);
        SurfaceRules.ConditionSource isBlockAboveY60 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(60), 0);
        SurfaceRules.ConditionSource isBlockAboveY62 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(62), 0);
        SurfaceRules.ConditionSource isBlockAboveY63 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(63), 0);
        SurfaceRules.ConditionSource isInOrAboveShallowWater = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.ConditionSource isAboveWater = SurfaceRules.waterBlockCheck(0, 0);
        SurfaceRules.ConditionSource isInOrAboveDeepWaterWithVariationBelow = SurfaceRules.waterStartCheck(-6, -1);
        SurfaceRules.ConditionSource isHole = SurfaceRules.hole();
        SurfaceRules.ConditionSource isFrozenOcean = SurfaceRules.isBiome(Biomes.FROZEN_OCEAN, Biomes.DEEP_FROZEN_OCEAN);
        SurfaceRules.ConditionSource isSteep = SurfaceRules.steep();
        SurfaceRules.RuleSource surfaceGrassOrDirtIfSubmerged = SurfaceRules.sequence(SurfaceRules.ifTrue(isAboveWater, GRASS_BLOCK), DIRT);
        SurfaceRules.RuleSource sandOrSandstoneCeiling = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SANDSTONE), SAND);
        SurfaceRules.RuleSource gravelOrStoneCeiling = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, STONE), GRAVEL);
        SurfaceRules.ConditionSource isSandyShoreOrOcean = SurfaceRules.isBiome(Biomes.WARM_OCEAN, Biomes.BEACH, Biomes.SNOWY_BEACH);
        SurfaceRules.ConditionSource isDesert = SurfaceRules.isBiome(Biomes.DESERT);

        SurfaceRules.RuleSource onAndUnderFloorSurfaceRules = SurfaceRules.sequence(
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(Biomes.STONY_PEAKS),
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(
                                        SurfaceRules.noiseCondition(Noises.CALCITE, -0.0125D, 0.0125D),
                                        CALCITE
                                ),
                                STONE
                        )
                ),
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(Biomes.STONY_SHORE),
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(
                                        SurfaceRules.noiseCondition(Noises.GRAVEL, -0.05D, 0.05D),
                                        gravelOrStoneCeiling
                                ),
                                STONE
                        )
                ),
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(Biomes.WINDSWEPT_HILLS),
                        SurfaceRules.ifTrue(
                                surfaceNoiseAbove(1.0D),
                                STONE
                        )
                ),
                SurfaceRules.ifTrue(
                        isSandyShoreOrOcean,
                        sandOrSandstoneCeiling
                ),
                SurfaceRules.ifTrue(isDesert, sandOrSandstoneCeiling),
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(Biomes.DRIPSTONE_CAVES),
                        STONE
                )
        );

        SurfaceRules.RuleSource powderedSnowSmallPatches = SurfaceRules.ifTrue(
                SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.45D, 0.58D),
                SurfaceRules.ifTrue(isAboveWater, POWDER_SNOW)
        );

        SurfaceRules.RuleSource powderedSnowLargePatches = SurfaceRules.ifTrue(
                SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.35D, 0.6D),
                SurfaceRules.ifTrue(isAboveWater, POWDER_SNOW)
        );

        SurfaceRules.RuleSource underFloorSurfaceRules = SurfaceRules.sequence(
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(Biomes.FROZEN_PEAKS),
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(isSteep, PACKED_ICE),
                                SurfaceRules.ifTrue(
                                        SurfaceRules.noiseCondition(Noises.PACKED_ICE, -0.5D, 0.2D),
                                        PACKED_ICE
                                ),
                                SurfaceRules.ifTrue(
                                        SurfaceRules.noiseCondition(Noises.ICE, -0.0625D, 0.025D),
                                        ICE
                                ),
                                SurfaceRules.ifTrue(isAboveWater, SNOW_BLOCK)
                        )
                ),
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(Biomes.SNOWY_SLOPES),
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(isSteep, STONE),
                                powderedSnowSmallPatches,
                                SurfaceRules.ifTrue(isAboveWater, SNOW_BLOCK)
                        )
                ),
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(Biomes.JAGGED_PEAKS),
                        STONE
                ),
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(Biomes.GROVE),
                        SurfaceRules.sequence(
                                powderedSnowSmallPatches,
                                DIRT
                        )
                ),
                onAndUnderFloorSurfaceRules,
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(Biomes.WINDSWEPT_SAVANNA),
                        SurfaceRules.ifTrue(
                                surfaceNoiseAbove(1.75D),
                                STONE
                        )
                ),
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(Biomes.WINDSWEPT_GRAVELLY_HILLS),
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(
                                        surfaceNoiseAbove(2.0D),
                                        gravelOrStoneCeiling
                                ),
                                SurfaceRules.ifTrue(
                                        surfaceNoiseAbove(1.0D),
                                        STONE
                                ),
                                SurfaceRules.ifTrue(
                                        surfaceNoiseAbove(-1.0D),
                                        DIRT
                                ),
                                gravelOrStoneCeiling
                        )
                ),
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(Biomes.MANGROVE_SWAMP),
                        MUD
                ),
                DIRT
        );

        SurfaceRules.RuleSource shallowFloorSurfaceRules = SurfaceRules.sequence(
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(Biomes.FROZEN_PEAKS),
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(isSteep, PACKED_ICE),
                                SurfaceRules.ifTrue(
                                        SurfaceRules.noiseCondition(Noises.PACKED_ICE, 0.0D, 0.2D),
                                        PACKED_ICE
                                ),
                                SurfaceRules.ifTrue(
                                        SurfaceRules.noiseCondition(Noises.ICE, 0.0D, 0.025D),
                                        ICE
                                ),
                                SurfaceRules.ifTrue(isAboveWater, SNOW_BLOCK)
                        )
                ),
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(Biomes.SNOWY_SLOPES),
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(isSteep, STONE),
                                powderedSnowLargePatches,
                                SurfaceRules.ifTrue(isAboveWater, SNOW_BLOCK)
                        )
                ),
                // Place stone on the cliff faces and snow on top for the jagged peaks
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(Biomes.JAGGED_PEAKS),
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(isSteep, STONE),
                                SurfaceRules.ifTrue(isAboveWater, SNOW_BLOCK)
                        )
                ),
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(Biomes.GROVE),
                        SurfaceRules.sequence(
                                powderedSnowLargePatches,
                                SurfaceRules.ifTrue(isAboveWater, SNOW_BLOCK)
                        )
                ),
                onAndUnderFloorSurfaceRules,
                // Windswept savanna stone mixed with coarse dirt
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(Biomes.WINDSWEPT_SAVANNA),
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(
                                        surfaceNoiseAbove(1.75D),
                                        STONE
                                ),
                                SurfaceRules.ifTrue(
                                        surfaceNoiseAbove(-0.5D),
                                        COARSE_DIRT
                                )
                        )
                ),
                // Windswept gravelly hills: Gravel, stone and grass mixed
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(Biomes.WINDSWEPT_GRAVELLY_HILLS),
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(
                                        surfaceNoiseAbove(2.0D),
                                        gravelOrStoneCeiling
                                ),
                                SurfaceRules.ifTrue(
                                        surfaceNoiseAbove(1.0D),
                                        STONE
                                ),
                                SurfaceRules.ifTrue(
                                        surfaceNoiseAbove(-1.0D),
                                        surfaceGrassOrDirtIfSubmerged
                                ),
                                gravelOrStoneCeiling
                        )
                ),
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA),
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(
                                        surfaceNoiseAbove(1.75D),
                                        COARSE_DIRT
                                ),
                                SurfaceRules.ifTrue(
                                        surfaceNoiseAbove(-0.95D),
                                        PODZOL
                                )
                        )
                ),
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(Biomes.ICE_SPIKES),
                        SurfaceRules.ifTrue(isAboveWater, SNOW_BLOCK)
                ),
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(Biomes.MANGROVE_SWAMP),
                        MUD
                ),
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(Biomes.MUSHROOM_FIELDS),
                        MYCELIUM
                ),
                surfaceGrassOrDirtIfSubmerged
        );

        SurfaceRules.ConditionSource isSuitableSurfaceNoiseLower = SurfaceRules.noiseCondition(Noises.SURFACE, -0.909D, -0.5454D);
        SurfaceRules.ConditionSource isSuitableSurfaceNoiseMid = SurfaceRules.noiseCondition(Noises.SURFACE, -0.1818D, 0.1818D);
        SurfaceRules.ConditionSource isSuitableSurfaceNoiseUpper = SurfaceRules.noiseCondition(Noises.SURFACE, 0.5454D, 0.909D);

        SurfaceRules.RuleSource surfaceRules = SurfaceRules.sequence(
                // Noisy biome floors (as seen in the wooded badlands, swamp and mangrove swamp)
                SurfaceRules.ifTrue(
                        SurfaceRules.ON_FLOOR,
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(
                                        SurfaceRules.isBiome(Biomes.WOODED_BADLANDS),
                                        SurfaceRules.ifTrue(
                                                isBlockAboveY97WithVariationAbove,
                                                SurfaceRules.sequence(
                                                        SurfaceRules.ifTrue(isSuitableSurfaceNoiseLower, COARSE_DIRT),
                                                        SurfaceRules.ifTrue(isSuitableSurfaceNoiseMid, COARSE_DIRT),
                                                        SurfaceRules.ifTrue(isSuitableSurfaceNoiseUpper, COARSE_DIRT),
                                                        surfaceGrassOrDirtIfSubmerged
                                                )
                                        )
                                ),
                                SurfaceRules.ifTrue(
                                        SurfaceRules.isBiome(Biomes.SWAMP),
                                        SurfaceRules.ifTrue(
                                                isBlockAboveY62,
                                                SurfaceRules.ifTrue(
                                                        SurfaceRules.not(isBlockAboveY63),
                                                        SurfaceRules.ifTrue(
                                                                SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D),
                                                                WATER
                                                        )
                                                )
                                        )
                                ),
                                SurfaceRules.ifTrue(
                                        SurfaceRules.isBiome(Biomes.MANGROVE_SWAMP),
                                        SurfaceRules.ifTrue(
                                                isBlockAboveY60,
                                                SurfaceRules.ifTrue(
                                                        SurfaceRules.not(isBlockAboveY63),
                                                        SurfaceRules.ifTrue(
                                                                SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D),
                                                                WATER
                                                        )
                                                )
                                        )
                                )
                        )
                ),
                // Badlands surface rules
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(Biomes.BADLANDS, Biomes.ERODED_BADLANDS, Biomes.WOODED_BADLANDS),
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(
                                        SurfaceRules.ON_FLOOR,
                                        SurfaceRules.sequence(
                                                below256Badlands,
                                                SurfaceRules.ifTrue(
                                                        isSurfaceAboveY74WithVariationAboveTectonic,
                                                        SurfaceRules.sequence(
                                                                SurfaceRules.ifTrue(isSuitableSurfaceNoiseLower, TERRACOTTA),
                                                                SurfaceRules.ifTrue(isSuitableSurfaceNoiseMid, TERRACOTTA),
                                                                SurfaceRules.ifTrue(isSuitableSurfaceNoiseUpper, TERRACOTTA),
                                                                SurfaceRules.bandlands()
                                                        )
                                                ),
                                                SurfaceRules.ifTrue(
                                                        isInOrAboveShallowWater,
                                                        SurfaceRules.sequence(
                                                                SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, RED_SANDSTONE),
                                                                RED_SAND
                                                        )
                                                ),
                                                SurfaceRules.ifTrue(
                                                        SurfaceRules.not(isHole),
                                                        ORANGE_TERRACOTTA
                                                ),
                                                SurfaceRules.ifTrue(isInOrAboveDeepWaterWithVariationBelow, WHITE_TERRACOTTA),
                                                gravelOrStoneCeiling
                                        )
                                ),
                                SurfaceRules.ifTrue(
                                        isSurfaceAbove63WithVariationBelow,
                                        SurfaceRules.sequence(
                                                SurfaceRules.ifTrue(
                                                        isBlockAboveY63,
                                                        SurfaceRules.ifTrue(
                                                                SurfaceRules.not(isSurfaceAboveY74WithVariationAbove),
                                                                ORANGE_TERRACOTTA
                                                        )
                                                ),
                                                SurfaceRules.bandlands()
                                        )
                                ),
                                SurfaceRules.ifTrue(
                                        SurfaceRules.UNDER_FLOOR,
                                        SurfaceRules.ifTrue(isInOrAboveDeepWaterWithVariationBelow, WHITE_TERRACOTTA)
                                )
                        )
                ),
                // Frozen ocean ice surfaces and shallow floors
                SurfaceRules.ifTrue(
                        SurfaceRules.ON_FLOOR,
                        SurfaceRules.ifTrue(
                                isInOrAboveShallowWater,
                                SurfaceRules.sequence(
                                        SurfaceRules.ifTrue(
                                                isFrozenOcean,
                                                SurfaceRules.ifTrue(
                                                        isHole,
                                                        SurfaceRules.sequence(
                                                                SurfaceRules.ifTrue(isAboveWater, AIR),
                                                                SurfaceRules.ifTrue(SurfaceRules.temperature(), ICE),
                                                                WATER
                                                        )
                                                )
                                        ),
                                        shallowFloorSurfaceRules
                                )
                        )
                ),
                SurfaceRules.ifTrue(
                        isInOrAboveDeepWaterWithVariationBelow,
                        SurfaceRules.sequence(
                                // Fill frozen ocean floor holes with water
                                SurfaceRules.ifTrue(
                                        SurfaceRules.ON_FLOOR,
                                        SurfaceRules.ifTrue(
                                                isFrozenOcean,
                                                SurfaceRules.ifTrue(isHole, WATER)
                                        )
                                ),
                                // Under the floor surface rules
                                SurfaceRules.ifTrue(
                                        SurfaceRules.UNDER_FLOOR,
                                        underFloorSurfaceRules
                                ),
                                // Place sandstone under sand deep under the floor in sandy shores or ocean
                                SurfaceRules.ifTrue(
                                        isSandyShoreOrOcean,
                                        SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, SANDSTONE)
                                ),
                                // Place sandstone very deep under the floor of deserts
                                SurfaceRules.ifTrue(
                                        isDesert,
                                        SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, SANDSTONE)
                                )
                        )
                ),
                SurfaceRules.ifTrue(
                        SurfaceRules.ON_FLOOR,
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(
                                        SurfaceRules.isBiome(Biomes.FROZEN_PEAKS, Biomes.JAGGED_PEAKS),
                                        STONE
                                ),
                                SurfaceRules.ifTrue(
                                        SurfaceRules.isBiome(Biomes.WARM_OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN),
                                        sandOrSandstoneCeiling
                                ),
                                gravelOrStoneCeiling
                        )
                )
        );
        ImmutableList.Builder<SurfaceRules.RuleSource> builder = ImmutableList.builder();
        if (bedrockRoof)
            builder.add(SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(128),2), BEDROCK));

        if (bedrockFloor)
            builder.add(SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(-128),2)), BEDROCK));

        SurfaceRules.RuleSource surfaceRulesWithPreliminarySurfaceCheck = SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), surfaceRules);
        builder.add(checkAbovePreliminarySurface ? surfaceRulesWithPreliminarySurfaceCheck : surfaceRules);

        builder.add(SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(-56),3)),DEEPSLATE));
        builder.add(makeSurfaceCaves());

        return SurfaceRules.sequence(builder.build().toArray((count) ->
        {
            return new SurfaceRules.RuleSource[count];
        }));
    }
    public static SurfaceRules.RuleSource air() {
        return AIR;
    }
    private static SurfaceRules.ConditionSource surfaceNoiseAbove(double value) {
        return SurfaceRules.noiseCondition(Noises.SURFACE, value / 8.25D, Double.MAX_VALUE);
    }
    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
