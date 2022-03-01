package org.softwareonpurpose.gauntlet;

import com.softwareonpurpose.calibrator4test.Calibrator;
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
    private String testName;
    private List<String> requirements = new ArrayList<>();

    protected GauntletTest() {
        WebUiHost.getInstance(ChromeUiDriver.getInstance());
    }

    @BeforeClass(alwaysRun = true)
    protected void initialize() {
        feature = this.getClass().getSimpleName().replace("Tests", "");
    }

    @BeforeMethod(alwaysRun = true)
    protected void initializeTest(Method method) {
        testName = method.getName();
        System.out.println(String.format("Executing %s...", testName));
    }

    @AfterMethod(alwaysRun = true)
    protected void terminateTest(ITestResult result) {
        Object[] scenarios = result.getParameters();
        scenarios = scenarios.length == 0 ? null : scenarios;
        String feature = result.getTestClass().getRealClass().getSimpleName().replace("Tests", "");
        for (String requirement : requirements) {
            reportManager.addRequirementTestEntry(testName, feature, scenarios, requirement);
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

    public static class TestSuite {
        public static final String SMOKE = "smoke";
    }
}
