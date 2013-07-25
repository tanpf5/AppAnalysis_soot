package decompiler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import soot.Body;
import soot.BodyTransformer;
import soot.PackManager;
import soot.Transform;
import soot.Unit;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.UnitGraph;
import util.DangerousBehavior;
import util.MaliceBehavior;
import util.MethodEntity;
import util.ReleaseException;
import util.SecureRule;
import util.WhitelistItem;

public class TestSoot {

	// 安全规则集合
	private List<SecureRule> secureRules = new ArrayList<SecureRule>();

	// 白名单集合
	private List<WhitelistItem> whiteList = new ArrayList<WhitelistItem>();

	// 风险行为集合
	private List<DangerousBehavior> dangerousBehaviors = new ArrayList<DangerousBehavior>();
	
	// 恶意行为集合
	private List<MaliceBehavior> maliceBehaviors = new ArrayList<MaliceBehavior>();


	private List<Body> bodyList = new ArrayList<Body>();

	public String[] run() throws ReleaseException {

		int size = 8;
		String[] soot_args = new String[size];
		soot_args[0] = "-process-dir";
		soot_args[1] = "release";
		soot_args[2] = "-keep-line-number";
		soot_args[3] = "-cp";
		soot_args[4] = "release;;android.jar;android-support-v4.jar;";
		// format
		soot_args[5] = "-f";
		soot_args[6] = "n";
		soot_args[7] = "-allow-phantom-refs";

		// 获取安全规则
		secureRules = getSecureRules();

		// 获取白名单
		whiteList = getWhitelist();

		// 初次分析，记录所有风险行为
		if (!secureRules.isEmpty()) {
			System.out
					.println("**********************初次分析**************************");
			analysis();
		}

		try {
			soot.Main.main(soot_args);
		} catch (Exception e) {
			throw new ReleaseException();
		}
		
		// 二次分析，从风险行为中筛选出恶意行为
		int i = 1;
		while (!dangerousBehaviors.isEmpty()) {
			System.out
					.println("**********************二次分析**************************"
							+ i);
			checkDangerousBehavior();
			i++;
		}

		// 输出分析结果
		outputResult();
		return getResult();
	}

