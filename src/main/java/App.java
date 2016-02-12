import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class App {
  public static void main(String[] args) {}

  public static String isVowel(String word) {
    word = word.replaceAll("a", "-");
    word = word.replaceAll("A", "-");
    word = word.replaceAll("e", "-");
    word = word.replaceAll("E", "-");
    word = word.replaceAll("i", "-");
    word = word.replaceAll("I", "-");
    word = word.replaceAll("o", "-");
    word = word.replaceAll("O", "-");
    word = word.replaceAll("u", "-");
    word = word.replaceAll("U", "-");
    return word;
  }
}
