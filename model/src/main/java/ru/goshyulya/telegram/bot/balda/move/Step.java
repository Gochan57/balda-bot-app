package ru.goshyulya.telegram.bot.balda.move;

/**
 * Created by Gochan on 18.05.2016.
 */
public class Step implements Comparable<Step> {
    private int x;
    private int y;
    private Character letter;
    private Integer score;

    public Step(int x, int y, Character letter, Integer score) {
        this.x = x;
        this.y = y;
        this.letter = letter;
        this.score = score;
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

    public Integer getScore() {
        return score;
    }

    public int compareTo(Step another){
        return Integer.compare(this.score, another.score);
    }

    public boolean equals(Step another){
        return this.x == another.x &&
                this.y == another.y &&
                (this.letter == null && another.letter == null ||
                        this.letter != null && this.letter.equals(another.letter)) &&
                (this.score == null && another.score == null ||
                        this.score != null && this.score.equals(another.score));
    }

    public int hashCode(){
        return this.x +
                this.y +
                (this.letter != null ? this.letter.hashCode() : 0) +
                (this.score != null ? this.score.hashCode() : 0);
    }
}
