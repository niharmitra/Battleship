package com.nihar.battleship.ship;

import java.util.ArrayList;
import java.util.Arrays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.nihar.battleship.Cell;
import com.nihar.battleship.Constants;

public class Ship {
	public enum ShipType {
		MOTORBOAT,
		DESTROYER,
		BATTLESHIP
	}
	public TextureRegion[] textures;
	private ArrayList<Cell> cells;
	private ShipType type;
	
	public Ship(ShipType type, Cell... cells) {
		this.type = type;
		this.cells = new ArrayList<Cell>(Arrays.asList(cells));
		setUpTextures();
	}
	
	public ArrayList<Cell> getCells() {
		return cells;
	}
	
	public boolean hit(Cell cell) {
		if(cells.contains(cell)) {
			cell.damage();
			return true;
		}
		return false;
	}
	
	/**
	 * Returns the appropriate texture for a cell to use
	 * Based on its position in the ship
	 */
	public TextureRegion getTexture(int position) {
		return textures[position];
	}
	
	/**
	 * Sets up this ship with the appropriate textures depending on which ship it is
	 */
	private void setUpTextures() {
		switch(type) {
		case MOTORBOAT:
			Texture motorboat = new Texture(Gdx.files.internal(Constants.MOTORBOAT_TEXTURE_PATH));
			textures = new TextureRegion[1];
			textures[0] = new TextureRegion(motorboat, 0, 0, motorboat.getWidth(), motorboat.getHeight());
			break;
		case DESTROYER:
			Texture destroyer = new Texture(Gdx.files.internal(Constants.DESTROYER_TEXTURE_PATH));
			textures = new TextureRegion[2];
			textures[0] = new TextureRegion(destroyer, 0, 0, destroyer.getWidth(), destroyer.getHeight()/2);
			textures[1] = new TextureRegion(destroyer, 0, destroyer.getHeight()/2, destroyer.getWidth(), destroyer.getHeight());
		case BATTLESHIP:
			Texture battleship = new Texture(Gdx.files.internal(Constants.BATTLESHIP_TEXTURE_PATH));
			textures = new TextureRegion[3];
			textures[0] = new TextureRegion(battleship, 0, 0, battleship.getWidth(), battleship.getHeight()/3);
			textures[1] = new TextureRegion(battleship, 0, battleship.getHeight()/3, battleship.getWidth(), battleship.getHeight()*2/3);
			textures[2] = new TextureRegion(battleship, 0, battleship.getHeight()*2/3, battleship.getWidth(), battleship.getHeight());
		}
	}
}