package decompiler;

import java.io.File;

import javax.swing.JOptionPane;

import main.ResultFrame;
import util.ReleaseException;

public class AppAnalysis {
	
	private static String rootPath = new File("").getAbsolutePath();
	
	public interface CompleteListener {
		public void onAnalysisComplete(String[] result);
	}
	
	public static void analysis(String apkFilePath, final CompleteListener listener){
		final File file = new File(apkFilePath);
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
			
			Decompiler decompiler = new Decompiler();
			cleanApkfile();
			decompiler.copyApkFile(file.getAbsolutePath());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			decompiler.getDexFromApk(rootPath+"\\apkfile\\"
					+ file.getName());

			decompiler.dex2Jar();

			decompiler.jar2class();
            
			new Thread(new Runnable(){
				@Override
				public void run() {
					try {
						final String[] resultStrs = new TestSoot().run();
						//delete files 
						cleanRelease();
						cleanTempFile(file.getName().substring(0,
								file.getName().length() - 4));
						
						if(listener != null){
							listener.onAnalysisComplete(resultStrs);
						}
					} catch (ReleaseException e) {
						cleanApkfile();
						cleanRelease();
						cleanTempFile(file.getName().substring(0,
								file.getName().length() - 4));
					}
				}}).start();
	}
	
	public static ResultFrame result(String[] resultStrs){
		return new ResultFrame(resultStrs);
	}
	
	private static void  cleanApkfile() {
		File apkfile = new File(rootPath+"\\apkfile");
		if (apkfile.exists()) {
			String[] filelist = apkfile.list();
			for (int i = 0; i < filelist.length; i++) {
				File delfile = new File(rootPath+"\\apkfile" + File.separator
						+ filelist[i]);
				delAllFile(delfile.getAbsolutePath());
				delFolder(delfile.getAbsolutePath());
			}
		}
	}
	
	private static void delFolder(String folderPath) {
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

	private static boolean delAllFile(String path) {
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
	
	
	private static void cleanRelease() {
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
	
	private static void cleanTempFile(String apkName) {
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

}
