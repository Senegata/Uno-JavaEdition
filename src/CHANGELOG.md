# Changelog

## [Unreleased]

### Added
- Added a new feature that allows both players to sort their hand by color.
    - Sorting order follows the official UNO color sequence: **Red → Yellow → Green → Blue**.
    - Introduced a new in‑turn command: **O = Sort hand by color**.

### Changed
- Updated the `Hands` class:
    - Added a reusable private method `ordinaManoPerColore(List<Carta> mano)` to sort any hand by color.
    - Added two public methods:
        - `ordinaManoGiocatore1PerColore()`
        - `ordinaManoGiocatore2PerColore()`


- Updated the `Actions` class:
    - Integrated the new sorting command into `turnoGiocatore1()`:
        - When the player inputs **O**, the hand is sorted and re‑rendered.
    - Applied the same integration to `turnoGiocatore2()`.

### Notes
- No changes were made to `CardRenderer` or the rendering logic.
- No changes were made to the deck structure (`Mazzo`).
- The feature is fully backward‑compatible and does not alter gameplay logic.
