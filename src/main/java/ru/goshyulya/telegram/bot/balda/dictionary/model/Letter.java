package ru.goshyulya.telegram.bot.balda.dictionary.model;

import ru.goshyulya.telegram.bot.balda.dictionary.lang.Alphabet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gochan on 16.05.2016.
 */
public class Letter {
    private char character;
    private Letter parent;
    private Letter[] children;
    private boolean isWord;

    public Letter() {
        children = new Letter[Alphabet.SIZE];
        for(int i=0; i<Alphabet.SIZE; i++){
            children[i] = null;
        }
    }

    public Letter(char character) {
        this();
        this.character = character;
    }

    public int getDepth(){
        int depth = 0;
        Letter letter = this;
        while(letter.getParent() != null){
            letter = letter.getParent();
            depth++;
        }
        return depth;
    }

    public Letter getNext(char c){
        return children[Alphabet.getIndex(c)];
    }

    public void addNext(Letter letter){
         children[Alphabet.getIndex(letter.getCharacter())] = letter;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public Letter getParent() {
        return parent;
    }

    public void setParent(Letter parent) {
        this.parent = parent;
    }

    public List<Letter> getChildren(){
        List<Letter> notNullChildren = new ArrayList<Letter>();
        for(Letter child : children){
            if(child != null){
                notNullChildren.add(child);
            }
        }
        return notNullChildren;
    }

    public void setChildren(Letter[] children) {
        this.children = children;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }

    @Override
    public String toString() {
        return ""+character;
    }
}
