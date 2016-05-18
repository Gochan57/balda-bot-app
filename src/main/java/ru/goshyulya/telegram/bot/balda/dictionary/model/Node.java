package ru.goshyulya.telegram.bot.balda.dictionary.model;

import ru.goshyulya.telegram.bot.balda.dictionary.lang.Alphabet;

/**
 * Created by Gochan on 16.05.2016.
 */
public class Node {
    private char letter;
    private Node[] children;
    private boolean is_word;

    public Node() {
        children = new Node[Alphabet.SIZE];
    }

    public Node(char letter, boolean is_word) {
        this();
        this.letter = letter;
        this.is_word = is_word;
    }

    public Node getNext(char c){
        return children[Alphabet.getIndex(c)];
    }

    public void addNext(Node node){
         children[Alphabet.getIndex(node.getLetter())] = node;
    }

    public char getLetter() {
        return letter;
    }

    public boolean is_word() {
        return is_word;
    }
}
