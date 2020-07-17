package utility;

public class Result {
	
	private String result;
	private String resultText;
	private String screen;
	
	public Result(String result,String resultText, String screen) {
		this.result = result;
		this.resultText = resultText;
		this.screen = screen;
	}
	//Test Execution Result
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getResult() {
		return this.result;
	}
	//Test result message
	public void setResultText(String resultText) {
		this.resultText = resultText;
	}
	
	public String getResultText() {
		return this.resultText;
	}
	//Screenshot of the test execution 
	public void setScreen(String screen) {
		this.screen = screen;
	}
	
	public String getScreen() {
		return this.screen;
	}
}