package ru.goshyulya.telegram.bot.balda.model.board;

import java.util.Iterator;

/**
 * Created by Gochan on 17.05.2016.
 */
public class Board implements Iterable<Field> {
    public static final int SIZE = 5;

    private Field[][] fields = new Field[SIZE][SIZE];

    public Board() {
        initDesc();
    }

    public Board(Character[][] letters){
        for(int x=0; x<letters.length; x++){
            for(int y=0; y<letters[0].length; y++){
                fields[x][y] = new Field(x, y, letters[x][y]);
            }
        }
    }

    private void initDesc(){
        for(int x=0; x<SIZE; x++){
            for(int y=0; y<SIZE; y++){
                fields[x][y] = new Field(x, y, null);
            }
        }
    }

    public Field getField(int x, int y){
        return fields[x][y];
    }

    public Field getField(Field field, Direction dir){
        int gapX = 0, gapY = 0;
        if(dir == Direction.Up){
            gapX = 0;
            gapY = 1;
        }
        else if(dir == Direction.Left){
            gapX = -1;
            gapY = 0;
        }
        else if(dir == Direction.Right){
            gapX = 1;
            gapY = 0;
        }
        else if(dir == Direction.Down){
            gapX = 0;
            gapY = -1;
        }
        int x = field.getX() + gapX;
        int y = field.getY() + gapY;

        if(x<0 || x>=SIZE){
            return null;
        }
        if(y<0 || y>=SIZE){
            return null;
        }
        return getField(x, y);
    }

    public Iterator<Field> iterator(){
        return new Iterator<Field>() {
            private int x = 0;
            private int y = 0;

            public boolean hasNext() {
                return x != SIZE-1 || y != SIZE-1;
            }

            public Field next() throws IndexOutOfBoundsException {
                if(!hasNext()){
                    throw new IndexOutOfBoundsException("No more fields on the board");
                }
                if(x != SIZE-1){
                    x++;
                }
                else {
                    x=0;
                    y++;
                }
                return fields[x][y];
            }
        };
    }
}
