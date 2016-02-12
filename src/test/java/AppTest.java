import org.junit.*;
import static org.junit.Assert.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Word Puzzler");
  }

  @Test
  public void wordPuzzler() {
      goTo("http://localhost:4567/");
      fill("#userInput").with("test");
      submit(".btn");
      assertThat(pageSource()).contains("Solve");
  }

  @Test
  public void wordPuzzler_replacesAllVowelsWithDash_dashWord() {
    App testApp = new App();
    assertEquals("-l-", testApp.wordPuzzler("ele"));
  }

  @Test
  public void wordPuzzler_replacesAllCaseVowelsWithDash_dashWord() {
    App testApp = new App();
    assertEquals("b---T-f-l", testApp.wordPuzzler("bEauTifUl"));
  }

  @Test
  public void wordPuzzler_replacesAllVowelsWithDashInTwoWords_dashWords() {
    App testApp = new App();
    assertEquals("b---T-f-l s-ng", testApp.wordPuzzler("bEauTifUl song"));
  }
}
