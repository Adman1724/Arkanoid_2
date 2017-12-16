package com.example.adamm.arkanoid.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.example.adamm.arkanoid.MainGame;
import com.example.adamm.arkanoid.TextureManager;
import com.example.adamm.arkanoid.camera.OrthoCamera;

/**
 * Created by adamm on 11/1/2017.
 */

public class Player extends Entity {

    private final OrthoCamera camera;
    private Vector2 touch;
    boolean onebreak=false;
    private EntityManager game;
    private Rectangle hitboxA ;
    private Rectangle hitboxB ;
    private Rectangle hitboxC ;
    private Rectangle hitboxD ;
    private Rectangle hitboxE ;
    private Rectangle hitboxS;
    public Player(Vector2 pos, Vector2 direction, OrthoCamera camera ){
        super(TextureManager.PLAYER,pos,direction);
        this.camera=camera;
        hitboxA= new Rectangle(pos.x, pos.y, 23 ,48 );
        hitboxB= new Rectangle(pos.x+23, pos.y, 23 ,48 );
        hitboxC= new Rectangle(pos.x+46, pos.y, 23 ,48 );
        hitboxD= new Rectangle(pos.x+69, pos.y, 23 ,48 );
        hitboxE= new Rectangle(pos.x+93, pos.y, 23 ,48 );
        hitboxS= new Rectangle(pos.x+52, pos.y, 11 ,48 );

    }

    @Override
    public void update(){
        pos.add(direction);

        if(Gdx.input.isTouched()) {
            touch = camera.unprojectCoordinates(Gdx.input.getX(), Gdx.input.getY());
            if (touch.x < MainGame.WIDTH / 2)
                if(this.pos.x>50||this.pos.x<MainGame.WIDTH-50)
                    setDirection(-300, 0);
                else setDirection(0,0);
            else
            if(this.pos.x>50||this.pos.x<MainGame.WIDTH-50)
                setDirection(300, 0);
            else setDirection(0,0);
        }
        else {setDirection(0,0);}


        hitboxA= new Rectangle(pos.x, pos.y, 23 ,48 );
        hitboxB= new Rectangle(pos.x+23, pos.y, 23 ,48 );
        hitboxC= new Rectangle(pos.x+46, pos.y, 23 ,48 );
        hitboxD= new Rectangle(pos.x+69, pos.y, 23 ,48 );
        hitboxE= new Rectangle(pos.x+93, pos.y, 23 ,48 );
        hitboxS= new Rectangle(pos.x+52, pos.y, 11 ,48 );


        if(game.getBall().getHitbox().overlaps(hitboxA)&&game.getBall().getHitbox().overlaps(hitboxB)){
            game.getBall().resetMove();
            game.getBall().getPosition().y=game.getBall().getPosition().y+3;
            game.getBall().setMove(1,-1);

        }
        else if(game.getBall().getHitbox().overlaps(hitboxB)&&game.getBall().getHitbox().overlaps(hitboxC)){
            if(game.getBall().getHitbox().overlaps(hitboxS)){
                game.getBall().getPosition().y=game.getBall().getPosition().y+3;
                game.getBall().resetMove();
                game.getBall().setMove(1,-3);


            }
            else{
                game.getBall().resetMove();
                game.getBall().getPosition().y=game.getBall().getPosition().y+3;
                game.getBall().setMove(1,-2);

            }
        }
        else if(game.getBall().getHitbox().overlaps(hitboxC)&&game.getBall().getHitbox().overlaps(hitboxD)){
            if(game.getBall().getHitbox().overlaps(hitboxS)){
                game.getBall().getPosition().y=game.getBall().getPosition().y+3;
                game.getBall().resetMove();
                game.getBall().setMove(1,-3);

            }
            else{
                game.getBall().resetMove();
                game.getBall().getPosition().y=game.getBall().getPosition().y+3;
                game.getBall().setMove(1,-2);

            }

        }
        else if(game.getBall().getHitbox().overlaps(hitboxD)&&game.getBall().getHitbox().overlaps(hitboxE)){
            game.getBall().resetMove();
            game.getBall().getPosition().y=game.getBall().getPosition().y+3;
            game.getBall().setMove(1,-1);

        }
        else if(game.getBall().getHitbox().overlaps(hitboxA)){
            game.getBall().resetMove();
            game.getBall().getPosition().y=game.getBall().getPosition().y+3;
            game.getBall().setMove(-1,-1);

        }
        else if(game.getBall().getHitbox().overlaps(hitboxE)){
            game.getBall().resetMove();
            game.getBall().getPosition().y=game.getBall().getPosition().y+3;
            game.getBall().setMove(-1,-1);

        }


    }
    public void setEM(EntityManager EM){
        game=EM;
    }
}
