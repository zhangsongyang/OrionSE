package cn.zsy;

import cn.zsy.util.DateUtil;
import cn.zsy.util.DateUtilThree;
import cn.zsy.util.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.httpclient.util.HttpURLConnection;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MarryTest {

    @Test
    public void sendmess() {

        String returnJson = "{\"version\":\"1.0\",\"user_profile\":{\"game\":27}}";
        String returnJsonQ = "{\"version\":\"1.0\",\"user_profile\":{\"game\":0}}";
        System.out.println(returnJson);
        System.out.println(returnJsonQ);
        String[] ss = new String[1];
        ss[0] = "asdf";
        System.out.println(ss[0]);

    }

    @Test
    public void marry1() {
//        UUID str = UUID.randomUUID();
//        System.out.println(str.toString());
        String srcid = "FUNMUSIC";
        if ("funmusic".equalsIgnoreCase(srcid)) {
            System.out.println("asfd");
        }

    }

    @Test
    public void marry2() {

        for (int i = 0; i < 100; i++) {
            Random r = new Random();
            System.out.println(r.nextInt(3));
        }

    }

    @Test
    public void marry3() {
        long s = 11L;
        System.out.println("asdfsdf" + s);
        String USER_HOME = System.getProperty("user.home");
        System.out.println(USER_HOME);
        ThreadLocal<MarryTest> t = new ThreadLocal<MarryTest>();
        System.out.println(t.get());
        Set<String> set = new HashSet<String>();
        System.out.println(set.toString());
    }

    @Test
    public void marry4() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("aa", "asdfasdf");
        jsonObject.put("bb", "a222222222");
        System.out.println(jsonObject.toJSONString());

        System.out.println(jsonObject.keySet().toString());
        if (jsonObject.keySet().contains("bbv")) {
            System.out.println(jsonObject.get("bb"));
        }
    }


    @Test
    public void marry5() {
//        try {
//            int a = 1 / 0;
//        } catch (Exception e) {
//            throw  new ArithmeticException();
////            e.printStackTrace();
//        }
//        System.out.println("-------------");

//        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            Random random = new Random();
//            int index = random.nextInt(4);
            int a = random.nextInt(4);
            System.out.println(a);
        }
