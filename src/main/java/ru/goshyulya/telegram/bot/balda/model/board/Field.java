package ru.goshyulya.telegram.bot.balda.model.board;

/**
 * Created by Gochan on 17.05.2016.
 */
public class Field {
    private int x;
    private int y;
    private Character character;

    public Field(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Field(int x, int y, Character character) {
        this(x, y);
        this.character = character;
    }

    public Field(Field other){
        this(other.getX(), other.getY(), other.getCharacter());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
