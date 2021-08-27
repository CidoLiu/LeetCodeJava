package solution;

/**
 * @author dongjin
 * @id 200
 * @date 2021/2/1 16:56
 */
public class numIslands200 {

    /**
     * 暴力解法，遍历每一个岛屿，看是否与其他岛屿连通。错了❌
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int islandsCounter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !isJoin(grid, i, j)) {
//                    System.out.println(i + "" + j);
                    islandsCounter++;
                }
            }
        }
        return islandsCounter;
    }

    /**
     * 考虑是否与已有的岛屿连通，错误🙅‍，不仅需要考虑左和上，要考虑四周！太暴力了，并且边界条件太多，容易出错。
     * @param grid
     * @param i
     * @param j
     * @return
     */
    public boolean isJoin(char[][] grid, int i, int j) {
        if (i==0 && j==0) {
            return false;
        }
        if (i==0) {
            if (grid[i][j - 1] == '0'){
                return false;
            } else {
                return true;
            }
        }
        if (j==0) {
            if (grid[i - 1][j] == '0') {
                return false;
            } else {
                return true;
            }
        }
        if (grid[i - 1][j] == '0' && grid[i][j - 1] == '0') {
            return false;
        }
        return true;
    }

    /**
     * 深度优先搜索，将搜索到的联通节点'1'置为'0'，岛屿数量为1出现的次数，即深度优先搜索的次数
     * 时间复杂度：O(mn)
     * 空间复杂度：O(mn)
     * @param grid
     * @return
     */
    public int numIslandsDFS(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int islandsCounter = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    islandsCounter++;
                    dfs(grid, i, j);
                }
            }
        }
        return islandsCounter;
    }

    /**
     * 深度优先搜索
     * @param grid
     * @param i
     * @param j
     */
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        dfs(grid,i-1, j);
        dfs(grid,i, j+1);
        dfs(grid,i+1, j);
        dfs(grid,i, j-1);
    }

    public static void main(String[] args) {
        numIslands200 temple = new numIslands200();
        System.out.println(temple.numIslandsDFS(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
    }
}
