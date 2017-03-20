package eu.the5zig.api.test;

import eu.the5zig.mod.modules.GameModeItem;

public class ActionBarModuleItem extends GameModeItem<MyServer.Main> {

	public ActionBarModuleItem() {
		super(MyServer.Main.class /* Only render when MyServer.Main is active */);
	}

	@Override
	protected Object getValue(boolean dummy) {
		if (dummy) {
			return "Example Action Bar Message";
		} else {
			return getGameMode().lastActionBarMessage;
		}
	}

	@Override
	public String getName() {
		return "ActionBar";
	}
}
