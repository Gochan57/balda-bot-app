package ru.goshyulya.telegram.bot.balda.dictionary.model;

import ru.goshyulya.telegram.bot.balda.dictionary.load.Loader;

import java.util.List;

/**
 * Created by Gochan on 16.05.2016.
 */
public class Tree {
    private Node root;

    public Tree(){
        root = new Node();
    }

    public Tree(List<String> words){
        this();
        Loader.loadTreeFromCollectionOfWords(this, words);
    }

    public Node getRoot() {
        return root;
    }

}
