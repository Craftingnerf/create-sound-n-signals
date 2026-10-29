package com.example.soundnsignals.config;

import com.simibubi.create.infrastructure.config.CKinetics;
import net.createmod.catnip.config.ConfigBase;

public class SnSServerConfig extends ConfigBase {
    public final ConfigGroup infrastructure = group(0, "infrastructure", Comments.infrastructure);

//    public final CKinetics

    @Override
    public String getName() {
        return "server";
    }

    private static class Comments {
        static String infrastructure = "Server Config for Sound n' Signals";
    }

}
