package Lesson6;

import java.util.Random;

public class MainTr {
    private static int nodeCount = 20;

    public static void main(String[] args) {

        Tree[] trees = new Tree[20];

        /*for (int i = 0; i < trees.length; i++) {
            trees[i] = new Tree();
            filTree(trees[i]);
        }*/

        trees[0] = new Tree();
        filTree(trees[0]);
        trees[0].displayTree();
    }

    public static void filTree(Tree tree){
        Random random = new Random();
        for (int i = 0; i < nodeCount; i++) {
            tree.insert(random.nextInt(100 + 1));
        }
    }
}
