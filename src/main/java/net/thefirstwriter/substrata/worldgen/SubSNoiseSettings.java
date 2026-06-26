package net.thefirstwriter.substrata.worldgen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.thefirstwriter.substrata.worldgen.biome.surface.SubSSurfaceRules;

public class SubSNoiseSettings{
    public static final ResourceKey<NoiseGeneratorSettings> OVERWORLD =
            ResourceKey.create(Registries.NOISE_SETTINGS, ResourceLocation.withDefaultNamespace("overworld"));

    public class NoiseRouterHelper extends NoiseRouterData {
        public static NoiseRouter createOverworldRouter(HolderGetter<DensityFunction> densityFunctions, HolderGetter<NormalNoise.NoiseParameters> noises){
            return overworld(densityFunctions,noises,false,false);
        }
    }

    public static void bootstrap(BootstapContext<NoiseGeneratorSettings> context) {
        HolderGetter<DensityFunction> densityFunctions = context.lookup(Registries.DENSITY_FUNCTION);
        HolderGetter<NormalNoise.NoiseParameters> noises = context.lookup(Registries.NOISE);

        NoiseSettings customNoiseParams = NoiseSettings.create(-128, 512, 1, 2);

        SurfaceRules.RuleSource myCustomSurfaceRules = SubSSurfaceRules.getCustomSurfaceRules();

        NoiseRouter customRouter = NoiseRouterHelper.createOverworldRouter(densityFunctions, noises);

        // 4. Construct the final NoiseGeneratorSettings
        NoiseGeneratorSettings customOverworld = new NoiseGeneratorSettings(
                customNoiseParams,          // Replaces OVERWORLD_NOISE_SETTINGS
                Blocks.STONE.defaultBlockState(), // defaultBlock
                Blocks.WATER.defaultBlockState(), // defaultFluid
                customRouter,               // noiseRouter
                myCustomSurfaceRules,       // surfaceRule (YOUR CUSTOM RULE)
                (new OverworldBiomeBuilder()).spawnTarget(), // spawnTarget
                63,                         // seaLevel
                false,                      // disableMobGeneration
                false,                       // aquifersEnabled
                true,                       // oreVeinsEnabled
                false                       // legacyRandomSource (use false for vanilla noise)
        );

        context.register(OVERWORLD, customOverworld);
    }

}