package beautyofPrograme;


import beautyofPrograme.aa.AInterface;

/**
 * Created by yanjiusuo4 on 2016/9/27.
 */
public class BBB {
    public static void main(String[] args){
//        AAA a=new AAA();
//        CCC c=new CCC();
//        DDD d=new DDD();
//
//        BBB b=new BBB();
//
//
//
//        AInterface[] aa=new AInterface[3];
//        aa[0]=a;
//        aa[1]=c;
//        aa[2]=d;
//
//
//        for(int i=0;i<3;i++){
//            aa[i].aa();
//        }

//        AInterface ain=new AAA(50);
//        ain.aa();
//        AAA aaa=new AAA();

//        Base base=new AAExtend();
////        base.baseOne();
////        base.baseTwo();
//        base.baseAbstract();
//        base.baseOne();
//        System.out.println(base.toString());
////        System.out.println(base.getClass());
//        System.out.println(base);
//
//
//        CCC ccc=new CCC();

        AInterface a=new AInterface() {
            private int i=0;
            @Override
            public void aa() {
                System.out.println("ss");
                bb();
            }

            public void bb(){
                System.out.print("bbb");
            }
        };

        a.aa();



    }


}
