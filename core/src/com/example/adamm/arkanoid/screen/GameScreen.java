package com.example.adamm.arkanoid.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.example.adamm.arkanoid.Arkanoid;
import com.example.adamm.arkanoid.camera.OrthoCamera;
import com.example.adamm.arkanoid.entity.EntityManager;

/**
 * Created by adamm on 11/1/2017.
 */

public class GameScreen implements Screen {
    private OrthoCamera camera;
    private EntityManager EM;
     Arkanoid game;
    public SpriteBatch batch;
    public GameScreen(){
        this.create();
    }
    public GameScreen( Arkanoid game){
        this.game=game;
        camera=game.camera;
        this.create();
    }

    public void create() {

        EM=new EntityManager(camera, game);

    }


    public void update() {
        camera.update();


        EM.update();
    }


    public void render(SpriteBatch sb) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch=sb;
        batch.setProjectionMatrix(camera.combined);
        batch.begin();


        EM.render(batch);
        batch.end();
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {
        camera.resize();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

}
