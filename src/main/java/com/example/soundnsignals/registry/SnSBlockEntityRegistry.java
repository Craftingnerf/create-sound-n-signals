package com.example.soundnsignals.registry;

import com.example.soundnsignals.CreateSoundandSignals;
import com.example.soundnsignals.blocks.radios.RadioBlockEntity;
import com.example.soundnsignals.blocks.radios.RadioRenderer;
import com.example.soundnsignals.blocks.radios.RadioVisual;
import com.example.soundnsignals.blocks.radios.redstone.RedstoneRadioEntity;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

public class SnSBlockEntityRegistry {
    private static final CreateRegistrate REGISTRATE = CreateSoundandSignals.registrate();

//    public static final BlockEntityEntry<RadioBlockEntity> RADIO_ENTITY = REGISTRATE
//            .blockEntity("radio", RadioBlockEntity::new)
//            .visual(() -> RadioVisual::new, false)
//            .validBlocks(SnSBlockRegistry.ROTATION_RADIO)
//            .renderer(() -> RadioRenderer::new)
//            .register();
    public static final BlockEntityEntry<RedstoneRadioEntity> REDSTONE_RADIO = REGISTRATE
            .blockEntity("redstone_radio", RedstoneRadioEntity::new)
            .visual(() -> RadioVisual::new, false)
            .validBlocks(SnSBlockRegistry.REDSTONE_RADIO)
            .renderer(() -> RadioRenderer::new)
            .register();

    public static void register() {}
}
