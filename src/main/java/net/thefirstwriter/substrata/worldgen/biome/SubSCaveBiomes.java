package net.thefirstwriter.substrata.worldgen.biome;
/*
import net.thefirstwriter.substrata.SubStrata;
//import net.kaupenjoe.tutorialmod.entity.ModEntities;
//import net.kaupenjoe.tutorialmod.sound.ModSounds;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
//import net.minecraft.sounds.Musics;
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.thefirstwriter.substrata.worldgen.SubSPlacedFeatures;

public class SubSCaveBiomes {
    public static final ResourceKey<Biome> ROOTED_CAVES = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(SubStrata.MOD_ID, "rooted_caves"));

    public static void boostrap(BootstapContext<Biome> context) {
        context.register(ROOTED_CAVES, rootedCaves(context));

    }

    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
    }

    public static Biome rootedCaves(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        //we need to follow the same order as vanilla biomes for the BiomeDefaultFeatures
        globalOverworldGeneration(biomeBuilder);
        //biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, SubSPlacedFeatures.DIRT_PATCHES_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, SubSPlacedFeatures.COARSE_DIRT_PATCHES_PLACED_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .downfall(0.8f)
                .temperature(0.6f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x3a7a6a)
                        .waterFogColor(0x4d7a60)
                        .skyColor(0x30c918)
                        .grassColorOverride(0x79c05a)
                        .foliageColorOverride(0x77ab2f)
                        .fogColor(0x455048)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
                .build();
    }
}*/
