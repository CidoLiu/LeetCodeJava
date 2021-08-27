package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @id 207
 * @author dongjin
 * @date 2021/2/1 18:27
 */
public class Course207 {

    List<List<Integer>> edges;
    int[] visited; // 0 未搜索，1 搜索中，2 已完成
    boolean valid = true; // 标记结果

    /**
     * 思路：构造一个图，若图中存在环，则不可以完成
     * 拓扑排序，DFS
     * @param numCourses 课程数量
     * @param prerequisites 课程的先修关系
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];

        for (int[] info: prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        System.out.println(edges);
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int v: edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }

    public static void main(String[] args) {
        Course207 temple = new Course207();
        int numCourses = 2;
        int[][] prerequisites = {{1,0}}; // 学习课程 1 之前，你需要完成课程 0
        temple.canFinish(numCourses, prerequisites);
        System.out.println();
    }
}
