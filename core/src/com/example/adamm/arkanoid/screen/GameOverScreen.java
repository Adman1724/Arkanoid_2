package com.example.adamm.arkanoid.screen;



import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.example.adamm.arkanoid.MainGame;




/**
 * Created by adamm on 12/16/2017.
 */

public class GameOverScreen extends Screen {

   public BitmapFont font = new BitmapFont();
    public String score="";


    public GameOverScreen(){}
    public GameOverScreen(String score){
        this.score=score;





    }

    @Override
    public void create() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render(SpriteBatch sb) {


        sb.begin();

        font.setColor(255,255,255,255);
        font.getData().setScale(5, 5);
        font.draw(sb,score, 20,MainGame.WIDTH/2);

        sb.end();
    }

    @Override
    public void resize(int width, int height) {


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
