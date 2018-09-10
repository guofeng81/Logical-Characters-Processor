package blocks;

import java.lang.reflect.Constructor;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ConverterFactory {
  public static Converter createConverter(String converterDetails) {

    try {
      String[] converters = converterDetails.split(" ");

      if (converters.length > 1) {
        Constructor blocker = Class.forName(converters[0]).getDeclaredConstructor(String.class);

        return (Converter) blocker.newInstance(converters[1]);

      } else {
        Class<?> preDefinedclassName = Class.forName(converters[0]);

        return (Converter) preDefinedclassName.getDeclaredConstructor().newInstance();

      }
    } catch (Exception e) {
      throw new RuntimeException("Invalid class");
    }
  }

  public static List<Converter> createConverters(List<String> convertersDetails) {
    return convertersDetails.stream()
            .map(ConverterFactory::createConverter)
            .collect(toList());
  }
}

