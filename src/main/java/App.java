import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get ("/", (request, response) -> {
    HashMap model = new HashMap();
    model.put("template", "templates/wordPuzzler.vtl");
    return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get ("/puzzle", (request, response) -> {
    HashMap model = new HashMap();
    model.put("template", "templates/puzzle.vtl");

    String userWords = request.queryParams("userWords");
    String wordPuzzle = wordPuzzler(userWords);
    model.put("wordPuzzle", wordPuzzle);
    return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

  public static String wordPuzzler(String userWords) {
    String[] vowels = {"a", "A", "e", "E", "i", "I", "o", "O", "u", "U"};
    for (String vowel : vowels) {
        userWords = userWords.replaceAll(vowel, "-");
    }
      return userWords;
  }
}
