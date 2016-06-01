package ru.goshyulya.telegram.bot.balda.logic;

import org.junit.Assert;
import org.junit.Test;
import ru.goshyulya.telegram.bot.balda.dictionary.load.Loader;
import ru.goshyulya.telegram.bot.balda.dictionary.model.Dict;
import ru.goshyulya.telegram.bot.balda.model.board.Board;
import ru.goshyulya.telegram.bot.balda.model.move.Step;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Gochan on 29.05.2016.
 */
public class QuickAlgorithmTest extends Assert {

    @Test
    public void testGo() throws Exception {
        Character[][] letters = {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {'ш',  'и',  'ш',  'к',  null},
                {null, null, null, null, null},
                {null, null, null, null, null}};
        Board board = new Board(letters);

        List voc = Arrays.asList("шишка", "кишка", "шиш", "шик");
        Dict descDict = new Dict();
        Loader.loadDictFromCollectionOfWords(descDict, voc);

        Dict ascDict = new Dict();
        Loader.loadDictFromCollectionOfWords(ascDict, voc, true);

        QuickAlgorithm quickAlgorithm = new QuickAlgorithm(board, descDict, ascDict);
        Step bestStep = quickAlgorithm.go();
        assertEquals(new Character('а'), bestStep.getLetter());
    }
}