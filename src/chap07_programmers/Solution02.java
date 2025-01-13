package chap07_programmers;
import java.util.*;
/**
 * 작성자: [소중한]
 * 작성일: [2025-01-09]
 * 문제 유형: [DFS 활용]
 * O표기법: [	O(N * M)]
 * 문제 이름: [리코쳇 로봇]
 * 후기 이동할때 한 방향으로 쭉 움직이는 로직을 생각못했다.
 * 하나의 방향이 주어지면 while 문으로 해당 방향으로 장애물, 경계선 만나면 break 걸기 그리고 멈춘 자리가 이미 왔던 자리면 그방향으로 이동하지 않음.
 */

class Solution {
    static class Position {
        int x, y, moves;

        public Position(int x, int y, int moves) {
            this.x = x;
            this.y = y;
            this.moves = moves;
        }
    }

    public int solution(String[] board) {
        int rows = board.length;
        int cols = board[0].length();

        int[][] map = new int[rows][cols];
        Position start = null;
        Position goal = null;

        // 맵 초기화
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char cell = board[i].charAt(j);
                if (cell == 'D') map[i][j] = 1;  // 장애물
                else if (cell == 'R') start = new Position(i, j, 0);  // 시작점
                else if (cell == 'G') goal = new Position(i, j, 0);  // 목표점
            }
        }

        // BFS를 위한 큐와 방문 배열
        Queue<Position> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        queue.offer(start);
        if (start != null) visited[start.x][start.y] = true;

        // 이동 방향 (상, 우, 하, 좌)
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            // 목표 지점에 도달하면 이동 횟수 반환
            if (current.x == goal.x && current.y == goal.y) {
                return current.moves;
            }

            // 4가지 방향으로 이동
            for (int dir = 0; dir < 4; dir++) {
                int nx = current.x;
                int ny = current.y;

                // 해당 방향으로 계속 이동
                while (true) {
                    int nextX = nx + dx[dir];
                    int nextY = ny + dy[dir];

                    // 경계 체크 및 장애물 확인
                    if (nextX < 0 || nextX >= rows || nextY < 0 || nextY >= cols || map[nextX][nextY] == 1) {
                        break;
                    }

                    nx = nextX;
                    ny = nextY;
                }

                // 멈춘 위치가 이미 방문한 곳이면 건너뜀
                if (visited[nx][ny]) continue;

                // 새로운 위치를 큐에 추가하고 방문 처리
                queue.offer(new Position(nx, ny, current.moves + 1));
                visited[nx][ny] = true;
            }
        }

        // 목표 지점에 도달할 수 없는 경우
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] board1 = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        System.out.println(solution.solution(board1)); // Output: 7

        String[] board2 = {".D.R", "....", ".G..", "...D"};
        System.out.println(solution.solution(board2)); // Output: -1
    }
}