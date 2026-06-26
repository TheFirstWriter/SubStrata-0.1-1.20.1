package net.thefirstwriter.substrata.worldgen.dimension;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterList;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.thefirstwriter.substrata.worldgen.SubSNoiseSettings;

import java.util.OptionalLong;

public class SubSDimension {
    public static final ResourceKey<DimensionType> SUBSTRATA_OVERWORLD_TYPE =
            ResourceKey.create(Registries.DIMENSION_TYPE, ResourceLocation.withDefaultNamespace("overworld"));
    public static final ResourceKey<LevelStem> SUBSTRATA_KEY =
            ResourceKey.create(Registries.LEVEL_STEM, ResourceLocation.withDefaultNamespace("overworld"));

    public static void bootstrapType(BootstapContext<DimensionType> context) {
        context.register(SUBSTRATA_OVERWORLD_TYPE, new DimensionType(
                OptionalLong.empty(), // fixedTime
                true, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                true, // natural
                1.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                -128, // minY
                512, // height
                512, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, // effectsLocation
                0.0f, // ambientLight
                new DimensionType.MonsterSettings(false, true, UniformInt.of(0,7), 0)));
    }
/*
    public static void bootstrapStem(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);

        Holder.Reference<NoiseGeneratorSettings> subSNoiseSettings = noiseGenSettings.getOrThrow(SubSNoiseSettings.OVERWORLD);

        NoiseBasedChunkGenerator chunkGenerator = new NoiseBasedChunkGenerator(
                MultiNoiseBiomeSourceParameterList.Preset,
                subSNoiseSettings);

        LevelStem stem = new LevelStem(dimTypes.getOrThrow(SubSDimension.SUBSTRATA_OVERWORLD_TYPE), chunkGenerator);

        context.register(SUBSTRATA_KEY, stem);
    }*/
}