//        String apacheHost = "asdfasfd";
//        String cid = "asdf";
//        String[] urls = {
//                apacheHost + "aid=text_ad_3127&cid=" + cid +
//                        "&url=http://game.kuwo.cn/g/st/newdl?dlid=gfbdl30&gameid=219&serverid=999&s=1&at=71&ap=85&from=icon&uid=" + cid,
//                apacheHost + "aid=text_ad_3127&cid=" + cid +
//                        "&url=http://game.kuwo.cn/g/st/newdl?dlid=gfbdl30&gameid=219&serverid=999&s=1&at=71&ap=85&from=icon&uid=" + cid,
//                apacheHost + "aid=text_ad_3127&cid=" + cid +
//                        "&url=http://game.kuwo.cn/g/st/newdl?dlid=gfbdl30&gameid=219&serverid=999&s=1&at=71&ap=85&from=icon&uid=" + cid,
//                apacheHost + "aid=text_ad_3230&cid=" + cid +
//                        "&url=http://game.kuwo.cn/g/st/newdl?dlid=gjyjh30&gameid=226&serverid=999&at=71&ap=86&from=icon&uid=" + cid
//        };
//        System.out.println(urls[3]);

    }


    @Test
    public void marry6() {
//        String[] ss = new String[]{"1001008096", "1001008097"};
//        System.out.println(ss[0] + "   " + ss[1]);
        System.out.println((int) Math.rint(333.544));


//        for (int i = 0; i < 100; i++) {
//            Random random = new Random();
//            int a = random.nextInt(2);
//            System.out.println(a);
//        }

    }

    @Test
    public void marry7() throws Exception {
        List<String> list = FileUtils.readLines(new File("E:\\Users\\zhangsongyang\\github\\OrionSE\\src\\test\\resources\\sexurl.list"));
        for (String str : list) {
            System.out.println(URLDecoder.decode(str, "GBK"));
        }

    }


    @Test
    public void marry8() {
//        int[] arr = {4, 2, 1, 2, 4};
//        int res = 0;//初始值
//        for (int i = 0; i < arr.length; i++) {
//            res ^= arr[i];
//        }
//        System.out.println(res);


//String str = "upfile/picture/user_loin_avatar.png";
//        if(StringUtils.contains(str, "upfile/picture/user_loin_avatar.png")){
//            System.out.println("2222222222");;
//        }

//        算法的原理就是：任何数异或0值不变，任何数与自己异或值为0。
//        因此一个数两次异或同一个数，值不变。
        String url = "http://120.197.89.214:22122/group1/M00/05/08/wKjUQVdzoZuAWeUMAAVIfrCOtJk395.jpg";
        System.out.println(HttpUtil.getHttpUrlContent(url, "utf-8"));


    }

    @Test
    public void marry9() {
        List<String> list = new ArrayList<String>();
        list.add("asdf");
        System.out.println(CollectionUtils.isNotEmpty(list));
    }


    @Test
    public void marry10() {
        String str = "asdfasdf";
        byte[] bytes = str.getBytes();
        System.out.println(bytes);
        String aa = new String(bytes);
        System.out.println(aa);
    }


    @Test
    public void marray11() {
        List<Long> idList = new ArrayList<Long>();
        idList.add(1L);
        idList.add(2L);
        idList.add(3L);
        Object[] ob = idList.toArray();
        Long[] aaa = (Long[]) ob;
//        for(){
//
//        }
        Long[] aa = {};
        aa[0] = 1L;
        System.out.println(aaa.toString());
    }

    @Test
    public void marray12() {
        int j = 0;
        for (int i = 0; i < 100; i++) {

            if (new Random().nextInt(100) == 100) {
                j++;
            }
        }
        System.out.println(j);
    }


    @Test
    public void marray14() throws IOException {
        String url = "http://www.baidu.com/img/baidu_sylogo1.gif";
        byte[] btImg = getImageFromNetByUrl(url);
        if (null != btImg && btImg.length > 0) {
            System.out.println("读取到：" + btImg.length + " 字节");
            String fileName = "百度.gif";
            writeImageToDisk(btImg, fileName);
        } else {
            System.out.println("没有从该连接获得内容");
        }
    }


    /**
     * 将图片写入到磁盘
     *
     * @param img      图片数据流
     * @param fileName 文件保存时的名称
     */
    public static void writeImageToDisk(byte[] img, String fileName) {
        try {
            File file = new File("C:\\" + fileName);
            FileOutputStream fops = new FileOutputStream(file);
            fops.write(img);
            fops.flush();
            fops.close();
            System.out.println("图片已经写入到C盘");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据地址获得数据的字节流
     *
     * @param strUrl 网络连接地址
     * @return
     */
    public static byte[] getImageFromNetByUrl(String strUrl) {
        try {
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream inStream = conn.getInputStream();//通过输入流获取图片数据
            byte[] btImg = readInputStream(inStream);//得到图片的二进制数据
            return btImg;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从输入流中获取数据
     *
     * @param inStream 输入流
     * @return
     * @throws Exception
     */
    public static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }


    @Test
    public void marry15() {
        String title = "a？s？d？f？g?？";
        System.out.println("a？s？d？f？g");
        System.out.println(StringUtils.replace(title, "？", ""));
    }

    @Test
    public void marry16() {
        int a = RandomUtils.nextInt(100);
//        System.out.println(a);
        String str = RandomStringUtils.randomNumeric(12);
        for (int i = 0; i < 10; i++) {
            int random = Integer.parseInt(RandomStringUtils.randomNumeric(2));
            System.out.println(random);
        }
    }


    @Test
    public void marry17() {
        String str = "[\n" +
                "            {\n" +
                "              \"ques_id\": 1,\n" +
                "              \"ans_id\": [\n" +
                "                1,\n" +
                "                2\n" +
                "              ]\n" +
                "            },\n" +
                "            {\n" +
                "              \"ques_id\": 2,\n" +
                "              \"ans_id\": [\n" +
                "                1\n" +
                "              ]\n" +
                "            }\n" +
                "          ]";
        JSONArray jsonObject = JSON.parseArray(str);
        for (int i = 0; i < jsonObject.size(); i++) {
            JSONObject jsonObject1 = jsonObject.getJSONObject(i);
            System.out.println(jsonObject1.toString());
        }

    }


    @Test
    public void marry18() {
        for (int i = 0; i < 1000; i++) {
            long random = NumberUtils.toLong(RandomStringUtils.randomNumeric(2), 10000);
            System.out.println(random);
        }
    }


    @Test
    public void marry19() {
        Date date = new Date(1477495943349L);
        System.out.println(date.toGMTString());
        System.out.println(RandomStringUtils.randomNumeric(5));
    }

    @Test
    public void marry20() throws IOException {
        File fileNew = new File("e:/aa.gif");
        if (!fileNew.getParentFile().exists()) {
            fileNew.getParentFile().mkdirs();
        }
        if (fileNew.exists()) {
            System.out.println("empty");
            System.out.println(fileNew.length());
        }
        fileNew.createNewFile();
        byte[] fileByte = new byte[1024];

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(fileByte);
        FileOutputStream fileOutputStream = new FileOutputStream(fileNew);
        IOUtils.copy(byteArrayInputStream, fileOutputStream);
        if (null != byteArrayInputStream) {
            byteArrayInputStream.close();
        }
        if (null != fileOutputStream) {
            fileOutputStream.close();
        }
    }


    @Test
    public void marry21() throws IOException {
        if (StringUtils.indexOf("gdmobile*?/group1/M00/04/C0/wKjUQVdzn6KAFtk-AAEqUnIXGMI196.png", "gdmobile*?", 0) == 0) {
            System.out.println("ddd");
        }
//        for(int i=0; i< 100; i++){
//            int winNO = new Random().nextInt(100);
//            System.out.println(winNO);
//        }
        long a = 100;
        int aa = 100;
        for (int i = 0; i < 100; i++) {
            System.out.println(Integer.parseInt(RandomStringUtils.randomNumeric(4)));
        }
    }

    @Test
    public void marry22() {
        Date date = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        System.out.println(formater.format(date));

        Date date2 = new Date();
        SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        System.out.println(formater1.format(date2));

        System.out.println(new Date().getTime());
        Date cashTime1 = DateUtilThree.timeStrToDate(DateUtilThree.dateToString(new Date(0), "yyyy-MM-dd 00:00:00"));
        System.out.println(cashTime1.toString());
        String aaa = DateUtilThree.dateToString(new Date(0), "yyyy-MM-dd 23:59:59");
        System.out.println(aaa);
        Date cashTime2 = DateUtilThree.timeStrToDate(aaa);
        System.out.println(cashTime2);


    }


    @Test
    public void marry23() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date start = calendar.getTime();

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.SECOND, -1);

        Date end = calendar.getTime();
        List<Date> list = new ArrayList<Date>();
        list.add(start);
        list.add(end);
        System.out.println(list.get(0));
        System.out.println(end);
    }


    @Test
    public void marry24() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        int year = calendar.get(Calendar.YEAR);   //获取年;
//        int month = calendar.get(Calendar.MONTH);  //获取月;
//        int date = calendar.get(Calendar.DATE);   //获取天;
//        calendar.set(year, month, 01, 0, 0, 0);
//        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK) - 1;    //这天，在一周内，是第几天
//        if(day_of_week == 0){
//            day_of_week = 7;
//        }
//        System.out.println(day_of_week);
//        System.out.println(day_of_week + date);


        //1481558400
        //1481625700L714
        long millis = 1433572437658L;
        Date date = new Date(millis);
        System.out.println(JSON.toJSONString(date));
//        System.out.println(new Date().getTime());
        System.out.println(JSON.toJSONString(date, SerializerFeature.WriteDateUseDateFormat));

    }

    @Test
    public void marry25() throws ParseException {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM");

        Date date = formater.parse("2016/11");
        System.out.println(date.toString());
    }


    @Test
    public void marry26() throws ParseException {
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        b.add(2);
        b.add(3);
        b.add(4);
        System.out.println(a);
        System.out.println(b);
        System.out.println(
                StringUtils.isNotBlank("    ")
        );
        System.out.println(StringUtils.split("2017-01", "-")[0]);
        System.out.println(StringUtils.split("2017-01", "-")[1]);

    }

    @Test
    public void marry27() {
        Calendar calendar = Calendar.getInstance();
        int year = 2016;
        int month = 2 - 1;
        int date = 1;
        System.out.println(month);
        calendar.set(year, month, date);
        System.out.println(DateUtil.dateToString(calendar.getTime(), "yyyy年MM月"));

        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println("Max Day: " + maxDay);

        int minDay = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
        System.out.println("Min Day: " + minDay);

        for (int i = maxDay; i >= minDay; i--) {
            calendar.set(year, month, i);
            System.out.println("Day: " + calendar.getTime().toLocaleString());
        }

    }


    @Test
    public void marry28() {
        // "dt" : "2017-01"
        Calendar calendar = Calendar.getInstance();
        int year = 2016;
        int month = 2 - 1;
        int date = 1;
        System.out.println(month);
        calendar.set(year, month, date);
        System.out.println(DateUtil.dateToString(calendar.getTime(), "yyyy年MM月"));
        System.out.println("zhangsongyang".substring(0, 3));


    }


    @Test
    public void marry29() {
        String json = "{\n" +
                "  \"question\": [\n" +
                "    {\n" +
                "      \"qid\": \"1\",\n" +
                "      \"answer\": [\n" +
                "        \"C\",\n" +
                "        \"B\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"qid\": \"2\",\n" +
                "      \"answer\": [\n" +
                "        \"A\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"qid\": \"3\",\n" +
                "      \"answer\": [\n" +
                "        \"C\"\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"accountId\": 153174827,\n" +
                "  \"userType\": 1,\n" +
                "  \"area\": \"cs\",\n" +
                "  \"userId\": 104702807\n" +
                "}";
        JSONObject jsonObject = JSON.parseObject(json);
        System.out.println(jsonObject.toString());
        JSONArray jsonArray = (JSONArray) jsonObject.get("question");
        for (int i = 0; i < jsonArray.size(); i++) {
            System.out.println(jsonArray.getJSONObject(i).get("qid"));
            JSONArray jsonArray1 = (JSONArray) jsonArray.getJSONObject(i).get("answer");
            String[] str = new String[jsonArray1.size()];
            for (int j = 0; j < jsonArray1.size(); j++) {
                str[j] = (String) jsonArray1.get(j);
            }
            Arrays.sort(str);
            StringBuilder stb = new StringBuilder();
            for(String s : str){
                stb.append(s);
            }
            System.out.println(stb.toString());
        }
    }


}
