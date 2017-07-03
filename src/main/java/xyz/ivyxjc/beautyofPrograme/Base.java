package xyz.ivyxjc.beautyofPrograme;

/**
 * Created by yanjiusuo4 on 2016/9/27.
 */
public abstract class Base {

    private int a=0;
    private int b=0;

    {
        System.out.println("instance");
    }
    public void baseOne(){
        System.out.println("baseOne");
    }

    public void baseTwo(){
        System.out.println("baseTwo");
    }

    public int baseThree(){
        System.out.println("baseThree");
        return 1;
    }

    private void basePrivate(){

    }

    protected void baseProtected(){

    }

    void baseDefault(){

    }

    public abstract void baseAbstract();

    @Override
    public String toString() {
        return "Base";
    }

    public static void main(String[] args){
        int n=2000000;
        int[] prime=new int[n];

        for(int i=0;i<n;i++){
            prime[i]=i+1;
        }


        int r=(int)(Math.sqrt((double)n));

        System.out.println(r);

        for(int j=2;j<r+1;j++){
            if(prime[j-1]!=0){
                int s=j*j;
                while (s<=n){
                    prime[s-1]=0;
                    s+=j;
                }
            }
        }
        int res=0;
        for(int i=0;i<n;i++){
            res+=prime[i];
        }

        System.out.println(res);
    }
}
