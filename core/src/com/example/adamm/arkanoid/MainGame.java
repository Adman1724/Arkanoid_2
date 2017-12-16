package com.example.adamm.arkanoid;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.example.adamm.arkanoid.screen.MenuScreen;
import com.example.adamm.arkanoid.screen.ScreenManger;

public class MainGame extends ApplicationAdapter {
	public static int WIDTH=600, HEIGHT= 1000;
	 private SpriteBatch batch;

	
	@Override
	public void create () {
		batch = new SpriteBatch();

		ScreenManger.setScreen(new MenuScreen());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if (ScreenManger.getCurrentScreeen()!=null)
			ScreenManger.getCurrentScreeen().update();
		if (ScreenManger.getCurrentScreeen()!=null)
			ScreenManger.getCurrentScreeen().render(batch);


	}
	
	@Override
	public void dispose () {
		if (ScreenManger.getCurrentScreeen()!=null)
			ScreenManger.getCurrentScreeen().dispose();
		batch.dispose();

	}
	@Override
	public void resize(int width,int height){
		if (ScreenManger.getCurrentScreeen()!=null)
			ScreenManger.getCurrentScreeen().resize(width,height);
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
