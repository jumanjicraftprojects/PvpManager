# Maintainer notes

`PvpStateManager` owns per-player state, `PvpState` owns lock/cooldown policy, and `CooldownTimer` now
runs on Bukkit's main-thread scheduler. `EventListener` resolves direct, projectile, TNT, and harmful
splash-potion attackers before applying both players' PvP state.

Use `.equals` for UUIDs, check worlds before measuring location distance, and never call Bukkit APIs
from `Timer` or another unmanaged thread. The duel command is intentionally informational until a
real consent/state machine is implemented. Build with `./gradlew clean test build` and test direct,
projectile, TNT, poison, wither, and instant-damage PvP plus logout cooldown persistence.
