package eu.the5zig.api.test;

import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.mod.event.ChatSendEvent;
import eu.the5zig.mod.event.EventHandler;
import eu.the5zig.mod.event.LoadEvent;
import eu.the5zig.mod.event.WorldTickEvent;
import eu.the5zig.mod.modules.Category;
import eu.the5zig.mod.plugin.Plugin;
import eu.the5zig.mod.util.IKeybinding;
import eu.the5zig.mod.util.NetworkPlayerInfo;
import eu.the5zig.util.minecraft.ChatColor;
import org.lwjgl.input.Keyboard;

/**
 * The main plugin class, as specified in plugin.json.
 */
@Plugin(name = "Test", version = "1.0") // necessary plugin annotation.
public class MainTest {

	/**
	 * Reference to a registered keybinding.
	 */
	private IKeybinding keybinding;

	@EventHandler(priority = EventHandler.Priority.LOW)
	public void onLoad(LoadEvent event) { // Called when the mod has been loaded.
		// log an info message
		The5zigAPI.getLogger().info("Hello World, the 5zig mod " + The5zigAPI.getAPI().getModVersion() + "!");

		// register a new server instance handler.
		The5zigAPI.getAPI().registerServerInstance(this, TestServerInstance.class);

		// register a new module item with the id "TEST" in category "Other".
		The5zigAPI.getAPI().registerModuleItem(this, "TEST", TestModuleItem.class, Category.OTHER);
		// register a new module item that renders only, when both the TestServerInstance and
		// the TestServer.TestServerGameMode are active
		The5zigAPI.getAPI().registerModuleItem(this, "TEST_MODE", TestServerGameItem.class, Category.SERVER_GENERAL);

		// register a new keybinding and store the result.
		keybinding = The5zigAPI.getAPI().registerKeyBiding("Gamemode 1", Keyboard.KEY_G, "OP");
	}


	@EventHandler(priority = EventHandler.Priority.HIGH)
	public void onWorldTick(WorldTickEvent event) { // called every tick, as long as the client is in a world.
		if (keybinding.isPressed()) { // check if the keybinding has been pressed.
			// if it has been pressed, change the game mode of the player.
			The5zigAPI.getAPI().sendPlayerMessage("/gamemode 1");
		}

		// Let's try something different: showing the current ping of all players behind their name in the player list
		for (NetworkPlayerInfo networkPlayerInfo : The5zigAPI.getAPI().getServerPlayers()) { // first of all, iterate through the player list
			// Not get the current display name (or player name, if the display name has not been set by the server) and append the players ping
			String displayName = networkPlayerInfo.getDisplayName();
			if (displayName == null) {
				displayName = networkPlayerInfo.getGameProfile().getName();
			}
			if (displayName == null) {
				continue;
			}
			int endIndex = displayName.lastIndexOf(" ");
			if (endIndex != -1) {
				displayName = displayName.substring(0, endIndex);
			}
			networkPlayerInfo.setDisplayName(displayName + ChatColor.GREEN + " " + ChatColor.ITALIC + networkPlayerInfo.getPing());
		}
	}

	@EventHandler
	public void onChatSend(ChatSendEvent event) { // called whenever the player wants to send a chat message to the server.
		if (event.getMessage().equals("I hate 5zig")) {
			event.setMessage("I love 5zig");
		}
	}

}
