package com.nihar.battleship;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.nihar.battleship.gui.GridScreen;
import com.nihar.battleship.ship.Ship;

/**
 * Main class that runs the different states of the game
 * @author Nihar
 *
 */
public class BattleshipGame extends Game {
	public ArrayList<Ship> ships;
	public ArrayList<Ship> getShips() {return ships;}
	//Player data
	
	private enum State {
		PLACING_SHIPS,
		PLAYER_1,
		SWITCH_TURNS,
		PLAYER_2,
		PAUSED
	}
	
	private State state;
	
	@Override
	public void create() {
		setScreen(new GridScreen());
	}
}
