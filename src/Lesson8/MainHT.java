package Lesson8;

import Lesson4.Cat;

public class MainHT {
    public static void main(String[] args) {
        HashTable ht = new HashTable(25);
        ht.insert(new Cat(1, ""));
        ht.insert(new Cat(23, ""));
        ht.insert(new Cat(30, ""));
        ht.insert(new Cat(40, ""));
        ht.insert(new Cat(23, ""));
        ht.insert(new Cat(37, ""));
        ht.insert(new Cat(56, ""));
        ht.insert(new Cat(78, ""));
        ht.insert(new Cat(89, ""));
        ht.insert(new Cat(125, ""));
        ht.insert(new Cat(10, ""));

        System.out.println(ht);
        ht.delete(78);
        System.out.println(ht);
    }
}
