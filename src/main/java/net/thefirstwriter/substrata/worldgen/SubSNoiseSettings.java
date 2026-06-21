package net.thefirstwriter.substrata.worldgen;

/*
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mojang.serialization.JsonOps;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

import net.minecraftforge.fml.ModList;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class SubSNoiseSettings {
    public static final ResourceKey<NoiseGeneratorSettings> OVERWORLD =
            ResourceKey.create(Registries.NOISE_SETTINGS, new ResourceLocation("minecraft", "overworld"));

    public static void bootstrap(BootstapContext<NoiseGeneratorSettings> context) {
        String fileName;
        if (ModList.get().isLoaded("tectonic")) {
            fileName = "substrata/worldgen/noise_settings/tectonic_overworld.json";}
        else if (ModList.get().isLoaded("terralith")) {
            fileName = "substrata/worldgen/noise_settings/terralith_overworld.json";}
        else if (ModList.get().isLoaded("terratonic")) {
                fileName = "substrata/worldgen/noise_settings/terratonic_overworld.json";}
        else {
            fileName = "substrata/worldgen/noise_settings/vanilla_overworld.json";}

        try {
            InputStream stream = SubSNoiseSettings.class.getClassLoader().getResourceAsStream(fileName);
            if (stream == null) {
                throw new RuntimeException("Could not find noise settings file: " + fileName);
            }

            JsonElement jsonElement = JsonParser.parseReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
            IOUtils.closeQuietly(stream);

            Optional<NoiseGeneratorSettings> optionalSettings = NoiseGeneratorSettings.DIRECT_CODEC.parse(JsonOps.INSTANCE, jsonElement).result();
            if (optionalSettings.isEmpty()) {throw new RuntimeException("Failed to parse noise settings from " + fileName);}

            NoiseGeneratorSettings settings = optionalSettings.get();
            context.register(OVERWORLD, settings);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load custom noise settings from " + fileName, e);
        }
    }
}
*/