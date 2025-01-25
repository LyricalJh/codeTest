package chap10_ImplAlgorithm;
import java.util.*;

public class Impl02 {
    static int k, answer = 0;

    public boolean checkGroup (String input) {
        String[] inputs = input.split("");
        List<String> checkList = new ArrayList<>();

        for (int i = 0; i < inputs.length; i++) {
            if (checkList.contains(inputs[i])) {
                String tmp = checkList.get(i - 1);
                if (!tmp.equals(inputs[i])) return false;
            }
            checkList.add(inputs[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Impl02 T = new Impl02();
        Scanner stdin = new Scanner(System.in);

        k = stdin.nextInt();

        for (int i = 0; i < k; i++) {
            if (T.checkGroup(stdin.next())) answer++;
        }
        System.out.println(answer);
    }
}
