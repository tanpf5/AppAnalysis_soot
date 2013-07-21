package util;

public class SecureRule {
	
	public static final String SECURE_RULE = "securerule";
	public static final String ATTR_CLASSNAME = "classname";
	public static final String ATTR_APINAME = "apiname";
	public static final String ATTR_DISCRIBESTRING = "discribeString";
	
	private String className="";
	
	private String apiName="";
	
	private String discribeString="";

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public String getDiscribeString() {
		return discribeString;
	}

	public void setDiscribeString(String discribeString) {
		this.discribeString = discribeString;
	}

}
