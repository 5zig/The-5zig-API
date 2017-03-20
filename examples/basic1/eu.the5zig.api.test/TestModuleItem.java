package eu.the5zig.api.test;

import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.mod.modules.AbstractModuleItem;
import eu.the5zig.mod.render.RenderLocation;

/**
 * A very simple module item that simply displays "Test", prefixed with "Hello".
 */
public class TestModuleItem extends AbstractModuleItem {

	@Override
	public void registerSettings() {
		// register a new setting.
		getProperties().addSetting("testSetting", true);
	}

	@Override
	public void render(int x, int y, RenderLocation renderLocation, boolean dummy) {
		// render something to the screen.
		The5zigAPI.getAPI().getRenderHelper().drawString(getPrefix() + "TEST", x, y);
	}

	@Override
	public int getWidth(boolean dummy) {
		return The5zigAPI.getAPI().getRenderHelper().getStringWidth(getPrefix() + "TEST"); // the width of this item.
	}

	@Override
	public int getHeight(boolean dummy) {
		return 10; // the height of this item.
	}

	@Override
	public String getName() {
		return "Test-Item"; // the name of this item.
	}
}
