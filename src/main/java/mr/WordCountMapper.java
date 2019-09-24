package mr;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * 只能用大数据类型
 * LongWritable -> int
 * Text -> String
 * keyin:偏移量offset  valuein:字符串
 * keyout：字符串   valueout：出现的次数1
 *
 */
public class WordCountMapper extends Mapper<LongWritable, Text,Text,LongWritable> {

    @Override
    protected void map(LongWritable k1, Text v1, Context context) throws IOException, InterruptedException {
        /**
         *
         * key:输入的key
         * value:数据 I love Beijing
         * context：map上下文
         */
        String data = v1.toString();
        //分词
        String[] words = data.split(" ");
        //输出每个单词
        for(String w:words) {
            context.write(new Text(w),new LongWritable(1));
        }

    }
}
