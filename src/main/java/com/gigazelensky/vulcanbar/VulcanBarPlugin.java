package com.gigazelensky.vulcanbar;

import me.frep.vulcan.api.check.Check;
import me.frep.vulcan.api.event.VulcanFlagEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Plugin entry‑point.
 */
public final class VulcanBarPlugin extends JavaPlugin implements Listener {

    private final Map<UUID, VlPair> latestVl = new ConcurrentHashMap<>();

    @Override
    public void onEnable() {
        // Ensure PlaceholderAPI is loaded.
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) {
            getLogger().severe("PlaceholderAPI not found – disabling.");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        // Register our expansion and events.
        new BarPlaceholder(this).register();
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("VulcanBar initialised.");
    }

    /** Called by the placeholder to get the last recorded numbers. */
    public VlPair getLatestVl(UUID uuid) {
        return latestVl.get(uuid);
    }

    /* ======================================= */
    /*          Vulcan event listener          */
    /* ======================================= */

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onFlag(VulcanFlagEvent event) {
        Check check = event.getCheck();
        latestVl.put(event.getPlayer().getUniqueId(), new VlPair(check.getVl(), check.getMaxVl()));
    }
}
