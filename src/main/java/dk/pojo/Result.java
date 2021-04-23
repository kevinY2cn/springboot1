package dk.pojo;

public class Result {
	
	private STATUS_CODE statusCode;
	
	private String resultMessage;
	
	private Object resultObject;
	
	public static enum STATUS_CODE {SUCCESS,FAILED}
	
	
	public Result(STATUS_CODE statusCode,String resultMessage,Object resultObject) {
		this.statusCode = statusCode;
		this.resultMessage = resultMessage;
		this.resultObject = resultObject;
	}

	public Result() {
	}

	public STATUS_CODE getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(STATUS_CODE statusCode) {
		this.statusCode = statusCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public Object getResultObject() {
		return resultObject;
	}

	public void setResultObject(Object resultObject) {
		this.resultObject = resultObject;
	}
	
	
	

}
