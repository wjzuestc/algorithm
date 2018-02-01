/* ������Ϊ�����������������ַ�������ԭ�����ڿ����߲�ͨ�����ǻ�������ԭ�� 0 0��ʼ�ߣ������߲�ͨ��ĳһ��<threshold��λ��
          ���Բ�Ҫ�ݹ������Ⱑ
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
 * ��Ŀ����:������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���
   ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ�񣬵��ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ� 
   
 * ·������ľ���ⷨ  �ݹ����
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
    
     // ���߽�
      public boolean checkBound(int threshold, int rows, int cols, int rowNum, int colNum, boolean[][] visited, int bitSum) {
          if (rowNum >= 0 && rowNum < rows && colNum >= 0 && colNum < cols 
              && bitSum <= threshold && !visited[rowNum][colNum]) {
              return true;
          }
          return false;
      }
         
    // �������λ��
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