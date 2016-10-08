package beautyofPrograme;

import beautyofPrograme.aa.AInterface;

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
        AAA aaa=new AAA();
        int res=aaa.a();
        System.out.print(aStatic());
    }

    @Override
    public void aa() {
        System.out.println(i);
    }
}
