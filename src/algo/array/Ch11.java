package algo.array;

import java.util.*;
import java.util.stream.Collectors;

public class Ch11 {

    /**
     * 임시반장 정하기
     * 그는 자기반 학생 중에서 1학년부터 5학년까지 지내오면서 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장
     * x축 = 학년,
     * y축 = 학생
     * 중복일 경우, 그 중 가장 작은 번호만 당선
     *
     * @param args
     */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int[][] list = new int[input+1][6];

        for (int i = 1; i <= input; i++) {
            for (int j = 1; j <= 5; j++) {
                int num = Integer.parseInt(sc.next());
                list[i][j] = num;

            }
        }
        solution(input, list);
    }

    private static void solution(int input, int[][] list) {


        int answer = 0, max = Integer.MIN_VALUE;
        for (int i = 1; i <= input; i++) {
            int cnt = 0;
            for (int j = 1; j <= input; j++) {
                for (int k = 1; k <= 5; k++) {
                    if (list[i][k] == list[j][k]){
                        cnt ++;
                        break;
                    }
                }
            }

            if (cnt>max){
                max=cnt;
                answer = i;
            }
        }

        System.out.println(answer);

    }


    private static void diffrentTry() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();


        List[][] classRoom = new List[5][9];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                classRoom[i][j] = new ArrayList<Integer>();
            }
        }

        int[][] arr = new int[input][5];
        for (int i = 0; i < input; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
                classRoom[j][arr[i][j] - 1].add(i);
            }
        }



        int classMan = 0, MaxValue = 0;
        HashSet<Integer> studentSet = new HashSet<>();
        List tempStudentList = new ArrayList<Integer>();

        for (int i = 0; i < input; i++) {
            for (int j = 0; j < 5; j++) {
                tempStudentList.addAll(classRoom[j][arr[i][j] - 1]);
            }
            studentSet.addAll(tempStudentList);

            if (MaxValue < studentSet.size()) {
                classMan = i;
                MaxValue = studentSet.size();
            }

            studentSet.clear();
            tempStudentList.clear();
        }

        System.out.println(classMan + 1);
    }

}
