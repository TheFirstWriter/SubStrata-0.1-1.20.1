package net.thefirstwriter.substrata.block;
/*
import net.minecraft.world.level.material.MapColor;
import net.thefirstwriter.substrata.SubStrata;
import net.thefirstwriter.substrata.block.customBlocks.RootVineHeadBlock;
import net.thefirstwriter.substrata.block.customBlocks.RootVinePlantBlock;
import net.thefirstwriter.substrata.item.ItemRegistry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SubStrata.MOD_ID);


    public static final RegistryObject<Block> ROOT_VINE_HEAD =
            BLOCKS.register("root_vine_plant",
                    () -> new RootVineHeadBlock(
                            BlockBehaviour.Properties.copy(Blocks.WEEPING_VINES)
                                    .mapColor(MapColor.DIRT)
                    ));

    public static final RegistryObject<Block> ROOT_VINE_PLANT =
            BLOCKS.register("root_vine_plant",
                    () -> new RootVinePlantBlock(
                            BlockBehaviour.Properties.copy(Blocks.WEEPING_VINES_PLANT)
                                    .mapColor(MapColor.DIRT)
                    ));

   /* public static final RegistryObject<Block> HANGING_ROOT_FLOWER =
            BLOCKS.register("hanging_root_flower",
                    () -> new RootVineFlowerFruit(
                            BlockBehaviour.Properties.copy(Blocks.SPORE_BLOSSOM)
                    ));*/
/*
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
*/