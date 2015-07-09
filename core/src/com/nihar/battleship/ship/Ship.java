package com.nihar.battleship.ship;

import java.util.ArrayList;
import java.util.Arrays;

import com.badlogic.gdx.graphics.Texture;
import com.nihar.battleship.Cell;

public class Ship {
	public enum ShipType {
		MOTORBOAT,
		DESTROYER,
		SUBMARINE,
		BATTLESHIP,
		AIRCRAFT_CARRIER
	}
	public Texture sprite;
	private ArrayList<Cell> cells;
	private ShipType type;
	
	public Ship(ShipType type, Cell... cells) {
		this.type = type;
		this.cells = new ArrayList<Cell>(Arrays.asList(cells));
	}
	
	public ArrayList<Cell> getCells() {
		return cells;
	}
}