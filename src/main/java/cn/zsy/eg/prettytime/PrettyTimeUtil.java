package cn.zsy.eg.prettytime;


import org.ocpsoft.prettytime.PrettyTime;

import java.util.Date;
import java.util.Locale;

public class PrettyTimeUtil {

    public static void main(String[] args)
    {
        PrettyTime p = new PrettyTime();
        System.out.println(p.format(new Date()));
        //prints: “moments from now”

        System.out.println(p.format(new Date(System.currentTimeMillis() + 1000*60*10)));
        //prints: “10 minutes from now”

        PrettyTime pp = new PrettyTime(new Locale("de"));
        System.out.println(pp.format(new Date()));
    }
}
