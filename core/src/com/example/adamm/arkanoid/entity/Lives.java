package com.example.adamm.arkanoid.entity;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.example.adamm.arkanoid.TextureManager;
import com.example.adamm.arkanoid.camera.OrthoCamera;

/**
 * Created by adamm on 12/16/2017.
 */

public class Lives extends Entity  {
        private int livesCount;
    private String count;
       public Lives(Vector2 pos, Vector2 direction, OrthoCamera camera ){
           super(TextureManager.LIVES,pos,direction);
           this.livesCount=0;
           count=""+livesCount;

       }

    @Override
    public void update() {
        count=""+livesCount;
    }
    public  int getLivesCount(){
        return livesCount;

    }
    public void setLivesCount(int a){
        this.livesCount=a;
    }
    public String getCount(){
        return count;
    }
}
