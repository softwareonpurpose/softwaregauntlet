package org.softwareonpurpose.gauntlet;

import com.softwareonpurpose.uinavigator.web.WebUiHost;
import org.apache.commons.io.FileUtils;
import org.softwareonpurpose.coverage4test.CoverageReport;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

@Test
public abstract class GauntletTest {
    private static final CoverageReport reportManager = CoverageReport.getInstance();
    private String feature;
    private String method;

    protected GauntletTest() {
        WebUiHost.getInstance(ChromeUiDriver.getInstance());
    }

    @BeforeClass(alwaysRun = true)
    protected void initialize() {
        feature = this.getClass().getSimpleName().replace("Tests", "");
    }

    @BeforeMethod(alwaysRun = true)
    protected void storeTestName(Method method) {
        this.method = method.getName();
    }

    @AfterMethod(alwaysRun = true)
    protected void terminateTest(ITestResult result) {
        WebUiHost.quitInstance();
    }

    @AfterClass(alwaysRun = true)
    protected synchronized void reportClass() {
        File reportFolder = new File("reports");
        File[] reports = reportFolder.listFiles();
        if (reports != null) {
            for (File file : reports) {
                file.delete();
            }
            reportFolder.delete();
        }
        boolean mkdir = reportFolder.mkdir();
        File systemReport = new File("reports/system_coverage.rpt");
        try {
            FileUtils.writeStringToFile(systemReport, reportManager.getSystemCoverage(), StandardCharsets.UTF_8);
            boolean newFile = systemReport.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
