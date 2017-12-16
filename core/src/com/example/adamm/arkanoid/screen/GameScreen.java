package com.example.adamm.arkanoid.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.example.adamm.arkanoid.camera.OrthoCamera;
import com.example.adamm.arkanoid.entity.Brick;
import com.example.adamm.arkanoid.entity.EntityManager;
import com.example.adamm.arkanoid.entity.Player;

/**
 * Created by adamm on 11/1/2017.
 */

public class GameScreen extends Screen {
    private OrthoCamera camera;
    private EntityManager EM;
    public GameScreen(){
        this.create();
    }
    @Override
    public void create() {
        camera=new OrthoCamera();
        EM=new EntityManager(camera);
    }

    @Override
    public void update() {
        camera.update();


        EM.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sb.setProjectionMatrix(camera.combined);
        sb.begin();


        EM.render(sb);
        sb.end();
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

}
