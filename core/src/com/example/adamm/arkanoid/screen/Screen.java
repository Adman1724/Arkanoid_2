package com.example.adamm.arkanoid.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by adamm on 11/1/2017.
 */

public abstract class Screen {
    public abstract void create();
    public abstract void  update();
    public abstract void render(SpriteBatch sb);
    public abstract void resize(int width,int height);
    public abstract void dispose();
    public abstract void pause();
    public abstract void resume();

}
