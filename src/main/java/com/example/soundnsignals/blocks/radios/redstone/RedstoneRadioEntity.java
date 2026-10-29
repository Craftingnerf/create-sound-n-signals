package com.example.soundnsignals.blocks.radios.redstone;

import com.example.soundnsignals.blocks.radios.RadioBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class RedstoneRadioEntity extends RadioBlockEntity {
    public RedstoneRadioEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
}
