package sistema;

import com.needhotel.modelo.dao.implementacao.UsuarioDaoImpl;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LoginUsuarioTest {

    private static WebDriver driver;
    private UsuarioDaoImpl usuarioDao;

    @BeforeClass
    public static void setUpTest(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
    }

    @Before
    public void setUp() {
        driver.get("http://localhost:8081/needhotel.com/");
    }

    @AfterClass
    public static void tearDownTest(){
        driver.quit();
    }

    @Test
    public void loginEmailInvalido() throws InterruptedException {
        WebElement element = driver.findElement(By.id("lognome"));
        element.sendKeys("daniel@gmail.com");
        element = driver.findElement(By.id("logsenha"));
        element.sendKeys("1234");
        element = driver.findElement(By.id("entrar"));
        element.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        element = driver.findElement(By.id("erro"));
        assertNotNull(element);

    }

    @Test
    public void loginNulo() throws InterruptedException {
        WebElement element = driver.findElement(By.id("lognome"));
        element.sendKeys("");
        Thread.sleep(2000L);
         element = driver.findElement(By.id("logsenha"));
        element.sendKeys("");
        element = driver.findElement(By.id("entrar"));
        element.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        element = driver.findElement(By.id("erro"));
        assertNotNull(element);
    }

    @Test
    public void loginValido(){
        WebElement element = driver.findElement(By.id("lognome"));
        element.sendKeys("danielalveslima36@gmail.com");
        element = driver.findElement(By.id("logsenha"));
        element.sendKeys("1234");
        element = driver.findElement(By.id("entrar"));
        element.click();
        assertEquals("http://localhost:8081/needhotel.com/login", driver.getCurrentUrl());
    }


}
