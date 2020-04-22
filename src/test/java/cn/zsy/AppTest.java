package cn.zsy;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }


    @org.junit.Test
    public void ttt() throws Exception{
//        File file = new File("E:\\Users\\zhangsongyang\\github\\OrionSE\\src\\main\\resources\\mac-2015-09-24.txt");
//        List<String> list = FileUtils.readLines(file);
//        File fileA = new File("E:\\Users\\zhangsongyang\\github\\OrionSE\\src\\main\\resources\\mac-cid-46-47.txt");
        System.out.println("asdf");
//        List<String> listA = FileUtils.readLines(fileA);
//        System.out.println(listA.size());
//        for(String str : listA){
//            System.out.println(str);
//        }

        //\xb0\xae\xc6\xe6\xd2\xd5PPS\xd3\xb0\xd2\xf4%20(\xce\xb4\xcf\xec\xd3\xa6)
        System.out.println("http://el.bbqk.com/abz1v/0.html".length());
        System.out.println(URLDecoder.decode("\\xb0\\xae\\xc6\\xe6\\xd2\\xd5PPS\\xd3\\xb0\\xd2\\xf4%20(\\xce\\xb4\\xcf\\xec\\xd3\\xa6", "utf-8"));
        System.out.println(URLEncoder.encode("张"));


    }
}
