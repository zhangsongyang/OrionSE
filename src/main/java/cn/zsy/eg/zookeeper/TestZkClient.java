package cn.zsy.eg.zookeeper;

import cn.zsy.eg.ApacheCommon.Student;
import com.alibaba.fastjson.JSONObject;
import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;

public class TestZkClient {

    public static void main(String[] args) throws InterruptedException {
        ZkClient zkClient = new ZkClient("34.208.9.85:2181", 3000, 3000, new MyZkSerializer());
        System.out.println("ZK 成功建立连接！");
//        zkClient.createPersistent("/Test/111/2222/3333", true);
        List<String> list = zkClient.getChildren("/"); //获取节点
        System.out.println(list.toString());
//        zkClient.deleteRecursive("/Test/111");  //替归删除节点
        Student student = new Student();
        student.setAge(28);
        student.setName("zhangsongyang");
        System.out.println(student.toString());
        zkClient.writeData("/Test", JSONObject.toJSONString(student));  //写数据到节点数据
        String str = zkClient.readData("/Test");  //读节点数据
        System.out.println("--->readData: " + str);
        if (zkClient.exists("/Test")) {
            System.out.println("node: " + zkClient.readData("/Test"));
        }


        String path = "/Test";
        // 注册子节点变更监听（此时path节点并不存在，但可以进行监听注册）
        zkClient.subscribeChildChanges(path, new IZkChildListener() {
            public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
                System.out.println("路径" + parentPath + "下面的子节点变更。子节点为：" + currentChilds);
            }
        });
        //注册子节点数据变更监听（此时path节点并不存在，但可以进行监听注册）
        zkClient.subscribeDataChanges(path, new IZkDataListener() {
            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {
                System.out.println("路径" + dataPath + "下面的数据变化" + (String) data);
            }

            @Override
            public void handleDataDeleted(String dataPath) throws Exception {
                System.out.println("handleDataDeleted路径" + dataPath);
            }
        });

        // 递归创建子节点（此时父节点并不存在）
//        zkClient.createPersistent("/Test/a111",true);
        Thread.sleep(50000000);
//        System.out.println(zkClient.getChildren(path));
    }

}
