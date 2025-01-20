package chap10_ImplAlgorithm;

import java.util.Scanner;

/**
 * 작성자: [소중한]
 * 작성일: [2025-01-16]
 * 문제 유형: [구현]
 * 문제 이름: [백준: 과제 안 내신 분..? ]
 * url : https://www.acmicpc.net/problem/5597
 */

public class Impl01 {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int[] checkList = new int[30 + 1];

        for (int i = 0; i < 28; i++) {
            int check = stdin.nextInt();
            checkList[check] = 1;
        }

        for (int i = 1; i < checkList.length; i++) {
            if (checkList[i] == 0) System.out.println(i);
        }



    }
}
