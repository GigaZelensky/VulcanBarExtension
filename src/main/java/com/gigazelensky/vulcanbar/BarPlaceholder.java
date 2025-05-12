package com.gigazelensky.vulcanbar;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Placeholder usage:
 *
 * <ul>
 *   <li><code>%bar_current_max%</code> – explicit numbers, e.g. %bar_5_20%</li>
 *   <li><code>%bar%</code>             – most recent VL / max supplied by Vulcan for that player</li>
 * </ul>
 */
public class BarPlaceholder extends PlaceholderExpansion {

    private final VulcanBarPlugin plugin;

    public BarPlaceholder(VulcanBarPlugin plugin) {
        this.plugin = plugin;
    }

    /* ============= Meta ============== */

    @Override public @NotNull String getIdentifier() { return "bar"; }
    @Override public @NotNull String getAuthor()    { return "ChatGPT"; }
    @Override public @NotNull String getVersion()   { return plugin.getDescription().getVersion(); }

    /* ========== Placeholder ========== */

    @Override
    public String onPlaceholderRequest(Player player, String args) {

        /* ---- No args: pull the values we cached from the last flag ---- */
        if (args == null || args.isEmpty()) {
            VlPair pair = plugin.getLatestVl(player.getUniqueId());
            if (pair == null) {
                return "&f[]";
            }
            return buildBar(pair.current(), pair.max());
        }

        /* ---- With args: expecting <current>_<max> ---- */
        String[] split = args.split("_", 3);
        if (split.length < 2) return "&f[]";

        int current, max;
        try {
            current = Integer.parseInt(split[0]);
            max     = Integer.parseInt(split[1]);
        } catch (NumberFormatException ex) {
            return "&f[]";
        }

        return buildBar(current, max);
    }

    /* ============ Helper ============= */

    private static String buildBar(int current, int max) {
        if (max <= 0)  max = 1;
        if (current < 0) current = 0;

        int filled = Math.min(max, current + 1); // fix: always show at least 1
        StringBuilder sb = new StringBuilder("&f[");
        sb.append("&d").append("|".repeat(filled));
        sb.append("&b").append("|".repeat(max - filled));
        sb.append("&f]");
        return sb.toString();
    }
}
