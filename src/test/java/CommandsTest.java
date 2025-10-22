import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CommandsTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void commandsTest() {
        System.out.println("--- Starting Dynamic Controls Test ---");
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        // Selector for the "Enable/Disable" button inside the Input field section
        By enableDisableButton = By.cssSelector("#input-example button");
        By inputField = By.cssSelector("#input-example input[type='text']");
        By messageArea = By.id("message");

        WebElement button = driver.findElement(enableDisableButton);
        Assert.assertEquals(button.getText(), "Enable", "Check: Initial button text should be 'Enable'.");

        button.click();
        System.out.println("Clicked 'Enable' button. Waiting for input field activation...");

        // Wait until the input field becomes clickable (enabled)
        wait.until(ExpectedConditions.elementToBeClickable(inputField));

        WebElement field = driver.findElement(inputField);
        WebElement message = driver.findElement(messageArea);

        // Check: Input field is enabled and success message text is correct
        Assert.assertTrue(field.isEnabled(), "Check: Input field is NOT enabled.");
        wait.until(ExpectedConditions.textToBePresentInElement(message, "It's enabled!"));
        Assert.assertEquals(message.getText(), "It's enabled!", "Check: Success message is incorrect.");

        System.out.println("→ Input field enabled and text visible");

        // Check: Button text changed to "Disable"
        wait.until(ExpectedConditions.textToBePresentInElement(button, "Disable"));
        Assert.assertEquals(button.getText(), "Disable", "Check: Button text did not change to 'Disable'.");
        System.out.println("→ Button text changed successfully");

        // Enter and clear text
        field.sendKeys("Bootcamp");
        Assert.assertEquals(field.getAttribute("value"), "Bootcamp", "Check: Text was not entered correctly.");
        field.clear();
        Assert.assertTrue(field.getAttribute("value").isEmpty(), "Check: Input field was not cleared.");
        System.out.println("Entered 'Bootcamp' and field cleared.");

        System.out.println("\n--- Starting Drag and Drop Test ---");
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");

        WebElement columnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));

        // Get Y-coordinates
        int columnAY = columnA.getLocation().getY();
        int columnBY = columnB.getLocation().getY();

        // Check if Y-coordinates match (horizontal alignment)
        Assert.assertEquals(columnAY, columnBY,
                String.format("Check: Y coordinates of columns A and B do not match. A: %d, B: %d", columnAY, columnBY));
        System.out.println("→ Columns A and B aligned successfully");
        System.out.println("--- All tests passed successfully! ---");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
