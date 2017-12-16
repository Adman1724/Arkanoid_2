package com.example.adamm.arkanoid.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.example.adamm.arkanoid.camera.OrthoCamera;
import com.example.adamm.arkanoid.entity.Brick;
import com.example.adamm.arkanoid.entity.EntityManager;
import com.example.adamm.arkanoid.entity.Player;

/**
 * Created by adamm on 11/1/2017.
 */

public class MenuScreen extends Screen {
    private OrthoCamera camera;
    private EntityManager EM;
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
