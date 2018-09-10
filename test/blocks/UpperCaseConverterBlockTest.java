package blocks;

import java.util.Map;

public class UpperCaseConverterBlockTest implements ConverterBlockTest {

  @Override
  public Map<String, String> createTestSample() {
    return Map.of("a", "A", "aa", "AA");
  }

  @Override
  public Converter createInstance() {
    return new UpperCaseConverter();
  }
}
