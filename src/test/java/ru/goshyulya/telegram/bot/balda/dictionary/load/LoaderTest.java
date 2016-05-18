package ru.goshyulya.telegram.bot.balda.dictionary.load;

import org.junit.Test;
import ru.goshyulya.telegram.bot.balda.dictionary.model.Tree;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gochan on 16.05.2016.
 */
public class LoaderTest {

    @Test
    public void testLoadTreeFromListOfWords() throws Exception {
        List voc = Arrays.asList("папка", "папа", "мама", "мамонт");
        Tree tree = new Tree();
        Loader.loadTreeFromCollectionOfWords(tree, voc);

        tree.getRoot().getNext('м').getNext('а').getNext('м').getNext('а');
    }

    @Test
    public void testLoadTreeFromFile() throws IOException {
        File file = new File(Thread.currentThread().getContextClassLoader().getResource("words.txt").getFile());
        Tree tree = new Tree();
        Loader.loadTreeFromFile(tree, file);

        tree.getRoot().getNext('м').getNext('а').getNext('м').getNext('а');
    }

//    @Test
    public void justTest() throws Exception{
        System.out.println((char)1105);
        System.out.println((char)1104);
        System.out.println((short)'а');
        System.out.println((short)'б');
        System.out.println((short)'в');
        System.out.println((short)'г');
        System.out.println((short)'д');
        System.out.println((short)'е');
        System.out.println((short)'ё');
        System.out.println((short)'ж');
        System.out.println((short)'з');
        System.out.println((short)'и');
        System.out.println((short)'й');
        System.out.println((short)'к');
        System.out.println((short)'л');
        System.out.println((short)'м');
        System.out.println((short)'н');
        System.out.println((short)'о');
        System.out.println((short)'п');
        System.out.println((short)'р');
        System.out.println((short)'с');
        System.out.println((short)'т');
        System.out.println((short)'у');
        System.out.println((short)'ф');
        System.out.println((short)'х');
        System.out.println((short)'ц');
        System.out.println((short)'ч');
        System.out.println((short)'ш');
        System.out.println((short)'щ');
        System.out.println((short)'ъ');
        System.out.println((short)'ы');
        System.out.println((short)'ь');
        System.out.println((short)'э');
        System.out.println((short)'ю');
        System.out.println((short)'я');
    }
}