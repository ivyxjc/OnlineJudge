package topCoder_div2;

/**
 * Created by xgh on 2016/1/30.
 */
public class SRM680_div2_500_BearChairs {
    public int[] findPositions(int[] atLeast, int d){
        int [] res=new int[atLeast.length];
        res[0]=atLeast[0];
        int max=res[0];
        int min=res[0];

        for(int i=1;i<atLeast.length;i++){
            if(atLeast[i]<=min-d&&min-d>=1){
                res[i]=atLeast[i];
                min=res[i];
                continue;
            }else if(atLeast[i]>max+d){
                res[i]=atLeast[i];
                max=res[i];
                continue;
            }
            int tmp=min+d;
            while(tmp<=max-d){
                if(atLeast[i]<=tmp){
                    res[i]=tmp;
                }
                tmp+=d;
            }
            if(res[i]==tmp-d)
                continue;
            res[i]=max+d;
            max+=d;


        }

        return res;
    }
    public static void main(String[] args){
        SRM680_div2_500_BearChairs aa=new SRM680_div2_500_BearChairs();
        int [] atleast={1,21,11,7};
        int [] bb =aa.findPositions(atleast,10);
        for(int i=0;i<bb.length;i++){
            System.out.println(bb[i]);
        }
    }
}
