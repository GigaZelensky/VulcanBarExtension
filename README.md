## Placeholders

This plugin provides two simple placeholders for displaying Vulcan violation levels as progress bars:

### 1. `%bar%`

Displays a progress bar using the most recent VL data cached for the player (from the last `VulcanFlagEvent`).

Example output (with current VL = 3, max VL = 20):

```
&f[&d|||&b|||||||||||||||||&f]
```

### 2. `%bar_<current>_<max>%`

Allows you to manually specify current and maximum VL for custom scenarios or explicit values.

Example usage and output (`%bar_7_20%`):

```
&f[&d|||||||&b|||||||||||||&f]
```

---

Made by **GigaZelensky** with ☕ and rage.
