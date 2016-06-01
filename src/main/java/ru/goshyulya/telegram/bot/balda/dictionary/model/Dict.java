package ru.goshyulya.telegram.bot.balda.dictionary.model;

import ru.goshyulya.telegram.bot.balda.dictionary.load.Loader;

import java.util.List;

/**
 * Created by Gochan on 16.05.2016.
 */
public class Dict {
    private Letter root;

    public Dict(){
        root = new Letter();
    }

    public Dict(List<String> words){
        this();
        Loader.loadDictFromCollectionOfWords(this, words);
    }

    public Letter getRoot() {
        return root;
    }

}
