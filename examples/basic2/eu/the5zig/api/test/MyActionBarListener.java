package eu.the5zig.api.test;

import eu.the5zig.mod.server.AbstractGameListener;
import eu.the5zig.util.minecraft.ChatColor;

/**
 * Handle the action bar event
 */
public class MyActionBarListener extends AbstractGameListener<MyServer.Main> {

	@Override
	public Class<MyServer.Main> getGameMode() {
		return MyServer.Main.class;
	}

	/**
	 * When should this action listener be active? Return {@code true} to be always active.
	 * @param lobby the new lobby. The lobby can be switched by calling {@link #gameListener} {@link eu.the5zig.mod.server.GameListenerRegistry#switchLobby(String)}
	 * @return true, if the action handler should be active for the specified lobby.
	 */
	@Override
	public boolean matchLobby(String lobby) {
		return true;
	}

	/**
	 * Called whenever we receive an action bar message.
	 *
	 * @param gameMode the current game mode instance.
	 * @param message  the message that has been received.
	 * @return true to cancel.
	 */
	@Override
	public boolean onActionBar(MyServer.Main gameMode, String message) {
		gameMode.lastActionBarMessage = ChatColor.stripColor(message);
		return false;
	}
}
