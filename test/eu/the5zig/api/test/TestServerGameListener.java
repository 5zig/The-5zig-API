package eu.the5zig.api.test;

import eu.the5zig.mod.server.AbstractGameListener;
import eu.the5zig.mod.server.GameState;
import eu.the5zig.mod.server.IPatternResult;

public class TestServerGameListener extends AbstractGameListener<TestServer.TestServerGameMode> {

	@Override
	public Class<TestServer.TestServerGameMode> getGameMode() {
		return TestServer.TestServerGameMode.class;
	}

	@Override
	public boolean matchLobby(String lobby) {
		return lobby.startsWith("dl-");
	}

	@Override
	public void onMatch(TestServer.TestServerGameMode gameMode, String key, IPatternResult match) {
		if (key.equals("dl.start")) {
			gameMode.setState(GameState.GAME);
		}
		if (key.equals("dl.end")) {
			gameMode.setState(GameState.FINISHED);
		}
	}
}
