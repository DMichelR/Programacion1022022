package Practica7;

import java.util.Scanner;

public class Magic_square {

    static int row;
    static int column;

    public static int SetLength() {
        int length = 0;
        Scanner scanner = new Scanner(System.in);
		do
		{
			System.out.print("Ingrese la longitud del cuadrado (numero impar): ");
			try {
				length = Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {}
		}
		while (length % 2 == 0 || length <= 1);
		scanner.close();
        return length;
    }

    public static int[][] FillSquare(int length) {
        int[][] matrix = new int[length][length];
		row = length / 2 - 1;
		column = length / 2;
		matrix[row][column] = 1;

		for (int i = 2; i <= length * length; i++)
		{
			if (row == 0 && column == length - 1)
				row = length - 2;
			else if (row != 0 && column != length - 1 && matrix[row - 1][column + 1] == 0) {
				row = row - 1;
				column = column + 1;
			} 
			else if (row == 0 && column != length - 1) {
				row = length - 1;
				column = column + 1;
			} 
			else if (column == length - 1 && row != 0) {
				row = row - 1;
				column = 0;
			}
			else if (matrix[row - 1][column + 1] != 0 && row != 1 && column != length - 1)
				row = row - 2;
			else if (matrix[row - 1][column + 1] != 0 && row == 1 && column != length - 1)
				row = length - 1;

			matrix[row][column] = i;
		}
        return matrix;
    }

    public static void Print(int length, int[][] matrix) {
		System.out.print("*");
		repeat('*', length * digitCount(length * length) + 3 * (length - 1) + 2);
		System.out.print("*\n");
		
		for (row = 0; row < length; row++)
		{
			for (column = 0; column < length; column++)
			{
				if (column == 0)
					System.out.print("* ");
				
				System.out.print(matrix[row][column]);
				
				if (column != length - 1)
					repeat(' ', digitCount(length * length) - digitCount(matrix[row][column]) + 3);
				
				if (column == length - 1) {
					repeat(' ', digitCount(length * length) - digitCount(matrix[row][column]) + 1);
					System.out.print("*");
				}
			}
			System.out.println();
			
			if (row < length - 1) {
				System.out.print("*");
				repeat(' ', length * digitCount(length * length) + 3 * (length - 1) + 2);
				System.out.print("*\n");
			}
		}
		
		System.out.print("*");
		repeat('*', length * digitCount(length * length) + 3 * (length - 1) + 2);
		System.out.print("*\n");
        
    }

    public static void KnowSum(int[][] matrix) {
		int sum = 0;
		for(int i = 0; i < matrix.length; i++)
			sum += matrix[0][i];
			
		System.out.println("\nTodas las filas, columnas y diagonales suman: " + sum);
        
    }

    public static int digitCount(int number)
	{
		int j = 0;

		for (;;) {
			number = number / 10;
			j++;
			if (number == 0)
				break;
		}
		return (j);
	}

	public static void repeat(char c, int i)
	{
		for (int x = 0; x < i; x++)
			System.out.print(c);
	}
	    
}
