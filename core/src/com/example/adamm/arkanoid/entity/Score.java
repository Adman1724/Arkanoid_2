package com.example.adamm.arkanoid.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.example.adamm.arkanoid.TextureManager;
import com.example.adamm.arkanoid.camera.OrthoCamera;

/**
 * Created by adamm on 12/16/2017.
 */

public class Score extends Entity  {
    float accelX = Gdx.input.getAccelerometerX();
    private int scoreCount;
            private String count;
    public Score(Vector2 pos, Vector2 direction, OrthoCamera camera ){
        super(TextureManager.SCORE,pos,direction);
        scoreCount=0;
        count=""+scoreCount;

    }
    @Override
    public void update() {

        count=""+scoreCount;

    }
    public int getScoreCount(){
        return scoreCount;
    }
    public void setScoreCount(int a){
        this.scoreCount=a;
    }
    public String getCount(){
        return count;
    }
}
