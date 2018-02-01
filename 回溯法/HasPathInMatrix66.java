/**
 * 题目描述:请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 递归回溯
 */
public class HasPathInMatrix66 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows <= 0 || cols <= 0 || str == null || str.length <= 0) {
            return false;
        }
        boolean[][] visited = new boolean[rows][cols];
        // 整个矩阵都进行遍历寻找
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 如果以i j 为起点，找到了一个路径，则返回true
                if (findPath(matrix, rows, cols, i, j, str, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
     public boolean findPath (char[] matrix, int rows, int cols, int rowNum, int colNum, char[] str, int index, boolean[][] visited) {
         // 注意边界判断  是index == str.length  说明最后一个字符也比较过了
         if (index == str.length) {
             return true;
         }
         // 边界判断
         if (checkBound(matrix, rows, cols, rowNum, colNum, str, index, visited)) {
             visited[rowNum][colNum] = true;
             boolean find =  findPath(matrix, rows, cols, rowNum + 1, colNum, str, index + 1, visited) 
                 || findPath(matrix, rows, cols, rowNum - 1, colNum, str, index + 1, visited)
                 || findPath(matrix, rows, cols, rowNum, colNum + 1, str, index + 1, visited)
                 || findPath(matrix, rows, cols, rowNum, colNum - 1, str, index + 1, visited);
             if (!find) {
                 // 如果这条路径没找到，要记得回退状态
                 visited[rowNum][colNum] = false;
                 return false;
             }
             return true;
         }
         return false;
     }

    /**
     * 边界判断  注意matrix是一维数组
     */
    public boolean checkBound(char[] matrix, int rows, int cols, int rowNum, int colNum, char[] str, int index, boolean[][] visited) {
        if (rowNum >= 0 && rowNum < rows && colNum >= 0 && colNum < cols 
            && str[index] == matrix[rowNum * cols + colNum] && !visited[rowNum][colNum]) {
            return true;
        }
        return false;
    }

}











