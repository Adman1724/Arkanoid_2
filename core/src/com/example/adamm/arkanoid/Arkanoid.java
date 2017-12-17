package com.example.adamm.arkanoid;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.example.adamm.arkanoid.camera.OrthoCamera;
import com.example.adamm.arkanoid.camera.ScrollingBackground;
import com.example.adamm.arkanoid.screen.GameOverScreen;
import com.example.adamm.arkanoid.screen.GameScreen;
import com.example.adamm.arkanoid.screen.MenuScreen;
import com.example.adamm.arkanoid.screen.ScreenManger;

public class Arkanoid extends Game {
	public static int WIDTH=1080, HEIGHT= 1920;

	public SpriteBatch batch;
	public OrthoCamera camera;
	public ScrollingBackground scrollingBackground;

	@Override
	public void create () {
		camera=new OrthoCamera();
		this.scrollingBackground = new ScrollingBackground();
		batch = new SpriteBatch();

		this.setScreen(new MenuScreen(this));
	}
	public  void createGameOver(int a ){
		this.setScreen( new GameOverScreen(a,this));
	}
	public  void createNewGame(){

		this.setScreen(new GameScreen(this));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		super.render();


	}

	@Override
	public void dispose () {
		if (ScreenManger.getCurrentScreeen()!=null)
			ScreenManger.getCurrentScreeen().dispose();
		batch.dispose();

	}
	@Override
	public void resize(int width,int height){
		camera.update();
		super.resize(width,height);
	}
	@Override
	public void pause(){
		if (ScreenManger.getCurrentScreeen()!=null)
			ScreenManger.getCurrentScreeen().pause();
	}
	@Override
	public void resume(){
		if (ScreenManger.getCurrentScreeen()!=null)
			ScreenManger.getCurrentScreeen().resume();
	}
}
