package processor.ui;

import blocks.Converter;
import processor.Processor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static blocks.ConverterFactory.createConverters;
import static java.util.stream.Collectors.toList;

public class Driver {

  public static void main(String[] args) {

    try {

      List<String> inputs = readFile("/input/text.txt");
      List<String> blockDetails = readFile("/input/blocks.txt");

      List<Converter> converters = createConverters(blockDetails);
      inputs.forEach(text -> useConverters(converters, text));

    } catch (Exception exception) {
      throw new RuntimeException("File not found or the path is incorrect");
    }
  }


  private static List<String> readFile(String path) throws IOException {
    String fileName = Paths.get(".").toAbsolutePath().normalize().toString() + path;

    return Files.lines(Paths.get(fileName))
        .collect(toList());

  }

  private static void useConverters(List<Converter> converters, String text) {
    System.out.println(new Processor(converters).process(text));
  }

}




