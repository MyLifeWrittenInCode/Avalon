package com.ruse.world.content.globalBosses;

import com.ruse.model.Position;

/**
 * Created by Stan van der Bend on 16/12/2017. project: runeworld-game-server
 * package: runeworld.world.entity.combat.strategy.global
 */
public class SpawnLocation {

	private final Position spawnPosition;
	private final String spawnMessage;

	public SpawnLocation(Position spawnPosition, String spawnMessage) {
		this.spawnPosition = spawnPosition;
		this.spawnMessage = spawnMessage;
	}

	public Position getSpawnPosition() {
		return spawnPosition;
	}

	public String getString() {
		return spawnMessage;
	}
}
