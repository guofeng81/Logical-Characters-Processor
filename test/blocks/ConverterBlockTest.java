package blocks;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public interface ConverterBlockTest {

  Converter createInstance();
  Map<String,String> createTestSample();

  @TestFactory
  default Stream<DynamicTest> convert() {

    Converter converter = createInstance();
    Map<String, String> testSample = createTestSample();

    Function<String, DynamicTest> createDynamicTest = key ->
            dynamicTest("convert from " + key,
                    () -> assertEquals(testSample.get(key), converter.convert(key)));

    return testSample.keySet()
            .stream()
            .map(createDynamicTest);
  }
}

