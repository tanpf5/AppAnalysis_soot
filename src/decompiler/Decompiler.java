package decompiler;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;

public class Decompiler {

	private ArrayList<String> filelist = new ArrayList<String>();

	private String rootPath = new File(getClass().getResource("/").getFile()
			.toString()).getParent();

	/**
	 * Get smali file from APK.
	 * 
	 * @param apkPath
	 *            The APK file path.
	 */
	public boolean apk2Smali(String apkPath) {
		if ("".equals(apkPath) || null == apkPath) {
			return false;
		}
		File file = new File(apkPath);
		if (!file.exists()) {
			return false;
		}
		File smali = new File("smali");
		if (smali.exists()) {
			deletDir(smali);
		}

		String path = rootPath + "\\apktool\\apktool.bat d -f " + apkPath + " "
				+ rootPath + "\\smali";
		try {
			Process process = Runtime.getRuntime().exec(path);
			process.waitFor();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		return true;
	}

	/**
	 * Translate .class to .java.
	 */
	public boolean class2Java() {
		if (!refreshFileList("release")) {
			return false;
		}
		HashSet<String> hashSet = new HashSet<String>(filelist);
		filelist.clear();
		filelist.addAll(hashSet);

		File dir = new File("java");
		if (dir.exists()) {
			for (File file : dir.listFiles()) {
				if (file.getName().endsWith("java")) {
					file.delete();
				}
			}
		}

		for (int i = 0; i < filelist.size(); i++) {
			String path = rootPath + "\\jad\\jad.exe -sjava -d " + rootPath
					+ "\\java " + filelist.get(i) + "\\*.class ";
			try {
				Runtime.getRuntime().exec(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return true;
	}

	/**
	 * Get the class file's directory.
	 * 
	 * @param strPath
	 *            The root dir path.
	 */
	public boolean refreshFileList(String filePath) {
		if ("".equals(filePath) || null == filePath) {
			return false;
		}
		File dir = new File(filePath);
		if (!dir.exists()) {
			return false;
		}
		File[] files = dir.listFiles();
		if (files == null) {
			return true;
		}
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				refreshFileList(files[i].getAbsolutePath());
			} else {
				filelist.add(files[i].getParent());
			}
		}
		return true;
	}

	/**
	 * Delete a directory.
	 * 
	 * @param dir
	 */
	private void deletDir(File dir) {
		if (null == dir || !dir.exists() || !dir.isDirectory()) {
			return;
		}
		for (File file : dir.listFiles()) {
			if (file.isFile()) {
				file.delete();
			} else if (file.isDirectory()) {
				deletDir(file);
			}
		}
		dir.delete();
	}

	/**
	 * Rename file;
	 * 
	 * @param file
	 */
	public void UnzipApk() {
		File file = new File(rootPath + "\\apkfile\\");
		String[] apkString = file.list();
		String cmdString = "7z x " + rootPath + "\\apkfile\\" + apkString[0]
				+ " -o" + rootPath + "\\apkfile\\";
		try {
			Runtime.getRuntime().exec(cmdString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param filePath
	 * @return
	 */
	public boolean copyApkFile(String filePath) {
		if ("".equals(filePath) || null == filePath) {
			return false;
		}
		File sourceFile = new File(filePath);
		if (!sourceFile.exists()) {
			return false;
		}

		String dirPath = rootPath + "\\apkfile";
		File dir = new File(dirPath);
		if (!dir.exists()) {
			dir.mkdir();
		}

		File targetFile = new File(dir + "\\" + sourceFile.getName());
		try {
			copyFile(sourceFile, targetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public void copyFile(File sourceFile, File targetFile) throws IOException {
		BufferedInputStream inBuff = null;
		BufferedOutputStream outBuff = null;
		try {
			// 新建文件输入流并对它进行缓冲
			inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

			// 新建文件输出流并对它进行缓冲
			outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

			// 缓冲数组
			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = inBuff.read(b)) != -1) {
				outBuff.write(b, 0, len);
			}
			// 刷新此缓冲的输出流
			outBuff.flush();
		} finally {
			// 关闭流
			if (inBuff != null)
				inBuff.close();
			if (outBuff != null)
				outBuff.close();
		}
	}

	/**
	 * Release classes.dex from APK.
	 * 
	 * @param filePath
	 *            The APK file path.
	 */
	public boolean getDexFromApk(String filePath) {
		if ("".equals(filePath) || null == filePath) {
			return false;
		}
		File oldFile = new File(filePath);
		String newFilePath = "";
		// rename to .zip
		if (oldFile.exists()) {
			String fileName = oldFile.getName();
			newFilePath = fileName.substring(0, fileName.lastIndexOf("."))
					+ ".zip";
			oldFile.renameTo(new File(newFilePath));
		} else {
			String fileName = oldFile.getName();
			newFilePath = fileName.substring(0, fileName.lastIndexOf("."))
					+ ".zip";
		}
		// release the classes.dex
		try {
			ZipRelease.release(newFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}

	public boolean dex2Jar() {
		File file = new File("classes.dex");
		if (!file.exists()) {
			return false;
		}
		Process process = null;
		String path = rootPath + "\\dex2jar\\d2j-dex2jar.bat classes.dex";
		try {
			process = Runtime.getRuntime().exec(path);
			if (process.waitFor() == 0) {
				System.out.println("Over");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Translate jar to class.
	 */
	public boolean jar2class() {
		File file = new File("classes-dex2jar.jar");
		if (!file.exists()) {
			return false;
		}
		File dir = new File("release");
		deletDir(dir);
		try {
			ZipRelease.unJar(file, new File(rootPath + "//release"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public void handleJavaFile() {
		File dir = new File(rootPath + "\\Java");
		String[] fileStrings = dir.list();
		for (int i = 0; i < fileStrings.length; i++) {
			File file = new File(rootPath + "\\Java\\" + fileStrings[i]);
			File newFile = new File(rootPath + "\\apkfile\\" + fileStrings[i]);
			System.out.println(file.getAbsolutePath());
			try {
				newFile.createNewFile();
				BufferedReader br = new BufferedReader(new FileReader(file));

				FileOutputStream fos = new FileOutputStream(newFile);
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				while (br.ready()) {
					String line = br.readLine();
					if (line.length() != 0) {
						if (line.length() > 8
								&& line.substring(0, 8).equals("package ")) {
							// do nothing
						} else if (line.length() > 7
								&& line.substring(0, 7).equals("import ")) {
							// do nothing
						} else {
							osw.write(line + "\n");
						}
					} else {
						// do nothing
					}
				}
				br.close();
				osw.close();
				fos.close();
				copyFile(newFile, file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}

	public ArrayList<String> getCodeList(String path) {
		ArrayList<String> codelist = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			while (reader.ready()) {
				String line = reader.readLine();
				if (line.length() != 0) {
					codelist.add(line);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return codelist;
	}
}
