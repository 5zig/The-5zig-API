package eu.the5zig.api.test;

import eu.the5zig.mod.server.ServerInstance;

public class TestServerInstance extends ServerInstance {

	@Override
	public void registerListeners() {
		getGameListener().registerListener(new TestServerListener());
		getGameListener().registerListener(new TestServerGameListener());
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
		return host.equals("localhost");
	}

}
