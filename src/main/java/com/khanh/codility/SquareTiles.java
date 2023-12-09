package com.khanh.codility;

public class SquareTiles {

    public int solution(int M, int N) {
        double result = Math.sqrt(4 * N + M);
        return (int) Math.floor(result);
    }
}
