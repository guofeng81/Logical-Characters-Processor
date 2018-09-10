package blocks;

import java.util.Map;

public class MultiplierBlockTest implements ConverterBlockTest {

  @Override
  public Map<String, String> createTestSample() {
    return Map.of("a", "aa", "aa", "aaaa", "AAA", "AAAAAA", "ABC", "AABBCC");
  }

  @Override
  public Converter createInstance() {
    return new Multiplier();
  }
}
