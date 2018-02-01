/* 本来以为可以这样，但是这种方法根本原因在于可能走不通，就是机器人在原点 0 0开始走，可能走不通到某一个<threshold的位置
          所以才要递归回溯求解啊
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (getBitSum(i, j) <= threshold) {
                    count++;
                }
            }
        }
        return count;*/
/*
 * 题目描述:地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
   每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 
   
 * 路径问题的经典解法  递归回溯
 */ 
public class MovingCountOfRobot67 {
    
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];
		return findNumber(threshold, rows, cols, 0, 0, visited);
    }
    
     public int findNumber(int threshold, int rows, int cols, int rowNum, int colNum, boolean[][] visited) {
         int bitSum = getBitSum(rowNum, colNum);
         int count = 0;
         if (checkBound(threshold, rows, cols, rowNum, colNum, visited, bitSum)) {
             visited[rowNum][colNum] = true;
             count = 1 + findNumber(threshold, rows, cols, rowNum - 1, colNum, visited)
                       + findNumber(threshold, rows, cols, rowNum + 1, colNum, visited)
                       + findNumber(threshold, rows, cols, rowNum, colNum - 1, visited)
                       + findNumber(threshold, rows, cols, rowNum, colNum + 1, visited);
         }
         return count;
     }
    
     // 检查边界
      public boolean checkBound(int threshold, int rows, int cols, int rowNum, int colNum, boolean[][] visited, int bitSum) {
          if (rowNum >= 0 && rowNum < rows && colNum >= 0 && colNum < cols 
              && bitSum <= threshold && !visited[rowNum][colNum]) {
              return true;
          }
          return false;
      }
         
    // 获得坐标位和
     public int getBitSum(int rowNum, int colNum) {
         int num = 0;
         while(rowNum != 0) {
             num += (rowNum % 10);
             rowNum /= 10;
         }
         while(colNum != 0) {
             num += (colNum % 10);
             colNum /= 10;
         }
         return num;
     }
}