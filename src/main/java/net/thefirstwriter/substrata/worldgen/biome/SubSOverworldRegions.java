package net.thefirstwriter.substrata.worldgen.biome;
/*
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class SubSOverworldRegions extends Region {
    public SubSOverworldRegions(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper)
    {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
        // Overlap Vanilla's parameters with our own for our COLD_BLUE biome.
        // The parameters for this biome are chosen arbitrarily.
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.COOL,ParameterUtils.Temperature.NEUTRAL))
                .humidity(Climate.Parameter.span(-1.0F,1.0F))
                .continentalness(Climate.Parameter.span(-0.11F,1.0F))
                .erosion(ParameterUtils.Erosion.FULL_RANGE)
                .depth(Climate.Parameter.span(0.25F,0.45F))
                .weirdness(ParameterUtils.Weirdness.FULL_RANGE)
                .build().forEach(point -> builder.add(point, SubSCaveBiomes.ROOTED_CAVES));

        // Add our points to the mapper
        builder.build().forEach(mapper::accept);
    }
}*/