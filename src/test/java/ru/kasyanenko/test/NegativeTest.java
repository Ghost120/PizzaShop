package ru.kasyanenko.test;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kasyaneneko.Pizza;

import java.util.Arrays;
import java.util.Collection;
import static ru.kasyanenko.test.utils.Util.getRecipe;

/**
 * Created by Kasyanenko Konstantin
 * on 28.08.2017.
 */
@RunWith(value = Parameterized.class)
public class NegativeTest {
    private static final Logger LOG = LoggerFactory.getLogger(NegativeTest.class);
    public String fileName;

    public NegativeTest(String fileName) {
        this.fileName = fileName;
    }


    @Parameterized.Parameters
    public static Collection<String> params() {
        return Arrays.asList("1false.json", "2false.json");
    }

    @Test
    public void test() {
        Pizza pizza = new Pizza();
        LOG.info("fileName" + fileName);
        Assert.assertFalse(pizza.getPizza(getRecipe(fileName)));
    }
}
