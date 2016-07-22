package eu.the5zig.mod.util;

import com.mojang.authlib.GameProfile;

/**
 * A class that represents an entry of the network player list.
 */
public interface NetworkPlayerInfo {

	/**
	 * @return the {@link GameProfile} of this player.
	 */
	GameProfile getGameProfile();

	/**
	 * @return the display name of this player or {@code null}, if no display name has been set.
	 */
	String getDisplayName();

	/**
	 * Sets a new display name for this player.
	 *
	 * @param displayName the new display name for this player.
	 */
	void setDisplayName(String displayName);

	/**
	 * @return the player response time to server in milliseconds.
	 */
	int getPing();

}
