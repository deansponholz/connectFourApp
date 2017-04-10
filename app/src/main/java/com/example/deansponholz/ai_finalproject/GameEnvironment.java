package com.example.deansponholz.ai_finalproject;

import android.widget.TextView;

/**
 * Created by deansponholz on 4/8/17.
 */

public class GameEnvironment {


    //game board with 6x7 open spaces
    byte[][] gameGrid = new byte[6][7];
    String gameBoard = new String();

    //constructor
    public GameEnvironment(){

        //initialize game board
        gameGrid = new byte[][]{
                {0, 0, 0, 0, 0, 0, 0, 0,},
                {0, 0, 0, 0, 0, 0, 0, 0,},
                {0, 0, 0, 0, 0, 0, 0, 0,},
                {0, 0, 0, 0, 0, 0, 0, 0,},
                {0, 0, 0, 0, 0, 0, 0, 0,},
                {0, 0, 0, 0, 0, 0, 0, 0,},
        };
    }

    public boolean isMoveLegal(int column){
        return gameGrid[0][column] == 0;
    }

    public boolean dropPiece(int column, int player){
        if (isMoveLegal(column) == false){
            System.out.println("Move not allowed!");
            return false;
        }
        for (int i = 5; i >= 0; --i){
            if(gameGrid[i][column] == 0){
                gameGrid[i][column] = (byte) player;
                return true;
            }
        }
        return false;
    }

    public void undoLastMove(int column){
        for(int i=0; i < 5; i++){
            if(gameGrid[i][column] != 0){
                gameGrid[i][column] = 0;
                break;
            }
        }
    }

    //display game-board to Console(for now)
    public void displayEnvironment(TextView tv){
        //System.out.println();
        for (int i=0; i <=5; ++i){
            for(int k = 0; k <=6; ++k){
                System.out.print(gameGrid[i][k] + " ");
                gameBoard = (gameBoard + gameGrid[i][k] + " ");
            }
            System.out.println();
            gameBoard = gameBoard + "\n";
            tv.setText(gameBoard);
        }
        System.out.println();
    }
}