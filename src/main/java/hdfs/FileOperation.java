package hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class FileOperation {

    public static void main(String[] args) throws Exception {
        //使用HDFS的API创建目录
        //设置NameNode地址
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://172.22.128.81:9000");

        //得到hdfs的文件系统
        FileSystem fileSystem = FileSystem.get(conf);
//        fileSystem.mkdirs(new Path("/testFolder"));
        fileSystem.delete(new Path("/home"),true);
    }
}
