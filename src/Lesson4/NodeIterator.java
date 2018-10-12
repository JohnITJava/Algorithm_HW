package Lesson4;

import Lesson4.BiDirectionList.Node;

public class NodeIterator {
    /*private class Node {
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
    }*/

    private Node current;
    private Node prev;
    private Node next;
    private BiDirectionList list;

    public void setCurrent(Node current) {
        this.current = current;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public NodeIterator(BiDirectionList list){
        this.list = list;
        this.reset();
    }


    public void reset(){
        this.current = list.getHead();
    }

    public void nextLink(){
        prev = current;
        current = current.next;
        next = current.next;
    }

    public Node getCurrent(){
        return current;
    }

    public void atEnd(){

    }

    public void insertAfter(int i){
        for (int j = 0; j < i; j++) {
            nextLink();
        }
    }

    public void insertBefore(){}

    public void deleteCurrent(int i){}

}

