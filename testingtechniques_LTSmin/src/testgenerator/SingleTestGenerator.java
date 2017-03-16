package testgenerator;

public class SingleTestGenerator {

	private String testCase;
	private TestFileGenerator master;
	
	public SingleTestGenerator(TestFileGenerator master) {
		this.master = master;
	}
	
	public void GenerateTest(String testName, String args[]){
		
		
		
		
		testCase = null;
		generateStart(testName);
		testCase += "\t" + master.getInterface() + " unit*";
		testCase += "\n";
		testCase += "\t" +
				"unit = " + master.getConstructor() + "(" + argsPasstrough(args) + ");";	
	}
	
	public void TestString(String stringFetcher, String target) {
		
	}
	
	public void TestInt(String stringFetcher, int target) {
		
	}
	
	public String FinishTest() {
		generateEnd();
		return testCase;
	}
	
	private void generateStart(String testName){
		testCase += "START_TEST (" + testName + ") \n"
				+ "{\n";
	}
	
	
	private void generateEnd(){
		testCase += "}\n"
				+ "END_TEST\n";		
	}
	
	private String argsPasstrough(String args[]) {
		if (args.length > 0) {
		    StringBuilder nameBuilder = new StringBuilder();

		    for (String n : args) {
		        nameBuilder.append(n).append(", ");
		    }
		    nameBuilder.deleteCharAt(nameBuilder.length() - 1);
		    nameBuilder.deleteCharAt(nameBuilder.length() - 1);

		    return nameBuilder.toString();
		} else {
		    return "";
		}
	}
	
}
