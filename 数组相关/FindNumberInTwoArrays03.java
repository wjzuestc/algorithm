/**
 * 题目描述: 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
   每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
   
 * 实现：1.很简单。两次遍历即可，但是没有利用数组的顺序特点
        2.从右上角开始找，提高从而利用数组特点，迅速找到数
 */
public class FindNumberInTwoArrays03 {
    public boolean Find(int target, int [][] array) {
        if (array == null || array.length <= 0 || array[0].length <= 0) {
            return false;
        }
        // 从右上角开始，可以一次判断排除一行或一列
        int rows = array.length;
        int cols = array[0].length;
        int rowNum = 0;
        int colNum = cols - 1;
        // 边界  rowNum >= rows  colNum < 0 超出则无效 返回false
        while (rowNum < rows && colNum >= 0) {
            if (array[rowNum][colNum] == target) {
                return true;
            } else if (array[rowNum][colNum] > target) {
                colNum--;
            } else {
                rowNum++;
            }
        }
        return false;
    }
}