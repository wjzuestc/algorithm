/**
 * ��Ŀ����:�����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����
 * �ݹ����
 */
public class HasPathInMatrix66 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows <= 0 || cols <= 0 || str == null || str.length <= 0) {
            return false;
        }
        boolean[][] visited = new boolean[rows][cols];
        // �������󶼽��б���Ѱ��
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // �����i j Ϊ��㣬�ҵ���һ��·�����򷵻�true
                if (findPath(matrix, rows, cols, i, j, str, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
     public boolean findPath (char[] matrix, int rows, int cols, int rowNum, int colNum, char[] str, int index, boolean[][] visited) {
         // ע��߽��ж�  ��index == str.length  ˵�����һ���ַ�Ҳ�ȽϹ���
         if (index == str.length) {
             return true;
         }
         // �߽��ж�
         if (checkBound(matrix, rows, cols, rowNum, colNum, str, index, visited)) {
             visited[rowNum][colNum] = true;
             boolean find =  findPath(matrix, rows, cols, rowNum + 1, colNum, str, index + 1, visited) 
                 || findPath(matrix, rows, cols, rowNum - 1, colNum, str, index + 1, visited)
                 || findPath(matrix, rows, cols, rowNum, colNum + 1, str, index + 1, visited)
                 || findPath(matrix, rows, cols, rowNum, colNum - 1, str, index + 1, visited);
             if (!find) {
                 // �������·��û�ҵ���Ҫ�ǵû���״̬
                 visited[rowNum][colNum] = false;
                 return false;
             }
             return true;
         }
         return false;
     }

    /**
     * �߽��ж�  ע��matrix��һά����
     */
    public boolean checkBound(char[] matrix, int rows, int cols, int rowNum, int colNum, char[] str, int index, boolean[][] visited) {
        if (rowNum >= 0 && rowNum < rows && colNum >= 0 && colNum < cols 
            && str[index] == matrix[rowNum * cols + colNum] && !visited[rowNum][colNum]) {
            return true;
        }
        return false;
    }

}











