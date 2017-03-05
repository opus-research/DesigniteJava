package DesigniteTests;

import static org.junit.Assert.*;

import org.junit.Test;

import Designite.InputArgs;
import Designite.SourceModel.SM_Project;

public class SM_ProjectTest {
	//Set this path before executing tests
	private static String TESTS_PATH = "C:\\Users\\Alex\\workspace\\DesigniteJava\\tests\\TestFiles";
	
	@Test
	public void testSM_Project_positive_case() {
		SM_Project project = new SM_Project(new InputArgs(TESTS_PATH + "\\inBatchFile.txt"));
		project.parse();
		assertEquals(project.getPackageCounter(), 2);
	}
	
	@Test
	public void testSM_Project_input_nullObj() {
		SM_Project project = new SM_Project(null);
		project.parse();
	}
	
	@Test
	public void testSM_Project_nullSourceFileList() {
		SM_Project project = new SM_Project(new InputArgs(TESTS_PATH + "\\testBatchFile.txt"));
		project.setSourceFileList(null);
		project.parse();
	}
	
	@Test(expected = NullPointerException.class)
	public void testSM_Project_nullCU() {
		SM_Project project = new SM_Project(new InputArgs(TESTS_PATH + "\\testBatchFile.txt"));
		project.setCompilationUnitList(null);
		project.parse();
	}
	
/*	@Test
	public void testSM_Project_null() {
		SM_Project project = new SM_Project(new InputArgs("C:\\Users\\Alex\\Desktop\\null.txt"));
		project.parse();
	}*/
	
	@Test
	public void testSM_Project_sourceFilesCounter() {
		SM_Project project = new SM_Project(new InputArgs(TESTS_PATH + "\\testBatchFile.txt"));
		project.parse();
		assertEquals(project.getSourceFileList().size(), 3);
	}
	
	@Test
	public void testSM_Project_cuCounter() {
		SM_Project project = new SM_Project(new InputArgs(TESTS_PATH + "\\testBatchFile.txt"));
		project.parse();
		assertEquals(project.getCompilationUnitList().size(), 3);
	}
	
	@Test
	public void testSM_Project_packageCounter() {
		SM_Project project = new SM_Project(new InputArgs(TESTS_PATH + "\\testBatchFile.txt"));
		project.parse();
		assertEquals(project.getPackageCounter(), 2);
	}
}
