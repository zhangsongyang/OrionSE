package cn.zsy.eg.ReadConfigProperties;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class TestApacheCommonsConfiguration {

    public static void main(String[] args) throws Exception {
        PropertiesConfiguration  config = new PropertiesConfiguration("configApache.properties");
        config.setEncoding("utf8");
        config.load("configApache.properties");
        String ip = config.getString("kDefDllVersion");
        int inttest = config.getInt("inttest");
        String zhtest = config.getString("cn");
        System.out.println(ip);
        System.out.println(inttest);
        System.out.println(zhtest);






    }
}
