/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Practica7;


public class App {

    public static void main(String[] args) {
        //Ejercicio 1
        int [][] matrix = new int[4][4];
        int option;
        boolean matrixFilled = false; 
        do{
            option = Matrix.DisplayMenu(matrixFilled);
            Matrix.OptionCases(option, matrix, matrixFilled);
        }while(option != 7);
        System.out.println("Hasta Luego ;)");




        //MAGIC SQUARE************************
		/* int length = Magic_square.SetLength();

        int[][] magicSquare = Magic_square.FillSquare(length);

		System.out.println("");

		Magic_square.Print(length, magicSquare);
		
		Magic_square.KnowSum(magicSquare); */



        //3 en raya *********
        /* TicTacToe game = new TicTacToe();
        int row, column;
        boolean correct, validPosition;

        while (!game.endofgame()) {
            do{
                game.showCurrentTurn()
                game.showBoard()
                correct = false
                row = game.setRow();
                column = game.setColumn();
                validPosition = game.validatePosition(row, column);
                if (validatePosition){
                    if(game)
                }

            }
        } */
	}

}
