package org.softwareonpurpose.gauntlet;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.uinavigator.UiDriver;
import com.softwareonpurpose.uinavigator.web.WebUiHost;
import org.apache.commons.io.FileUtils;
import org.softwareonpurpose.coverage4test.CoverageReport;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Test
public abstract class GauntletTest {
    private static final CoverageReport reportManager = CoverageReport.getInstance();
    private String feature;
    private String method;
    private String testName;
    private List<String> requirements = new ArrayList<>();

    protected GauntletTest() {
        String host = System.getProperty("host");
        UiDriver uiDriver;
        if (host == null) {
            uiDriver = ChromeUiDriver.getInstance();
        } else if (host.equals("saucelabs")) {
            uiDriver = SauceLabsUiDriver.getInstance();
        } else {
            uiDriver = ChromeUiDriver.getInstance();
        }
        WebUiHost.getInstance(uiDriver);
    }

    @BeforeClass(alwaysRun = true)
    protected void initialize() {
        feature = this.getClass().getSimpleName().replace("Tests", "");
    }

    @BeforeMethod(alwaysRun = true)
    protected void initializeTest(Method method) {
        testName = method.getName();
        System.out.printf("Executing %s...%n", testName);
    }

    @AfterMethod(alwaysRun = true)
    protected void terminateTest(ITestResult result) {
        Object[] scenarios = result.getParameters();
        scenarios = scenarios.length == 0 ? null : scenarios;
        if (requirements.size() > 1) {
            for (String requirement : requirements) {
                reportManager.addRequirementTestEntry(testName, feature, scenarios, requirement);
            }
        } else {
            reportManager.addTestEntry(testName, feature, scenarios);
        }
        WebUiHost.quitInstance();
    }

    @AfterClass(alwaysRun = true)
    protected synchronized void reportClass() {
        String coverageFolder = "build/reports/coverage";
        File systemReport = new File(String.format("%s/system/%s.system.rpt", coverageFolder, feature));
        File requirementsReport = new File(String.format("%s/requirements/%s.requirements.rpt", coverageFolder, feature));
        try {
            FileUtils.writeStringToFile(systemReport, reportManager.getSystemCoverage(), StandardCharsets.UTF_8);
            FileUtils.writeStringToFile(requirementsReport, reportManager.getRequirementsCoverage(), StandardCharsets.UTF_8);
            boolean newFile = systemReport.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void then(Calibrator calibrator) {
        Assert.assertEquals(calibrator.calibrate(), Calibrator.SUCCESS);
    }

    protected void addRequirements(String... requirements) {
        this.requirements.addAll(Arrays.asList(requirements));
    }

    public static class Application {
        public static final String INSURANCE_APPLICATION = "insurance_application";
    }

    public static class View {
        public static final String ZIP_ROUTER = "zip_router";
        public static final String SHORT_FORM = "short_form";
        public static final String CONTACT = "contact";
    }

    public static class TestSuite {
        public static final String SMOKE = "smoke";
        public static final String ACCEPTANCE = "acceptance";
    }
}
