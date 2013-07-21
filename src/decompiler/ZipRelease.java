package decompiler;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.jar.JarInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class ZipRelease {

	public static void release(String filePath) throws IOException {
		File file = new File(filePath);// 压缩文件
		ZipFile zipFile = new ZipFile(file);// 实例化ZipFile，每一个zip压缩文件都可以表示为一个ZipFile
		// 实例化一个Zip压缩文件的ZipInputStream对象，可以利用该类的getNextEntry()方法依次拿到每一个ZipEntry对象
		ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(
				file));
		ZipEntry zipEntry = null;
		while ((zipEntry = zipInputStream.getNextEntry()) != null) {
			String fileName = zipEntry.getName();
			if (!"classes.dex".equals(fileName)) {
				continue;
			}
			File temp = new File(fileName);
			OutputStream os = new FileOutputStream(temp);
			// 通过ZipFile的getInputStream方法拿到具体的ZipEntry的输入流
			InputStream is = zipFile.getInputStream(zipEntry);
			int len = 0;
			while ((len = is.read()) != -1)
				os.write(len);
			os.close();
			is.close();
			break;
		}
		zipInputStream.close();
	}

	public static void jar2Class(String filePath) throws IOException {
		File file = new File(filePath);// 压缩文件
		ZipFile zipFile = new ZipFile(file);// 实例化ZipFile，每一个zip压缩文件都可以表示为一个ZipFile
		// 实例化一个Zip压缩文件的ZipInputStream对象，可以利用该类的getNextEntry()方法依次拿到每一个ZipEntry对象
		ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(
				file));
		ZipEntry zipEntry = null;
		while ((zipEntry = zipInputStream.getNextEntry()) != null) {
			String fileName = zipEntry.getName();
			File temp = new File(fileName);
			OutputStream os = new FileOutputStream(temp);
			// 通过ZipFile的getInputStream方法拿到具体的ZipEntry的输入流
			InputStream is = zipFile.getInputStream(zipEntry);
			int len = 0;
			while ((len = is.read()) != -1)
				os.write(len);
			os.close();
			is.close();
		}
		zipInputStream.close();
	}

	// 解压jar
	public static void unJar(File src, File desDir)
			throws FileNotFoundException, IOException {
		JarInputStream jarIn = new JarInputStream(new BufferedInputStream(
				new FileInputStream(src)));
		if (!desDir.exists())
			desDir.mkdirs();
		byte[] bytes = new byte[1024];

		while (true) {
			ZipEntry entry = jarIn.getNextJarEntry();
			if (entry == null)
				break;

			File desTemp = new File(desDir.getAbsoluteFile() + File.separator
					+ entry.getName());

			if (entry.isDirectory()) { // jar条目是空目录
				if (!desTemp.exists()) {
					desTemp.mkdirs();
				}
			} else { // jar条目是文件
				BufferedOutputStream out = new BufferedOutputStream(
						new FileOutputStream(desTemp));
				int len = jarIn.read(bytes, 0, bytes.length);
				while (len != -1) {
					out.write(bytes, 0, len);
					len = jarIn.read(bytes, 0, bytes.length);
				}

				out.flush();
				out.close();

			}
			jarIn.closeEntry();
		}
	}
}