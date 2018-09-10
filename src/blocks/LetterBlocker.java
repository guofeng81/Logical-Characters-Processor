package blocks;

public class LetterBlocker implements Converter {

  private String letter;

  public LetterBlocker(String letterToBlock) {
    letter = letterToBlock;
  }

  @Override
  public String convert(String text) {
    return text.replaceAll(letter, "");
  }
}
