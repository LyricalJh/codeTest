package chap01_GreedyAlgorithm;
import java.util.*;
/**
 * 작성자: [소중한]
 * 작성일: [2024-12-19]
 * 문제 유형: [Union Find]
 * O표기법: [O(m * a(n))]
 * 문제 이름: [인프런: Union Find]
 */
public class Greedy04 {

    static int[] parent;

    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return false;
        // union 할때 대원칙 부모노드의 위치를 넣어줘야한다.
        if (x < y) parent[y] = x;
        else parent[x] = y;
        return true;
    }

    public static int find(int x) {
        // 부모노드가 들어오면 그대로 반환
        if (parent[x] == x) return x;
        // 그것이 아니라면 자기보다 상위 노드 반환 즉 값을 반환
        return find(parent[x]);
    }

    public static void printParent() {
        System.out.print("[ ");
        for (int i = 1; i < parent.length; i++) {
            System.out.print(parent[i]+ " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n + 1];

        // 부모노드 초기화
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            union(sc.nextInt(), sc.nextInt());
        }

        int findX = find(sc.nextInt());
        int findY = find(sc.nextInt());
        System.out.println(findX == findY ? "YES" : "NO");
    }
}
