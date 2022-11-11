package com.reports;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.base.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/**
 * @author Lenovo
 * @Description Used to Reporting
 * @Date 21/08/2022
 */
public class Reporting extends BaseClass {

	/**
	 * @Description Used to generate the report
	 * @param jsonfile
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void generateJVMReport(String jsonfile) throws FileNotFoundException, IOException {
		File file = new File(getPropertyValueConfig("jvmPath"));

		Configuration configuration = new Configuration(file, "OMR Automation");
		configuration.addClassifications("OS", "WIN10");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Version", "104.00");

		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonfile);
		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
		builder.generateReports();

	}

}
