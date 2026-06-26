package net.thefirstwriter.substrata.worldgen;

import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
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
    public static final ResourceKey<BiomeModifier> ADD_ANDESITE_ROCKS = registerKey("add_andesite_rocks");
    public static final ResourceKey<BiomeModifier> ADD_CALCITE_ROCKS = registerKey("add_calcite_rocks");
    public static final ResourceKey<BiomeModifier> ADD_DIORITE_ROCKS = registerKey("add_diorite_rocks");
    public static final ResourceKey<BiomeModifier> ADD_GRANITE_ROCKS = registerKey("add_granite_rocks");
    public static final ResourceKey<BiomeModifier> ADD_TUFF_ROCKS = registerKey("add_tuff_rocks");
    public static final ResourceKey<BiomeModifier> ADD_STONE_ROCKS = registerKey("add_stone_rocks");

    //Removing Features
    public static final ResourceKey<BiomeModifier> REMOVE_ORE_DIRT = registerKey("add_dirt_patches");

    //Adding Mobs

    //Removing Mobs

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);
        var rootedCaveBiome =  biomes.getOrThrow(SubsTags.Biomes.IS_ROOTED_CAVES);
        var andesiteRocks =  biomes.getOrThrow(SubsTags.Biomes.IS_ANDESITE_ROCKS);
        var calciteRocks =  biomes.getOrThrow(SubsTags.Biomes.IS_CALCITE_ROCKS);
        var dioriteRocks =  biomes.getOrThrow(SubsTags.Biomes.IS_DIORITE_ROCKS);
        var graniteRocks =  biomes.getOrThrow(SubsTags.Biomes.IS_GRANITE_ROCKS);
        var tuffRocks =  biomes.getOrThrow(SubsTags.Biomes.IS_TUFF_ROCKS);
        var stoneRocks =  biomes.getOrThrow(SubsTags.Biomes.IS_STONE_ROCKS);

        //Adding Features
        //Main Patches
        context.register(ADD_DIRT_PATCHES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(rootedCaveBiome,
                HolderSet.direct(placedFeatures.getOrThrow(SubSPlacedFeatures.DIRT_PATCHES_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_COARSE_DIRT_PATCHES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(rootedCaveBiome,
                HolderSet.direct(placedFeatures.getOrThrow(SubSPlacedFeatures.COARSE_DIRT_PATCHES_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //Roof Veg
        context.register(ADD_ROOTED_CEILING_VEGETATION, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(rootedCaveBiome,
                HolderSet.direct(placedFeatures.getOrThrow(SubSPlacedFeatures.ROOTED_CEILING_FEATURES_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        //Floor Boulders
        context.register(ADD_ANDESITE_ROCKS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(andesiteRocks,
                HolderSet.direct(placedFeatures.getOrThrow(SubSPlacedFeatures.ANDESITE_ROCKS_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_DECORATION));
        context.register(ADD_CALCITE_ROCKS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(calciteRocks,
                HolderSet.direct(placedFeatures.getOrThrow(SubSPlacedFeatures.CALCITE_ROCKS_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_DECORATION));
        context.register(ADD_DIORITE_ROCKS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(dioriteRocks,
                HolderSet.direct(placedFeatures.getOrThrow(SubSPlacedFeatures.DIORITE_ROCKS_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_DECORATION));
        context.register(ADD_GRANITE_ROCKS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(graniteRocks,
                HolderSet.direct(placedFeatures.getOrThrow(SubSPlacedFeatures.GRANITE_ROCKS_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_DECORATION));
        context.register(ADD_TUFF_ROCKS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(tuffRocks,
                HolderSet.direct(placedFeatures.getOrThrow(SubSPlacedFeatures.TUFF_ROCKS_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_DECORATION));
        context.register(ADD_STONE_ROCKS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(stoneRocks,
                HolderSet.direct(placedFeatures.getOrThrow(SubSPlacedFeatures.STONE_ROCKS_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_DECORATION));


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
