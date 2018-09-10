package blocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static blocks.ConverterFactory.createConverter;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConverterFactoryTest {

  ConverterFactory converterfactory;

  @BeforeEach
  void init() {
    converterfactory = new ConverterFactory();
  }

  @Test
  void createConverterByTextTest() {

    assertAll(
            () -> assertEquals("blocks.UpperCaseConverter", createConverter("blocks.UpperCaseConverter").getClass().getName()),
            () -> assertEquals("blocks.LowerCaseConverter", createConverter("blocks.LowerCaseConverter").getClass().getName()),
            () -> assertEquals("blocks.Multiplier", createConverter("blocks.Multiplier").getClass().getName()),
            () -> assertEquals("blocks.LetterBlocker", createConverter("blocks.LetterBlocker a").getClass().getName()),
            () -> assertEquals("blocks.LetterBlocker", createConverter("blocks.LetterBlocker b").getClass().getName()));
  }

  @Test
  void createListOfConverterObjectsTest() {
    List<Converter> converterList = new ArrayList<Converter>(Arrays.asList(new UpperCaseConverter(), new LowerCaseConverter(), new LetterBlocker("a")));
    List<String> converterDetails = Arrays.asList("blocks.UpperCaseConverter", "blocks.LowerCaseConverter", "blocks.LetterBlocker a");

    assertAll(
            () -> assertEquals(converterList.get(0).getClass(), converterfactory.createConverters(converterDetails).get(0).getClass()),
            () -> assertEquals(converterList.get(1).getClass(), converterfactory.createConverters(converterDetails).get(1).getClass()),
            () -> assertEquals(converterList.get(2).getClass(), converterfactory.createConverters(converterDetails).get(2).getClass()));
  }

  @Test
  void invalidClassNameTest() {
    assertThrows(RuntimeException.class, () -> converterfactory.createConverter("invalidclassname"), "Invalid class");
  }
}

