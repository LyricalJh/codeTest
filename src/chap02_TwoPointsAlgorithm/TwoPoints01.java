package chap02_TwoPointsAlgorithm;
import java.util.*;
import java.util.Scanner;

/**
 * 작성자: [소중한]
 * 작성일: [2024-12-19]
 * 문제 유형: [TwoPoint 알고리즘]
 * O표기법: [O(N)]
 * 문제 이름: [공통원소 구하기]
 */
public class TwoPoints01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        Arrays.sort(arr1);
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }
        Arrays.sort(arr2);
        List<Integer> answer = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;

        while (p1 < arr1.length && p2 < arr2.length) {
            if (arr1[p1] == arr2[p2]) {
                answer.add(arr1[p1]);
                p1++;
                p2++;
            } else if (arr1[p1] > arr2[p2]) {
                p2++;
            } else {
                p1++;
            }

        }
        for (int value : answer) {
            System.out.print(value + " " );
        }

    }
}
