import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyTicketBooking() {
        homePage.selectFromCity();
    }
}