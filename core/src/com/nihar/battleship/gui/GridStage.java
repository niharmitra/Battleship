package com.nihar.battleship.gui;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.nihar.battleship.Cell;

/*
 * Holds a grid with all the triggers
 */
public class GridStage extends Stage {
	//Game grid
	private ArrayList<ArrayList<Cell>> grid;
	public ArrayList<ArrayList<Cell>> getGrid() {return grid;}
	private OrthographicCamera camera;
    private static final int VIEWPORT_WIDTH = 20;
    private static final int VIEWPORT_HEIGHT = 20;
    
    public GridStage() {
    	super();
    	setUpCamera();
    	setUpGrid();
    	Gdx.input.setInputProcessor(this);
    }
    
    private void setUpCamera() {
    	camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
    	camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0f);
    	camera.update();
    }
    
    private void setUpGrid() {
    	grid = new ArrayList<ArrayList<Cell>>(5);
		for(int i=0; i<5; i++) {
			grid.add(new ArrayList<Cell>(5));
			for(int j=0; j<5; j++) {
				grid.get(i).add(new Cell(i,j));
				this.addActor(grid.get(i).get(j));
			}
		}
    }
    
    @Override
    public void act() {
    	super.act();
    	if(Cell.cellWidth != Gdx.graphics.getWidth()/grid.size()) {
    		Cell.cellWidth = Gdx.graphics.getWidth()/grid.size();
    	}
    }
}
