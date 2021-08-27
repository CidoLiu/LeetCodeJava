package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @id
 * @author dongjin
 * @date 2021/2/18 12:00
 */
public class Course210 {

    List<List<Integer>> edges;
    int[] visited;
    Stack<Integer> stack; // 可以用数组代替栈（固定大小），节省空间，省去最后又转为数组
    boolean valid = true;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        for (int[] info: prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        stack = new Stack<Integer>();
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (valid) {
            int[] order = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                order[i] = stack.pop();
//                System.out.println(order[i]);
            }
            return order;
        } else {
            return new int[0];
        }
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
        stack.push(u);
//        System.out.println(u);
    }

    public static void main(String[] args) {
        Course210 temple = new Course210();
        int numCourses = 2;
        int[][] prerequisites = {{1,0}}; // 学习课程 1 之前，你需要完成课程 0
        System.out.println(Arrays.toString(temple.findOrder(numCourses, prerequisites)));
        System.out.println();
    }
}
