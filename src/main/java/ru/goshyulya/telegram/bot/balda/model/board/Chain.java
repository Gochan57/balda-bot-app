package ru.goshyulya.telegram.bot.balda.model.board;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Gochan on 24.05.2016.
 */
public class Chain {
    private LinkedList<FieldInChain> fields;

    public Chain() {
        fields = new LinkedList<FieldInChain>();
    }

    public void append(Field field){
        FieldInChain newField;
        if(fields.size() != 0){
            newField = new FieldInChain(field, null, fields.getLast());
            fields.getLast().setNext(newField);
        }
        else {
            newField = new FieldInChain(field, null, null);
        }
        fields.add(newField);
    }

    public boolean containsField(Field field){
        for(FieldInChain fieldInChain : fields){
            if(field.getX() == fieldInChain.getX() &&
                    field.getY() == fieldInChain.getY()){
                return true;
            }
        }
        return false;
    }

    public FieldInChain getFirstField(){
        return fields.getFirst();
    }

    public FieldInChain getLastField(){
        return fields.getLast();
    }

    public Iterator<FieldInChain> getIterator(){
        return fields.iterator();
    }

    public Chain getReversed(){
        Chain reversedChain = new Chain();
        ListIterator<FieldInChain> iterator = fields.listIterator(fields.size());
        while(iterator.hasPrevious()){
            Field newField = new Field(iterator.previous());
            reversedChain.append(newField);
        }
        return reversedChain;
    }

    public class FieldInChain extends Field{
        private FieldInChain next;
        private FieldInChain prev;

        public FieldInChain(int x, int y, FieldInChain next, FieldInChain prev) {
            super(x, y);
            this.next = next;
            this.prev = prev;
        }

        public FieldInChain(Field field, FieldInChain next, FieldInChain prev) {
            super(field.getX(), field.getY(), field.getCharacter());
            this.next = next;
            this.prev = prev;
        }

        public boolean hasNext(){
            return (next != null);
        }

        public boolean hasPrev(){
            return (prev != null);
        }

        public FieldInChain getNext() {
            return next;
        }

        public void setNext(FieldInChain next) {
            this.next = next;
        }

        public FieldInChain getPrev() {
            return prev;
        }

        public void setPrev(FieldInChain prev) {
            this.prev = prev;
        }

        public boolean isStart() {
            return prev==null;
        }
    }
}
