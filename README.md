![NoBullying Banner](https://lapislabs.dev/images/NoBullyingBanner.png)

A lightweight plugin that prevents mob swarms by limiting how many mobs can target a player at once.

## Features

- 🛡️ Limits the number of mobs that can target a player simultaneously
- 🌍 Multi-world support - enable/disable per world
- ⚡ Lightweight and efficient
- ⚙️ Fully configurable
- 🔄 Reload configuration without restart

## Configuration

```yaml
# Maximum number of mobs that can target a player at once
max-targeting-mobs: 5

# Worlds where the plugin is enabled
enabled-worlds:
  - world
  - world_nether
  - world_the_end
```

## Commands

- `/bully reload` - Reloads the plugin configuration
  - Permission: `nobullying.reload`

## Installation

1. Download the latest version of NoBullying
2. Place the jar file in your server's `plugins` folder
3. Start/restart your server
4. Configure the plugin in `plugins/NoBullying/config.yml`

## Support

Need help? Join our Discord server: [Discord Support](https://discord.gg/KmHGjaHWct)

## License

This project is licensed under the MIT License.

---
Made with ❤️ by KoopaLabs
```
