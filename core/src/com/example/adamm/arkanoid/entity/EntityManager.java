package com.example.adamm.arkanoid.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.example.adamm.arkanoid.Level.Level;
import com.example.adamm.arkanoid.camera.OrthoCamera;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by adamm on 11/5/2017.
 */

public class EntityManager {

    private Player player;
    private Brick brick1;
    private Array<Brick> bricks;
    private Ball ball;
    private Level level=new Level(1);






    public EntityManager(OrthoCamera camera){
        level.loadSave();
        bricks=new Array<Brick>();
        Vector2 v=new Vector2(20,800);
        for(int i=0;i<6;i++){
            for(int j=0;j<11;j++){
                brick1=new Brick(new Vector2(v.x,v.y),new Vector2(0,0),level.getInt(i,j));
                v.set((v.x+50),v.y);
                bricks.add(brick1);
            }
            v.set(20,(v.y-30));
        }

        player=new Player(new Vector2(200,20),new Vector2(0,0),camera);
        brick1=new Brick(new Vector2(0,750),new Vector2(0,0),2);
        ball=new Ball(new Vector2(300,300),new Vector2(2,2));
        player.setEM(this);
        ball.setEM(this);


    }
    public void update(){
        player.update();
        ball.update();
        for (Brick user : bricks) {
            user.update();
        }



    }
    public void render(SpriteBatch sb){

        player.render(sb);
        ball.render(sb);

        for (Brick user : bricks) {
            user.render(sb);
        }


    }
    public Array getArray(){
        return bricks;
    }
    public void setArray(Array a){
        bricks=a;
    }
    public Ball getBall(){
        return ball;
    }
    }

