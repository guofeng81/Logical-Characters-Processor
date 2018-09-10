package blocks;

import java.util.Map;

public class zBlockTest implements ConverterBlockTest {

  @Override
  public Converter createInstance() {
    return new LetterBlocker("z");
  }

  @Override
  public Map<String, String> createTestSample() {
    return Map.of("z", "", "az", "a", "AAz", "AA", "AAzzZ", "AAZ");
  }
}
