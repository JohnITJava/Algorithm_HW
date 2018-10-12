package Lesson4;

public class MainListHW {
    public static void main(String[] args) {
        BiDirectionList bdl = new BiDirectionList();
        bdl.insertHead(new Cat(3, "Sam"));
        bdl.insertTail(new Cat(4,"Pet"));
        bdl.insertHead(new Cat(2, "Mad"));
        bdl.removeTail();
        bdl.removeHead();
        System.out.println(bdl.toString());
    }
}
