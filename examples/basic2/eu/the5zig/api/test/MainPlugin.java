package eu.the5zig.api.test;

import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.mod.event.EventHandler;
import eu.the5zig.mod.event.LoadEvent;
import eu.the5zig.mod.modules.Category;
import eu.the5zig.mod.plugin.Plugin;

/**
 * Example plugin for displaying the last received action bar message.
 */
@Plugin(name = "Test", version = "1.0") // necessary plugin annotation.
public class MainPlugin {

	@EventHandler(priority = EventHandler.Priority.LOW)
	public void onLoad(LoadEvent event) { // Called when the mod has been loaded.
		// log an info message
		The5zigAPI.getLogger().info("Hello World, the 5zig mod " + The5zigAPI.getAPI().getModVersion() + "! Loading example plugin!");

		// register a new server instance handler.
		The5zigAPI.getAPI().registerServerInstance(this, MyServerInstance.class);

		// register a new module item with the id "ACTION_BAR" in category "Other".
		The5zigAPI.getAPI().registerModuleItem(this, "ACTION_BAR", ActionBarModuleItem.class, Category.OTHER);
	}

}
