package graph;

import java.util.Iterator;

/**
 * Created by yanjiusuo4 on 2016/9/23.
 */
public class Bag<Edge> implements Iterable<Edge>{

    private Node first;
    private class Node{
        Edge edge;
        Node next;
    }

    public void add(Edge edge){
        Node oldfirst=first;
        first=new Node();
        first.edge=edge;
        first.next=oldfirst;
    }

    @Override
    public Iterator<Edge> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Edge>{
        private Node current=first;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Edge next() {
            Edge edge=current.edge;
            current=current.next;
            return edge;
        }
    }
}

