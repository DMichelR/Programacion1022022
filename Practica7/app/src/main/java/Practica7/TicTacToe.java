package Practica7;

import java.util.Scanner;

public class TicTacToe {
    private final char player1 = 'X';
    private final char player2 = 'O';
    private final char empty = '-';

    private boolean turn;
    private char[][] board;
    
    public TicTacToe(){
        this.turn = true;
        this.board = new char[3][3];
        this.initialize();
    }

    private void initialize() {
        for ( int i=0; i < board.length; i++){
            for (int j = 0; j< board.length; j++){
                board[i][j] = empty;
            }
        }
    }

    public void showCurrentTurn() {
        if(turn){
            System.out.println("le toca al jugador 1");
        }
        else{
            System.out.println("le toca al jugador 2");
        }
    }

    public void showBoard() {
        for ( int i=0; i < board.length; i++){
            for (int j = 0; j< board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public int setNumber(String message) {
        System.out.println(message);
        Scanner read = new Scanner(System.in);
        int number = read.nextInt();
        read.close();
        return number;
    }

    public boolean validatePosition(int row, int column) {
        if (row >= 0 && row <board.length && column >=0 && column < board.length){
            return true;
        }
        return false;
    }

    public boolean positionFilled(int row, int column) {
        if (this.board[row][column] != empty){
            return true;
        }
        return false;
    }

    public void insertIntoPosition(int row, int column) {
        this.board[row][column] = turn? player1 : player2;
    }

    public void changeTurn() {
        this.turn = !this.turn;
    }

    public boolean endofgame() {
        if (boardFull() 
            || rowMatch() != empty
            || columnMatch() != empty
            || diagonalMatch() != empty){
                return true;
            }
        return false;
    }

    private boolean boardFull() {
        for ( int i=0; i < board.length; i++){
            for (int j = 0; j< board.length; j++){
                if (this.board[i][j] == empty){
                    return true;
                }
            }
        }
        return false;
    }

    private char rowMatch() {
        char symbol;
        boolean match;
        for ( int i = 0; i < board.length; i++){
            match = true;
            symbol = board[i][0];
            if (symbol != empty){
                for(int j = 0; j < board[0].length; j++){
                    if (symbol != board[i][j]){
                        match = false;
                    }
                }
                if (match){
                    return symbol;
                }
            }
        }
        return empty;
    }

    private char columnMatch() {
        char symbol;
        boolean match;
        for ( int i = 0; i < board.length; i++){
            match = true;
            symbol = board[0][i];
            if (symbol != empty){
                for(int j = 0; j < board[0].length; j++){
                    if (symbol != board[j][i]){
                        match = false;
                    }
                }
                if (match){
                    return symbol;
                }
            }
        }
        return empty;
    }

    private char diagonalMatch() {
        char symbol;
        boolean match = true;
        symbol = board[0][0];
        if (symbol != empty){
            for ( int i = 0; i < board.length; i++){
                if (symbol != board[i][i]){
                    match = false;
                }
            }
            if (match){
                return symbol;
            }
        }
        match = true;
        symbol = board[0][2];
        if (symbol != empty){
            for (int i = 1, j = 1; i < board.length; i++, j--){
                if(symbol != board[i][j]){
                    match = false;
                }
            }
            if (match){
                return symbol;
            }
        }
        return empty;
    }
    
    public void showWinner() {
        char symbol = rowMatch();
        if (symbol != empty){
            if (symbol == player1){
                System.out.println("Ha ganado el Jugador 1");
            }
            else{
                System.out.println("Ha ganado el Jugador 2");
            }
            return;
        }
        symbol = columnMatch();
        if (symbol != empty){
            if (symbol == player1){
                System.out.println("Ha ganado el Jugador 1");
            }
            else{
                System.out.println("Ha ganado el Jugador 2");
            }
            return;
        }
        symbol = diagonalMatch();
        if (symbol != empty){
            if (symbol == player1){
                System.out.println("Ha ganado el Jugador 1");
            }
            else{
                System.out.println("Ha ganado el Jugador 2");
            }
            return;
        }

    }
    
}
