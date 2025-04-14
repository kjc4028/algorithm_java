package algorithm_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * 
입력
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
출력
3
7
8
9
 */
public class BOJ2667 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int count;
    static List<Integer> complexSizes = new ArrayList<>();

    // 상하좌우 이동 좌표
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine(); // 줄바꿈 처리

        map = new int[N][N];
        visited = new boolean[N][N];

        // 지도 입력
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        // 전체 순회
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    dfs(i, j);
                    complexSizes.add(count);
                }
            }
        }

        // 결과 출력
        System.out.println(complexSizes.size());
        Collections.sort(complexSizes);
        for (int size : complexSizes) {
            System.out.println(size);
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 확인
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
