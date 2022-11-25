package com.github.kaspiandev.flyinghat;

import com.github.kaspiandev.KAPI.libs.dev.dejvokep.boostedyaml.YamlDocument;
import com.github.kaspiandev.kapi.config.Config;
import com.github.kaspiandev.kapi.config.DefaultConfig;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.logging.Logger;

public final class FlyingHat extends JavaPlugin {

    private static Plugin plugin;
    private static Config config;
    private static YamlDocument yamlDoc;

    @Override
    public void onEnable() {
        try {
            yamlDoc = new DefaultConfig(this).get();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        config = new Config(yamlDoc);
        plugin = this;
    }

    @Override
    public void onDisable() {}

    public static Plugin getPlugin() {
        return plugin;
    }

    public static Config getPluginConfig() {
        return config;
    }

    public static YamlDocument getYamlDoc() {
        return yamlDoc;
    }

    @NotNull
    @Override
    public Logger getLogger() {
        return super.getLogger();
    }
}