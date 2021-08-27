package solution;

public class Number547 {

    /*********************DFS***********************************/
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int len = isConnected.length;
        int[] isVisit = new int[len];
        for (int i = 0; i < len; i++) {
            if (isVisit[i] == 0) {
                dfs(isConnected, isVisit, i);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] isConnected,int[] isVisit, int i) {
        int len = isConnected.length;
        for (int j = 0; j < len; j++) {
            if (isConnected[i][j] == 1 && isVisit[j] == 0) {
                isVisit[j] = 1;
                dfs(isConnected, isVisit, j);
            }
        }
    }

    /**************************并查集*****************************/

    int[] map;

    public void merge(int x, int y) {
        map[find(x)] = find(y);
    }

    public int find(int x) {
        if (map[x] == x) {
            return x;
        } else {
            map[x] = find(map[x]);
            return map[x];
        }
    }

    public int findCircleNumUnit(int[][] isConnected) {
        int len = isConnected.length;
        map = new int[len];
        for (int i = 0; i < len; i++) {
            map[i] = i;
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (isConnected[i][j] == 1) {
                    merge(i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (find(i) == i) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Number547 test = new Number547();
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(test.findCircleNumUnit(isConnected));
    }
}
