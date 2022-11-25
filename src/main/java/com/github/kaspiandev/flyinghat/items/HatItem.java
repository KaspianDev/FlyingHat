package com.github.kaspiandev.flyinghat.items;

import com.github.kaspiandev.KAPI.libs.dev.dejvokep.boostedyaml.YamlDocument;
import com.github.kaspiandev.flyinghat.FlyingHat;
import com.github.kaspiandev.kapi.builders.ItemBuilder;
import com.github.kaspiandev.kapi.colors.Color;
import com.github.kaspiandev.kapi.config.Config;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public class HatItem {

    private final Plugin plugin = FlyingHat.getPlugin();
    private final YamlDocument yamlDoc = FlyingHat.getYamlDoc();
    private final Config config = FlyingHat.getPluginConfig();
    private final Color color = new Color(config);
    private final Map<Enchantment, Integer> enchantMap = new HashMap<>();

    public HatItem() {
    }

    private ItemStack get() {
        for (Object key : yamlDoc.getSection("hat.enchants").getKeys()) {
            enchantMap.put(Enchantment.getByKey(new NamespacedKey(plugin,
                    key.toString())), yamlDoc.getInt("hat.enchants." + key));
        }
        return new ItemBuilder(Material.valueOf(yamlDoc.getString("hat.material")))
                            .lore(color.list(yamlDoc.getStringList("hat.lore")))
                            .enchants(enchantMap)
                            .integer(new NamespacedKey(plugin, "flyinghat"), 1)
                            .build();
    }
}