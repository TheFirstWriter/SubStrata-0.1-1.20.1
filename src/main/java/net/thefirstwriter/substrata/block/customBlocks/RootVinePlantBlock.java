package net.thefirstwriter.substrata.block.customBlocks;
/*
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
//import net.minecraft.server.level.ServerLevel;
//import net.minecraft.util.RandomSource;
//import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
//import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
//import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thefirstwriter.substrata.block.BlockRegistry;
import net.thefirstwriter.substrata.item.ItemRegistry;


public class RootVinePlantBlock extends GrowingPlantBodyBlock {
    public static final IntegerProperty COLOR =
            IntegerProperty.create("color", 0, 2);
    public static final IntegerProperty VARIANT =
            IntegerProperty.create("variant", 0, 2);

    public static final VoxelShape SHAPE =
            Block.box(
                    3.0D, 0.0D, 3.0D,
                    13.0D, 16.0D, 13.0D
            );

    public RootVinePlantBlock(final Properties properties) {
        super(properties, Direction.DOWN, SHAPE, false);
        this.registerDefaultState(this.stateDefinition.any().setValue(COLOR,0).setValue(VARIANT,0));

    }

    protected GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock) BlockRegistry.ROOT_VINE_HEAD.get();
    }
    @Override
    protected BlockState updateHeadAfterConvertedFromBody(final BlockState bodyState, final BlockState headState) {
        return headState.setValue(COLOR, bodyState.getValue(COLOR));
    }

    @Override
    public ItemStack getCloneItemStack(final BlockGetter level, final BlockPos pos, final BlockState state) {
        return new ItemStack(ItemRegistry.RootVine.get());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(COLOR, VARIANT);
    }
}
*/