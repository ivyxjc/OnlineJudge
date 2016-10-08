package list;

/**
 * Created by yanjiusuo4 on 2016/9/27.
 */
public class Node<E> {
    private E data;
    private E y;
    private Node<E> next;

    public Node(){

    }

    public Node(E e){
        data=e;
    }

    public void setData(E data){
        this.data=data;
    }

    public E getData(){
        return data;
    }

    public void setNext(Node<E> next){
        this.next=next;
    }

    public Node<E> next(){
        return next;
    }

}
