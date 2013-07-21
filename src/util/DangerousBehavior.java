package util;

import java.util.ArrayList;
import java.util.List;

public class DangerousBehavior {
	
	private MethodEntity initMethod = new MethodEntity();
	
	private List<MethodEntity> curMethods= new ArrayList<MethodEntity>();
	
	private List<MethodEntity> nextMethods= new ArrayList<MethodEntity>();
	
	private String discribeString="";
	
	private String api="";
	
	public MethodEntity getInitMethod() {
		return initMethod;
	}

	public void setInitMethod(MethodEntity initMethod) {
		this.initMethod = initMethod;
	}

	public List<MethodEntity> getCurMethods() {
		return curMethods;
	}

	public void setCurMethods(List<MethodEntity> curMethods) {
		this.curMethods = curMethods;
	}

	public List<MethodEntity> getNextMethods() {
		return nextMethods;
	}

	public void setNextMethods(List<MethodEntity> nextMethods) {
		this.nextMethods = nextMethods;
	}

	public String getDiscribeString() {
		return discribeString;
	}

	public void setDiscribeString(String maliceDiscribeString) {
		this.discribeString = maliceDiscribeString;
	}

	public String getApi() {
		return api;
	}

	public void setApi(String maliceApi) {
		this.api = maliceApi;
	}
	
}
