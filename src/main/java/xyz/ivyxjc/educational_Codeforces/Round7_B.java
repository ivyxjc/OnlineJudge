package xyz.ivyxjc.educational_Codeforces;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by xgh on 2016/2/16.
 */
public class Round7_B {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String first_line=in.nextLine();
        int second_line=in.nextInt();
        String[] hour_minute=first_line.split(":");
        int hour=Integer.parseInt(hour_minute[0]);
        int minute=Integer.parseInt(hour_minute[1]);
        int[] end_hour_minute=calculate(hour,minute,second_line);
        int end_hour=end_hour_minute[0];
        int end_minute=end_hour_minute[1];
        DecimalFormat df=new DecimalFormat("00");
        String end_hour_res=df.format(end_hour);
        String end_minute_res=df.format(end_minute);
        System.out.println(end_hour_res+":"+end_minute_res);
        System.out.println(df.format(125));
    }

    public static int[] calculate(int hour,int minute,int time_passed){
        int start_time_convert_to_minute=hour*60+minute;
        int end_time_convert_to_minute=start_time_convert_to_minute+time_passed;
        int end_minute=end_time_convert_to_minute%60;
        int end_hour=(end_time_convert_to_minute/60)%24;
        int[] res={end_hour,end_minute};
        return res;
    }
}
