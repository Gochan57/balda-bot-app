package ru.goshyulya.telegram.bot.balda.desc;

/**
 * Created by Gochan on 17.05.2016.
 */
public class Desc {
    public static final int SIZE = 5;

    private Field[][] fields;

    public Desc() {
        initDesc();
    }

    private void initDesc(){
        fields = new Field[SIZE][SIZE];
        for(int x=0; x<SIZE; x++){
            for(int y=0; y<SIZE; y++){
                fields[x][y] = new Field(x, y, null);
            }
        }
    }

    public Field getField(int x, int y){
        return fields[x][y];
    }
}
