package ch12;

import java.util.LinkedList;
import java.util.Queue;

public class Solution35 {

    public static void main(String[] args) {
//        int i = numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}});
//        System.out.println("result " + i);
        int result = numIslands(new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}});
        System.out.println("result " + result);
    }

    public static int numIslands(char[][] grid) {
        char island = '1';
        int [][] visited = new int[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 이미 방문했거나 섬이 아니면 pass
                if (visited[i][j] == 1 || grid[i][j] == '0') {
                    continue;
                }


                queue.offer(new int[]{i, j}); // 방문해야할 위치 추가
                visited[i][j] = 1; // 방문 처리

                while (!queue.isEmpty()) {
                    // 인접한 네 방향 모두 탐색
                    int[] current = queue.poll();
                    int row = current[0];
                    int col = current[1];

                    if (row-1 >= 0 && grid[row -1][col] == island && visited[row-1][col] == 0) {
                        visited[row-1][col] = 1;
                        queue.offer(new int[]{row-1, col});
                    }
                    if (col+1 < grid[0].length && grid[row][col+1] == island && visited[row][col+1] == 0) {
                        visited[row][col+1] = 1;
                        queue.offer(new int[]{row, col+1});
                    }
                    if (row+1 < grid.length && grid[row+1][col] == island && visited[row+1][col] == 0) {
                        visited[row+1][col] = 1;
                        queue.offer(new int[]{row+1, col});
                    }
                    if (col-1 >= 0 && grid[row][col-1] == island && visited[row][col-1] == 0) {
                        visited[row][col-1] = 1;
                        queue.offer(new int[] {row, col-1});
                    }
                }
                count++;
            }
        }
        return count;
    }
}
