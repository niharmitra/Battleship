package com.nihar.battleship.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.nihar.battleship.BattleshipGame;
import com.nihar.battleship.Cell;

/**
 * Covers the gui aspects of the Battleship game
 * Takes the graphical control (shape renderer, etc) from Battleship.java
 * @author Nihar Mitra
 *
 */
public class Gui {
	private ShapeRenderer sr;
	private BattleshipGame game;
	
	public Gui(BattleshipGame game, ShapeRenderer sr) {
		this.sr = sr;
		this.game = game;
	}
	/**
	 * Draws the grid for battleship
	 */
	public void drawGrid() {
		sr.begin(ShapeType.Line);
		Gdx.gl.glLineWidth(2);
		//Vertical lines
		for(int i=0; i<game.getGrid().size(); i++) {
			sr.line(i*Cell.cellWidth, 0, i*Cell.cellWidth, Gdx.graphics.getHeight());
		}
		//Horizontal lines
		for(int j=1; j<game.getGrid().get(0).size(); j++) {
			sr.line(0, j*Cell.cellWidth, Math.min(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), j*Cell.cellWidth);
		}

		sr.end();
	}
}
