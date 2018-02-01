import java.util.*;
/**
 * 题目描述:输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。

 * 通过自定义排序规则：将数组从小到大按自定义排序规则排序。排完序从小到大组合即可。
   1. 排序规则：A < B  规则是：AB < BA
   2. 大数问题，所以要用字符串模拟
 */
public class PrintMinNumber33 {
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return "";
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            Integer num = numbers[i];
            list.add(num.toString());
        }
        //利用collections类的排序方法，自定义比较器定义排序规则。默认从小到大
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String temp1 = s1 + s2;
                String temp2 = s2 + s1;
                return temp1.compareTo(temp2);
            }
        });
        // 将从小到大排序的数组进行拼接返回即可
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }
}