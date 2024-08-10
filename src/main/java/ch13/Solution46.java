package ch13;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution46 {

    public static void main(String[] args) {
        int [][] maps = new int [][] {new int [] {1,0,1,1,1}, new int []{1,0,1,0,1}, new int[] {1,0,1,1,1}, new int []{1,1,1,0,1}, new int[]{0,0,0,0,1}};
//        int solution = solution(maps);
//        System.out.println(solution);
        int result = solution2(maps);
        System.out.println(result);
    }

    // 시간 초과
    public static int solution(int[][] maps) {
        int n = maps.length; // 행
        int m = maps[0].length; // 열

        int [][] path = new int[][] {new int[] {0,1}, new int[] {0,-1}, new int[]{1,0}, new int[]{-1,0}};

        // x, y까지 최단 거리 저장할 dist
        int[][] dist = new int[n][m];
        dist[0][0] = 1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            // 방문처리
            maps[x][y] = 0;

            // 가능한 경로 모두 탐색
            for (int [] p : path) {
                int a = x + p[0];
                int b = y + p[1];

                if (a < n && a >= 0 && b < m && b >= 0 && maps[a][b] == 1) { // 좌표가 범위 내에 있고, 벽이 아니면
                    // q에 삽입
                    q.add(new int[] {a, b});
                    if (dist[a][b] == 0) {
                        dist[a][b] = dist[x][y] + 1;
                    } else {
                        dist[a][b] = Math.min(dist[a][b], dist[x][y] + 1);
                    }
                }
            }
        }
        return dist[n-1][m-1] == 0 ? -1 : dist[n-1][m-1];
    }

    // 시간 초과
    public static int solution2(int[][] maps) {
        int n = maps.length; // 행
        int m = maps[0].length; // 열

        int [][] path = new int[][] {new int[] {0,1}, new int[] {0,-1}, new int[]{1,0}, new int[]{-1,0}};

        // x, y까지 최단 거리 저장할 dist
        int[][] dist = new int[n][m];
        dist[0][0] = 1;

        // x, y, (x,y)까지 거리
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(q -> q[2]));// priorityQueue로 x, y 까지 최단 경로를 먼저 pop
        pq.add(new int[]{0,0,1});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            // 가능한 경로 모두 탐색 -> n, m에 도착하면 return
            for (int [] p : path) {
                int a = x + p[0];
                int b = y + p[1];

                if (a < n && a >= 0 && b < m && b >= 0 && maps[a][b] == 1) { // 좌표가 범위 내에 있고, 벽이 아니면
                    // q에 삽입
                    int next_distance = dist[a][b] == 0 ? distance + 1 : Math.min(distance + 1, dist[a][b]);
                    dist[a][b] = next_distance;
                    pq.add(new int[] {a, b, next_distance});
                    // 방문 처리
                    maps[a][b] = 0;
                }
            }
        }
        return dist[n-1][m-1] == 0 ? -1 : dist[n-1][m-1];
    }
}
