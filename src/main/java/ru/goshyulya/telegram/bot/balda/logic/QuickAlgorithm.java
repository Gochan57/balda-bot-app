package ru.goshyulya.telegram.bot.balda.logic;

import ru.goshyulya.telegram.bot.balda.dictionary.model.Letter;
import ru.goshyulya.telegram.bot.balda.dictionary.model.Dict;
import ru.goshyulya.telegram.bot.balda.model.board.Board;
import ru.goshyulya.telegram.bot.balda.model.board.Chain;
import ru.goshyulya.telegram.bot.balda.model.board.Direction;
import ru.goshyulya.telegram.bot.balda.model.board.Field;
import ru.goshyulya.telegram.bot.balda.model.move.Step;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Gochan on 18.05.2016.
 */
public class QuickAlgorithm {
    private Board board;
    private Dict descDict;
    private Dict ascDict;

    public QuickAlgorithm(Board board, Dict descDict, Dict ascDict) {
        this.board = board;
        this.descDict = descDict;
        this.ascDict = ascDict;
    }

    public ru.goshyulya.telegram.bot.balda.model.move.Step go(){
        List<Field> availableFields = getAvailableFields();

        List<Step> goodSteps = new ArrayList<Step>();
        for(Field field : availableFields){
            for(Letter newLetter : descDict.getRoot().getChildren()){
                QuickAlgorithmForField quickAlgorithmForField = new QuickAlgorithmForField(field, newLetter);
                Step goodStep = quickAlgorithmForField.go();
                if(goodStep != null) {
                    goodSteps.add(goodStep);
                }
            }
        }

        return Collections.max(goodSteps);
    }

    private List<Field> getAvailableFields(){
        List fields = new ArrayList();
        Iterator<Field> iterator = board.iterator();
        Iter_fields: while(iterator.hasNext()){
            Field field = iterator.next();
            if(field.getCharacter() != null){
                continue Iter_fields;
            }
            for(Direction dir : Direction.values()){
                Field nearField = board.getField(field, dir);
                if(nearField != null && nearField.getCharacter() != null){
                    fields.add(field);
                    continue Iter_fields;
                }
            }
        }
        return fields;
    }

    private class QuickAlgorithmForField{
        private Field field;
        private Letter newLetter;
        private Integer maxScore = 0;

        public QuickAlgorithmForField(Field field, Letter newLetter) {
            this.field = field;
            this.newLetter = newLetter;
        }

        public Step go(){
            assert(field.getCharacter() == null);

            field.setCharacter(newLetter.getCharacter());
            Chain chain = new Chain();
            chain.append(field);

            Letter letter = descDict.getRoot().getNext(newLetter.getCharacter());
            if(letter == null) {
                return null;
            }

            findWord(chain, letter, true);

            Step step = new Step(field, maxScore);
            field.setCharacter(null);

            return step;
        }

        private void findWord(Chain chain, Letter letter, boolean findSuffix){
            if("ки".equals(chain.toString())){
                int a=1;
            }
            if(letter.isWord()){
                if(findSuffix) {
                    Chain reversedChain = chain.getReversed();
                    Letter ascLetter = getNode(ascDict, reversedChain);
                    findWord(reversedChain, ascLetter, false);
                }
                else{ // findPrefix
                    maxScore = Integer.max(maxScore, letter.getDepth());
                }
            }

            Field lastField = chain.getLastField();
            for(Direction dir : Direction.values()){
                Field nextField = board.getField(lastField, dir);
                if(nextField == null || nextField.getCharacter() == null || chain.containsField(nextField)){
                    continue;
                }
                Letter nextLetter = letter.getNext(nextField.getCharacter());
                if(nextLetter == null){
                    continue;
                }
                chain.append(nextField);

                findWord(chain, nextLetter, findSuffix);

                chain.removeLast();
            }
        }

        private Letter getNode(Dict dict, Chain chain){
            Chain.FieldInChain field = chain.getFirstField();
            Letter letter = dict.getRoot();
            Iterator<Chain.FieldInChain> iterator = chain.getIterator();
            while(iterator.hasNext()){
                assert(letter != null);
                char character = iterator.next().getCharacter();
                letter = letter.getNext(character);
            }
            return letter;
        }
    }
}
