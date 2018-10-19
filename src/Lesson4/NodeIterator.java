package Lesson4;

import Lesson4.BiDirectionList.Node;

public class NodeIterator {

    private Node current;
    private Node prev;
    private Node next;
    private BiDirectionList list;


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

    public boolean atEnd(){
        return current.next == null;
    }

    public boolean atFirst(){
        return current.prev == null;
    }

    public void insertAfter(int i, Node node){
        for (int j = 0; j < i; j++) {
            nextLink();
        }
        node.prev = current.prev;
        node.next = current;
    }

    public void insertBefore(){}

    public void deleteCurrent(int i){
        for (int j = 0; j < i - 1; j++) {
            nextLink();
        }
        /*current.prev.next = current.next;
        current.next.prev = current.prev;*/
    }

}

