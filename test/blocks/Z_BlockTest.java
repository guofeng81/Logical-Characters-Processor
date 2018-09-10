package blocks;

import java.util.Map;

public class Z_BlockTest implements ConverterBlockTest {

  @Override
  public Converter createInstance() {
    return new LetterBlocker("Z");
  }

  @Override
  public Map<String, String> createTestSample() {
    return Map.of("Z", "", "aZ", "a", "AAZ", "AA", "AAZZz", "AAz");
  }
}
