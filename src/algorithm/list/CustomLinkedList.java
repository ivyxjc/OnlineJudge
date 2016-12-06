package algorithm.list;

/**
 * Created by yanjiusuo4 on 2016/9/27.
 */
public class CustomLinkedList<E> {
    private final Node<E> root;

    private Node<E> addFlag;

    public CustomLinkedList(){
        root=new Node<E>();
        addFlag=root;
    }


    public void add(E data){
        Node<E> node=new Node<E>();
        addFlag.setNext(node);
        addFlag=node;
    }

    public E get(int index) throws IndexOutOfBoundsException{
        int tmp=index;
        Node<E> start=root;
        while(tmp>=0){
            start=start.next();
            if(start==null){
                throw new IndexOutOfBoundsException(index+"");
            }
            tmp--;
        }
        return start.getData();

    }


}


