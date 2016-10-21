package beautyofPrograme;

import beautyofPrograme.aa.AInterface;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yanjiusuo4 on 2016/9/27.
 */
public class AAA implements AInterface {

    private int i=100;

    public AAA(){
//        System.out.println(3);
    }

    public AAA(int i){
        this.i=i;
//        System.out.println(4);

    }

    public AAA(int i,int j){
        System.out.println(5);

    }

    public int a(){
        return 1;
    }

    public static int aStatic(){
        return 2;
    }

    public static void main(String[] args){
        Set<Integer> aa=new HashSet<>();
        System.out.println(aa.add(20));
        System.out.println(aa.add(20));
        for(int i:aa){
            System.out.println(i);
        }
    }

    @Override
    public void aa() {
        System.out.println(i);
    }
}
