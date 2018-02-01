/**
 * ��Ŀ����:��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ�
 * ��������������hash�ṹ���ﵽO(1)�����Ҵ���
 */
public class FirstAppearingOnce55 {
    //������Ascii 256 ���ַ�
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