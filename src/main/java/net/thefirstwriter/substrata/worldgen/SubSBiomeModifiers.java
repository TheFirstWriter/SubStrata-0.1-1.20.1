package net.thefirstwriter.substrata.worldgen;

import net.minecraft.data.worldgen.placement.OrePlacements;
import net.thefirstwriter.substrata.SubStrata;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.thefirstwriter.substrata.utils.SubsTags;

import java.util.Set;

public class SubSBiomeModifiers {
    //Adding Features
    public static final ResourceKey<BiomeModifier> ADD_DIRT_PATCHES = registerKey("add_dirt_patches");
    public static final ResourceKey<BiomeModifier> ADD_COARSE_DIRT_PATCHES = registerKey("add_coarse_dirt_patches");
    public static final ResourceKey<BiomeModifier> ADD_ROOTED_CEILING_VEGETATION = registerKey("add_rooted_ceiling_vegetation");

    //Removing Features
    public static final ResourceKey<BiomeModifier> REMOVE_ORE_DIRT = registerKey("add_dirt_patches");

    //Adding Mobs

    //Removing Mobs

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);
        var rootedCaveBiome =  biomes.getOrThrow(SubsTags.Biomes.IS_ROOTED_CAVES);

        //Adding Features
        context.register(ADD_DIRT_PATCHES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(rootedCaveBiome,
                HolderSet.direct(placedFeatures.getOrThrow(SubSPlacedFeatures.DIRT_PATCHES_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_COARSE_DIRT_PATCHES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(rootedCaveBiome,
                HolderSet.direct(placedFeatures.getOrThrow(SubSPlacedFeatures.COARSE_DIRT_PATCHES_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_ROOTED_CEILING_VEGETATION, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(rootedCaveBiome,
                HolderSet.direct(placedFeatures.getOrThrow(SubSPlacedFeatures.ROOTED_CEILING_FEATURES_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        //Removing Features
       /* context.register(REMOVE_ORE_DIRT, new ForgeBiomeModifiers.RemoveFeaturesBiomeModifier(
                rootedCaveBiome, HolderSet.direct(placedFeatures.getOrThrow(OrePlacements.ORE_DIRT)),
                Set.of(GenerationStep.Decoration.UNDERGROUND_ORES )));
*/
        //Adding Mobs


        //Removing Mobs


    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(SubStrata.MOD_ID, name));
    }
}
