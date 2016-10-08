package beautyofPrograme;

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
}
