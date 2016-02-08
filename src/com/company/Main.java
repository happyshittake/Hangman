package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan Kata Permainan");
        String wordGame = scanner.next();
        System.out.println("masukkan berapa kali kesempatan");
        int kesempatan = scanner.nextInt();
        Kata kata = new Kata(wordGame);
        Game game = new Game(kata, kesempatan);
        game.gameStart();
    }
}