	private String[] getResult() {
		String[] result = new String[31];
		int[] count = new int[31];
		if (!maliceBehaviors.isEmpty()) {
			int size = maliceBehaviors.size();
			for (int i = 0; i < size; i++) {
				MaliceBehavior maliceBehavior = maliceBehaviors.get(i);
				if (maliceBehavior.getString().contains("发送短信")) {
					count[0] = count[0] + 1;
				} else if (maliceBehavior.getString().contains("发送多人短信")) {
					count[1] = count[1] + 1;
				} else if (maliceBehavior.getString().contains("连接网络")) {
					count[2] = count[2] + 1;
				} else if (maliceBehavior.getString().contains("获取电话状态")) {
					count[3] = count[3] + 1;
				} else if (maliceBehavior.getString().contains("获取手机位置")) {
					count[4] = count[4] + 1;
				} else if (maliceBehavior.getString().contains("获取唯一的设备ID")) {
					count[5] = count[5] + 1;
				} else if (maliceBehavior.getString().contains("获取设备的软件版本号")) {
					count[6] = count[6] + 1;
				} else if (maliceBehavior.getString().contains("获取手机号")) {
					count[7] = count[7] + 1;
				} else if (maliceBehavior.getString().contains("获取附近的电话的信息")) {
					count[8] = count[8] + 1;
				} else if (maliceBehavior.getString().contains("获取ISO标准的国家码")) {
					count[9] = count[9] + 1;
				} else if (maliceBehavior.getString()
						.contains("获取MCC+MNC(SIM)")) {
					count[15] = count[15] + 1;
				} else if (maliceBehavior.getString().contains("获取当前已注册的用户的名字")) {
					count[11] = count[11] + 1;
				} else if (maliceBehavior.getString().contains("获取当前的网络类型")) {
					count[12] = count[12] + 1;
				} else if (maliceBehavior.getString().contains("获取手机类型")) {
					count[13] = count[13] + 1;
				} else if (maliceBehavior.getString().contains("获取IＳＯ国家码")) {
					count[14] = count[14] + 1;
				} else if (maliceBehavior.getString().contains("获取MCC+MNC")) {
					count[10] = count[10] + 1;
				} else if (maliceBehavior.getString().contains("获取服务商名称")) {
					count[16] = count[16] + 1;
				} else if (maliceBehavior.getString().contains("获取SIM卡的序列号")) {
					count[17] = count[17] + 1;
				} else if (maliceBehavior.getString().contains("获取SIM的状态信息")) {
					count[18] = count[18] + 1;
				} else if (maliceBehavior.getString().contains("获取唯一的用户ID")) {
					count[19] = count[19] + 1;
				} else if (maliceBehavior.getString().contains("获取语音邮件的标签")) {
					count[20] = count[20] + 1;
				} else if (maliceBehavior.getString().contains("获取语音邮件号码")) {
					count[21] = count[21] + 1;
				} else if (maliceBehavior.getString().contains("获取用户位置信息")) {
					count[22] = count[22] + 1;
				} else if (maliceBehavior.getString().contains("读取设备通讯录")) {
					count[23] = count[23] + 1;
				} else if (maliceBehavior.getString().contains("读取通话记录")) {
					count[24] = count[24] + 1;
				} else if (maliceBehavior.getString().contains("读取用户短信息")) {
					count[25] = count[25] + 1;
				} else if (maliceBehavior.getString().contains("获取GPS现在的状态")) {
					count[26] = count[26] + 1;
				} else if (maliceBehavior.getString().contains("打开GPS")) {
					count[27] = count[27] + 1;
				} else if (maliceBehavior.getString().contains("获取root权限")) {
					count[28] = count[28] + 1;
				} else if (maliceBehavior.getString().contains("终止其他进程")) {
					count[29] = count[29] + 1;
				} else if (maliceBehavior.getString().contains("终止服务")) {
					count[30] = count[30] + 1;
				}
			}
			for (int i = 0; i < count.length; i++) {
				result[i] = String.valueOf(count[i]);
			}
		} else {
			for (int i = 0; i < result.length; i++) {
				result[i] = String.valueOf(0);
			}
		}
		return result;
	}

