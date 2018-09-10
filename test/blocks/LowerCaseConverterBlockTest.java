package blocks;

import java.util.Map;

public class LowerCaseConverterBlockTest implements ConverterBlockTest {

  @Override
  public Map<String, String> createTestSample() {
    return Map.of("A", "a", "AA", "aa");
  }

  @Override
  public Converter createInstance() {
    return new LowerCaseConverter();
  }
}
