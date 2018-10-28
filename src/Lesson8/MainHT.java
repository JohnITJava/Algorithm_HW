package Lesson8;

import Lesson4.Cat;

public class MainHT {
    public static void main(String[] args) {
        HashTable ht = new HashTable(10);
        ht.insert(new Cat(1, ""));
        ht.insert(new Cat(23, "S"));
        ht.insert(new Cat(30, "S"));
        ht.insert(new Cat(40, "D"));
        ht.insert(new Cat(50, ""));
        ht.insert(new Cat(23, "D"));
        ht.insert(new Cat(37, ""));
        ht.insert(new Cat(56, ""));
        ht.insert(new Cat(78, ""));
        ht.insert(new Cat(89, ""));
        ht.insert(new Cat(125, ""));
        ht.insert(new Cat(10, ""));

        System.out.println(ht);
        System.out.println("Finded: " + ht.find(23));
        System.out.println(ht.delete(50));
        ht.delete(78);
        System.out.println(ht);
        ht.insert(new Cat(78, "N"));
        System.out.println(ht);
        System.out.println("Some find: " + ht.find(40));
    }
}
