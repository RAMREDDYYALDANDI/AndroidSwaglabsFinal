package Reports;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentreportsNG {
	
	public static ExtentReports configextentreports()
	{
		String path = System.getProperty("user.dir")+ File.separator+"reports"+File.separator+"index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setReportName("yaldandi Ram Reddy");
		report.config().setDocumentTitle("Extent Reports");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Ram Reddy Yaldandi");
		return extent;
	}

}
