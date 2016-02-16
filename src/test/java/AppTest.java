import java.util.ArrayList;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Restaurants have been added");
  }
  @Test
  public void restaurantAddedTest() {
      goTo("http://localhost:4567/");
      fill("#restaurantName").with("Boxer Ramen");
      submit(".btn");
      assertThat(pageSource()).contains("The restaurant of your choice has been added.");
  }
  @Test
  public void checkIfRestaurantDisplayedTest() {
      goTo("http://localhost:4567/");
      fill("#restaurantName").with("Boxer Ramen");
      submit(".btn");
      click("a", withText("Go Back"));
      assertThat(pageSource()).contains("Boxer Ramen");
  }
  @Test
  public void checkIfMultipleRestaurantAreDisplayedTest() {
      goTo("http://localhost:4567/");
      fill("#restaurantName").with("Boxer Ramen");
      submit(".btn");
      click("a", withText("Go Back"));
      fill("#restaurantName").with("The Nines");
      submit(".btn");
      click("a", withText("Go Back"));
      assertThat(pageSource()).contains("The Nines");
      assertThat(pageSource()).contains("Boxer Ramen");
  }

}
