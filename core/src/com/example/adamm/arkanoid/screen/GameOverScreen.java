package com.example.adamm.arkanoid.screen;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.example.adamm.arkanoid.Arkanoid;
import com.badlogic.gdx.Screen;



/**
 * Created by adamm on 12/16/2017.
 */

public class GameOverScreen implements Screen {
    private static final int BANNER_WIDTH=350;
    private static final int BANNER_HEIGHT=200;
   public BitmapFont scorefont = new BitmapFont();
    public int score;
    public int score1,highscore;
    private Texture playTexture;
    private TextureRegion playTextureRegion;
    private TextureRegionDrawable playTextureDrawable;
    private ImageButton playButton;
    private Stage stage;
    Texture gameOverBanner;
    final Arkanoid game;


    public GameOverScreen(int score, final Arkanoid game){
        this.score=score;
        this.game=game;
        Preferences prefs=Gdx.app.getPreferences("rkanoid2");
        this.highscore=prefs.getInteger("highscore", 0);
        if(score>highscore){
            prefs.putInteger("highscore", score);
            prefs.flush();
        }
        gameOverBanner=new Texture("gameOverBanner.jpg");
        scorefont=new BitmapFont();
        playTexture = new Texture(Gdx.files.internal("play.PNG"));
        playTextureRegion = new TextureRegion(playTexture);
        playTextureDrawable = new TextureRegionDrawable(playTextureRegion);
        playButton = new ImageButton(playTextureDrawable); //Set the button up

        stage = new Stage(new ScreenViewport()); //Set up a stage for the ui
        stage.addActor(playButton); //Add the button to the stage to perform rendering and take input.
        Gdx.input.setInputProcessor(stage);
        playButton.addListener(new EventListener()
        {
            @Override
            public boolean handle(Event event)
            {
                game.createNewGame();
                return true;
            }
        });





    }


    public void create() {

    }


    public void update() {

    }


    public void render(SpriteBatch sb) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        sb.begin();
        sb.draw(gameOverBanner,Gdx.graphics.getWidth()/2-BANNER_WIDTH/2,Gdx.graphics.getHeight()-BANNER_HEIGHT-15,BANNER_WIDTH,BANNER_HEIGHT);
        GlyphLayout scoreLayout =new GlyphLayout(scorefont, "Score: \n"+score, Color.WHITE, 0 , Align.left, false);
        GlyphLayout highscoreLayout =new GlyphLayout(scorefont, "HighScore: \n"+highscore, Color.WHITE, 0 , Align.left, false);
        scorefont.draw(sb,scoreLayout,Gdx.graphics.getWidth()/2-scoreLayout.width/2,Gdx.graphics.getHeight()-BANNER_HEIGHT-15*2);
        scorefont.draw(sb,highscoreLayout,Gdx.graphics.getWidth()/2-highscoreLayout.width/2,Gdx.graphics.getHeight()-BANNER_HEIGHT-scoreLayout.height-15*3);
        //stage.act(Gdx.graphics.getDeltaTime()); //Perform ui logic
        //stage.draw();


        sb.end();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        game.batch.draw(gameOverBanner,Gdx.graphics.getWidth()/2-BANNER_WIDTH/2,Gdx.graphics.getHeight()-BANNER_HEIGHT-15,BANNER_WIDTH,BANNER_HEIGHT);
        GlyphLayout scoreLayout =new GlyphLayout(scorefont, "Score: \n"+score, Color.WHITE, 0 , Align.left, false);
        GlyphLayout highscoreLayout =new GlyphLayout(scorefont, "HighScore: \n"+highscore, Color.WHITE, 0 , Align.left, false);
        scorefont.draw(game.batch,scoreLayout,Gdx.graphics.getWidth()/2-scoreLayout.width/2,Gdx.graphics.getHeight()-BANNER_HEIGHT-15*2);
        scorefont.draw(game.batch,highscoreLayout,Gdx.graphics.getWidth()/2-highscoreLayout.width/2,Gdx.graphics.getHeight()-BANNER_HEIGHT-scoreLayout.height-15*3);
        //stage.act(Gdx.graphics.getDeltaTime()); //Perform ui logic
        //stage.draw();


        game.batch.end();
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

    @Override
    public void hide() {

    }

}
