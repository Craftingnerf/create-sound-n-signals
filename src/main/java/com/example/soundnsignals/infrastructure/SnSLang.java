package com.example.soundnsignals.infrastructure;

import com.example.soundnsignals.CreateSoundandSignals;
import net.createmod.catnip.lang.LangBuilder;
import net.createmod.catnip.lang.LangNumberFormat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class SnSLang {
    public static LangBuilder builder() {
        return new LangBuilder(CreateSoundandSignals.MODID);
    }
    public static LangBuilder number(double d) {
        return builder().text(LangNumberFormat.format(d));
    }
    public static LangBuilder itemName(ItemStack stack) {
        return builder().add(stack.getHoverName().copy());
    }
    public static LangBuilder text(String text) {
        return builder().text(text);
    }
    public static LangBuilder blockName(BlockState state) {
        return builder().add(state.getBlock().getName());
    }

    public static LangBuilder translate(String langKey, Object... args) {
        return builder().translate(langKey, args);
    }
}
