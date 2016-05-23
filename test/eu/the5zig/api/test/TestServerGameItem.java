/*
 *    Copyright 2016 5zig
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package eu.the5zig.api.test;

import eu.the5zig.mod.modules.GameModeItem;

/**
 * This item will be only rendered, when {@link eu.the5zig.api.test.TestServer.TestServerGameMode} is active.
 */
public class TestServerGameItem extends GameModeItem<TestServer.TestServerGameMode> {

	public TestServerGameItem() {
		super(TestServer.TestServerGameMode.class);
	}

	@Override
	protected Object getValue(boolean dummy) {
		return getGameMode().getName();
	}

	@Override
	public String getName() {
		return "Game Mode";
	}
}
