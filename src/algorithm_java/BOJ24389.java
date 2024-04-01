package algorithm_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ24389 {

    /*
     * 주어진 값과 2의보수의 서로 다른값 XOR
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int Nb = ~N + 1;

        int rsCnt = 0;

        // System.out.println(Integer.toBinaryString(N^Nb));

        String binary = Integer.toBinaryString(N ^ Nb);

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                rsCnt = rsCnt + 1;
            }
        }

        System.out.println(rsCnt);

    }
}