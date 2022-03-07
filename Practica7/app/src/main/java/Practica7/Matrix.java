package Practica7;

import java.util.Scanner;

public class Matrix {

    public static int DisplayMenu(boolean matrixFilled) {
        int option = -1;
        Scanner read = new Scanner(System.in);
        do{
            option = -1;
            System.out.println("Ingrese el numero de la opción que desea ejecutar");
            System.out.println("1 --Rellenar TODA la matriz de números");
            System.out.println("2 --Suma de una fila");
            System.out.println("3 --Suma de una columna");
            System.out.println("4 --Suma de la diagonal principal");
            System.out.println("5 --Suma de la diagonal reversa");
            System.out.println("6 --Mostrar la media de todos los valores");
            System.out.println("7 --Salir");
            option= read.nextInt();
        }while (
            (!matrixFilled && !(option == 1 || option == 7)) ||
            (matrixFilled && !VerifyOption(option))
            );

        read.close();
        return option;
    }

    public static boolean VerifyOption(int option){
        boolean bool = false;
        bool = option >= 1 && option <= 7;
        return bool;
    }

    public static void OptionCases(int option, int[][] matrix, boolean matrixFilled) {
        int sum;
        switch (option){
            case 1:
                matrix = Matrix.Fill();
                matrixFilled = true;
                break;
            case 2:
                sum = Matrix.SumRow(matrix);
                System.out.println("La suma de los valores de la fila es: " + sum);
                break;
            case 3:
                sum = Matrix.SumColumn(matrix);
                System.out.println("La suma de los valores de la columna es: " + sum);
                break;
            case 4:
                sum = Matrix.SumPrincipalDiagonal(matrix);
                System.out.println("La suma de los valores de la diagonal principal es: " + sum);
                break;
            case 5:
                sum = Matrix.SumReverseDiagonal(matrix);
                System.out.println("La suma de los valores de la diagonal principal es: " + sum);
                break;
            case 6:
                Matrix.CalculateMean(matrix);
                break;
            case 7:
                break;

        }
    }

    public static int[][] Fill() {
        int[][] matrix = new int[4][4];
        Scanner readnum =  new Scanner(System.in);
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                System.out.println("ingrese un nuemro entero para la matriz");
                matrix[i][j] = readnum.nextInt();
            }
        }
        readnum.close();
        return matrix;
    }

    public static int SumRow(int[][] matriz) {
        Scanner read = new Scanner(System.in);
        int row, sum = 0;
        do{
            System.out.println("Ingrese el numero de la fila que desea llenar (1, 2, 3 o 4) :");
            row = read.nextInt();
        }while( row >=1 && row <=4);
        read.close();
        for (int i = 0; i < 4; i++){
            sum = sum + matriz[row-1][i];
        }
        return sum;
    }

    public static int SumColumn(int[][] matriz) {
        Scanner read = new Scanner(System.in);
        int column, sum = 0;
        do{
            System.out.println("Ingrese el numero de la columna que desea llenar (1, 2, 3 o 4) :");
            column = read.nextInt();
        }while( column >=1 && column <=4);
        read.close();
        for (int i = 0; i < 4; i++){
            sum = sum + matriz[i][column-1];
        }
        return sum;
    }

    public static int SumPrincipalDiagonal(int[][] matriz) {
        Scanner read = new Scanner(System.in);
        int sum = 0;
        read.close();
        for (int i = 0; i < 4; i++){
            sum = sum + matriz[i][i];
        }
        return sum;
    }

    public static int SumReverseDiagonal(int[][] matriz) {
        Scanner read = new Scanner(System.in);
        int sum = 0, j = 3;
        read.close();
        for (int i = 0; i < 4; i++){
            sum = sum + matriz[i][j];
            j--;
        }
        return sum;
    }

    public static void CalculateMean(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < 4;){
            for(int j = 0; 0 < 4; j++){
                sum = sum + matrix[i][j];
            }
        }
        System.out.println("la media de todos los valores de la matriz es: " + sum);
    }


}
