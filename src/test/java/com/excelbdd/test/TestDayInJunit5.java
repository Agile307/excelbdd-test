package com.excelbdd.test;


import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.excelbdd.Behavior;
import com.excelbdd.TestWizard;

class TestDayInJunit5 {

	static Stream<Map<String, String>> provideExampleList() throws IOException {
		String filePath = TestWizard.getExcelBDDStartPath("excelbdd-test")
				+ "excelbdd-test\\src\\test\\resources\\excel.xlsx";
		return Behavior.getExampleStream(filePath, "WeekDayCheck");
	}

	@ParameterizedTest(name = "#{index} - Test with Map : {0}")
	@MethodSource("provideExampleList")
	final void test(Map<String, String> mapParams) {
		String actualAnswer;
		System.out.println("Day " + mapParams.get("Day"));
		System.out.println("DayOfWeek " + mapParams.get("DayOfWeek"));
		System.out.println("Answer " + mapParams.get("Answer"));
		if (mapParams.get("Day").equals(mapParams.get("DayOfWeek"))) {
			actualAnswer = "Yup";
		} else {
			actualAnswer = "Nope";
		}
		assertEquals(mapParams.get("Answer"), actualAnswer);
	}

}
