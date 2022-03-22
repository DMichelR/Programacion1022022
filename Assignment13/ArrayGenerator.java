package Assignment13;

import java.util.Random;

public class ArrayGenerator {
    public int cant = 141;
    public int[] array = new int[100];
    public Random rnd = new Random();

    public ArrayGenerator(){
        fillArray();
    }

    public String toString(){
        String texto = "";
        for(int i =0; i< array.length;i++){
           texto = texto + array[i] + ", "; 
        }
        return texto;
    }

    public void fillArray(){
        int random, aux = 0;
        int i = 0;
        boolean valid = true;
        do{
            random = rnd.nextInt(cant);
            aux = 0;
            valid = true;
            for(int j = 0; j < array.length; j++){
                if (array[j] == random ){
                    valid = false;
                }
            }
            int k = 0;
            while (aux < cant){
                aux = fibonacci(k);
                if (aux == random){
                    valid = false;
                }
                k++;
            }
             if (valid){
                array[i] = random;
                i++;
            }
        }while(i < array.length);
    }

    public int fibonacci(int n){
        if (n == 0){
            return 0;
        }
        else if (n == 1){
            return 1;
        }
        else{
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

}
