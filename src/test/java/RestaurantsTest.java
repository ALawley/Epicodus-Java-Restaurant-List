import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class RestaurantsTest {

  @Test
  public void addRestaurant_initiateCorrectly_true() {
    Restaurants testRestaurant = new Restaurants("Test Restaurant");
    assertEquals(true, testRestaurant instanceof Restaurants);
  }
  @Test
  public void addRestaurant_initiateRestaurantNameCorrectly() {
    Restaurants testRestaurant = new Restaurants("Test Restaurant");
    assertEquals("Test Restaurant", testRestaurant.getName());
  }
}