	// 获取安全规则
	private List<SecureRule> getSecureRules() {

		ArrayList<SecureRule> secureRules = new ArrayList<SecureRule>();

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder db = factory.newDocumentBuilder();
			Document doc = db.parse(new File("secure_rules.xml"));
			Element elmtInfo = doc.getDocumentElement();
			NodeList ruleNodeList = elmtInfo
					.getElementsByTagName(SecureRule.SECURE_RULE);
			for (int i = 0; i < ruleNodeList.getLength(); i++) {

				SecureRule rule = new SecureRule();

				Node ruleNode = ruleNodeList.item(i);
				NodeList ruleAttrNodeList = ruleNode.getChildNodes();
				for (int j = 0; j < ruleAttrNodeList.getLength(); j++) {
					Node ruleAttrNode = ruleAttrNodeList.item(j);
					if (ruleAttrNode.getNodeType() == Node.ELEMENT_NODE
							&& ruleAttrNode.getNodeName().equals(
									SecureRule.ATTR_CLASSNAME)) {
						rule.setClassName(ruleAttrNode.getTextContent());
					} else if (ruleAttrNode.getNodeType() == Node.ELEMENT_NODE
							&& ruleAttrNode.getNodeName().equals(
									SecureRule.ATTR_APINAME)) {
						rule.setApiName(ruleAttrNode.getTextContent());
					} else if (ruleAttrNode.getNodeType() == Node.ELEMENT_NODE
							&& ruleAttrNode.getNodeName().equals(
									SecureRule.ATTR_DISCRIBESTRING)) {
						rule.setDiscribeString(ruleAttrNode.getTextContent());
					}
				}

				secureRules.add(rule);
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return secureRules;
	}

	// 获取白名单
	private List<WhitelistItem> getWhitelist() {

		ArrayList<WhitelistItem> whiteList = new ArrayList<WhitelistItem>();

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder db = factory.newDocumentBuilder();
			Document doc = db.parse(new File("white_list.xml"));
			Element elmtInfo = doc.getDocumentElement();
			NodeList whiteNodeList = elmtInfo
					.getElementsByTagName(WhitelistItem.WHITELIST_ITEM);
			for (int i = 0; i < whiteNodeList.getLength(); i++) {
				WhitelistItem whitelistItem = new WhitelistItem();

				Node whiteNode = whiteNodeList.item(i);
				whitelistItem.setMethodName(whiteNode.getTextContent());

				whiteList.add(whitelistItem);
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return whiteList;
	}

	// 初次分析，记录所有风险行为
	private void analysis() {

		PackManager.v().getPack("jtp")
				.add(new Transform("jtp.myInstrumenter", new BodyTransformer() {
					@Override
					protected void internalTransform(final Body b,
							String phaseName,
							@SuppressWarnings("rawtypes") Map options) {

						bodyList.add(b);

						UnitGraph graph = new ExceptionalUnitGraph(b);
						Iterator<Unit> gIt = graph.iterator();
						while (gIt.hasNext()) {
							Unit u = gIt.next();
							String unitString = u.toString();

							int size = secureRules.size();
							for (int i = 0; i < size; i++) {
								SecureRule secureRule = secureRules.get(i);
								String className = secureRule.getClassName();
								String apiName = secureRule.getApiName();

								if (unitString.contains(className)
										&& unitString.contains(apiName)) {
									recordDangerousBehavior(b, secureRule);
								}
							}
						}
					}
				}));
	}

	// 记录风险行为
	private void recordDangerousBehavior(Body b, SecureRule rule) {

		int whiteListSize = whiteList.size();
		for (int whiteIndex = 0; whiteIndex < whiteListSize; whiteIndex++) {
			// 对匹配项进行白名单循环
			WhitelistItem whiteItem = whiteList.get(whiteIndex);
			String whiteItemMethod = whiteItem.getMethodName();
			if (b.getMethod().getName().equals(whiteItemMethod)) {
				return;
			}
		}
		System.out.println("------------记录风险行为-------------Method:"
				+ b.getMethod().getName() + "   danger:"
				+ rule.getDiscribeString());
		DangerousBehavior dangerousBehavior = new DangerousBehavior();

		MethodEntity method = new MethodEntity();
		method.setClassName(b.getMethod().getDeclaringClass().getName());
		method.setMethodName(b.getMethod().getName());

		dangerousBehavior.setInitMethod(method);
		dangerousBehavior.getCurMethods().add(method);
		dangerousBehavior.setDiscribeString(rule.getDiscribeString());
		dangerousBehavior.setApi(rule.getApiName());

		dangerousBehaviors.add(dangerousBehavior);
	}

	// 通过白名单匹配方式对风险行为进行判别
	private void checkDangerousBehavior() {

		int bodylistSize = bodyList.size();
		for (int bodyIndex = 0; bodyIndex < bodylistSize; bodyIndex++) {
			// Body循环
			Body b = bodyList.get(bodyIndex);
			UnitGraph graph = new ExceptionalUnitGraph(b);
			Iterator<Unit> gIt = graph.iterator();
			while (gIt.hasNext()) {
				// Body内语句循环
				Unit u = gIt.next();
				String unitString = u.toString();
				checkDangerousBehaviorByUnit(b, unitString);
			}
		}

		handleCheckResult();
	}


	private void checkDangerousBehaviorByUnit(Body b, String unitString) {

		int dangerSize = dangerousBehaviors.size();
		for (int dangerIndex = 0; dangerIndex < dangerSize; dangerIndex++) {

			// 每个语句--风险行为循环
			DangerousBehavior dangerousBehavior = dangerousBehaviors
					.get(dangerIndex);
			List<MethodEntity> curMethods = dangerousBehavior.getCurMethods();
			List<MethodEntity> nextMethods = dangerousBehavior.getNextMethods();

			int methodsSize = curMethods.size();
			for (int methodIndex = 0; methodIndex < methodsSize; methodIndex++) {
				MethodEntity method = curMethods.get(methodIndex);

				if (unitString.contains(method.getClassName())
						&& unitString.contains(method.getMethodName())) {
					// 发现匹配项
					method.setMethodCalledByNull(false);
					String curMethod = b.getMethod().getName();

					int whiteListSize = whiteList.size();
					for (int whiteIndex = 0; whiteIndex < whiteListSize; whiteIndex++) {
						// 对匹配项进行白名单循环
						WhitelistItem whiteItem = whiteList.get(whiteIndex);
						String whiteItemMethod = whiteItem.getMethodName();
						if (curMethod.equals(whiteItemMethod)) {
							method.setMethodCalledByWhite(true);
						}
					}
					// 如果匹配项不在白名单中，则加入nextMethods中
					if (!method.isMethodCalledByWhite()) {
						MethodEntity nextMethod = new MethodEntity();
						nextMethod.setClassName(b.getMethod()
								.getDeclaringClass().getName());
						nextMethod.setMethodName(b.getMethod().getName());
						nextMethods.add(nextMethod);
					}
					curMethods.set(methodIndex, method);
				}
			}
			dangerousBehavior.setNextMethods(nextMethods);
		}
	}
	private void handleCheckResult() {

		exit: for (int dangerIndex = 0; dangerIndex < dangerousBehaviors.size(); dangerIndex++) {
			if (dangerIndex < 0) {
				break;
			}
			DangerousBehavior dangerousBehavior = dangerousBehaviors
					.get(dangerIndex);
			List<MethodEntity> curMethods = dangerousBehavior.getCurMethods();
			List<MethodEntity> nextMethods = dangerousBehavior.getNextMethods();

			if (nextMethods.isEmpty()) {

				boolean hasCall = false;
				int methodsSize = curMethods.size();
				for (int methodIndex = 0; methodIndex < methodsSize; methodIndex++) {
					MethodEntity method = curMethods.get(methodIndex);

					if (method.isMethodCalledByWhite()) {
						hasCall = true;
					}
				}
				if (hasCall) {
					System.out.println("----"
							+ dangerousBehavior.getInitMethod().getMethodName()
							+ "-----只有白名单调用，循环停止------------");
				} else {
					System.out.println("----"
							+ dangerousBehavior.getInitMethod().getMethodName()
							+ "-----无调用，循环停止------------");
					changeToMaliceBehavior(dangerousBehavior);
				}
				dangerousBehaviors.remove(dangerIndex);
				dangerIndex--;
				continue exit;
			}

			int methodsSize = curMethods.size();
			for (int methodIndex = 0; methodIndex < methodsSize; methodIndex++) {
				MethodEntity method = curMethods.get(methodIndex);
				if (method.isMethodCalledByNull()) {

					// 遍历完毕，没有匹配项，判断为恶意行为
					changeToMaliceBehavior(dangerousBehavior);
					dangerousBehaviors.remove(dangerIndex);
					dangerIndex--;
					System.out.println("-----"
							+ dangerousBehavior.getInitMethod().getMethodName()
							+ "----再无调用，判断为恶意行为------------");
					continue exit;
				}
			}

			dangerousBehavior.setCurMethods(nextMethods);
			dangerousBehavior.setNextMethods(new ArrayList<MethodEntity>());

			System.out.println("-----"
					+ dangerousBehavior.getInitMethod().getMethodName()
					+ "----仍有调用，循环继续------------");
			dangerousBehaviors.set(dangerIndex, dangerousBehavior);

		}
	}

	// 风险行为转化为恶意行为
	private void changeToMaliceBehavior(DangerousBehavior dangerousBehavior) {

		MaliceBehavior maliceBehavior = new MaliceBehavior();

		maliceBehavior.setClassName(dangerousBehavior.getInitMethod()
				.getClassName());
		maliceBehavior.setMethodName(dangerousBehavior.getInitMethod()
				.getMethodName());
		maliceBehavior.setMaliceDiscribeString(dangerousBehavior
				.getDiscribeString());
		maliceBehavior.setMaliceApi(dangerousBehavior.getApi());

		maliceBehaviors.add(maliceBehavior);
	}

	// 输出分析结果
	private void outputResult() {

		if (!maliceBehaviors.isEmpty()) {
			int size = maliceBehaviors.size();
			System.out.println("发现 " + size + " 个恶意行为 ！详细信息如下：");

			for (int i = 0; i < size; i++) {
				MaliceBehavior maliceBehavior = maliceBehaviors.get(i);
				System.out.println(maliceBehavior.getString());
			}
		} else {
			System.out.println("没有发现恶意行为！");
		}
	}
}
