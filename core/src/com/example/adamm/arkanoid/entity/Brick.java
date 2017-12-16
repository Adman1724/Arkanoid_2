package com.example.adamm.arkanoid.entity;

import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.example.adamm.arkanoid.TextureManager;



/**
 * Created by adamm on 11/5/2017.
 */

public class Brick extends Entity {

    private Rectangle hitbox =new Rectangle((int)pos.x,(int) pos.y, 48 ,24 );;

    public Brick( Vector2 pos, Vector2 direction,int num) {
        super(TextureManager.GOLD, pos, direction);
        if(num==1) super.texture=TextureManager.BLUE;
        if(num==2) super.texture=TextureManager.GOLD;
        if(num==3) super.texture=TextureManager.GRAY;
        if(num==4) super.texture=TextureManager.GREEN;
        if(num==5) super.texture=TextureManager.RED;

        hitbox =new Rectangle(pos.x,pos.y, 48 ,24 );;
    }
    public Rectangle getHitbox(){

        return hitbox;
    }

    @Override
    public void update() {
        hitbox=new Rectangle((int)pos.x,(int) pos.y, 48 ,24 );
    }

}
