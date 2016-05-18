package ru.goshyulya.telegram.bot.balda.move;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Gochan on 18.05.2016.
 */
public class StepTest {
    @Test
    public void bestStep(){
        Step s1 = new Step(1,1,'a',4);
        Step s2 = new Step(1,1,'b',2);
        Step s3 = new Step(1,1,'c',5);
        Step s4 = new Step(1,1,'d',3);
        List<Step> steps = Arrays.asList(s1, s2, s3, s4);

        Step best = Collections.max(steps);
        assertEquals(s3, best);
    }

}