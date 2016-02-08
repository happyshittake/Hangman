package com.company;

import java.util.Arrays;

public class Kata {
    private String kata;
    private Boolean[] statusHuruf;

    public Kata(String kata) {
        this.kata = kata;
        this.statusHuruf = new Boolean[this.kata.length()];
        Arrays.fill(this.statusHuruf, Boolean.FALSE);
    }

    public String displayKata() {
        String result = "";

        for (int i = 0; i < this.statusHuruf.length; i++) {
            if (this.statusHuruf[i]) {
                result += this.kata.charAt(i);
            } else {
                result += "_";
            }
        }

        return result;
    }

    public Boolean setHuruf(String huruf) {
        if (this.kata.contains(huruf)) {
            int i = 0;
            while (i < this.kata.length()) {
                String guess = this.kata.charAt(i) + "";
                if (guess.equals(huruf)) {
                    this.statusHuruf[i] = true;
                }
                i++;
            }

            return true;
        }

        return false;
    }

    public Boolean isGuessed() {
        Boolean result = true;

        for (Boolean status : this.statusHuruf) {
            result = result && status;
        }

        return result;
    }

    public String getKata() {
        return kata;
    }
}
