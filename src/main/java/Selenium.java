import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium {
    static WebDriver browser;
    static final int WAIT_TIME_SEC = 2;

    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ".\\.\\drivers\\chromedriver.exe");
        browser = new ChromeDriver();
    }

    public static void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(browser, WAIT_TIME_SEC);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void close() {
        browser.close();
    }

    public static void main(String [] args) {
        setup();
        browser.get("https://forums.sherdog.com");
        WebElement login = browser.findElement(By.linkText("Log in or Sign up"));
        waitForElement(login);
        login.click();
        WebElement inputLogin = browser.findElement(By.cssSelector("input[name=\"login\"]"));
        WebElement inputPassword = browser.findElement(By.cssSelector("input[name=\"password\"]"));
        waitForElement(inputLogin);
        waitForElement(inputPassword);
        inputLogin.sendKeys("civerx@gmail.com");
        inputPassword.sendKeys("individual11");
        inputPassword.submit();

        //close();
    }
}
