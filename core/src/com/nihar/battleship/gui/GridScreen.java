package com.nihar.battleship.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.nihar.battleship.Cell;

public class GridScreen implements Screen {
	private GridStage stage;
	private ShapeRenderer sr;
	
	public GridScreen() {
		stage = new GridStage();
		sr = new ShapeRenderer();
	}
	
	@Override
	public void render(float delta) {
		//Blue/water background
		Gdx.gl.glClearColor(0f, 0.75f, 1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.draw();
		stage.act(delta);
		drawGrid();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		stage.getViewport().update(width, height);
		Cell.cellWidth = Gdx.graphics.getWidth()/stage.getGrid().size();
		for(Actor actor : stage.getActors()) {
			((Cell) actor).updateDimensions();
		}
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		stage.dispose();
		this.dispose();
		System.exit(0);
	}
	
	private void drawGrid() {
		sr.begin(ShapeType.Line);
		sr.setColor(Color.CYAN);
		for(int i=0; i<stage.getGrid().size(); i++) {
			Gdx.gl.glLineWidth(2);
			//Vertical grid lines
			float yCoord = i*Gdx.graphics.getHeight()/stage.getGrid().size();
			sr.line(0, yCoord, Gdx.graphics.getWidth(), yCoord);
		}
		for(int j=0; j<stage.getGrid().get(0).size(); j++) {
			float xCoord = j*Gdx.graphics.getWidth()/stage.getGrid().get(0).size();
			sr.line(xCoord, 0, xCoord, Gdx.graphics.getHeight());
		}
		sr.end();
	}
}
