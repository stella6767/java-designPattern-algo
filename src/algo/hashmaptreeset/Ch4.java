package algo.hashmaptreeset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Ch4 {

    /**
     * 모든 아나그램 찾기
     * S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하라
     * 아나그램 판별시 대소문자가 구분
     * @param args
     * @throws IOException
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        String s = stk.nextToken();
        stk = new StringTokenizer(br.readLine());
        String t = stk.nextToken();


        solution(s, t);

        br.close();
    }

    private static void solution(String s, String t) {

        int answer = 0, lt = 0;

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for (int i=0; i< t.length() -1 ; i ++ ){
            sMap.put(sChars[i], sMap.getOrDefault(sChars[i],0) + 1);
        }

        for (int i=0; i< t.length() ; i ++ ){
            tMap.put(tChars[i], tMap.getOrDefault(tChars[i],0) + 1);
        }

        //System.out.println(sMap);
       // System.out.println(tMap);


        for(int rt=t.length()-1; rt< sChars.length; rt++) {
            sMap.put(sChars[rt], sMap.getOrDefault(sChars[rt],0) + 1);

            if (sMap.equals(tMap)) answer ++;
            sMap.put(sChars[lt], sMap.get(sChars[lt])-1);
            if(sMap.get(sChars[lt])==0)sMap.remove(sChars[lt]);
            lt++;
        }


        System.out.println(answer);

    }

}
