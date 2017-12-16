package com.example.adamm.arkanoid.Level;

import java.io.File;
import java.util.Scanner;

/**
 * Created by adamm on 11/5/2017.
 */

public class Level {
    private int[][] array=new int[6][11];
    private File loadPath;

    public Level(int level){
       int[][] a={ {1,1,1,1,1,1,1,1,1,1,1},
               {2,2,2,2,2,2,2,2,2,2,2},
               {3,3,3,3,3,3,3,3,3,3,3},
               {4,4,4,4,4,4,4,4,4,4,4},
               {1,2,3,4,1,2,3,4,1,2,1},
               {1,2,3,4,1,2,3,4,1,2,1},};
        array=a;

    }

    public void loadSave() {






    }
    public int getInt(int x,int y){

        return array[x][y];
    }
}
