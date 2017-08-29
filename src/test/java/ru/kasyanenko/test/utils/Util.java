package ru.kasyanenko.test.utils;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kasyanenko.test.PositiveTest;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Kasyanenko Konstantin
 * on 29.08.2017.
 */
public class Util {
    private static final Logger LOG = LoggerFactory.getLogger(Util.class);
    public static String getRecipe(String fileName) {
        String json = "";
        try (FileReader reader = new FileReader("src/test/resources/jsons/" + fileName)) {
            json = new JSONParser().parse(reader).toString();
        } catch (ParseException | IOException e) {
            LOG.error("Ошибка чтения json-файла",e);
            Assert.fail("Ошибка чтения json-файла");
        }
        return json;
    }
}
