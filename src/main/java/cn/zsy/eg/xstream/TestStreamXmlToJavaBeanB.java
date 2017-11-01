package cn.zsy.eg.xstream;

import cn.zsy.eg.xstream.bean.Metadata;


//  http://www.cnblogs.com/happyPawpaw/p/4972650.html
//Xstream注解常用知识：
//@XStreamAlias("message") 别名注解
//    作用目标: 类,字段
//@XStreamImplicit 隐式集合
//@XStreamImplicit(itemFieldName="part")
//作用目标: 集合字段
//@XStreamConverter(SingleValueCalendarConverter.class) 注入转换器
//    作用目标: 对象
//@XStreamAsAttribute 转换成属性
//    作用目标: 字段
//@XStreamOmitField 忽略字段
//    作用目标: 字段


public class TestStreamXmlToJavaBeanB {

    public static void main(String[] args) {
        String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<metadata>\n" +
            "  <groupId>com.haier.uhome.uplus</groupId>\n" +
            "  <artifactId>cms</artifactId>\n" +
            "  <versioning>\n" +
            "    <versions>\n" +
            "      <version>1.0.0-SNAPSHOT</version>\n" +
            "      <version>1.1.0-chengtao-SNAPSHOT</version>\n" +
            "      <version>1.1.0-SNAPSHOT</version>\n" +
            "      <version>1.1.0-chengtao-sc-SNAPSHOT</version>\n" +
            "    </versions>\n" +
            "    <lastUpdated>20171030062207</lastUpdated>\n" +
            "  </versioning>\n" +
            "</metadata>\n";
//用泛型的知识
        Metadata readObject = XmlUtil.toBean(xmlStr, Metadata.class);


//        XStream xStream = new XStream();
//        Metadata syncAppOrderReq = new Metadata();
//        xStream.autodetectAnnotations(true);
//        String javaToXML = xStream.toXML(syncAppOrderReq);   //这个在从xml到java Bean时候不能少，少了就会报异常，尽管这个方法作用是javaBean到xml, 这里我推测这个方便有将xml和bean映射作用
//        System.out.println(javaToXML);
//        System.out.println("---------");
//        xStream.setClassLoader(Metadata.class.getClassLoader());
//        Metadata readObject = (Metadata) xStream.fromXML(xmlStr);
//        System.out.println("Object loaded by xstream:\n " + readObject);
//        System.out.println("--------------------------------------------------");





        System.out.println(readObject.getGroupId());
        System.out.println(readObject.getVersioning().getLastUpdated());
        System.out.println(readObject.getVersioning().getVersions().getVersion().get(0));

    }
}
