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

import static org.junit.Assert.*;

public class CadastroUsuarioTest {
    private static WebDriver driver;
    private UsuarioDaoImpl usuarioDao;

    @BeforeClass
    public static void setUpTest(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
    }

    @Before
    public void setUp() {
        driver.get("http://localhost:8081/needhotel.com/cadastrar");
    }

    @AfterClass
    public static void tearDownTest(){
        driver.quit();
    }

    @Test
    public void cadastroUsuarioValido() throws InterruptedException {
        WebElement element = driver.findElement(By.name("primeiroNome"));
        element.sendKeys("Daniel");
        element = driver.findElement(By.name("sobrenome"));
        element.sendKeys("Alves");
        element = driver.findElement(By.name("cpf"));
        element.sendKeys("387.776.138-05");
        element = driver.findElement(By.name("telefone"));
        element.sendKeys("(83) 99607-4974");
        element = driver.findElement(By.name("nascimento"));
        element.sendKeys("07/02/1999");
        element = driver.findElement(By.id("btnCadastrar"));
        element.click();
        element = driver.findElement(By.name("foto"));
        element.sendKeys("/home/danielalves/thumb-1920-144565.jpg");
        element = driver.findElement(By.name("email"));
        element.sendKeys("danielalveslima36@gmail.com");
        element = driver.findElement(By.name("senha"));
        element.sendKeys("1234");
        element = driver.findElement(By.name("conSenha"));
        element.sendKeys("1234");
        element = driver.findElement(By.id("cadastrar"));
        element.click();
        element = driver.findElement(By.id("register"));
        assertNotNull(element);
    }

    @Test
    public void cadastroUsuarioCpfCadastrado(){
        WebElement element = driver.findElement(By.name("primeiroNome"));
        element.sendKeys("Alex");
        element = driver.findElement(By.name("sobrenome"));
        element.sendKeys("Almeida");
        element = driver.findElement(By.name("cpf"));
        element.sendKeys("387.776.138-05");
        element = driver.findElement(By.name("telefone"));
        element.sendKeys("(83) 99999-9999");
        element = driver.findElement(By.name("nascimento"));
        element.sendKeys("30/09/1999");
        element = driver.findElement(By.id("btnCadastrar"));
        element.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        element = driver.findElement(By.id("cpfErro"));
        assertNotNull(element);
    }

}
