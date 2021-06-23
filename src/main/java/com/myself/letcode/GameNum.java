package com.myself.letcode;

/**
 * @program: GameNum
 * @description: 猜字游戏
 * @author: qll
 * @create: 2019-11-28 20:59
 **/
public class GameNum {
    public static void main(String[] args) {

        int game = game(new int[]{1, 2, 3}, new int[]{1, 2, 3});
        System.out.println(game);
    }

    public static int game(int[] guess, int[] answer) {

        return (guess[0]==answer[0]?1:0)+(guess[1]==answer[1]?1:0)+(guess[2]==answer[2]?1:0);
    }
}
