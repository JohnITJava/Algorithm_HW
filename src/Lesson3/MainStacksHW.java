package Lesson3;

public class MainStacksHW {
    public static void main(String[] args) {
        String someStr = "abcdefg";

        reverse(someStr);
    }

    public static void reverse(String str){
        int size = str.length();
        Stack stack = new Stack(size);
        for (int i = 0; i < size; i++) {
            char ch = str.charAt(i);
            stack.insert(ch);
        }
        for (int i = 0; i < size; i++) {
            System.out.print((char) stack.remove());
        }
    }
}