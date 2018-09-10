package blocks;

import java.util.Map;

public class kBlockTest implements ConverterBlockTest {

  @Override
  public Converter createInstance() {
    return new LetterBlocker("k");
  }

  @Override
  public Map<String, String> createTestSample() {
    return Map.of("k", "", "ak", "a", "ka", "a", "Kaak", "Kaa");
  }
}
