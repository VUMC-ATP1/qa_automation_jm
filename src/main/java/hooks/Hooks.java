package hooks;

import io.cucumber.java.After;
import utils.WebDriverManager;

public class Hooks {

    @After
        public void tearDown(){
        WebDriverManager.closeBrowser();
    }
}
