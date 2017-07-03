package xyz.ivyxjc.algorithm.dynamicProgram;

/**
 * Created by ivxyjc on 2016/12/6.
 */


/**
 * 切割钢条的问题
 * 算法导论-动态规划-钢条切割
 */
public class Memorized_cut_rod {


    /**
     * 自底而上的方法
     * @param p
     * @param n
     * @return
     */
    public int cutRodBottom(int[] p, int n){
        int[] r=new int[n+1];
        r[0]=0;
        for (int i = 1; i <n+1 ; i++) {
            int q = -1;
            for (int j = 1; j < i+1; j++) {
                q = Math.max(q, r[i - j] + p[j]);
            }
            r[i] = q;
        }
        return r[n];
    }

    /**
     *
     * 自顶而下的带备忘录的方法
     * @param p
     * @param n
     * @return
     */
    public int cutRod(int [] p, int n){
        int [] r=new int[n+1];
        for(int i=0;i<n+1;i++){
            r[i]=-1;
        }
        return cutRodAux(p,n,r);
    }

    public int cutRodAux(int[] p,int n,int[] r){
        int q;
        if(r[n]>=0){
            return r[n];
        }
        if(n==0){
            q=0;
        }else{
            q=-1;
            for(int i=1;i<n+1;i++) {
                q = Math.max(q, p[i] + cutRodAux(p, n - i, r));
            }
        }
        r[n]=q;
        return r[n];
    }


    /**
     * 不带备忘录的自顶而下方法, 时间复杂度O(2^n),复杂度太大
     * @param p
     * @param n
     * @return
     */
    public long cutRod_basic(int[] p, int n){
        long q;
        if(n==0){
            return 0;
        }
        q=-1;
        for(int i=1;i<n+1;i++){
            q=Math.max(q,p[i]+cutRod_basic(p,n-i));
        }
        return q;
    }

    public static void main(String[] args){
        int [] p={0,1,5,8,9,10,17,17,20,24,30,45,57,78,89,121,134,135,136,145,148,156,168,169,179,185,23,231,2345,2345,1234,234,1234,34,26,46,56,234,5345,35,235,235,235,23,5234,5,23,523,5,32,523,5,235,234,435,32,45,34,};
//        long [] p=new long[10000];
//        Random random=new Random();
//        for(int i=0;i<10000;i++){
//            p[i]= random.nextInt();
//        }
        int n=6;
        System.out.println("----------------");
        System.out.println(new Memorized_cut_rod().cutRod_basic(p,n));
        System.out.println(new Memorized_cut_rod().cutRod(p,n));
        System.out.println(new Memorized_cut_rod().cutRodBottom(p,n));


    }


}

