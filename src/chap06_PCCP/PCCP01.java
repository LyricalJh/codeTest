package chap06_PCCP;

public class PCCP01 {

    // 우, 하, 좌, 상 탐색
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] land = {
            {0, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 1, 1, 0, 0},
            {1, 1, 0, 0, 0, 1, 1, 0},
            {1, 1, 1, 0, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0, 1, 1}
    };

    static int rows = land.length;
    static int cols = land[0].length;

    // DFS로 연결된 1의 개수 탐색
    public static int DFS(int x, int y, int[][] tempLand) {
        // 경계 조건 및 방문 확인
        if (x < 0 || y < 0 || x >= rows || y >= cols || tempLand[x][y] == 0) {
            return 0;
        }

        // 방문 처리
        tempLand[x][y] = 0;
        int count = 1; // 현재 위치 포함

        // 네 방향 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            count += DFS(nx, ny, tempLand);
        }

        return count;
    }

    public static void main(String[] args) {
        int maxOil = 0; // 가장 많은 석유를 얻을 수 있는 열의 석유 양
        int bestColumn = -1; // 가장 많은 석유를 얻을 수 있는 열의 번호

        // 각 열(column)을 기준으로 탐색
        for (int col = 0; col < cols; col++) {
            int oilCount = 0;

            // 복사본을 만들어서 탐색
            int[][] tempLand = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                System.arraycopy(land[i], 0, tempLand[i], 0, cols);
            }

            // 복원된 배열에서 열(column)을 순회
            for (int row = 0; row < rows; row++) {
                if (tempLand[row][col] == 1) {
                    oilCount += DFS(row, col, tempLand); // 연결된 1의 개수 추가
                }
            }

            // 가장 많은 석유를 얻는 열 갱신
            if (oilCount > maxOil) {
                maxOil = oilCount;
                bestColumn = col;
            }
        }
        System.out.println(maxOil);
    }
}