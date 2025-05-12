# VulcanBar

A **minimal Paper 1.21+ plugin** that hooks directly into the [Vulcan](https://www.mc-market.org/resources/18306/) anti‑cheat API and exposes a colourful visual **violation‑level progress bar** as a PlaceholderAPI expansion.

```
&f[&d|||||&b|||||||||||||||&f]  ← 5 / 20 VL
```

*Pink (`&d`) bars* represent the player’s **current VL**.
*Light‑blue (`&b`) bars* show how much is left until Vulcan reaches its **maximum VL** and will take action.

---

## Why?

* In‑game VL numbers are ugly and hard to parse at a glance.
* Most scoreboard / tab plugins accept PAPI placeholders – why not show a tidy bar instead?
* Ultra‑lightweight – \~30 lines of logic, no commands, no config, no runtime tasks.

---

## Placeholders

| Placeholder             | Example (`current = 3`, `max = 20`) | Notes |   |   |     |   |   |     |   |   |   |   |   |   |   |   |   |   |   |   |        |                                                                                       |
| ----------------------- | ----------------------------------- | ----- | - | - | --- | - | - | --- | - | - | - | - | - | - | - | - | - | - | - | - | ------ | ------------------------------------------------------------------------------------- |
| `%bar%`                 | \`\&f\[\&d                          |       |   |   | \&b |   |   |     |   |   |   |   |   |   |   |   |   |   |   |   | \&f]\` | Uses the most recent VL pair cached for the player (from the last `VulcanFlagEvent`). |
| `%bar_<current>_<max>%` | `%bar_7_20%` → \`\&f\[\&d           |       |   |   |     |   |   | \&b |   |   |   |   |   |   |   |   |   |   |   |   | \&f]\` | Supply explicit numbers if you need a bar unrelated to the last flag.                 |

> **Heads‑up:** The bar always shows **at least one filled segment** – so a player on 0 VL appears as `&f[&d|&b|||||||||||||||||||&f]`.

---

## Installation

1. Drop **`VulcanBar-<version>.jar`** into your server’s `plugins/` folder.
2. Make sure you already have:

   * **Vulcan** (same version you compiled against)
   * **PlaceholderAPI**
3. Restart / reload.
4. Use `%bar%` or `%bar_<current>_<max>%` in any plugin that supports PAPI (TAB, DeluxeMenus, Scoreboard, etc.).

### Upgrading

Simply replace the old jar and reload – no configuration files to worry about.

---

## Building from Source

```bash
git clone https://github.com/<your‑user>/VulcanBar.git
cd VulcanBar
mvn clean package
```

* **Java 17** and **Maven 3.9+** required.
* The build grabs `paper‑api`, `placeholderapi` and `vulcan‑api` automatically from public Maven repos (no shady jars in `libs/`).
* The shaded jar is produced in `target/`.

---

## How It Works (quick overview)

1. **`VulcanBarPlugin`** registers a listener for `VulcanFlagEvent`.
2. When a player flags, we store a small record `{current, max}` in a `Map<UUID, VlPair>`.
3. **`BarPlaceholder`** implements `PlaceholderExpansion` and returns a coloured bar built with `StringBuilder` + `"|".repeat()`.
4. The bar’s length equals `max`.  Current VL is capped, sanitised, and the display guarantees at least one filled segment.

---

## Contributing

Pull requests and issues are welcome!  Please keep the project’s ethos – **minimal, dependency‑free and easy to read** – in mind when proposing changes.

---

## License

MIT

---

Made by **GigaZelensky** with ☕ and rage.
