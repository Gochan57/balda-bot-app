package ru.goshyulya.telegram.bot.balda.logic;


import ru.goshyulya.telegram.bot.balda.desc.Desc;
import ru.goshyulya.telegram.bot.balda.desc.Field;
import ru.goshyulya.telegram.bot.balda.move.Step;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Gochan on 18.05.2016.
 */
public class QuickAlgorithm {
    public static Step go(Desc desc){
        List<Field> availableFields = getAvailableFields(desc);

        List<Step> goodSteps = new ArrayList<Step>();
        for(Field field : availableFields){
            Step goodStep = go(field);
            if(goodStep != null){
                goodSteps.add(goodStep);
            }
        }

        return Collections.max(goodSteps);
    }

    private static List<Field> getAvailableFields(Desc desc){
        List fields = new ArrayList();
        //TODO
        return fields;
    }

    private static Step go(Field field){
        return null; //TODO
    }
}
