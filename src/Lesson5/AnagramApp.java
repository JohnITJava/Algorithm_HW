package Lesson5;

import java.util.ArrayList;

public class AnagramApp {
    private char[] word;
    private int size;

    public int getSize() {
        return size;
    }

    public AnagramApp(String input) {
        word = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            word[i] = input.charAt(i);
        }
        this.size = word.length;
    }



    public void getAnagramm(int newSize){
        if (newSize == 1) return;
        for (int i = 0; i < newSize; i++) {
            getAnagramm(newSize - 1);
            if (newSize == 2){
                showIt();
            }
            rotate(newSize);
        }

    }

    public void showIt(){
        for(int i=0; i < size; i++){
            System.out.print(word[i]);
        }
        System.out.println("");
    }

    public void rotate(int newSize){
        int i;
        int pos = size - newSize;
        char temp = word[pos];
        for (i = pos + 1; i < size; i++) {
            word[i-1] = word[i];
        }
        word[i-1] = temp;

    }
}
