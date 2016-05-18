package ru.goshyulya.telegram.bot.balda.vocabulary.lang;

/**
 * Created by Gochan on 17.05.2016.
 */
public class Alphabet {

    public static final char[] LETTERS = {'а','б','в','г','д','е','ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};

    public static final int SIZE = LETTERS.length;

    private static final short firstCode = (short)(LETTERS[0]-1);

    public static int getIndex(char c){
        return (short)c - firstCode;
    }
}
