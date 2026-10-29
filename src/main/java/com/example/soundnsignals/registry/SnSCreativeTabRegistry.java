package com.example.soundnsignals.registry;

import com.example.soundnsignals.CreateSoundandSignals;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SnSCreativeTabRegistry {
    private static final DeferredRegister<CreativeModeTab> REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateSoundandSignals.MODID);
    private static final CreateRegistrate REGISTRATE = CreateSoundandSignals.registrate();

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN_TAB = REGISTER.register("sound_n_signals-main",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creative_tab.soundnsignals_main"))
//                    .withTabsBefore(CreativeModeTab.COMBAT)
                    .icon(() -> SnSBlockRegistry.REDSTONE_RADIO.get().asItem().getDefaultInstance())
                    .build());

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        CreateSoundandSignals.LOGGER.info("Adding to Creative Tab");
        if (event.getTab() == SnSCreativeTabRegistry.MAIN_TAB.get()) {
            for (RegistryEntry<Item, ?> item : REGISTRATE.getAll(Registries.ITEM)) {
                CreateSoundandSignals.LOGGER.info("Checking item {}", item.getId());
                if (!CreateRegistrate.isInCreativeTab(item, MAIN_TAB))
                    continue;
                CreateSoundandSignals.LOGGER.info("Adding item {}", item.getId());
                event.accept(item.get(), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
            }
        }
    }

    public static void register(IEventBus modEventBus) {
        CreateSoundandSignals.LOGGER.info("Registering Creative Tabs");
        REGISTER.register(modEventBus);
    }

}
