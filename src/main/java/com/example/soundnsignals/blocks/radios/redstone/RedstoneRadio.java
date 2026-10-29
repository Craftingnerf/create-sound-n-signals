package com.example.soundnsignals.blocks.radios.redstone;

import com.example.soundnsignals.blocks.radios.RadioBase;
import com.example.soundnsignals.registry.SnSBlockEntityRegistry;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class RedstoneRadio extends RadioBase<RedstoneRadioEntity> {
    public RedstoneRadio(Properties properties) {
        super(properties);
    }
    @Override
    public Class<RedstoneRadioEntity> getBlockEntityClass() {
        return RedstoneRadioEntity.class;
    }

    @Override
    public BlockEntityType<? extends RedstoneRadioEntity> getBlockEntityType() {
        return SnSBlockEntityRegistry.REDSTONE_RADIO.get();
    }
}
