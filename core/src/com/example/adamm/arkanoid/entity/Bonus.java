package com.example.adamm.arkanoid.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.example.adamm.arkanoid.Arkanoid;
import com.example.adamm.arkanoid.TextureManager;


import java.util.Iterator;

import javax.naming.Context;

/**
 * Created by adamm on 11/5/2017.
 */

public class Bonus extends Entity {
    Sound cing = Gdx.audio.newSound(Gdx.files.internal("Sounds/cing.wav"));

    private Rectangle hitboxD ;


    private EntityManager EM;
    public Bonus( Vector2 pos, Vector2 direction) {
        super(TextureManager.BALL, pos, direction);
        hitboxD= new Rectangle((int)this.pos.x, (int)this.pos.y+19, 24 ,5 );

    }

    @Override
    public void update() {
        hitboxD= new Rectangle((int)this.pos.x, (int)this.pos.y+19, 24 ,5 );

        this.pos=new Vector2(this.pos.x+this.direction.x,this.pos.y+this.direction.y);
    }
    public void setEM(EntityManager EM){

        this.EM=EM;
    }
    public Rectangle getHitbox() {
        return this.hitboxD;
    }
    public void setMove(int x,int y){

        this.direction.x=0;
        this.direction.y=-3;
    }
    public void resetMove(){
        if(direction.x>0) this.direction.x=1.5f;

        if(direction.x<0)this.direction.x=-1.5f;

        if(direction.y>0)this.direction.y=1.5f;
        if(direction.y<0)this.direction.y=-1.5f;

    }
}

