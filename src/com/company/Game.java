package com.company;

import java.util.Scanner;

public class Game {
    private int kesempatan;
    private Kata kata;
    private String historiHuruf = "";

    public Game(Kata kata, int kesempatan) {
        this.kesempatan = kesempatan;
        this.kata = kata;
    }

    public void gameStart() {
        Scanner scan = new Scanner(System.in);
        while (this.isStillPlay()) {
            System.out.println(this.kata.displayKata());
            System.out.printf("kesempatan %d kali lagi", this.kesempatan);
            System.out.println();
            System.out.println("Woooiii Silahkan masukkan huruf tebakan:");
            String word = scan.nextLine();
            this.inputHurufAction(word);
        }

        this.checkGamesStatusAction();

    }

    private void checkGamesStatusAction() {
        if (this.isSuccess()) {
            System.out.printf("Kata Sukses Ditebak kata: %s", this.kata.getKata());
        } else {
            System.out.printf("kata gagal ditebak kata: %s", this.kata.getKata());
        }
    }

    private void inputHurufAction(String word) {
        if (this.validasiHuruf(word)) {
            if (this.hurufBaru(word)) {
                this.historiHuruf += word;
                if (this.kata.setHuruf(word)) {
                    System.out.println("Huruf berhasil dimasukkan");
                } else {
                    System.out.println("Huruf tidak ada");
                    this.decrementChance();
                }
            } else {
                System.out.printf("Huruf %s sudah anda masukkan", word);
                System.out.println();
            }
        } else {
            System.out.println("Huruf tidak valid, hanya boleh satu karakter");
        }
    }

    private boolean isStillPlay() {
        return (this.kesempatan > 0) && !this.kata.isGuessed();
    }

    private boolean isSuccess() {
        return (this.kesempatan > 0) && this.kata.isGuessed();
    }

    private void decrementChance() {
        this.kesempatan--;
    }

    private boolean validasiHuruf(String huruf) {
        return huruf.length() == 1;
    }

    private boolean hurufBaru(String huruf) {
        return !this.historiHuruf.contains(huruf);
    }
}
