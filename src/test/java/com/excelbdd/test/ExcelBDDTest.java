package com.excelbdd.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.excelbdd.Behavior;
import com.excelbdd.TestWizard;

class ExcelBDDTest {

	@Test
	final void test() throws IOException {
		String filePath = TestWizard.getExcelBDDStartPath("excelbdd-test");
		System.out.println(filePath);
	}

	@Test
	final void testWrongSheet() {

		Exception exception = assertThrows(Exception.class, () -> {
			String filePath = TestWizard.getExcelBDDStartPath("excelbdd-test")
					+ "excelbdd-test\\src\\test\\resources\\excel.xlsx";
			System.out.println(filePath);
			List exampleList = Behavior.getExampleList(filePath, "NotExists");
		});
		System.out.println(exception.getMessage());
		assertTrue(exception.getMessage().contains("NotExists sheet does not exist."));
	}
}
