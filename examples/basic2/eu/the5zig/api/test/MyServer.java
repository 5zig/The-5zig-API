package eu.the5zig.api.test;

import eu.the5zig.mod.server.GameMode;

public class MyServer {

	public static class Main extends GameMode {

		public String lastActionBarMessage;

		/**
		 * @return the name of the gamemode (will be displayed to all mod friends).
		 */
		@Override
		public String getName() {
			return "Server";
		}

	}
}
