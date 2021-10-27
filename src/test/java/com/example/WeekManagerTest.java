package com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.excelbdd.Behavior;
import com.excelbdd.TestWizard;

class WeekManagerTest {

	static Stream<Map<String, String>> provideExampleList() throws IOException {
		String filePath = "src/test/resources/excel.xlsx";
		return Behavior.getExampleStream(filePath, "FridayCheck");
	}

	@ParameterizedTest(name = "#{index} - Test with Map : {0}")
	@MethodSource("provideExampleList")
	final void test(Map<String, String> mapParams) {
		TestWizard.showMap(mapParams);
		String actualAnswer = WeekManager.isFriday(mapParams.get("Day"));
		assertEquals(mapParams.get("Answer"), actualAnswer);

	}

}
