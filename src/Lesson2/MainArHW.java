package Lesson2;

public class MainArHW {
    public static void main(String[] args) {
        /*int[] arr = {1,2,3,4,5};
        System.out.println(arr);
        System.out.println(Arrays.toString(arr));*/

        Array arr = new Array(5);
        for (int i = 0; i < 10; i++) {
            arr.append(i);
        }

        for (int i = 0; i < arr.length(); i++) {
            System.out.printf("%3d", arr.get(i));
        }

        /*arr.deleteAll();
        System.out.println();*/

        arr.append(5);
        arr.append(6);
        System.out.println(" Before:");
        System.out.println(arr.toString());
        arr.deleteAll(5);
        System.out.println(" After:");
        System.out.println(arr.toString());
    }
}
