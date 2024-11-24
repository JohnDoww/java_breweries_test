package apiTests;

import dataGenerator.TestData;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import utils.ProjectInfo;

/**
 * Base class which we inherit to perform some default actions after/before whole test suite or after each test.
 * Also, we need it to reduce duplication the method and initialisation within test classes.
 */
public class BaseApiTest {
    public BaseApiTest() {
        projectInfo = new ProjectInfo();
        endpoints = projectInfo.new Endpoints();
        requirements = projectInfo.new Requirements();
        testData = new TestData();
    }

    protected ProjectInfo projectInfo;
    protected ProjectInfo.Endpoints endpoints;
    protected ProjectInfo.Requirements requirements;
    protected  TestData testData;


    @BeforeMethod
    public void setupEnvBeforeRunningTests() {
        System.out.println("Generate Data");
    }

    @AfterSuite
    public void cleaningAfterTests() {
        System.out.println("Clean Up Data");

    }
}
