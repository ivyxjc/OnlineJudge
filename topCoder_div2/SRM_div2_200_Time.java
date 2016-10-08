package topCoder_div2;

/**
 * Created by xgh on 2016/1/30.
 */
public class SRM_div2_200_Time {
    public String whatTime(int seconds){
        int hour=seconds/3600;
        seconds=seconds%3600;
        int minute=seconds/60;
        seconds=seconds%60;

        String res="";
        res=hour+":"+minute+":"+seconds;
        return res;
    }

}
