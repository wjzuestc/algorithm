/**
 *��Ŀ����
	��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� ������ĳЩ�������ظ��ģ�
	����֪���м����������ظ��ġ�Ҳ��֪��ÿ�������ظ����Ρ�
	���ҳ�����������һ���ظ������֡� 
	���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��

 * ��򵥵�hash��O(n)ʱ�临�Ӷȣ�O(n)�ռ临�Ӷ�
 * ��ָoffer���ǿ���O(1) �ռ临�Ӷ�
 */
public class DuplicateNumber51 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    ����Ҫ�ر�ע��~���������ظ���һ������ֵduplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || length <= 1) {
            return false;
        }
        //����boolean hash��
        boolean[] hash = new boolean[length];
        // ɨ��һ�鼴��
        for (int i = 0; i < length; i++) {
            if (hash[numbers[i]]) {
                duplication[0] = numbers[i];
                return true;
            }
            hash[numbers[i]] = true;
        }
        return false;
    }
}