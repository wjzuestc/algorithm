import java.util.*;
/**
 * 递归实现   
 * 1. 将i位置的值将i-(len-1)的值替换
 * 2. 然后再将后边的按照上一步，递归进行实现
 */
public class PermutationString28 {
    ArrayList<String> list = new ArrayList<String>();
    //按照字典序存储
    Set<String> set = new TreeSet<>();
    
    public ArrayList<String> Permutation(String str) {
       if (str == null || str.length() <= 0) {
           return list;
       }
       char[] strChar = str.toCharArray();
       int len = strChar.length;
       permutationString(strChar,len, 0);
       for(String s : set) {
           list.add(s);
       }
       return list;
    }
    
    public void permutationString(char[] strChar, int len, int index) {
        if (index >= len) {
            set.add(new String(strChar));
            return;
        }
        // 注意要从i开始替换，这样就可以将初始字符串加入
        for (int i = index; i < len; i++) {
            char temp = strChar[i];
            strChar[i] = strChar[index];
            strChar[index] = temp;
            permutationString(strChar, len, index + 1);
            //注意需要恢复到原状态  进行下一次调换
            temp = strChar[i];
            strChar[i] = strChar[index];
            strChar[index] = temp;
        }
        return;
    }
}