package Lesson4;

public class MainLL {
    public static void main(String[] args) {
        RelatedList rl = new RelatedList();
        rl.insert(new Cat(2, "cat-1"));
        rl.insert(new Cat(32, "cat-2"));
        rl.insert(new Cat(4, "cat-3"));
        rl.insert(new Cat(6, "cat-4"));
        System.out.println(rl);
        System.out.println(rl.remove());
        System.out.println(rl);
    }
}
