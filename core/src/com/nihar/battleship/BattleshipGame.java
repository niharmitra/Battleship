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
	private ShapeRenderer sr;
	private Gui gui;
	private GridStage stage;
	//Game data, grid and ships
	private ArrayList<ArrayList<Cell>> grid;
	public ArrayList<ArrayList<Cell>> getGrid() {return grid;}
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
		sr = new ShapeRenderer();
		gui = new Gui(this, sr);
		stage = new GridStage();
		setScreen(new GridScreen());
		grid = new ArrayList<ArrayList<Cell>>(5);
		for(int i=0; i<5; i++) {
			grid.add(new ArrayList<Cell>(5));
			for(int j=0; j<5; j++) {
				grid.get(i).add(new Cell(i,j));
			}
		}
	}
	
	private Ship placeShip(Cell... cell) {
		//Somehow do the spawning lol
		Ship ship;
		switch(cell.length) {
		case 1:
			
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		default:
			return null;
		}
		ship = new Ship(ShipType.MOTORBOAT, randomCell());
		return ship;
	}
	
	private Cell randomCell() {
		return(grid.get((int) (Math.random()*grid.size())).get((int) (Math.random()*grid.get(0).size())));
	}
}
