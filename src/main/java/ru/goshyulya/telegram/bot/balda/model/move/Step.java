package ru.goshyulya.telegram.bot.balda.move;

/**
 * Created by Gochan on 18.05.2016.
 */
public class Step {
    public int x;
    public int y;
    public Character letter;

    public Step(int x, int y, Character letter) {
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

    public Character getLetter() {
        return letter;
    }
}
