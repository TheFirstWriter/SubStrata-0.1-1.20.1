package net.thefirstwriter.substrata.block.customBlocks;
/*
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.NetherVines;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thefirstwriter.substrata.block.BlockRegistry;
import net.thefirstwriter.substrata.item.ItemRegistry;

public class RootVineHeadBlock extends GrowingPlantHeadBlock {
    public static final IntegerProperty COLOR =
            IntegerProperty.create("color", 0, 2);
    public static final IntegerProperty VARIANT =
            IntegerProperty.create("variant", 0, 2);
    protected static final VoxelShape SHAPE =
            Block.box(
                    3.0D, 0.0D, 3.0D,
                    13.0D, 16.0D, 13.0D
            );

    public RootVineHeadBlock(final Properties properties){
        super(properties, Direction.DOWN, SHAPE, false, 0.1D);
        this.registerDefaultState(this.stateDefinition.any().setValue(COLOR, 0).setValue(VARIANT, 0));
    }

    @Override
    protected int getBlocksToGrowWhenBonemealed(RandomSource random) {
        return NetherVines.getBlocksToGrowWhenBonemealed(random);
    }

    @Override
    protected boolean canGrowInto(BlockState state) { return state.isAir();}

    @Override
    protected Block getBodyBlock() {return BlockRegistry.ROOT_VINE_PLANT.get();}

    @Override
    protected BlockState updateBodyAfterConvertedFromHead(BlockState headState, BlockState bodyState) {
        return bodyState.setValue(COLOR, headState.getValue(COLOR));
    }

    @Override
    protected BlockState getGrowIntoState(BlockState state, RandomSource random) {
        return this.defaultBlockState().setValue(COLOR, state.getValue(COLOR))
                .setValue(VARIANT, random.nextInt(3));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(COLOR, VARIANT);
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
        return new ItemStack(
                ItemRegistry.RootVine.get()
        );
    }
}
*/