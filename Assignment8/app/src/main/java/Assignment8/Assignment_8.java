package Assignment8;

import java.util.Random;

public class Assignment_8 {

    String[] input;
    char[] aux;
    String mixed = "";
    public Assignment_8(String input) {
        this.input = input.split(" ");
        mixInput(this.input);
    }

    public String mixInput(String[] input) {
        char charAux1, charAux2;
        Random rnd = new Random();
        for (int i=0; i < input.length; i++){
            aux = input[i].toCharArray();
            int comma;
            if (input[i].length() > 3){
                comma = (aux[aux.length -1] == ',') || (aux[aux.length -1] == '.')? 2 : 1;
                for (int j=1; j < input[i].length()-comma; j++){
                    int index = rnd.nextInt(input[i].length()-3) +1;
                    charAux1 = aux[j];
                    charAux2 = aux[index];
                    aux[j] = charAux2;
                    aux[index] = charAux1;
                }
            }
            mixed = mixed + word(aux) + " ";
        }
        return mixed;
    }

    public String word (char[] aux){
        String word = "";
        for (int i=0; i < aux.length; i++){
            word = word + aux[i];
        }
        return word;
    }

    public String toString() {
        return mixed;
    }

}
