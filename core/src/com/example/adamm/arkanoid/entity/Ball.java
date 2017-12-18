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

public class Ball extends Entity {
    Sound cing = Gdx.audio.newSound(Gdx.files.internal("Sounds/cing.wav"));
    private Rectangle hitboxL ;
    private Rectangle hitboxR ;
    private Rectangle hitboxU ;
    private Rectangle hitboxD ;
    private Array<Brick> arr;

    private EntityManager EM;
    public Ball( Vector2 pos, Vector2 direction) {
        super(TextureManager.BALL, pos, direction);
        hitboxD= new Rectangle((int)this.pos.x, (int)this.pos.y+19, 24 ,5 );
        hitboxU= new Rectangle((int)this.pos.x, (int)this.pos.y, 24 ,5 );
        hitboxL= new Rectangle((int)this.pos.x,(int)this.pos.y, 5 ,24 );
        hitboxR= new Rectangle((int)this.pos.x+19, (int)this.pos.y, 5 ,24 );
    }

    @Override
    public void update() {
        hitboxD= new Rectangle((int)this.pos.x, (int)this.pos.y+19, 24 ,5 );
        hitboxU= new Rectangle((int)this.pos.x, (int)this.pos.y, 24 ,5 );
        hitboxL= new Rectangle((int)this.pos.x,(int)this.pos.y, 5 ,24 );
        hitboxR= new Rectangle((int)this.pos.x+19, (int)this.pos.y, 5 ,24 );

        if(this.pos.x<=0||this.pos.x>= Arkanoid.WIDTH-19)
        { this.direction.x=0-this.direction.x;
            if(this.pos.x<=0)this.pos.x=this.pos.x+10;
            if(this.pos.x>=Arkanoid.WIDTH-19)this.pos.x=this.pos.x-10;

        }


        if(this.pos.y>= Arkanoid.HEIGHT)
            this.direction.y=0-this.direction.y;
        Brick b;


        arr=EM.getArray();
        Iterator it=arr.iterator();
         boolean wasRemove = true;
        while(it.hasNext()){
            b=(Brick) it.next();
            hitboxD= new Rectangle((int)this.pos.x, (int)this.pos.y+19, 24 ,5 );
            hitboxU= new Rectangle((int)this.pos.x,(int)this.pos.y, 24 ,5 );
            hitboxL= new Rectangle((int)this.pos.x,(int)this.pos.y, 5 ,24 );
            hitboxR= new Rectangle((int)this.pos.x+19, (int)this.pos.y, 5 ,24 );
            if(this.pos.y<=0){
                this.pos.x=300;
                this.pos.y=300;
                this.direction.x=3;
                this.direction.y=3;
                EM.getLives().setLivesCount(EM.getLives().getLivesCount()-1);


            }
            if(wasRemove)
            {
                if(b.getHitbox().overlaps(hitboxL)&&b.getHitbox().overlaps(hitboxD)&&b.getHitbox().overlaps(hitboxR))
                {
                    direction.y = -direction.y;
                    cing.play();
                    it.remove();
                    Score updateScore=EM.getScore();
                    updateScore.setScoreCount(updateScore.getScoreCount()+15);
                    EM.setScore(updateScore);
                    wasRemove=!wasRemove;
                }
                else if(b.getHitbox().overlaps(hitboxL)&&b.getHitbox().overlaps(hitboxU)&&b.getHitbox().overlaps(hitboxD))
                {
                    direction.x = -direction.x;
                    cing.play();
                    it.remove();
                    Score updateScore=EM.getScore();
                    updateScore.setScoreCount(updateScore.getScoreCount()+15);
                    EM.setScore(updateScore);
                    wasRemove=!wasRemove;}
                else if(b.getHitbox().overlaps(hitboxL)&&b.getHitbox().overlaps(hitboxU)&&b.getHitbox().overlaps(hitboxR))
                {
                    direction.y = -direction.y;
                    cing.play();
                    it.remove();
                    Score updateScore=EM.getScore();
                    updateScore.setScoreCount(updateScore.getScoreCount()+15);
                    EM.setScore(updateScore);
                    wasRemove=!wasRemove;
                }
                else if(b.getHitbox().overlaps(hitboxU)&&b.getHitbox().overlaps(hitboxR)&&b.getHitbox().overlaps(hitboxD))
                {
                    direction.x = -direction.x;
                    cing.play();
                    it.remove();
                    Score updateScore=EM.getScore();
                    updateScore.setScoreCount(updateScore.getScoreCount()+15);
                    EM.setScore(updateScore);
                    wasRemove=!wasRemove;
                }
                else {
                    if(b.getHitbox().overlaps(hitboxL)&&b.getHitbox().overlaps(hitboxD)&&!(b.getHitbox().overlaps(hitboxU))&&!(b.getHitbox().overlaps(hitboxR)))
                    {
                        if(direction.x>=0&& direction.y>=0)direction.y = -direction.y;
                        else direction.x = -direction.x;
                        cing.play();
                        it.remove();
                        Score updateScore=EM.getScore();
                        updateScore.setScoreCount(updateScore.getScoreCount()+15);
                        EM.setScore(updateScore);
                        wasRemove=!wasRemove;
                    }
                    else if(b.getHitbox().overlaps(hitboxD)&&b.getHitbox().overlaps(hitboxR)&&!(b.getHitbox().overlaps(hitboxU))&&!(b.getHitbox().overlaps(hitboxL)))
                    {
                        if(direction.x<=0&&direction.y>=0)direction.y = -direction.y;
                        else direction.x = -direction.x;
                        cing.play();
                        it.remove();
                        Score updateScore=EM.getScore();
                        updateScore.setScoreCount(updateScore.getScoreCount()+15);
                        EM.setScore(updateScore);
                        wasRemove=!wasRemove;
                    }
                    else if(b.getHitbox().overlaps(hitboxU)&&b.getHitbox().overlaps(hitboxR)&&!(b.getHitbox().overlaps(hitboxD))&&!(b.getHitbox().overlaps(hitboxL)))
                    {
                        if(direction.x>=0&&direction.y<=0)direction.x = -direction.x;
                        else direction.y = -direction.y;
                        cing.play();
                        it.remove();
                        Score updateScore=EM.getScore();
                        updateScore.setScoreCount(updateScore.getScoreCount()+15);
                        EM.setScore(updateScore);
                        wasRemove=!wasRemove;
                    }
                    else if(b.getHitbox().overlaps(hitboxU)&&b.getHitbox().overlaps(hitboxL)&&!(b.getHitbox().overlaps(hitboxD))&&!(b.getHitbox().overlaps(hitboxR)))
                    {
                        if(direction.x>=0&&direction.y<=0)direction.y = -direction.y;
                        else direction.x = -direction.x;
                        cing.play();
                        it.remove();
                        Score updateScore=EM.getScore();
                        updateScore.setScoreCount(updateScore.getScoreCount()+15);
                        EM.setScore(updateScore);
                        wasRemove=!wasRemove;
                    }}

            }}



        EM.setArray(arr);


        this.pos=new Vector2(this.pos.x+this.direction.x,this.pos.y+this.direction.y);
    }
    public void setEM(EntityManager EM){

        this.EM=EM;
    }
    public Rectangle getHitbox() {
        return this.hitboxD;
    }
    public void setMove(int x,int y){

        this.direction.x=this.direction.x*x;
        this.direction.y=this.direction.y*y;
    }
    public void resetMove(){
        if(direction.x>0) this.direction.x=1.5f;

        if(direction.x<0)this.direction.x=-1.5f;

        if(direction.y>0)this.direction.y=1.5f;
        if(direction.y<0)this.direction.y=-1.5f;

    }
}
