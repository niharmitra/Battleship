package com.nihar.battleship;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nihar.battleship.gui.GridScreen;
import com.nihar.battleship.gui.GridStage;
import com.nihar.battleship.gui.Gui;
import com.nihar.battleship.ship.Ship;
import com.nihar.battleship.ship.Ship.ShipType;

/**
 * Main class that runs the different states of the game
 * @author Nihar
 *
 */
public class BattleshipGame extends Game {
	public ArrayList<Ship> ships;
	public ArrayList<Ship> getShips() {return ships;}
	//Player data
	private Cell[] selectedCells = new Cell[5];
	
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
		grid = new ArrayList<ArrayList<Cell>>(5);
		for(int i=0; i<5; i++) {
			grid.add(new ArrayList<Cell>(5));
			for(int j=0; j<5; j++) {
				grid.get(i).add(new Cell(i,j));
			}
		}
	}
	
	private Cell randomCell() {
		return(grid.get((int) (Math.random()*grid.size())).get((int) (Math.random()*grid.get(0).size())));
	}
}
