package com.example.soundnsignals.infrastructure;

import com.example.soundnsignals.CreateSoundandSignals;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import it.unimi.dsi.fastutil.objects.Object2DoubleOpenHashMap;
import net.createmod.catnip.config.ConfigBase;
import net.createmod.catnip.registry.RegisteredObjectsHelper;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleSupplier;

// copying the create mod's (and TFMG) format
public class SnSStress extends ConfigBase {
    private static final int VERSION = 2;


    // IDs need to be used since configs load before registration
    private static final Object2DoubleMap<ResourceLocation> DEFAULT_IMPACTS = new Object2DoubleOpenHashMap<>();
    private static final Object2DoubleMap<ResourceLocation> DEFAULT_CAPACITIES = new Object2DoubleOpenHashMap<>();

    protected final Map<ResourceLocation, ModConfigSpec.ConfigValue<Double>> capacities = new HashMap<>();
    protected final Map<ResourceLocation, ModConfigSpec.ConfigValue<Double>> impacts = new HashMap<>();

    @Override
    public String getName() {
        return "stressValues.v" + VERSION;
    }

    @Override
    public void registerAll(ModConfigSpec.Builder builder) {
        // 'Comments' class references are for string blobs
        builder.comment(".", Comments.su, Comments.impact).push("impact");
        DEFAULT_IMPACTS.forEach((id, value) -> this.impacts.put(id, builder.define(id.getPath(), value)));
        builder.pop();

        builder.comment(".", Comments.su, Comments.capacity).push("capacity");
        DEFAULT_CAPACITIES.forEach((id, value) -> this.capacities.put(id, builder.define(id.getPath(), value)));
        builder.pop();
    }

    // need one for capacities and impact, otherwise its the same code
    @Nullable
    public DoubleSupplier getImpact(Block block) {
        ResourceLocation id = RegisteredObjectsHelper.getKeyOrThrow(block);
        ModConfigSpec.ConfigValue<Double> value = this.impacts.get(id);
        return value == null ? null : value::get;
    }

    @Nullable
    public DoubleSupplier getCapacity(Block block) {
        ResourceLocation id = RegisteredObjectsHelper.getKeyOrThrow(block);
        ModConfigSpec.ConfigValue<Double> value = this.capacities.get(id);
        return value == null ? null : value::get;
    }
    // to be used when creating blocks in SnSBlockRegistry
    public static <B extends Block, P>NonNullUnaryOperator<BlockBuilder<B,P>> setImpact(double value) {
        return builder -> {
            assertFromSoundNSigs(builder);
            ResourceLocation id = CreateSoundandSignals.asResource(builder.getName());
            DEFAULT_IMPACTS.put(id, value);
            return builder;
        };
    }
    public static <B extends Block, P> NonNullUnaryOperator<BlockBuilder<B,P>> setCapacity(double value) {
        return builder -> {
            assertFromSoundNSigs(builder);
            ResourceLocation id = CreateSoundandSignals.asResource(builder.getName());
            DEFAULT_CAPACITIES.put(id, value);
            return builder;
        };
    }

    public static <B extends Block, P>NonNullUnaryOperator<BlockBuilder<B,P>> setNoImpact() {
        return setImpact(0.0f);
    }

    private static void assertFromSoundNSigs(BlockBuilder<?,?> builder) {
        if (!builder.getOwner().getModid().equals(CreateSoundandSignals.MODID))
            throw new IllegalStateException("Non-SoundnSignals blocks cant be addid to Sound n' Signals config (stop using SnSStress)");
    }

    private static class Comments {
        static String su = "[in Stress Units]";
        static String impact = "Configure the individual stress impact of mechanical blocks. Note that this cost is doubled for every speed increase it recieves.";
        static String capacity = "Configure how much stress a source can accomodate for.";
    }
}
