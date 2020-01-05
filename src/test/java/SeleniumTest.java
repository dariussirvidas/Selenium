import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SeleniumTest {
    @Before
    public void testSetup() {
        Selenium.setup();
    }
    @Test
    public void testLoginToSherdog1() {
        Selenium.loginToSherdog("civerx@gmail.com", "individual11");
        Assert.assertEquals("https://forums.sherdog.com/", Selenium.browser.getCurrentUrl());
        WebElement visitorTabs = Selenium.browser.findElement(By.cssSelector("ul.visitorTabs"));
        Assert.assertTrue(visitorTabs.isDisplayed());
    }
    @Test
    public void testLoginToSherdog2() {
        Selenium.loginToSherdog("civerxgmail.com", "individual11");
        Assert.assertEquals("https://forums.sherdog.com/login/login", Selenium.browser.getCurrentUrl());
    }
    @After
    public void testClose() {
        Selenium.close();
    }
}
