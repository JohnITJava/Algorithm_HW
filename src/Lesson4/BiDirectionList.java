package Lesson4;

public class BiDirectionList {
    private class Node {
        Cat c;
        Node next;
        Node prev;

        public Node(Cat c) {
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return c != null ? c.equals(node.c) : node.c == null;
        }

        @Override
        public String toString() {
            return c.toString();
        }
    }

    private Node head;
    private Node tail;

    public BiDirectionList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void insertHead(Cat c){
        Node n = new Node(c);
        if (this.isEmpty()) tail = n;
        else {n.next = head;
        head.prev = n;}
        head = n;
    }

    public void insertTail(Cat c){
        Node n = new Node(c);
        if (isEmpty()) head = n;
        else {tail.next = n;
        n.prev = tail;}
        tail = n;
    }

    public Cat removeHead(){
        if (isEmpty()) return null;
        Cat c = head.c;
        head = head.next;
        head.prev = null;
        return c;
    }

    public Cat removeTail(){
        if (isEmpty()) return null;
        Cat c = tail.c;
        tail = tail.prev;
        tail.next = null;
        return c;
    }

    @Override
    public String toString() {
        Node current = head;
        StringBuilder sb = new StringBuilder("[ ");
        while (current != null) {
            sb.append(current);
            current = current.next;
            sb.append(current == null ? " ]" : ", ");
        }
        return sb.toString();
    }

    public boolean contains(Cat c){
        if (isEmpty()) return false;
        Node current = head;
        while (current.c.equals(c)){
            if (current.next == null) return false;
            else current = current.next;
        }
        return true;
    }

    //вставка в i-ю позицию с помощью итератора
    public void insert(int i){}

    //удаление i-й позиции с помощью итератора
    public boolean delete(int i){return true;}
}
