package chap07_programmers;
import java.util.*;
/**
 * 작성자: [소중한]
 * 작성일: [2025-01-09]
 * 문제 유형: [Stack 활용]
 * O표기법: [O(n)]
 * 문제 이름: [햄버거 만들기]
 */

public class Solution01 {
    public int solution(int[] ingredient) {
        Stack<Integer> recipe = new Stack<>();
        int answer = 0;
        for (int  food : ingredient) {
            recipe.push(food);

            if (recipe.size() >= 4) {
                int size = recipe.size();
                if (recipe.get(size - 4) == 1 && // 1
                    recipe.get(size - 3) == 2 && // 2
                    recipe.get(size - 2) == 3 && // 3
                    recipe.get(size - 1) == 1) { // 4
                    recipe.pop();
                    recipe.pop();
                    recipe.pop();
                    recipe.pop();
                    answer++;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution01 solution = new Solution01();
        int []ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        int result = solution.solution(ingredient);
        System.out.println("만들 수 있는 총 햄버거 갯수는 : " + result);

    }
}
