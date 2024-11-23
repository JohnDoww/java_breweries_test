package apiTests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

/**
 * Base class which we inherit to perform some default actions after/before whole test suite or after each test
 */
public class BaseApiTest {

    @BeforeMethod
    public void setupEnvBeforeRunningTests(){
        System.out.println("Generate Data");
    }

    @AfterSuite
    public void cleaningAfterTests(){
        System.out.println("Clean Up Data");

    }
}
