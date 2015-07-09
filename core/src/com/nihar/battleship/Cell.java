package com.nihar.battleship;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.nihar.battleship.ship.*;

/**
 * Represents a cell in the grid
 * @author Nihar
 *
 */
public class Cell extends Actor {
	//Variables for water animation
	private Animation water;
	private TextureRegion[] waterTextures;
	float waterStateTime = 0f;
	private SpriteBatch waterSpriteBatch;
	//Textures for ships and selection
	Texture selected = new Texture(Gdx.files.internal("select.png"));
	Texture motorboat = new Texture(Gdx.files.internal("motorboat.png"));
	Texture destroyer = new Texture(Gdx.files.internal("sailboat.png"));
	//Ship contained
	public Ship ship = null;
	private int x, y;
	public static int cellWidth = Gdx.graphics.getHeight()/5;
	private enum State {
		X, O
	}
	State state = State.O;
	
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
		//Sets up actor on the stage
		super.setPosition(x*Gdx.graphics.getWidth(), y*Gdx.graphics.getHeight());
		super.setWidth(cellWidth);
		super.setHeight(cellWidth);
		//Used to detect actor based on x,y string
		super.setName(x+","+y);
		//Combines the water images into a TextureRegion array
		waterTextures = new TextureRegion[32];
		for(int i=0; i<32; i++) {
			//Uses entire texture as "region" since they aren't on combined sprite sheet
			waterTextures[i] = new TextureRegion(new Texture(Gdx.files.internal("water\\water"+i+".png")), 0, 0, 32, 32);
		}
		//Sets up the background animation at 32 fps
		water = new Animation(1/32f, waterTextures);
		waterSpriteBatch = new SpriteBatch();
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.end();
		drawWater();
		switch(state) {
		case O:
			
			break;
		case X:
			break;
		}
		batch.begin();
	}
	
	public boolean hasShip() {
		if(ship != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * Draws water "sprite"
	 */
	public void drawWater() {
		waterStateTime += Gdx.graphics.getDeltaTime();
		TextureRegion currentFrame = water.getKeyFrame(waterStateTime, true);
		waterSpriteBatch.begin();
		//Use size of the actor to draw enough water
		waterSpriteBatch.draw(currentFrame, getX(), getY());
		
		waterSpriteBatch.end();
	}	
}
