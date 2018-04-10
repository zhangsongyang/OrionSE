package cn.zsy.eg.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FastjsonTest {

    public static void main(String[] args) {
        String test = "{\n" +
                "  \"MUSIC8014BCS6\": {\n" +
                "    \"1.0.1.1003\": {\n" +
                "      \"kDefX64Url_1\": \"http://wa.kuwo.cn/lyrics/img/kwgg/bigdata/1.0.1.1003/KwShellExtDllx.dll\",\n" +
                "      \"kDefX64DllMd5_1\": \"f6177186ed8a1fc54d4a57ba22c81072\",\n" +
                "      \"kDefX86Url_1\": \"http://wa.kuwo.cn/lyrics/img/kwgg/bigdata/1.0.1.1003/KwShellExtDll.dll\",\n" +
                "      \"kDefX86DllMd5_1\": \"3a322282551cd1c043e6b879e84fd517\",\n" +
                "      \"kDefDllVersion_1\": \"1.0.1.1003\",\n" +
                "      \"kDefModelName\": \"CoreModule.dll\",\n" +
                "      \"kDefModelUrl_1\": \"http://wa.kuwo.cn/lyrics/img/kwgg/bigdata/1.0.1.1003/KwTaskService.dll\",\n" +
                "      \"kDefModelMd5_1\": \"8c601bce3182de4e643e353d3fdad154\",\n" +
                "      \"kDefModelVersion_1\": \"1.0.1.1003\"\n" +
                "    },\n" +
                "    \"1.0.1.1004\": {\n" +
                "      \"kDefX64Url_1\": \"http://wa.kuwo.cn/lyrics/img/kwgg/bigdata/1.0.1.1003/KwShellExtDllx.dll\",\n" +
                "      \"kDefX64DllMd5_1\": \"f6177186ed8a1fc54d4a57ba22c81072\",\n" +
                "      \"kDefX86Url_1\": \"http://wa.kuwo.cn/lyrics/img/kwgg/bigdata/1.0.1.1003/KwShellExtDll.dll\",\n" +
                "      \"kDefX86DllMd5_1\": \"3a322282551cd1c043e6b879e84fd517\",\n" +
                "      \"kDefDllVersion_1\": \"1.0.1.1003\",\n" +
                "      \"kDefModelName\": \"CoreModule.dll\",\n" +
                "      \"kDefModelUrl_1\": \"http://wa.kuwo.cn/lyrics/img/kwgg/bigdata/1.0.1.1003/KwTaskService.dll\",\n" +
                "      \"kDefModelMd5_1\": \"8c601bce3182de4e643e353d3fdad154\",\n" +
                "      \"kDefModelVersion_1\": \"1.0.1.1003\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"MUSIC8014BCS7\": {\n" +
                "    \"1.0.1.1005\": {\n" +
                "      \"kDefX64Url_1\": \"http://wa.kuwo.cn/lyrics/img/kwgg/bigdata/1.0.1.1003/KwShellExtDllx.dll\",\n" +
                "      \"kDefX64DllMd5_1\": \"f6177186ed8a1fc54d4a57ba22c81072\",\n" +
                "      \"kDefX86Url_1\": \"http://wa.kuwo.cn/lyrics/img/kwgg/bigdata/1.0.1.1003/KwShellExtDll.dll\",\n" +
                "      \"kDefX86DllMd5_1\": \"3a322282551cd1c043e6b879e84fd517\",\n" +
                "      \"kDefDllVersion_1\": \"1.0.1.1003\",\n" +
                "      \"kDefModelName\": \"CoreModule.dll\",\n" +
                "      \"kDefModelUrl_1\": \"http://wa.kuwo.cn/lyrics/img/kwgg/bigdata/1.0.1.1003/KwTaskService.dll\",\n" +
                "      \"kDefModelMd5_1\": \"8c601bce3182de4e643e353d3fdad154\",\n" +
                "      \"kDefModelVersion_1\": \"1.0.1.1003\"\n" +
                "    },\n" +
                "    \"1.0.1.1006\": {\n" +
                "      \"kDefX64Url_1\": \"http://wa.kuwo.cn/lyrics/img/kwgg/bigdata/1.0.1.1003/KwShellExtDllx.dll\",\n" +
                "      \"kDefX64DllMd5_1\": \"f6177186ed8a1fc54d4a57ba22c81072\",\n" +
                "      \"kDefX86Url_1\": \"http://wa.kuwo.cn/lyrics/img/kwgg/bigdata/1.0.1.1003/KwShellExtDll.dll\",\n" +
                "      \"kDefX86DllMd5_1\": \"3a322282551cd1c043e6b879e84fd517\",\n" +
                "      \"kDefDllVersion_1\": \"1.0.1.1003\",\n" +
                "      \"kDefModelName\": \"CoreModule.dll\",\n" +
                "      \"kDefModelUrl_1\": \"http://wa.kuwo.cn/lyrics/img/kwgg/bigdata/1.0.1.1003/KwTaskService.dll\",\n" +
                "      \"kDefModelMd5_1\": \"8c601bce3182de4e643e353d3fdad154\",\n" +
                "      \"kDefModelVersion_1\": \"1.0.1.1003\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
        JSONObject jsonObject = JSON.parseObject(test);
        System.out.println(jsonObject.keySet().toString());
//        System.out.println(jsonObject.getJSONObject("MUSIC8014BCS6").getJSONObject("1.0.1.1003").getString("kDefModelUrl_1"));
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("asdfsadf");
        jsonArray.add("asdfsadw");
        jsonArray.add("asdfsade");
        jsonArray.add("asdfsadr");
        jsonArray.add("asdfsadtt");
        System.out.println(jsonArray.toString());
        System.out.println(jsonArray.getString(2));
        String[] ss1 = jsonArray.toArray(new String[0]);
        System.out.println("##############" + ss1[2]);
        Map<String, String[]> params = new HashMap<String, String[]>();
        String[] ss = {"11", "22", "33"};
        params.put("aa", ss);
        System.out.println(JSON.toJSONString(params)); //将一个map转化为jsonString
    }

}
