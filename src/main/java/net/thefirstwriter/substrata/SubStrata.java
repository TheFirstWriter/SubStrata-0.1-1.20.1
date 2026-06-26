package net.thefirstwriter.substrata;

import com.mojang.logging.LogUtils;
//import net.thefirstwriter.substrata.worldgen.biome.SubSTerrablender;
//import net.thefirstwriter.substrata.block.BlockRegistry;
//import net.thefirstwriter.substrata.item.CreativeModTab;
//import net.thefirstwriter.substrata.item.ItemRegistry;
import net.thefirstwriter.substrata.worldgen.biome.surface.SubSSurfaceRules;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
//import net.minecraft.world.food.FoodProperties;
//import net.minecraft.world.item.BlockItem;
//import net.minecraft.world.item.CreativeModeTab;
//import net.minecraft.world.item.CreativeModeTabs;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.state.BlockBehaviour;
//import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;
import static terrablender.api.SurfaceRuleManager.RuleStage.BEFORE_BEDROCK;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(SubStrata.MOD_ID)
public class SubStrata

{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "substrata";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public SubStrata(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        //CreativeModTab.register(modEventBus);

        //ItemRegistry.register(modEventBus);
        //BlockRegistry.register(modEventBus);


        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        /*event.enqueueWork(() -> {
            SurfaceRuleManager.addToDefaultSurfaceRulesAtStage(SurfaceRuleManager.RuleCategory.OVERWORLD, BEFORE_BEDROCK,100, SubSSurfaceRules.makeRules());
        });*/
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
