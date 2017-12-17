package com.example.adamm.arkanoid.screen;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.example.adamm.arkanoid.Arkanoid;
import com.badlogic.gdx.Screen;
import com.example.adamm.arkanoid.camera.OrthoCamera;


/**
 * Created by adamm on 12/16/2017.
 */

public class GameOverScreen implements Screen {
    private static final int BANNER_WIDTH=350;
    private static final int BANNER_HEIGHT=200;
   public BitmapFont scorefont ;
    public int score;
    public OrthoCamera camera;
    public int highscore;

    Texture gameOverBanner;
    final Arkanoid game;



    public GameOverScreen(int score, final Arkanoid game){
        Arkanoid.WIDTH=1080;
        Arkanoid.HEIGHT=1920;
        this.score=score;

        this.game=game;
        Preferences prefs=Gdx.app.getPreferences("Akanoid2");
        this.highscore=prefs.getInteger("highscore", 0);
        if(score>highscore){
            prefs.putInteger("highscore", score);
            prefs.flush();
        }
        camera=game.camera;
        gameOverBanner=new Texture("game_over.png");
        scorefont = new BitmapFont(Gdx.files.internal("fonts/score.fnt"));






    }





    public void update() {

    }




    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(gameOverBanner,Gdx.graphics.getWidth()/2-BANNER_WIDTH/2,Gdx.graphics.getHeight()-BANNER_HEIGHT-15,BANNER_WIDTH,BANNER_HEIGHT);
        GlyphLayout scoreLayout =new GlyphLayout(scorefont, "Score: \n"+score, Color.WHITE, 0 , Align.left, false);
        GlyphLayout highscoreLayout =new GlyphLayout(scorefont, "HighScore: \n"+highscore, Color.WHITE, 0 , Align.left, false);
        scorefont.draw(game.batch,scoreLayout,Gdx.graphics.getWidth()/2-scoreLayout.width/2,Gdx.graphics.getHeight()-BANNER_HEIGHT-15*2);
        scorefont.draw(game.batch,highscoreLayout,Gdx.graphics.getWidth()/2-highscoreLayout.width/2,Gdx.graphics.getHeight()-BANNER_HEIGHT-scoreLayout.height-15*3);
        GlyphLayout tryAgainLayout =new GlyphLayout(scorefont, "Try Again: \n", Color.WHITE, 0 , Align.left, false);
        GlyphLayout exitLayout =new GlyphLayout(scorefont, "Exit \n", Color.WHITE, 0 , Align.left, false);

        scorefont.draw(game.batch,tryAgainLayout,Gdx.graphics.getWidth()/2-tryAgainLayout.width/2,Gdx.graphics.getHeight()-BANNER_HEIGHT-tryAgainLayout.height-15*8);
        scorefont.draw(game.batch,exitLayout,Gdx.graphics.getWidth()/2-exitLayout.width/2,Gdx.graphics.getHeight()-BANNER_HEIGHT-exitLayout.height-15*15);
        if(Gdx.input.isTouched()) {
            Rectangle playRec = new Rectangle(Gdx.graphics.getWidth()/2-tryAgainLayout.width/2,Gdx.graphics.getHeight()-BANNER_HEIGHT-tryAgainLayout.height-15*8-Arkanoid.WIDTH+50, 300,50);
            Gdx.app.log("kokot", "" + Gdx.input.getX() + "y:" + Gdx.input.getY());
            if (playRec.contains(Gdx.input.getX(), Gdx.input.getY())) {


                Gdx.app.log("doooo", "exit");
                //mainMenuScreen.dispose();
                Gdx.app.exit();
            }
            Rectangle exitRec = new Rectangle(Gdx.graphics.getWidth()/2-exitLayout.width/2,Gdx.graphics.getHeight()-BANNER_HEIGHT-exitLayout.height-15*15-Arkanoid.WIDTH+50, 300,50);
            Gdx.app.log("kokot", "" + Gdx.input.getX() + "y:" + Gdx.input.getY());
            if (exitRec.contains(Gdx.input.getX(), Gdx.input.getY())) {



                Gdx.app.log("doooo", "play");

                //mainMenuScreen.dispose();
                game.setScreen(new GameScreen(game));

            }
        }

        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
        camera.resize();

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

    @Override
    public void hide() {

    }

}
