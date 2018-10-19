package Lesson6;

import java.util.Random;

public class MainTr {
    private static int nodeCount = 20;

    public static void main(String[] args) {

        Random random = new Random();

        Tree[] trees = new Tree[20];

        /*for (int i = 0; i < trees.length; i++) {
            trees[i] = new Tree();
            filTree(trees[i]);
        }*/

        trees[0] = new Tree();
        //filTree(trees[0]);
        //trees[0].displayTree();

        int arr[] = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100 + 1);
            System.out.print(arr[i] + " ");
            trees[0].insert(arr[i]);
        }

        System.out.println();
        trees[0].displayTree();
        trees[0].isBalanced(trees[0].root, 0);
        System.out.println("LeftC " + trees[0].leftC);
        System.out.println("RoghtC " + trees[0].rightC);
    }

    public static void filTree(Tree tree){
        Random random = new Random();
        for (int i = 0; i < nodeCount; i++) {
            tree.insert(random.nextInt(100 + 1));
        }
    }
}
