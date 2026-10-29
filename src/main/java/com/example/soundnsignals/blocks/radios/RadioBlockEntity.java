package com.example.soundnsignals.blocks.radios;

import com.example.soundnsignals.infrastructure.SnSLang;
import com.simibubi.create.content.kinetics.base.DirectionalShaftHalvesBlockEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

// copying create's gearbox block entity
public class RadioBlockEntity extends DirectionalShaftHalvesBlockEntity {
    protected float frequency;

    @Override
    public void tick() {
        super.tick();
    }
    @Override
    public void lazyTick() {
        super.lazyTick();
        setFrequency(Mth.abs(this.getSpeed() * 3.5f));
    }
    private void setFrequency(float frequency) {
        this.frequency = frequency;
        notifyUpdate();
    }
    public float getFrequency() {
        return frequency;
    }

    @Override
    protected void write(CompoundTag tag, HolderLookup.Provider registries, boolean clientPacket) {
        super.write(tag, registries, clientPacket);
        tag.putFloat("Frequency", frequency);
    }
    @Override
    protected void read(CompoundTag tag, HolderLookup.Provider registries, boolean clientPacket) {
        super.read(tag, registries, clientPacket);
        frequency = tag.getFloat("Frequency");
    }

    @Override
    public float calculateStressApplied() {
        float impact = 1.0f;
        this.lastStressApplied = impact;
        return impact;
    }

     @Override
     public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
         super.addToGoggleTooltip(tooltip, isPlayerSneaking);
         SnSLang.translate("radio_block_entity.frequency")
                 .style(ChatFormatting.GRAY)
                 .add(SnSLang.text(" "))
                 .add(SnSLang.number(this.frequency).add(SnSLang.text("MHz")).style(ChatFormatting.AQUA))
                 .forGoggles(tooltip);
         return true;
     }
    public RadioBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
    @Override
    protected boolean isNoisy() {
        return false;
    }
}
