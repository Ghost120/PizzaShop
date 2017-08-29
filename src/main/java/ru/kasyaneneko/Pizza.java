package ru.kasyaneneko;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static ru.kasyaneneko.SingleSchema.*;

/**
 * Created by Kasyanenko Konstantin
 * on 28.08.2017.
 */
public class Pizza {
    private static final Logger LOG = LoggerFactory.getLogger(Pizza.class);
    public boolean getPizza(String jsonIngredients) {
       return getPizzaWithIngredient(getRecipe(jsonIngredients), getSingleSchema().getSchema());
    }

    private boolean getPizzaWithIngredient(List<String> listIngredients, Map<String, Map<String, String>> schema) {
        boolean ret = true;
        if (listIngredients.isEmpty()) return false;
        if (schema.isEmpty()) return false;
        for (int i = 0; i < listIngredients.size(); i++) {
            for (int j = 1; j < listIngredients.size(); j++) {
                if (!Boolean.parseBoolean(schema.get(listIngredients.get(i)).get(listIngredients.get(j)))) {
                    return false;
                }
            }
        }
        return ret;
    }

    private List<String> getRecipe(String json) {
        JSONParser parser = new JSONParser();
        JSONObject object = null;
        try {
            object = (JSONObject) parser.parse(json);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (List<String>) object.get("ingredients");
    }
}
