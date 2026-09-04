# Changelog

## 1.0.1

- Moves cooldown callbacks onto Bukkit's main-thread scheduler.
- Corrects UUID identity comparisons and harmful splash-potion filtering.
- Preserves player data files during startup and updates the supported build toolchain.
- Rejects self/cross-world duel requests and reports that duels remain intentionally disabled.
