package util;

public class MethodEntity {
	
	private String className = "";
	
	private String methodName = "";
	
	private boolean methodCalledByNull = true;
	
	private boolean methodCalledByWhite = false;
	
	private boolean methodCalledByBlack = false;

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
	
	public boolean isMethodCalledByNull() {
		return methodCalledByNull;
	}

	public void setMethodCalledByNull(boolean methodCalledByNull) {
		this.methodCalledByNull = methodCalledByNull;
	}

	public boolean isMethodCalledByWhite() {
		return methodCalledByWhite;
	}

	public void setMethodCalledByWhite(boolean methodCalledByWhite) {
		this.methodCalledByWhite = methodCalledByWhite;
	}

	public boolean isMethodCalledByBlack() {
		return methodCalledByBlack;
	}

	public void setMethodCalledByBlack(boolean methodCalledByBlack) {
		this.methodCalledByBlack = methodCalledByBlack;
	}
	
	public void resetFlags(){
		methodCalledByNull = true;
		methodCalledByWhite = false;
		methodCalledByBlack = false;
	}
	
}
