package net.thefirstwriter.substrata.datagen;

import net.thefirstwriter.substrata.SubStrata;
import net.thefirstwriter.substrata.worldgen.SubSBiomeModifiers;
import net.thefirstwriter.substrata.worldgen.SubSConfiguredFeatures;
import net.thefirstwriter.substrata.worldgen.SubSPlacedFeatures;
import net.thefirstwriter.substrata.worldgen.SubSNoiseSettings;
//import net.thefirstwriter.substrata.worldgen.biome.SubSCaveBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;
import net.thefirstwriter.substrata.worldgen.dimension.SubSDimension;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class SubSWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.DIMENSION_TYPE, SubSDimension::bootstrapType)
            .add(Registries.NOISE_SETTINGS, SubSNoiseSettings::bootstrap)

            .add(Registries.CONFIGURED_FEATURE, SubSConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, SubSPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, SubSBiomeModifiers::bootstrap);
            //.add(Registries.BIOME, SubSCaveBiomes::boostrap);

    public SubSWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(SubStrata.MOD_ID,"minecraft"));
    }
}