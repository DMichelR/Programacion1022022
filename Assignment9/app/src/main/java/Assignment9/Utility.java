package Assignment9;

import java.util.Arrays;

public class Utility {

    public static String[] Repeated(String string) {
        String[] words = string.split(" ");
        System.out.println(Arrays.toString(words));
        String word = "";
        String auxword;
        int count = 0;
        int auxcount = 0;
        for (int i = 0; i < words.length; i++){
            auxword = words[i].toLowerCase();
            auxcount = 0;
            for (int i2 = 0; i2 < words.length; i2++){
                if (auxword.compareTo(words[i2].toLowerCase()) == 0){
                    auxcount++;
                }
            }
            if (count <= auxcount){
                count = auxcount;
                word = auxword;
            }
        }
        String[] reapeted = {word, ""+count};
        return reapeted;
    }

}
