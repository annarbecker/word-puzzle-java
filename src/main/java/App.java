import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class App {
  public static void main(String[] args) {
    System.out.println(isVowel("Believe you can and you're halfway there. Theodore Roosevelt."));
  }

  public static String isVowel(String userWords) {
    String[] vowels = {"a", "A", "e", "E", "i", "I", "o", "O", "u", "U"};
    for (String vowel : vowels) {
        userWords = userWords.replaceAll(vowel, "-");
    }
      return userWords;
  }
}
