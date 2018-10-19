package Lesson3;

public class MainStacksHW {
    public static void main(String[] args) {
        //String someStr = "abcdefg";

        //reverse(someStr);

        /*PriorityQueue pq = new PriorityQueue(5);
        pq.insert(5);
        pq.insert(6);
        pq.insert(8);
        pq.insert(3);
        pq.insert(4);
        pq.insert(1);
        System.out.println(pq.remove());
        System.out.println(pq.remove());*/

        Deck deck = new Deck(5);
        deck.insertLeft(1);
        deck.insertLeft(2);
        deck.insertLeft(3);
        deck.insertRight(4);
        deck.insertRight(5);
        deck.insertRight(5);
        deck.removeLeft();
        deck.removeRight();
        deck.insertRight(6);
        deck.insertLeft(7);
        deck.removeLeft();
        deck.removeLeft();
        deck.removeLeft();
        deck.removeLeft();

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