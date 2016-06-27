package failedTestCase;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class Runner {

	public static void main(String[] args) {
		TestNG failed =new TestNG();
		List<String> list = new ArrayList<>();
		list.add("D:\\Selenium\\Jd\\OnlineStore\\test-output\\testng-failed.xml");
		failed.setTestSuites(list);
		failed.run();
					
	}

}
