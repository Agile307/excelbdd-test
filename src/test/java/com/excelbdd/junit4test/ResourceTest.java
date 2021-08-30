package com.excelbdd.junit4test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.excelbdd.Behavior;
import com.excelbdd.TestWizard;

public class ResourceTest {

	@Test
	public final void test() throws IOException {
		System.out.println(getClass().getResource("/excel.xlsx").getPath());
		System.out.println(getClass().getResource("/excel.xlsx").getFile());
		String filepath = getClass().getResource("/excel.xlsx").getFile();
		System.out.println(Behavior.getExampleList(filepath, "FirstSheet"));
		final String resourcePath = "src/test/resources/excel.xlsx";
		final File file = new File(resourcePath);
		final String absolutePath = file.getAbsolutePath();

		System.out.println(absolutePath);
	}

}
