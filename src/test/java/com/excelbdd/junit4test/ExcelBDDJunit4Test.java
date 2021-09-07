package com.excelbdd.junit4test;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.excelbdd.Behavior;
import com.excelbdd.TestWizard;

@RunWith(Parameterized.class)
public class ExcelBDDJunit4Test {
	
	Map<String, String> parameterMap;

	@Parameters
	public static Collection<Object[]> prepareData() throws IOException {
		String filePath = "src/test/resources/excel.xlsx";
		return Behavior.getExampleCollection(filePath, "FirstSheet");
	}

	public ExcelBDDJunit4Test(Map<String, String> map) {
		this.parameterMap = map;
	}

	@Test
	public void testLoadData() {
		TestWizard.showMap(this.parameterMap);
	}
}
