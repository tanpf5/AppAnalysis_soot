package util;

public class MaliceBehavior {
	
	private String className="";
	
	private String methodName="";
	
	private String maliceDiscribeString="";
	
	private String maliceApi="";
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getMaliceDiscribeString() {
		return maliceDiscribeString;
	}

	public void setMaliceDiscribeString(String maliceDiscribeString) {
		this.maliceDiscribeString = maliceDiscribeString;
	}

	public String getMaliceApi() {
		return maliceApi;
	}

	public void setMaliceApi(String maliceApi) {
		this.maliceApi = maliceApi;
	}
	
	public String getString(){
		return "Position: "+className+"->"+methodName+"    Malice Behavior: "+maliceDiscribeString+"->"+maliceApi;
	}
	
}
