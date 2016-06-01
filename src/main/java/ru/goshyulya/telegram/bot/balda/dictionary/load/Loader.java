package ru.goshyulya.telegram.bot.balda.dictionary.load;


import ru.goshyulya.telegram.bot.balda.dictionary.model.Letter;
import ru.goshyulya.telegram.bot.balda.dictionary.model.Dict;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Gochan on 16.05.2016.
 */
public class Loader {
    public static void loadDictFromCollectionOfWords(Dict dict, Collection<String> words){
        loadDictFromCollectionOfWords(dict, words, false);
    }

    public static void loadDictFromCollectionOfWords(Dict dict, Collection<String> words, boolean revert){
        for(String word : words){
            loadWord(dict, word, revert);
        }
    }

    public static void loadDictFromFile(Dict dict, File file) throws IOException{
        loadDictFromFile(dict, file, false);
    }

    public static void loadDictFromFile(Dict dict, File file, boolean revert) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line=br.readLine())!=null){
            loadWord(dict, line.trim(), revert);
        }
    }

    private static void loadWord(Dict dict, String word, boolean revert){
        char[] chars;
        if(revert){
           chars = word.toCharArray();
        }
        else{
            chars = new char[word.length()];
            char[] chars_ = word.toCharArray();
            for(int i=0; i<word.length(); i++){
                chars[i] = chars_[chars_.length-i-1];
            }
        }
        loadPrefix(dict, chars);
    }

    private static void loadPrefix(Dict dict, char[] chars){
        loadPrefixStartingWithNode(dict.getRoot(), chars);
    }

    private static void loadPrefixStartingWithNode(Letter letter, char[] chars){
        if(chars.length == 0){
            return;
        }
        char c = chars[0];
        Letter nextLetter = letter.getNext(c);
        if(nextLetter == null){
            nextLetter = new Letter(c);
            nextLetter.setParent(letter);
            letter.addNext(nextLetter);
        }
        nextLetter.setWord(chars.length==1);
        loadPrefixStartingWithNode(nextLetter, Arrays.copyOfRange(chars, 1, chars.length));
    }
}
