package main;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ResultFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JButton cancel;

	public ResultFrame(String[] result) {
		JPanel jPanel = new JPanel();
		jPanel.setLayout(null);

		JTextField title = new JTextField("分析结果");
		title.setEditable(false);
		title.setFont(new Font("宋体", Font.BOLD, 20));
		title.setHorizontalAlignment(JTextField.CENTER);
		title.setBorder(null);
		title.setBounds(250, 12, 100, 30);
		jPanel.add(title);

		JTextField cell11 = new JTextField("恶意行为类别");
		cell11.setEditable(false);
		cell11.setFont(new Font("宋体", Font.BOLD, 12));
		cell11.setHorizontalAlignment(JTextField.CENTER);
		cell11.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell11.setBounds(100, 50, 100, 30);
		jPanel.add(cell11);

		JTextField cell12 = new JTextField("恶意行为");
		cell12.setEditable(false);
		cell12.setFont(new Font("宋体", Font.BOLD, 12));
		cell12.setHorizontalAlignment(JTextField.CENTER);
		cell12.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell12.setBounds(200, 50, 200, 30);
		jPanel.add(cell12);

		JTextField cell21 = new JTextField("自动耗费");
		cell21.setEditable(false);
		cell21.setFont(new Font("宋体", Font.BOLD, 12));
		cell21.setHorizontalAlignment(JTextField.CENTER);
		cell21.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell21.setBounds(100, 80, 100, 90);
		jPanel.add(cell21);

		JTextField cell22 = new JTextField("自动发送短信");
		cell22.setEditable(false);
		cell22.setFont(new Font("宋体", Font.BOLD, 12));
		cell22.setHorizontalAlignment(JTextField.CENTER);
		cell22.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell22.setBounds(200, 80, 200, 30);
		jPanel.add(cell22);

		JTextField cell32 = new JTextField("自动发送多人短信");
		cell32.setEditable(false);
		cell32.setFont(new Font("宋体", Font.BOLD, 12));
		cell32.setHorizontalAlignment(JTextField.CENTER);
		cell32.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell32.setBounds(200, 110, 200, 30);
		jPanel.add(cell32);

		JTextField cell42 = new JTextField("自动连接网络");
		cell42.setEditable(false);
		cell42.setFont(new Font("宋体", Font.BOLD, 12));
		cell42.setHorizontalAlignment(JTextField.CENTER);
		cell42.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell42.setBounds(200, 140, 200, 30);
		jPanel.add(cell42);

		JTextField cell51 = new JTextField("窃取隐私");
		cell51.setEditable(false);
		cell51.setFont(new Font("宋体", Font.BOLD, 12));
		cell51.setHorizontalAlignment(JTextField.CENTER);
		cell51.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell51.setBounds(100, 170, 100, 780);
		jPanel.add(cell51);

		JTextField cell52 = new JTextField("获取电话状态");
		cell52.setEditable(false);
		cell52.setFont(new Font("宋体", Font.BOLD, 12));
		cell52.setHorizontalAlignment(JTextField.CENTER);
		cell52.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell52.setBounds(200, 170, 200, 30);
		jPanel.add(cell52);

		JTextField cell72 = new JTextField("获取手机位置");
		cell72.setEditable(false);
		cell72.setFont(new Font("宋体", Font.BOLD, 12));
		cell72.setHorizontalAlignment(JTextField.CENTER);
		cell72.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell72.setBounds(200, 200, 200, 30);
		jPanel.add(cell72);

		JTextField cell82 = new JTextField("获取唯一的设备ID");
		cell82.setEditable(false);
		cell82.setFont(new Font("宋体", Font.BOLD, 12));
		cell82.setHorizontalAlignment(JTextField.CENTER);
		cell82.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell82.setBounds(200, 230, 200, 30);
		jPanel.add(cell82);

		JTextField cell92 = new JTextField("获取设备的软件版本号");
		cell92.setEditable(false);
		cell92.setFont(new Font("宋体", Font.BOLD, 12));
		cell92.setHorizontalAlignment(JTextField.CENTER);
		cell92.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell92.setBounds(200, 260, 200, 30);
		jPanel.add(cell92);

		JTextField cell102 = new JTextField("获取手机号");
		cell102.setEditable(false);
		cell102.setFont(new Font("宋体", Font.BOLD, 12));
		cell102.setHorizontalAlignment(JTextField.CENTER);
		cell102.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell102.setBounds(200, 290, 200, 30);
		jPanel.add(cell102);

		JTextField cell112 = new JTextField("获取附近的电话的信息");
		cell112.setEditable(false);
		cell112.setFont(new Font("宋体", Font.BOLD, 12));
		cell112.setHorizontalAlignment(JTextField.CENTER);
		cell112.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell112.setBounds(200, 320, 200, 30);
		jPanel.add(cell112);

		JTextField cell122 = new JTextField("获取ISO标准的国家码");
		cell122.setEditable(false);
		cell122.setFont(new Font("宋体", Font.BOLD, 12));
		cell122.setHorizontalAlignment(JTextField.CENTER);
		cell122.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell122.setBounds(200, 350, 200, 30);
		jPanel.add(cell122);

		JTextField cell132 = new JTextField("获取MCC+MNC");
		cell132.setEditable(false);
		cell132.setFont(new Font("宋体", Font.BOLD, 12));
		cell132.setHorizontalAlignment(JTextField.CENTER);
		cell132.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell132.setBounds(200, 380, 200, 30);
		jPanel.add(cell132);

		JTextField cell142 = new JTextField("获取当前已注册的用户的名字");
		cell142.setEditable(false);
		cell142.setFont(new Font("宋体", Font.BOLD, 12));
		cell142.setHorizontalAlignment(JTextField.CENTER);
		cell142.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell142.setBounds(200, 410, 200, 30);
		jPanel.add(cell142);

		JTextField cell152 = new JTextField("获取当前的网络类型");
		cell152.setEditable(false);
		cell152.setFont(new Font("宋体", Font.BOLD, 12));
		cell152.setHorizontalAlignment(JTextField.CENTER);
		cell152.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell152.setBounds(200, 440, 200, 30);
		jPanel.add(cell152);

		JTextField cell162 = new JTextField("获取手机类型");
		cell162.setEditable(false);
		cell162.setFont(new Font("宋体", Font.BOLD, 12));
		cell162.setHorizontalAlignment(JTextField.CENTER);
		cell162.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell162.setBounds(200, 470, 200, 30);
		jPanel.add(cell162);

		JTextField cell172 = new JTextField("获取IＳＯ国家码");
		cell172.setEditable(false);
		cell172.setFont(new Font("宋体", Font.BOLD, 12));
		cell172.setHorizontalAlignment(JTextField.CENTER);
		cell172.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell172.setBounds(200, 500, 200, 30);
		jPanel.add(cell172);

		JTextField cell182 = new JTextField("获取MCC+MNC(SIM)");
		cell182.setEditable(false);
		cell182.setFont(new Font("宋体", Font.BOLD, 12));
		cell182.setHorizontalAlignment(JTextField.CENTER);
		cell182.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell182.setBounds(200, 530, 200, 30);
		jPanel.add(cell182);

		JTextField cell192 = new JTextField("获取服务商名称");
		cell192.setEditable(false);
		cell192.setFont(new Font("宋体", Font.BOLD, 12));
		cell192.setHorizontalAlignment(JTextField.CENTER);
		cell192.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell192.setBounds(200, 560, 200, 30);
		jPanel.add(cell192);

		JTextField cell202 = new JTextField("获取SIM卡的序列号");
		cell202.setEditable(false);
		cell202.setFont(new Font("宋体", Font.BOLD, 12));
		cell202.setHorizontalAlignment(JTextField.CENTER);
		cell202.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell202.setBounds(200, 590, 200, 30);
		jPanel.add(cell202);

		JTextField cell212 = new JTextField("获取SIM的状态信息");
		cell212.setEditable(false);
		cell212.setFont(new Font("宋体", Font.BOLD, 12));
		cell212.setHorizontalAlignment(JTextField.CENTER);
		cell212.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell212.setBounds(200, 620, 200, 30);
		jPanel.add(cell212);

		JTextField cell222 = new JTextField("获取唯一的用户ID");
		cell222.setEditable(false);
		cell222.setFont(new Font("宋体", Font.BOLD, 12));
		cell222.setHorizontalAlignment(JTextField.CENTER);
		cell222.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell222.setBounds(200, 650, 200, 30);
		jPanel.add(cell222);

		JTextField cell232 = new JTextField("获取语音邮件的标签（识别码）");
		cell232.setEditable(false);
		cell232.setFont(new Font("宋体", Font.BOLD, 12));
		cell232.setHorizontalAlignment(JTextField.CENTER);
		cell232.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell232.setBounds(200, 680, 200, 30);
		jPanel.add(cell232);

		JTextField cell242 = new JTextField("获取语音邮件号码");
		cell242.setEditable(false);
		cell242.setFont(new Font("宋体", Font.BOLD, 12));
		cell242.setHorizontalAlignment(JTextField.CENTER);
		cell242.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell242.setBounds(200, 710, 200, 30);
		jPanel.add(cell242);

		JTextField cell252 = new JTextField("获取用户位置信息");
		cell252.setEditable(false);
		cell252.setFont(new Font("宋体", Font.BOLD, 12));
		cell252.setHorizontalAlignment(JTextField.CENTER);
		cell252.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell252.setBounds(200, 740, 200, 30);
		jPanel.add(cell252);

		JTextField cell262 = new JTextField("读取设备通讯录");
		cell262.setEditable(false);
		cell262.setFont(new Font("宋体", Font.BOLD, 12));
		cell262.setHorizontalAlignment(JTextField.CENTER);
		cell262.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell262.setBounds(200, 770, 200, 30);
		jPanel.add(cell262);

		JTextField cell272 = new JTextField("读取通话记录");
		cell272.setEditable(false);
		cell272.setFont(new Font("宋体", Font.BOLD, 12));
		cell272.setHorizontalAlignment(JTextField.CENTER);
		cell272.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell272.setBounds(200, 800, 200, 30);
		jPanel.add(cell272);

		JTextField cell282 = new JTextField("读取用户短信息");
		cell282.setEditable(false);
		cell282.setFont(new Font("宋体", Font.BOLD, 12));
		cell282.setHorizontalAlignment(JTextField.CENTER);
		cell282.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell282.setBounds(200, 830, 200, 30);
		jPanel.add(cell282);

		JTextField cell292 = new JTextField("获取GPS现在的状态");
		cell292.setEditable(false);
		cell292.setFont(new Font("宋体", Font.BOLD, 12));
		cell292.setHorizontalAlignment(JTextField.CENTER);
		cell292.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell292.setBounds(200, 860, 200, 30);
		jPanel.add(cell292);

		JTextField cell302 = new JTextField("打开GPS");
		cell302.setEditable(false);
		cell302.setFont(new Font("宋体", Font.BOLD, 12));
		cell302.setHorizontalAlignment(JTextField.CENTER);
		cell302.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell302.setBounds(200, 890, 200, 30);
		jPanel.add(cell302);

		JTextField cell81 = new JTextField("破坏系统");
		cell81.setEditable(false);
		cell81.setFont(new Font("宋体", Font.BOLD, 12));
		cell81.setHorizontalAlignment(JTextField.CENTER);
		cell81.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell81.setBounds(100, 950, 100, 60);
		jPanel.add(cell81);

		JTextField cell312 = new JTextField("获取root权限");
		cell312.setEditable(false);
		cell312.setFont(new Font("宋体", Font.BOLD, 12));
		cell312.setHorizontalAlignment(JTextField.CENTER);
		cell312.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell312.setBounds(200, 920, 200, 30);
		jPanel.add(cell312);

		JTextField cell322 = new JTextField("终止其它进程");
		cell322.setEditable(false);
		cell322.setFont(new Font("宋体", Font.BOLD, 12));
		cell322.setHorizontalAlignment(JTextField.CENTER);
		cell322.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell322.setBounds(200, 950, 200, 30);
		jPanel.add(cell322);
		
		JTextField cell332 = new JTextField("终止服务");
		cell332.setEditable(false);
		cell332.setFont(new Font("宋体", Font.BOLD, 12));
		cell332.setHorizontalAlignment(JTextField.CENTER);
		cell332.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell332.setBounds(200, 980, 200, 30);
		jPanel.add(cell332);

		JTextField cell13 = new JTextField("出现次数");
		cell13.setEditable(false);
		cell13.setFont(new Font("宋体", Font.BOLD, 12));
		cell13.setHorizontalAlignment(JTextField.CENTER);
		cell13.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell13.setBounds(400, 50, 100, 30);
		jPanel.add(cell13);

		JTextField cell23 = new JTextField();
		if (result[0] != null) {
				cell23.setText(result[0]);
		}
		cell23.setEditable(false);
		cell23.setFont(new Font("宋体", Font.BOLD, 12));
		cell23.setHorizontalAlignment(JTextField.CENTER);
		cell23.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell23.setBounds(400, 80, 100, 30);
		jPanel.add(cell23);

		JTextField cell33 = new JTextField();
		if (result[1] != null) {
			cell33.setText(result[1]);
		}
		cell33.setEditable(false);
		cell33.setFont(new Font("宋体", Font.BOLD, 12));
		cell33.setHorizontalAlignment(JTextField.CENTER);
		cell33.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell33.setBounds(400, 110, 100, 30);
		jPanel.add(cell33);

		JTextField cell43 = new JTextField();
		if (result[2] != null) {
			cell43.setText(result[2]);
		}
		cell43.setEditable(false);
		cell43.setFont(new Font("宋体", Font.BOLD, 12));
		cell43.setHorizontalAlignment(JTextField.CENTER);
		cell43.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell43.setBounds(400, 140, 100, 30);
		jPanel.add(cell43);

		JTextField cell53 = new JTextField();
		if (result[3] != null) {
			cell53.setText(result[3]);
		}
		cell53.setEditable(false);
		cell53.setFont(new Font("宋体", Font.BOLD, 12));
		cell53.setHorizontalAlignment(JTextField.CENTER);
		cell53.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell53.setBounds(400, 170, 100, 30);
		jPanel.add(cell53);

		JTextField cell63 = new JTextField();
		if (result[4] != null) {
			cell63.setText(result[4]);
		}
		cell63.setEditable(false);
		cell63.setFont(new Font("宋体", Font.BOLD, 12));
		cell63.setHorizontalAlignment(JTextField.CENTER);
		cell63.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell63.setBounds(400, 200, 100, 30);
		jPanel.add(cell63);

		JTextField cell73 = new JTextField();
		if (result[5] != null) {
			cell73.setText(result[5]);
		}
		cell73.setEditable(false);
		cell73.setFont(new Font("宋体", Font.BOLD, 12));
		cell73.setHorizontalAlignment(JTextField.CENTER);
		cell73.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell73.setBounds(400, 230, 100, 30);
		jPanel.add(cell73);

		JTextField cell83 = new JTextField();
		if (result[6] != null) {
			cell83.setText(result[6]);
		}
		cell83.setEditable(false);
		cell83.setFont(new Font("宋体", Font.BOLD, 12));
		cell83.setHorizontalAlignment(JTextField.CENTER);
		cell83.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell83.setBounds(400, 260, 100, 30);
		jPanel.add(cell83);

		JTextField cell93 = new JTextField();
		if (result[7] != null) {
			cell93.setText(result[7]);
		}
		cell93.setEditable(false);
		cell93.setFont(new Font("宋体", Font.BOLD, 12));
		cell93.setHorizontalAlignment(JTextField.CENTER);
		cell93.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell93.setBounds(400, 290, 100, 30);
		jPanel.add(cell93);

		JTextField cell103 = new JTextField();
		if (result[8] != null) {
			cell103.setText(result[8]);
		}
		cell103.setEditable(false);
		cell103.setFont(new Font("宋体", Font.BOLD, 12));
		cell103.setHorizontalAlignment(JTextField.CENTER);
		cell103.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell103.setBounds(400, 320, 100, 30);
		jPanel.add(cell103);

		JTextField cell113 = new JTextField();
		if (result[9] != null) {
			cell113.setText(result[9]);
		}
		cell113.setEditable(false);
		cell113.setFont(new Font("宋体", Font.BOLD, 12));
		cell113.setHorizontalAlignment(JTextField.CENTER);
		cell113.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell113.setBounds(400, 350, 100, 30);
		jPanel.add(cell113);

		JTextField cell123 = new JTextField();
		if (result[10] != null) {
			cell123.setText(result[10]);
		}
		cell123.setEditable(false);
		cell123.setFont(new Font("宋体", Font.BOLD, 12));
		cell123.setHorizontalAlignment(JTextField.CENTER);
		cell123.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell123.setBounds(400, 380, 100, 30);
		jPanel.add(cell123);

		JTextField cell133 = new JTextField();
		if (result[11] != null) {
			cell133.setText(result[11]);
		}
		cell133.setEditable(false);
		cell133.setFont(new Font("宋体", Font.BOLD, 12));
		cell133.setHorizontalAlignment(JTextField.CENTER);
		cell133.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell133.setBounds(400, 410, 100, 30);
		jPanel.add(cell133);

		JTextField cell143 = new JTextField();
		if (result[12] != null) {
			cell143.setText(result[12]);
		}
		cell143.setEditable(false);
		cell143.setFont(new Font("宋体", Font.BOLD, 12));
		cell143.setHorizontalAlignment(JTextField.CENTER);
		cell143.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell143.setBounds(400, 440, 100, 30);
		jPanel.add(cell143);

		JTextField cell153 = new JTextField();
		if (result[13] != null) {
			cell153.setText(result[13]);
		}
		cell153.setEditable(false);
		cell153.setFont(new Font("宋体", Font.BOLD, 12));
		cell153.setHorizontalAlignment(JTextField.CENTER);
		cell153.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell153.setBounds(400, 470, 100, 30);
		jPanel.add(cell153);

		JTextField cell163 = new JTextField();
		if (result[14] != null) {
			cell163.setText(result[14]);
		}
		cell163.setEditable(false);
		cell163.setFont(new Font("宋体", Font.BOLD, 12));
		cell163.setHorizontalAlignment(JTextField.CENTER);
		cell163.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell163.setBounds(400, 500, 100, 30);
		jPanel.add(cell163);

		JTextField cell173 = new JTextField();
		if (result[15] != null) {
			cell173.setText(result[15]);
		}
		cell173.setEditable(false);
		cell173.setFont(new Font("宋体", Font.BOLD, 12));
		cell173.setHorizontalAlignment(JTextField.CENTER);
		cell173.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell173.setBounds(400, 530, 100, 30);
		jPanel.add(cell173);

		JTextField cell183 = new JTextField();
		if (result[16] != null) {
			cell183.setText(result[16]);
		}
		cell183.setEditable(false);
		cell183.setFont(new Font("宋体", Font.BOLD, 12));
		cell183.setHorizontalAlignment(JTextField.CENTER);
		cell183.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell183.setBounds(400, 560, 100, 30);
		jPanel.add(cell183);

		JTextField cell193 = new JTextField();
		if (result[17] != null) {
			cell193.setText(result[17]);
		}
		cell193.setEditable(false);
		cell193.setFont(new Font("宋体", Font.BOLD, 12));
		cell193.setHorizontalAlignment(JTextField.CENTER);
		cell193.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell193.setBounds(400, 590, 100, 30);
		jPanel.add(cell193);

		JTextField cell203 = new JTextField();
		if (result[18] != null) {
			cell203.setText(result[18]);
		}
		cell203.setEditable(false);
		cell203.setFont(new Font("宋体", Font.BOLD, 12));
		cell203.setHorizontalAlignment(JTextField.CENTER);
		cell203.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell203.setBounds(400, 620, 100, 30);
		jPanel.add(cell203);

		JTextField cell213 = new JTextField();
		if (result[19] != null) {
			cell213.setText(result[19]);
		}
		cell213.setEditable(false);
		cell213.setFont(new Font("宋体", Font.BOLD, 12));
		cell213.setHorizontalAlignment(JTextField.CENTER);
		cell213.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell213.setBounds(400, 650, 100, 30);
		jPanel.add(cell213);

		JTextField cell223 = new JTextField();
		if (result[20] != null) {
			cell223.setText(result[20]);
		}
		cell223.setEditable(false);
		cell223.setFont(new Font("宋体", Font.BOLD, 12));
		cell223.setHorizontalAlignment(JTextField.CENTER);
		cell223.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell223.setBounds(400, 680, 100, 30);
		jPanel.add(cell223);

		JTextField cell233 = new JTextField();
		if (result[21] != null) {
			cell233.setText(result[21]);
		}
		cell233.setEditable(false);
		cell233.setFont(new Font("宋体", Font.BOLD, 12));
		cell233.setHorizontalAlignment(JTextField.CENTER);
		cell233.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell233.setBounds(400, 710, 100, 30);
		jPanel.add(cell233);

		JTextField cell243 = new JTextField();
		if (result[22] != null) {
			cell243.setText(result[22]);
		}
		cell243.setEditable(false);
		cell243.setFont(new Font("宋体", Font.BOLD, 12));
		cell243.setHorizontalAlignment(JTextField.CENTER);
		cell243.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell243.setBounds(400, 740, 100, 30);
		jPanel.add(cell243);

		JTextField cell253 = new JTextField();
		if (result[23] != null) {
			cell253.setText(result[23]);
		}
		cell253.setEditable(false);
		cell253.setFont(new Font("宋体", Font.BOLD, 12));
		cell253.setHorizontalAlignment(JTextField.CENTER);
		cell253.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell253.setBounds(400, 770, 100, 30);
		jPanel.add(cell253);

		JTextField cell263 = new JTextField();
		if (result[24] != null) {
			cell263.setText(result[24]);
		}
		cell263.setEditable(false);
		cell263.setFont(new Font("宋体", Font.BOLD, 12));
		cell263.setHorizontalAlignment(JTextField.CENTER);
		cell263.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell263.setBounds(400, 800, 100, 30);
		jPanel.add(cell263);

		JTextField cell273 = new JTextField();
		if (result[25] != null) {
			cell273.setText(result[25]);
		}
		cell273.setEditable(false);
		cell273.setFont(new Font("宋体", Font.BOLD, 12));
		cell273.setHorizontalAlignment(JTextField.CENTER);
		cell273.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell273.setBounds(400, 830, 100, 30);
		jPanel.add(cell273);

		JTextField cell283 = new JTextField();
		if (result[26] != null) {
			cell283.setText(result[26]);
		}
		cell283.setEditable(false);
		cell283.setFont(new Font("宋体", Font.BOLD, 12));
		cell283.setHorizontalAlignment(JTextField.CENTER);
		cell283.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell283.setBounds(400, 860, 100, 30);
		jPanel.add(cell283);

		JTextField cell293 = new JTextField();
		if (result[27] != null) {
			cell293.setText(result[27]);
		}
		cell293.setEditable(false);
		cell293.setFont(new Font("宋体", Font.BOLD, 12));
		cell293.setHorizontalAlignment(JTextField.CENTER);
		cell293.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell293.setBounds(400, 890, 100, 30);
		jPanel.add(cell293);

		JTextField cell303 = new JTextField();
		if (result[28] != null) {
			cell303.setText(result[28]);
		}
		cell303.setEditable(false);
		cell303.setFont(new Font("宋体", Font.BOLD, 12));
		cell303.setHorizontalAlignment(JTextField.CENTER);
		cell303.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell303.setBounds(400, 920, 100, 30);
		jPanel.add(cell303);

		JTextField cell313 = new JTextField();
		if (result[29] != null) {
			cell313.setText(result[29]);
		}
		cell313.setEditable(false);
		cell313.setFont(new Font("宋体", Font.BOLD, 12));
		cell313.setHorizontalAlignment(JTextField.CENTER);
		cell313.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell313.setBounds(400, 950, 100, 30);
		jPanel.add(cell313);
		
		JTextField cell323 = new JTextField();
		if (result[30] != null) {
			cell323.setText(result[30]);
		}
		cell323.setEditable(false);
		cell323.setFont(new Font("宋体", Font.BOLD, 12));
		cell323.setHorizontalAlignment(JTextField.CENTER);
		cell323.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		cell323.setBounds(400, 980, 100, 30);
		jPanel.add(cell323);

		cancel = new JButton("退出");
		cancel.addActionListener(this);
		cancel.setBounds(270, 1050, 60, 30);
		jPanel.add(cancel);

		setBounds(200, 100, 600, 600);
		setTitle("测试");
		JScrollPane scrollPane = new JScrollPane(jPanel);
		scrollPane.setBounds(0, 0, 600, 600);
		jPanel.setPreferredSize(new Dimension(600, 1150));
		add(new JScrollPane(scrollPane));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if (button == cancel) {
			System.exit(0);
		}
	}
}

