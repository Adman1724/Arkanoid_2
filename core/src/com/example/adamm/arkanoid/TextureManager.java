package com.example.adamm.arkanoid;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by adamm on 11/1/2017.
 */

public class TextureManager {
    public static Texture PLAYER = new Texture(Gdx.files.internal("player.png"));
    public static Texture BACKGROUND = new Texture(Gdx.files.internal("background.jpg"));
    public static Texture BALL = new Texture(Gdx.files.internal("ball.png"));
    public static Texture BLUE = new Texture(Gdx.files.internal("blue.gif"));
    public static Texture GRAY = new Texture(Gdx.files.internal("gray.gif"));
    public static Texture GREEN = new Texture(Gdx.files.internal("green.gif"));
    public static Texture RED = new Texture(Gdx.files.internal("red.gif"));
    public static Texture SCORE = new Texture(Gdx.files.internal("score.jpg"));
    public static Texture GOLD = new Texture(Gdx.files.internal("gold.gif"));
    public static Texture LIVES = new Texture(Gdx.files.internal("lives.png"));
}
