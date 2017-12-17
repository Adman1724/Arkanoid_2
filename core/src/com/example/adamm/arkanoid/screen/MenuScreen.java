package com.example.adamm.arkanoid.screen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.example.adamm.arkanoid.Arkanoid;
import com.example.adamm.arkanoid.entity.EntityManager;

import static com.badlogic.gdx.scenes.scene2d.ui.Table.Debug.actor;

/**
 * Created by adamm on 12/17/2017.
 */

public class MenuScreen implements Screen {

    private static final int EXIT_BUTTON_WIDTH = 250;
    private static final int EXIT_BUTTON_HEIGHT = 120;
    private static final int PLAY_BUTTON_WIDTH = 300;
    private static final int PLAY_BUTTON_HEIGHT = 120;
    private static final int EXIT_BUTTON_Y = 100;
    private static final int PLAY_BUTTON_Y = 530;


    final Arkanoid game;
    Texture exitButtonActive;
    Texture exitButtonInactive;
    Texture playButtonActive;
    Texture playButtonInactive;
    final MenuScreen mainMenuScreen;
    private Vector2 touch;



    public MenuScreen(final Arkanoid game){
        this.game=game;
        playButtonActive = new Texture("play_button_active.png");
        playButtonInactive = new Texture("play_button_inactive.png");
        exitButtonActive = new Texture("exit_button_active.png");
        exitButtonInactive = new Texture("exit_button_inactive.png");

       mainMenuScreen = this;


    }
    @Override
    public void show(){

    }

    @Override
    public void hide(){

    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        touch = game.camera.unprojectCoordinates(Gdx.input.getX(), Gdx.input.getY());
        game.batch.begin();

        game.scrollingBackground.updateAndRender(delta, game.batch);
        int x = game.WIDTH /2 - EXIT_BUTTON_WIDTH ;
        game.batch.draw(exitButtonActive, x, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
        game.batch.draw(playButtonActive, x, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
        Gdx.app.log("MyTag", "before before  if");
        if(Gdx.input.isTouched()) {
            Rectangle exitRec = new Rectangle(x, game.HEIGHT-EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
            Gdx.app.log("kokot", ""+Gdx.input.getX()+"y:"+Gdx.input.getY());
            if(exitRec.contains(Gdx.input.getX(),Gdx.input.getY())){

                Gdx.app.log("doooo", "exit");
                //mainMenuScreen.dispose();
                Gdx.app.exit();

            }
            Rectangle playRec = new Rectangle(x, game.HEIGHT-PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
            Gdx.app.log("kokot", ""+Gdx.input.getX()+"y:"+Gdx.input.getY());
            if(playRec.contains(Gdx.input.getX(),Gdx.input.getY())){

                Gdx.app.log("doooo", "play");

                //mainMenuScreen.dispose();
                game.setScreen(new GameScreen(game));

            }

        }
            /*
        int x = Arkanoid.WIDTH /2 - EXIT_BUTTON_WIDTH ;
        Gdx.app.log("MyTag", "before if");
        if (touch.x < x + EXIT_BUTTON_WIDTH && touch.x > x && Arkanoid.HEIGHT - touch.y < EXIT_BUTTON_Y + EXIT_BUTTON_HEIGHT && Arkanoid.HEIGHT - touch.y > EXIT_BUTTON_Y) {
            {Gdx.app.log("MyTag", "if");
                game.batch.draw(exitButtonActive, x, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);

                mainMenuScreen.dispose();
                Gdx.app.exit();
            }
        } else {
            Gdx.app.log("MyTag", "else");
            game.batch.draw(exitButtonInactive, x, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
        }

        x = Arkanoid.WIDTH/2  - PLAY_BUTTON_WIDTH  ;
        if (touch.x < x + PLAY_BUTTON_WIDTH && touch.x > x && Arkanoid.HEIGHT - touch.y < PLAY_BUTTON_Y + PLAY_BUTTON_HEIGHT && Arkanoid.HEIGHT - touch.y > PLAY_BUTTON_Y) {
            {game.batch.draw(playButtonActive, x, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);

                mainMenuScreen.dispose();
                game.setScreen(new GameScreen(game));
            }
        } else {
            game.batch.draw(playButtonInactive, x, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
        }
        */



        game.batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void dispose() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }
}
