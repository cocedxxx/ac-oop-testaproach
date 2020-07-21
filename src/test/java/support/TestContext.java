package support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestContext {

    private static WebDriver driver;
//    private static String timestamp;
//    private static Map<String,Object> testData = new HashMap<>();

    public static WebDriver getDriver(){
        return driver;
    }
//    public static void setTimestamp(){
//        SimpleDateFormat dateFormat = new SimpleDateFormat("+yyyy-MM-dd-h-mm-sss");
//        timestamp = dateFormat.format(new Date());
//    }
//    public static String getTimestamp(){
//        return timestamp;
//    }
    public static Actions getActions(){
        return new Actions(driver);
    }
    public static WebDriverWait getWait(){
        return getWait(getConfig().explicitTimeout);
    }
    public static WebDriverWait getWait(int timeout) {
        return new WebDriverWait(driver, timeout);
    }
    public static Config getConfig(){
        try {
            String configPath = System.getProperty("user.dir") + "/src/test/resources/data/config.yml";
            return new Yaml().load(new FileInputStream(new File(configPath)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static JavascriptExecutor getExecuter() {
        return (JavascriptExecutor) getDriver();
    }

    public static void initialize() {
//        setTimestamp();
        initialize(getConfig().browser, "local", getConfig().isHeadless);
    }
    public static void teardown() {
        driver.quit();
    }

    public static void initialize(String browser, String testEnv, boolean isHeadless) {
        Dimension size = new Dimension(1920, 1080);
        Point position = new Point(0, 0);
        if (testEnv.equals("local")) {
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    Map<String, Object> chromePreferences = new HashMap<>();
                    chromePreferences.put("profile.default_content_settings.geolocation", 2);
                    chromePreferences.put("download.prompt_for_download", false);
                    chromePreferences.put("download.directory_upgrade", true);
                    chromePreferences.put("credentials_enable_service", false);
                    chromePreferences.put("password_manager_enabled", false);
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.setExperimentalOption("prefs", chromePreferences);
                    System.setProperty("webdriver.chrome.silentOutput", "true");
                    if (isHeadless) {
                        chromeOptions.setHeadless(true);
                        chromeOptions.addArguments("--window-size=1920,1080");
                        chromeOptions.addArguments("--disable-gpu");
                    }
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (isHeadless) {
                        FirefoxBinary firefoxBinary = new FirefoxBinary();
                        firefoxBinary.addCommandLineOptions("--headless");
                        firefoxOptions.setBinary(firefoxBinary);
                    }
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "grid":
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setBrowserName(BrowserType.CHROME);
                    capabilities.setPlatform(Platform.ANY);
                    URL hubUrl = null;
                    try {
                        hubUrl = new URL("http://localhost:4444/wd/hub");
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    driver = new RemoteWebDriver(hubUrl, capabilities);
                    break;
                default:
                    throw new RuntimeException("Driver is not implemented for: " + browser);
            }
        }
    }
    private static String getDriversDirPath() {
        return System.getProperty("user.dir") + String.format("%1$ssrc%1$stest%1$sresources%1$sdrivers%1$s", File.separator);
    }
    private static String getDownloadsPath() {
        return System.getProperty("user.dir") + String.format("%1$ssrc%1$stest%1$sresources%1$sdownloads%1$s", File.separator);
    }
}