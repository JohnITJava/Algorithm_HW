package Lesson4;

public class MainListHW {
    public static void main(String[] args) {
        BiDirectionList bdl = new BiDirectionList();
        bdl.insertHead(new Cat(3, "Sam"));
        bdl.insertTail(new Cat(4,"Pet"));
        bdl.insertHead(new Cat(2, "Mad"));
        NodeIterator ni = new NodeIterator(bdl);
        System.out.println(bdl.toString());

        bdl.insert(new Cat(5, "Kitty"), 3);
        System.out.println(bdl.toString());

        bdl.delete(2);
        System.out.println(bdl.toString());

        /*ni.nextLink();
        System.out.println(ni.getCurrent().toString());*/

        //bdl.removeTail();
        //bdl.removeHead();

    }
}
