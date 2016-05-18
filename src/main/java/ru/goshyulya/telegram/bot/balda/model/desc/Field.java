package ru.goshyulya.telegram.bot.balda.desc;

/**
 * Created by Gochan on 17.05.2016.
 */
public class Field {
    private int x;
    private int y;
    private Character letter;

    public Field(int x, int y, Character letter) {
        this.x = x;
        this.y = y;
        this.letter = letter;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(Character letter) {
        this.letter = letter;
    }
}
