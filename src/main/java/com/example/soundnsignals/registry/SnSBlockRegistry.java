package com.example.soundnsignals.registry;

import com.example.soundnsignals.CreateSoundandSignals;
import com.example.soundnsignals.blocks.radios.redstone.RedstoneRadio;
import com.example.soundnsignals.infrastructure.SnSStress;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;

import static com.simibubi.create.foundation.data.ModelGen.customItemModel;

public class SnSBlockRegistry {
    private static final CreateRegistrate REGISTRATE = CreateSoundandSignals.registrate();

    static {
        REGISTRATE.setCreativeTab(SnSCreativeTabRegistry.MAIN_TAB);
    }

    // public static final BlockEntry<RotationRadio> ROTATION_RADIO =
    //     REGISTRATE.block("rotation_radio", RotationRadio::new)
    //         .initialProperties(SharedProperties::stone)
    //         .transform(SnSStress.setImpact(4.0f))
    //         .blockstate(BlockStateGen.directionalBlockProvider(true))
    //         .item()
    //         .transform(customItemModel())
    //         .register();
    public static final BlockEntry<RedstoneRadio> REDSTONE_RADIO =
            REGISTRATE.block("redstone_radio", RedstoneRadio::new)
                    .initialProperties(SharedProperties::stone)
                    .transform(SnSStress.setImpact(4.0f))
                    .blockstate(BlockStateGen.directionalBlockProvider(true))
                    .item()
                    .transform(customItemModel())
                    .register();

    public static void register() {}
}