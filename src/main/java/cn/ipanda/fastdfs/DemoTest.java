package cn.ipanda.fastdfs;
import org.csource.common.MyException;
import org.csource.fastdfs.*;
import java.io.IOException;
public class DemoTest {
    public static void main(String[] args) {
        try {
            ClientGlobal.init("C:\\resource-maven\\NEW_SVN\\fastfds\\src\\main\\resources\\fdfs_cleant.conf");//1、加载配置文件，配置文件中的内容就是 tracker 服务的地址。
            TrackerClient trackerClient = new TrackerClient();                                                              //2、创建一个 TrackerClient 对象。直接 new 一个。
            TrackerServer trackerServer = trackerClient.getConnection();                                                    //3、使用 TrackerClient 对象创建连接，获得一个 TrackerServer 对象。
            StorageServer storageServer = null;                                                                             //4、创建一个 StorageServer 的引用，值为 null
            StorageClient storageClient = new StorageClient(trackerServer, storageServer);                                  //5、创建一个 StorageClient 对象，需要两个参数 TrackerServer 对象、StorageServer 的引用
            String[] strings = storageClient.upload_file("C:\\Users\\Administrator\\Desktop\\fastdfsjpa\\panda.png", "jpg",
                    null);                                                                                         //6、使用 StorageClient 对象上传图片。扩展名不带“.”
            for (String string : strings) {                                                                                  //7、返回数组。包含组名和图片的路径。
                System.out.println(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
