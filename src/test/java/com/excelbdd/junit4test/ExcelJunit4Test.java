package com.excelbdd.junit4test;

import static org.junit.Assert.*;

import java.io.File;
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
public class ExcelJunit4Test {
	
	Map<String, String> parameterMap;

	@Parameters
	public static Collection<Object[]> prepareData() throws IOException {
		String filePath = "src/test/resources/excel.xlsx";
		return TestWizard.getExampleCollection(Behavior.getExampleList(filePath, "FirstSheet"));
	}

	public ExcelJunit4Test(Map<String, String> map) {
		this.parameterMap = map;
	}

	@Test
	public void testLoadData() {
		TestWizard.showMap(this.parameterMap);
	}




}
