/**
 * 题目描述:请实现一个函数用来找出字符流中第一个只出现一次的字符
 * 利用数组来构造hash结构，达到O(1)来查找次数
 */
public class FirstAppearingOnce55 {
    //假设是Ascii 256 个字符
    private int[] indexArray = new int[256];
    private StringBuilder sb = new StringBuilder();
    
    //Insert one char from stringstream
    public void Insert(char ch){
        sb.append(ch);
        indexArray[ch] += 1;
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        String s = sb.toString();
        for (int i = 0; i < sb.length(); i++) {
            if (indexArray[s.charAt(i)] == 1) {
                return s.charAt(i);
            }
        }
        return '#';
    }
}