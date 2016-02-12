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
  public void isVowel_replacesAllVowelsWithDash_dashWord() {
    App testApp = new App();
    assertEquals("-l-", testApp.isVowel("ele"));
  }

  @Test
  public void isVowel_replacesAllCaseVowelsWithDash_dashWord() {
    App testApp = new App();
    assertEquals("b---T-f-l", testApp.isVowel("bEauTifUl"));
  }

  @Test
  public void isVowel_replacesAllVowelsWithDashInTwoWords_dashWords() {
    App testApp = new App();
    assertEquals("b---T-f-l s-ng", testApp.isVowel("bEauTifUl song"));
  }

}
