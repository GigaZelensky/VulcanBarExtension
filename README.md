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

Example usage:

```
format: '%prefix% &f%player% &7failed &f%check% %dev%&7(&fType %type%&7)%dev% &7[&4%vl%&7/&4%max-vl%&7] %bar%'
```

# I suggest editing the code to change the bar colors and then compiling it yourself.
# This plugin was made for personal use but I decided to post it here in case someone likes it.
---

Made by **GigaZelensky** with ☕ and rage.
