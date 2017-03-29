package eu.the5zig.api.test;

import eu.the5zig.mod.server.ServerInstance;

/**
 * Tell the mod what server we want to handle.
 */
public class MyServerInstance extends ServerInstance {

	@Override
	public void registerListeners() {
		// Register a listener class
		getGameListener().registerListener(new MyLobbyListener());
		getGameListener().registerListener(new MyActionBarListener());
	}

	@Override
	public String getName() {
		return "localhost";
	}

	@Override
	public String getConfigName() {
		return "localhost";
	}

	@Override
	public boolean handleServer(String host, int port) {
		return host.equalsIgnoreCase("localhost");
	}

}
