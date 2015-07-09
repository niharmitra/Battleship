package com.nihar.battleship.gui;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
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
    private static final int VIEWPORT_WIDTH = 23;
    private static final int VIEWPORT_HEIGHT = 13;
    
    public GridStage() {
    	super();
    	setUpCamera();
    }
    
    private void setUpCamera() {
    	camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
    	camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0f);
    	camera.update();
    }
    
    @Override
    public void act(float delta) {
    	super.act(delta);
    	
    }
    
    @Override
    public void draw() {
    	super.draw();
    	
    }
}
