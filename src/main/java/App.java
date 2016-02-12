import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class App {
  public static void main(String[] args) {
    System.out.println(isVowel("test more things here abecaw3eld*!?as3weraeiouAEIOU"));
  }

  public static String isVowel(String word) {
    String[] vowels = {"a", "A", "e", "E", "i", "I", "o", "O", "u", "U"};
    for (String vowel : vowels) {
        word = word.replaceAll(vowel, "-");
    }
      return word;
  }
}
