package cn.zsy.eg.ReadConfigProperties;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestResourceBundle {

    public static void main(String[] args){
        Locale localeCN = new Locale("zh", "CN");
        Locale localeEN = new Locale("en", "US");
        ResourceBundle resourceBundleZH = ResourceBundle.getBundle("configTest",localeCN);
        ResourceBundle resourceBundleEN = ResourceBundle.getBundle("configTest",localeEN);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("configTest",Locale.getDefault());
        System.out.println(resourceBundle.getString("kDefX64Url_1"));
        System.out.println(resourceBundle.getString("kDefDllVersion"));
        System.out.println(resourceBundle.getString("kDefX64DllMd5"));
        System.out.println(resourceBundle.getString("xsh"));
        System.out.println(resourceBundle.getString("and"));
        System.out.println(resourceBundle.getString("zsy"));
        System.out.println(resourceBundle.getString("ddd"));
        System.out.println(resourceBundleEN.getString("ddd"));
        System.out.println(resourceBundleZH.getString("ddd"));

    }

}
