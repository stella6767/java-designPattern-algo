package algo.array;

public class Cmmon {

    public static void print2DArray(int[][] list) {
        System.out.println();
        for (int i = 0; i < list.length; i++) {
            int[] inArr = list[i];
            for (int j = 0; j < inArr.length; j++) {
                System.out.print(inArr[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
