package eu.the5zig.api.test;

import eu.the5zig.mod.server.GameMode;

public class TestServer {

	public static class TestServerGameMode extends GameMode {

		@Override
		public String getName() {
			return "Dummy-Mode";
		}

	}
}
