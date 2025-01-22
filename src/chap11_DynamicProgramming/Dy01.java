package chap11_DynamicProgramming;
import java.util.*;
/**
 * 작성자: [소중한]
 * 작성일: [2025-01-13]
 * 문제 유형: [BFS 활용]
 * O표기법: [	O(N * M)]
 * 문제 이름: [백준 유기농 배추]
 * url : https://www.acmicpc.net/problem/1012
 */
public class Dy01 {
    static int[] dy;
    static int n;

    public int dy (int n) {
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <=n; i++) {
            dy[i] = dy[i - 1] + dy[i - 2];
        }
        return dy[n];
    }
    public static void main(String[] args) {

        Dy01 T = new Dy01();
        Scanner stdin = new Scanner(System.in);

        n = stdin.nextInt();
        dy = new int[n + 1];
        System.out.println(T.dy(7));

    }
}
