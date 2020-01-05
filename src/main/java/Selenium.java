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

    public static void waitForURL(String url) {
        WebDriverWait wait = new WebDriverWait(browser, WAIT_TIME_SEC);
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public static void close() {
        browser.close();
    }

    public static void loginToSherdog(String login, String password) {
        browser.get("https://forums.sherdog.com");
        WebElement loginButton = browser.findElement(By.linkText("Log in or Sign up"));
        waitForElement(loginButton);
        loginButton.click();
        WebElement inputLogin = browser.findElement(By.cssSelector("input[name=\"login\"]"));
        WebElement inputPassword = browser.findElement(By.cssSelector("input[name=\"password\"]"));
        waitForElement(inputLogin);
        waitForElement(inputPassword);
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        inputPassword.submit();
    }

    public static void registerSherdog(String login, String password) {
        browser.get("https://forums.sherdog.com");
        WebElement loginButton = browser.findElement(By.linkText("Log in or Sign up"));
        waitForElement(loginButton);
        loginButton.click();
        WebElement inputLogin = browser.findElement(By.cssSelector("input[name=\"login\"]"));
        WebElement inputNotRegistered = browser.findElement(By.xpath("//*[@id=\"ctrl_not_registered\"]"));
        waitForElement(inputNotRegistered);
        inputNotRegistered.click();
        inputLogin.sendKeys(login);
        inputLogin.submit();
        WebElement inputPassword = browser.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/form/fieldset[1]/dl[1]/dd/input"));
        inputPassword.sendKeys(password);
    }

    public static void main(String [] args) {
        setup();
        //loginToSherdog("civerx@gmail.com", "individual11");
        registerSherdog("testName1", "testPassword1");

        //close();
    }
}
