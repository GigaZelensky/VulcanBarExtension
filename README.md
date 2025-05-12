# VulcanBar

A minimal **Paper 1.21+** plugin that turns Vulcan anti‑cheat violation levels into a clean, colour‑coded progress bar exposed through PlaceholderAPI.

```
&f[&d|||||||&b|||||||||||||||&f]  ← 7 / 20 VL
```

*Pink (`&d`) segments* = current VL · *Blue (`&b`) segments* = remaining until max

---

## Placeholders

| Placeholder             | Example                   | Description |   |     |   |   |   |     |   |   |   |   |   |   |   |   |   |   |   |        |                                                     |   |        |                                    |
| ----------------------- | ------------------------- | ----------- | - | --- | - | - | - | --- | - | - | - | - | - | - | - | - | - | - | - | ------ | --------------------------------------------------- | - | ------ | ---------------------------------- |
| `%bar%`                 | \`\&f\[\&d                |             |   | \&b |   |   |   |     |   |   |   |   |   |   |   |   |   |   |   | \&f]\` | Latest VL pair received from Vulcan for the player. |   |        |                                    |
| `%bar_<current>_<max>%` | `%bar_7_20%` → \`\&f\[\&d |             |   |     |   |   |   | \&b |   |   |   |   |   |   |   |   |   |   |   |        |                                                     |   | \&f]\` | Build a bar from explicit numbers. |

> The bar always shows at least **one filled segment**, even at 0 VL.

---

## Installation

1. Place **`VulcanBar.jar`** in your server’s `plugins/` folder.
2. Make sure **Vulcan** and **PlaceholderAPI** are installed.
3. Restart or reload the server.
4. Insert the placeholders in any plugin that supports PAPI (scoreboards, tablists, menus, etc.).

---

## Building

```bash
mvn clean package
```

Requires **Java 17** and **Maven 3.9+**.

---

## License

MIT
---

Made by **GigaZelensky** with ☕ and rage.
