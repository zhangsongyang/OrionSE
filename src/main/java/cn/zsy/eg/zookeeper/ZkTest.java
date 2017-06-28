package cn.zsy.eg.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

/**
 * Created by zhangsongyang on 6/28/2017.
 */
public class ZkTest {

    private ZooKeeper zk = null;

    /**
     * 创建ZK连接
     *
     * @param connectString
     * @param sessionTimeout
     */
    public void createConnection(String connectString, int sessionTimeout) {
        this.releaseConnection();
        try {
            zk = new ZooKeeper(connectString,
                    sessionTimeout, new Watcher() {
                // 监控所有被触发的事件
                public void process(WatchedEvent event) {
                    System.out.println("已经触发了" + event.getType() + "事件！");
                }
            });
        } catch (IOException e) {
            System.out.println("连接创建失败，发生 IOException");
            e.printStackTrace();
        }
    }

    /**
     * 关闭ZK连接
     */
    public void releaseConnection() {
        if (zk != null) {
            try {
                this.zk.close();
            } catch (InterruptedException e) {
                // ignore
                e.printStackTrace();
            }
        }
    }

    /**
     * 创建节点
     *
     * @param path 节点path
     * @param data 初始数据内容
     * @return
     */
    public boolean createPath(String path, String data) {
        try {
            String node = zk.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);//临时、永久...节点
            System.out.println("节点创建成功, Path: "
                    + node
                    + ", content: " + data);
        } catch (KeeperException e) {
            System.out.println("节点创建失败，发生KeeperException");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("节点创建失败，发生 InterruptedException");
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 读取指定节点数据内容
     *
     * @param path 节点path
     * @return
     */
    public String readData(String path) {
        try {
            String res = new String(zk.getData(path, false, null));
            System.out.println("获取数据成功：" + res);
            return res;
        } catch (KeeperException e) {
            System.out.println("读取数据失败，发生KeeperException，path: " + path);
            e.printStackTrace();
            return "";
        } catch (InterruptedException e) {
            System.out.println("读取数据失败，发生 InterruptedException，path: " + path);
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 更新指定节点数据内容
     *
     * @param path 节点path
     * @param data 数据内容
     * @return
     */
    public boolean writeData(String path, String data) {
        try {

            Stat stat = zk.setData(path, data.getBytes(), -1);//-1表示匹配所有版本
            System.out.println("更新数据成功，path：" + path + ", stat: " + stat);
        } catch (KeeperException e) {
            System.out.println("更新数据失败，发生KeeperException，path: " + path);
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("更新数据失败，发生 InterruptedException，path: " + path);
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除指定节点
     *
     * @param path 节点path
     */
    public void deleteNode(String path) {
        try {
            zk.delete(path, -1);
            System.out.println("删除节点成功，path：" + path);
        } catch (KeeperException e) {
            System.out.println("删除节点失败，发生KeeperException，path: " + path);
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("删除节点失败，发生 InterruptedException，path: " + path);
            e.printStackTrace();
        }
    }

    public List<String> getChildrens(String path) {
        try {
            return zk.getChildren(path, true);
        } catch (KeeperException e) {
            System.out.println("删除节点失败，发生KeeperException，path: " + path);
            e.printStackTrace();
            return null;
        } catch (InterruptedException e) {
            System.out.println("删除节点失败，发生 InterruptedException，path: " + path);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        ZkTest test = new ZkTest();
        test.createConnection("34.212.234.226:2181", 3000);

//        test.createPath("/node/", "node2");
        test.readData("/node");

        List<String> childrens = test.getChildrens("/node");
        for (String str : childrens) {
            System.out.println("--------->" + str);
        }

        test.releaseConnection();
    }

}
