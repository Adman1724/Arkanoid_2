package com.example.adamm.arkanoid.entity;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.example.adamm.arkanoid.Level.Level;
import com.example.adamm.arkanoid.Arkanoid;
import com.example.adamm.arkanoid.camera.OrthoCamera;
import com.example.adamm.arkanoid.screen.GameOverScreen;

/**
 * Created by adamm on 11/5/2017.
 */

public class EntityManager {

    private Player player;
    private Brick brick1;
    private Array<Brick> bricks;
    private Ball ball;
    private Level level=new Level(1);
    private Score score;
    private Lives lives;
    private boolean missle =false;
    int levels;
    final Arkanoid game;
    BitmapFont font = new BitmapFont();
    Sound gameOver = Gdx.audio.newSound(Gdx.files.internal("Sounds/gameover.wav"));






    public EntityManager(OrthoCamera camera, final Arkanoid game){
        levels=0;
        level.getlevels(levels);
        this.game=game;
        bricks=new Array<Brick>();
        Vector2 v=new Vector2(20,800);
        for(int i=0;i<6;i++){
            for(int j=0;j<12;j++){
                brick1=new Brick(new Vector2(v.x,v.y),new Vector2(0,0),level.getInt(i,j));
                v.set((v.x+48),v.y);
                bricks.add(brick1);
            }
            v.set(20,(v.y-30));
        }

        player=new Player(new Vector2(200,20),new Vector2(0,0),camera);
        brick1=new Brick(new Vector2(0,750),new Vector2(0,0),2);
        ball=new Ball(new Vector2(300,300),new Vector2(3,-3));
        player.setEM(this);
        ball.setEM(this);
        score=new Score(new Vector2(0,900),new Vector2(0,0),camera);
        lives=new Lives(new Vector2(100,900),new Vector2(0,0),camera);
        lives.setLivesCount(3);


    }
    public void update(){
        player.update();
        ball.update();
        for (Brick user : bricks) {
            user.update();
        }
        score.update();
        lives.update();
        if(lives.getLivesCount()<0){
           gameOver.play();

            game.createGameOver(this.getScore().getScoreCount());

        }
        boolean empty = true;
        for (Brick ob : bricks) {
            if (ob != null) {
                empty = false;
                break;
            }
        }
        if(empty){

            levels++;
            levelLoad();
            ball.pos.x=300;
            ball.pos.y=300;

        }



    }
    public void levelLoad(){
        level.getlevels(levels);

        bricks=new Array<Brick>();
        Vector2 v=new Vector2(20,800);
        for(int i=0;i<6;i++){
            for(int j=0;j<12;j++){
                brick1=new Brick(new Vector2(v.x,v.y),new Vector2(0,0),level.getInt(i,j));
                v.set((v.x+48),v.y);
                bricks.add(brick1);
            }
            v.set(20,(v.y-30));
        }


        brick1=new Brick(new Vector2(0,750),new Vector2(0,0),2);
    }
    public void render(SpriteBatch sb){

        player.render(sb);
        ball.render(sb);

        for (Brick user : bricks) {
            user.render(sb);
        }
        score.render(sb);
        font.setColor(255,255,255,255);
        font.draw(sb,score.getCount(),score.getPosition().x+20,score.getPosition().y-10);
        lives.render(sb);
        font.draw(sb,lives.getCount(),lives.getPosition().x+20,lives.getPosition().y-10);



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
    public Score getScore(){return score;}
    public void setScore(Score  a){
        this.score=a;
    }
    public  Lives getLives(){
        return lives;
    }
    public void setLives(Lives l){
        this.lives=l;
    }


    }

