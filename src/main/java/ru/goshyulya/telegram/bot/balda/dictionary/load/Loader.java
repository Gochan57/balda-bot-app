package ru.goshyulya.telegram.bot.balda.dictionary.load;


import ru.goshyulya.telegram.bot.balda.dictionary.model.Node;
import ru.goshyulya.telegram.bot.balda.dictionary.model.Tree;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Gochan on 16.05.2016.
 */
public class Loader {
    public static void loadTreeFromCollectionOfWords(ru.goshyulya.telegram.bot.balda.dictionary.model.Tree tree, Collection<String> words){
        for(String word : words){
            loadWord(tree, word);
        }
    }

    public static void loadTreeFromFile(ru.goshyulya.telegram.bot.balda.dictionary.model.Tree tree, File file) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line=br.readLine())!=null){
            loadWord(tree, line.trim());
        }
    }

    private static void loadWord(Tree tree, String word){
        loadPrefix(tree, word.toCharArray());
    }

    private static void loadPrefix(Tree tree, char[] chars){
        loadPrefixStartingWithNode(tree.getRoot(), chars);
    }

    private static void loadPrefixStartingWithNode(Node node, char[] chars){
        if(chars.length == 0){
            return;
        }
        char c = chars[0];
        ru.goshyulya.telegram.bot.balda.dictionary.model.Node nextNode = node.getNext(c);
        if(nextNode == null){
            nextNode = new Node(c, chars.length==1);
            node.addNext(nextNode);
        }
        loadPrefixStartingWithNode(nextNode, Arrays.copyOfRange(chars, 1, chars.length));
    }
}
