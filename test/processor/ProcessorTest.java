package processor;

import blocks.LetterBlocker;
import blocks.LowerCaseConverter;
import blocks.UpperCaseConverter;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProcessorTest {

  private Processor processor;

  @Test
  void ZBlockerAndUpperCaseProcessor() {
    processor = new Processor(Arrays.asList(new LetterBlocker("Z"), new UpperCaseConverter()));

    assertEquals("ZZAA", processor.process("zzZaA"));
  }

  @Test
  void ZBlockerAndLowerCaseProcessor() {
    processor = new Processor(Arrays.asList(new LetterBlocker("Z"), new LowerCaseConverter()));

    assertEquals("aa", processor.process("ZZAA"));
  }

  @Test
  void UpperCaseZBlockerAndLowerCaseProcessor() {
    processor = new Processor(Arrays.asList(new UpperCaseConverter(), new LetterBlocker("Z"), new LowerCaseConverter()));

    assertEquals("aab", processor.process("azaB"));
  }

  @Test
  void UpperCasezBlockerkBlockerAndLowerCaseProcessor() {
    processor = new Processor(Arrays.asList(new UpperCaseConverter(), new LetterBlocker("z"), new LetterBlocker("k"), new LowerCaseConverter()));

    assertEquals("kkzzabc", processor.process("kKzZabc"));
  }

  @Test
  void UpperCaseZBlockerkBlockerAndLowerCaseProcessor() {
    processor = new Processor(Arrays.asList(new UpperCaseConverter(), new LetterBlocker("Z"), new LetterBlocker("k"), new LowerCaseConverter()));

    assertEquals("kkabc", processor.process("kKzZabc"));
  }
}
