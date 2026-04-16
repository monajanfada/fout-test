package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public abstract class BaseTest /*implements TestConstants*/ {

    public static final String BASE_URL = "http://panel.lafa.me/";
    public static final String TMP_DIR = System.getProperty("java.io.tmpdir");

    protected Integer maxWaitDurationSeconds = 20;
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public abstract void internalTest() throws Exception;

    @Before
    public void startup() {
        // Initiating your chromedriver
        //String browser = System.getProperty("browser");
        String browser = "firefox";
        if ("firefox".equalsIgnoreCase(browser)) {
            testInFirefox();
        } else {
            testInChrome();
        }
    }

    private void testInFirefox() {
        System.setProperty("webdriver.gecko.driver", "WEB-INF/lib/geckodriver-v0.27.0-win64.exe");

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        //firefoxOptions.setProfile(getFirefoxProfile());
        webDriver = new FirefoxDriver(firefoxOptions);
        afterDriverInitialized();
    }

    private void testInChrome() {
        System.setProperty("webdriver.chrome.driver", "WEB-INF/lib/chromedriver.exe");
//        webDriver = new ChromeDriver();
        String chromeProfile = TMP_DIR;
        ArrayList<String> switches = new ArrayList<>();
        switches.add("--user-data-dir=" + chromeProfile);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.setCapability("chrome.switches", switches);
        webDriver = new ChromeDriver(chromeOptions);
        afterDriverInitialized();
    }

    private void afterDriverInitialized() {
        webDriverWait = new WebDriverWait(webDriver, maxWaitDurationSeconds);
    }

    @Test
    public void test() {
        // Creating WebDriver instance and all setting come here.
        try {
            internalTest();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            webDriver.close();
        }
    }

    @After
    public void tearDown() {
//        if (webDriver != null) {
//            webDriver.quit();
//        }
//        System.out.println("Execution of '" + getClass().getSimpleName() + "' finished.");
    }

    protected void navigateTo(String url) {
        webDriver.navigate().to(BASE_URL + url);
        waitForPageToLoad();
    }

    // public static final String ADMIN_USERNAME = "admin";
    // public static final String ADMIN_PASSWORD = "admin";

    public void login() {
        navigateTo("login");
        type("userName", "admin");
        type("password", "admin");
        click("submitButton");
        webDriver.manage().window().maximize();
    }

    public void type(String id, String value) {
        type(findElementById(id), value);
    }

    public void type(WebElement webElement, String value) {
        webElement.sendKeys(value);
    }

    public WebElement findElementById(String id) {
        return waitForPresenceOfElement(id);
        //return webDriver.findElement(By.id(id));
    }

    public WebElement findElementByClass(String className) {
        WebElement element = webDriver.findElement(By.className(className));
        return element;
    }

    public WebElement getChildElement(String parentId, String childId) {
        return hasText(parentId) ? findElementById(parentId).findElement(By.id(childId)) : findElementById(childId);
    }

    public String getElementAttribute(String id, String attribute) {
        return getElementAttribute(findElementById(id), attribute);
    }

    public String getElementAttribute(WebElement webElement, String attribute) {
        return webElement.getAttribute(attribute);
    }

    public void click(String id) {
        WebElement webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        webElement.click();
    }

    public String getValue(String id) {
        return getElementAttribute(id, "value");
    }

    public String getValue(WebElement webElement) {
        return webElement.getAttribute("value");
    }

    public String getText(String id) {
        WebElement elementById = findElementById(id);
        String text = "";
        for (int tryCount = 0; tryCount < 10; tryCount++) {
            try {
                text = elementById.getText();
                break;
            } catch (StaleElementReferenceException e) {
                // Do Nothing
            }
        }
        return text;
    }

    public String getText(WebElement webElement) {
        return webElement != null ? webElement.getText() : "";
    }

    public List<WebElement> getChildElementById(String parentId) {
        return parentId != null ? webDriver.findElements(By.id(parentId)) : new ArrayList<>();
    }

    public List<WebElement> getChildElementByClass(String parentClass) {
        return parentClass != null ? webDriver.findElements(By.className(parentClass)) : new ArrayList<>();
    }

    public List<WebElement> getSearchTableHeaderElements() {
        String dataTableClass = "MuiTableBody-root";
        waitForPresenceOfElementByClass(dataTableClass);
        WebElement parentElement = findElementByClass(dataTableClass);
        List<WebElement> tableRowElements = parentElement != null ? parentElement.findElements(By.xpath("*")) : new ArrayList<>();
        if (tableRowElements != null && tableRowElements.size() > 0) {
            WebElement headerRow = tableRowElements.get(0);
            List<WebElement> elements = headerRow.findElements(By.tagName("input"));
            return elements;
        }
        return new ArrayList<>();
    }

    public List<WebElement> getSearchTableFirstRow() {
        String dataTableClass = "MuiTableBody-root";
        WebElement parentElement = findElementByClass(dataTableClass);
        List<WebElement> tableRowElements = parentElement != null ? parentElement.findElements(By.xpath("*")) : new ArrayList<>();
        if (tableRowElements != null && tableRowElements.size() > 0) {
            WebElement firstRow = tableRowElements.get(1);
            List<WebElement> elements = firstRow.findElements(By.tagName("td"));
            return elements;
        }
        return new ArrayList<>();
    }

    public void waitForFixedDuration(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new AssertionError("Failed after waiting " + milliseconds + " milliseconds.");
        }
    }

    protected void waitForPageToLoad() {
        webDriverWait.until(ExpectedConditions.jsReturnsValue("return document.readyState=='complete';"));
        waitForFixedDuration(1000);
    }

    public WebElement waitForPresenceOfElement(String id) {
        WebElement webElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
        if (webElement == null) {
            System.out.println("Error! Element with id " + id + " not found.");
        }
        return webElement;
    }

    public WebElement waitForPresenceOfElementByClass(String className) {
        WebElement webElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className(className)));
        if (webElement == null) {
            System.out.println("Error! Element with className " + className + " not found.");
        }
        return webElement;
    }

    public WebElement waitForVisibilityOfElement(String id) {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }


    public void checkText(String id, String text) {
        checkText(findElementById(id), text);
    }

    public void checkText(WebElement webElement, String text) {
        String targetText = getText(webElement);
        if (hasText(text)) {
            return;
        }
        assertEquals(text, targetText);
    }

    public void clickMenu(Menu menu) {
        if (menu != null) {
            if (menu.getParentMenu() != null) {
                clickMenu(menu.getParentMenu());
                click(menu.getMenuId());
            } else {
                click(menu.getMenuId());
            }
        }
    }

    public void clear(String id) {
        clear(findElementById(id));
    }

    public void clear(WebElement webElement) {
        String bodyText;
        do {
            bodyText = webElement.getAttribute("value");
            for (int i = 0; i < bodyText.length(); i++) {
                webElement.sendKeys(Keys.BACK_SPACE.toString());
            }
        } while (hasText(bodyText));
    }

    public boolean hasText(Object object) {
        return object != null && object.toString().trim().length() > 0;
    }

    public void selectDropDownListByLabel(String id, String label) {
        WebElement div = findElementById(id).findElement(By.xpath(".."));
        div.click();
        waitForFixedDuration(500); // Options Open Animation Duration.
        WebElement option = webDriver.findElement(By.xpath("//ul[@role=\"listbox\"]/li[text()='" + label + "']"));
        option.click();
        waitForFixedDuration(500); // Options Close Animation Duration.
    }

}
