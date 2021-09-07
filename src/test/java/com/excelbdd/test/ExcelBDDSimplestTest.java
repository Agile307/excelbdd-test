package com.excelbdd.test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import com.excelbdd.Behavior;
import com.excelbdd.TestWizard;

class ExcelBDDSimplestTest {

	static Stream<Map<String, String>> provideExampleList() throws IOException {
		String filePath = "src/test/resources/excel.xlsx";
		return Behavior.getExampleStream(filePath);
	}

	@ParameterizedTest(name = "Test{index}:{0}")
	@MethodSource("provideExampleList")
	void testgetExampleFrom1stSheet(Map<String, String> parameterMap) {
		assertNotNull(parameterMap.get("Header"));
		for (Map.Entry<String, String> param : parameterMap.entrySet()) {
			System.out.println(String.format("%s --- %s", param.getKey(), param.getValue()));
		}
	}
}
