public class MyLobbyListener extends AbstractGameListener<MyServer.MainServer> {
  @Override
  public Class<MyServer.MainServer> getGameMode() {
    return null;
  }

  @Override
  public boolean matchLobby(String lobby) {
    return false;
  }

  @Override
  public void onServerJoin() {
    getGameListener().switchLobby("Lobby");
  }
}