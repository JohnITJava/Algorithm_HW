package Lesson2;

import java.util.Random;

public class MainArHW {
    public static void main(String[] args) {
        /*int[] arr = {1,2,3,4,5};
        System.out.println(arr);
        System.out.println(Arrays.toString(arr));*/
        Random random = new Random();

        Array arr = new Array(54, 32, 21, 6, 5, 10, 18, 0, 34, 11, 7);
        /*for (int i = 0; i < 10; i++) {
            arr.append(i);
        }*/

        /*for (int i = 0; i < arr.length(); i++) {
            System.out.printf("%3d", arr.get(i));
        }*/

        /*for (int i = 0; i < 100; i++) {
            arr.append(random.nextInt(100));
        }*/

        /*arr.deleteAll();
        System.out.println();*/

        //arr.append(5);
        //arr.append(6);
        System.out.println(" Before:");
        System.out.println(arr.toString());
        //arr.deleteAll(5);
        System.out.println(" After:");
        arr.sortBubbleUpd();
        System.out.println(arr.toString());
    }
}
