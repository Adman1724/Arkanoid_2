package com.example.adamm.arkanoid.screen;

/**
 * Created by adamm on 11/1/2017.
 */

public class ScreenManger {

    private static Screen currentScreeen;

    public static void setScreen(Screen screen){
        if(currentScreeen!=null)
            currentScreeen.dispose();
        currentScreeen = screen;
        currentScreeen.create();
    }
    public static Screen getCurrentScreeen(){
        return currentScreeen;
    }
}
