package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import util.ReleaseException;


import decompiler.Decompiler;
import decompiler.TestSoot;

public class CFGWindow extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JFileChooser fc = new JFileChooser();

	private JButton choose;

	private JButton ok;

	private JButton cancel;

	private JLabel pathLabel;

	private JTextField path;

	private String rootPath = new File(getClass().getResource("/").getFile()
			.toString()).getParent();

	public CFGWindow() {
		getContentPane().setLayout(null);
		choose = new JButton("选择APK");
		choose.addActionListener(this);
		choose.setBounds(400, 100, 85, 30);
		getContentPane().add(choose);

		pathLabel = new JLabel("路径：");
		pathLabel.setBounds(80, 100, 50, 30);
		getContentPane().add(pathLabel);

		path = new JTextField();
		path.setBounds(120, 100, 250, 30);
		path.setEditable(false);
		getContentPane().add(path);

		ok = new JButton("确定");
		ok.addActionListener(this);
		ok.setBounds(180, 180, 60, 30);
		getContentPane().add(ok);

		cancel = new JButton("退出");
		cancel.addActionListener(this);
		cancel.setBounds(320, 180, 60, 30);
		getContentPane().add(cancel);

		setSize(600, 400);
		setTitle("测试");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String args[]) {
		new CFGWindow();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if (button == choose) {
			int select = fc.showOpenDialog(this);
			if (select == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				path.setText(file.getAbsolutePath());
			}
		} else if (button == ok) {
			File file = new File(path.getText());
			String path = file.getAbsolutePath().toString();
			if (!file.exists()) {
				JOptionPane.showMessageDialog(null, "文件不存在!", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (!".apk".equals(path.substring(path.lastIndexOf(".")))) {
				JOptionPane.showMessageDialog(null, "格式错误!", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
				Decompiler decompiler = new Decompiler();
				cleanApkfile();
				decompiler.copyApkFile(file.getAbsolutePath());
				Thread.sleep(1000);

				decompiler.getDexFromApk(rootPath + "\\apkfile\\"
						+ file.getName());

				decompiler.dex2Jar();

				decompiler.jar2class();

				try {
					String[] strings = new TestSoot().run();
					ResultFrame jf = new ResultFrame(strings);// 用另一个面板创建的对象
					jf.setVisible(true);// 打开那个创建的面板
					this.dispose();// 关闭当前登陆窗体
				} catch (ReleaseException e1) {
					JOptionPane.showMessageDialog(null, "发生未知错误，无法解析APK!",
							"Error", JOptionPane.ERROR_MESSAGE);
					cleanApkfile();
					cleanRelease();
					cleanTempFile(file.getName().substring(0,
							file.getName().length() - 4));
					System.exit(0);
				}

				cleanApkfile();
				cleanRelease();
				cleanTempFile(file.getName().substring(0,
						file.getName().length() - 4));
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		} else if (button == cancel) {
			System.exit(0);
		}
	}

	public void cleanToolDir() {
		File tooFile = new File("D:\\Tool\\");
		if (tooFile.exists()) {
			String[] filelist = tooFile.list();
			for (int i = 0; i < filelist.length; i++) {
				File delfile = new File("D:\\Tool" + File.separator
						+ filelist[i]);
				delAllFile(delfile.getAbsolutePath());
				delFolder(delfile.getAbsolutePath());
			}
		}
	}

	public void cleanTempFile(String apkName) {
		File jarFile = new File(rootPath + File.separator
				+ "classes-dex2jar.jar");
		if (jarFile.exists()) {
			delFolder(jarFile.getAbsolutePath());
		}
		File dexFile = new File(rootPath + File.separator + "classes.dex");
		if (dexFile.exists()) {
			delFolder(dexFile.getAbsolutePath());
		}
		File zipFile = new File(rootPath + File.separator + apkName + ".zip");
		if (zipFile.exists()) {
			delFolder(zipFile.getAbsolutePath());
		}

	}

	public void cleanApkfile() {
		File apkfile = new File(rootPath + "\\apkfile");
		if (apkfile.exists()) {
			String[] filelist = apkfile.list();
			for (int i = 0; i < filelist.length; i++) {
				File delfile = new File(rootPath + "\\apkfile" + File.separator
						+ filelist[i]);
				delAllFile(delfile.getAbsolutePath());
				delFolder(delfile.getAbsolutePath());
			}
		}
	}

	public void cleanRelease() {
		File release = new File(rootPath + "\\release");
		if (release.exists()) {
			String[] filelist = release.list();
			for (int i = 0; i < filelist.length; i++) {
				File delfile = new File(rootPath + "\\release" + File.separator
						+ filelist[i]);
				delAllFile(delfile.getAbsolutePath());
				delFolder(delfile.getAbsolutePath());
			}
		}
	}

	public void cleanSmali() {
		File smali = new File(rootPath + "\\smali");
		if (smali.exists()) {
			String[] filelist = smali.list();
			for (int i = 0; i < filelist.length; i++) {
				File delfile = new File(rootPath + "\\smali" + File.separator
						+ filelist[i]);
				delAllFile(delfile.getAbsolutePath());
				delFolder(delfile.getAbsolutePath());
			}
		}
	}

	public void delFolder(String folderPath) {
		try {
			delAllFile(folderPath);
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			myFilePath.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean delAllFile(String path) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);
				delFolder(path + "/" + tempList[i]);
				flag = true;
			}
		}
		return flag;
	}
}
