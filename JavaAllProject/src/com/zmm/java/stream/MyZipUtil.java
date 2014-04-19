package com.zmm.java.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class MyZipUtil {
	
	public static void main(String[] args) {
		try {
//			zip("D:\\SHYJ\\test.zip", "D:\\SHYJ\\export.txt");
			unZip("D:\\SHYJ\\test.zip", "D:\\SHYJ\\export.txt");
			System.out.println("success");
		} 
		catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	
	static final int BUFFER = 8192;
	
	private static final String ALGORITHM = "PBEWITHMD5AndDES";
	
	
	public static void zip(String zipFIleName, String inputFile, String pwd) throws Exception{

		zip(zipFIleName, new File(inputFile), pwd);
	}
	
	private static void zip(String zipFIleName, File file, String pwd) throws Exception{
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFIleName));
		zip(out, file, "", pwd);
		out.close();
	}

	public static void zip(String zipFIleName,String inputFile)throws Exception{
		zip(zipFIleName,new File(inputFile),null);
	}
	
	/**
	 * 压缩文件对象
	 * @param outputStream
	 * @param file
	 * @param base
	 * @param pwd
	 * @throws Exception
	 */
	public static void zip(ZipOutputStream outputStream,File file,String base,String pwd) throws Exception{
		if(file.isDirectory()){
			File[] fl = file.listFiles();
			outputStream.putNextEntry(new ZipEntry(base+"/"));
			base = base.length() == 0 ? "" : base+"/";
			for(int i = 0;i < fl.length;i++){
				zip(outputStream,fl[i],base+fl[i].getName(),pwd);
			}
		}else{
			outputStream.putNextEntry(new ZipEntry(base));
			FileInputStream inputStream = new FileInputStream(file);
			//压缩普通文件
			if(pwd == null || pwd.trim().equals("")){
				int b;
				while((b = inputStream.read()) != -1){
					outputStream.write(b);
				}
				inputStream.close();
			}
			//给文件加密
			else{
				PBEKeySpec keySpec = new PBEKeySpec(pwd.toCharArray());
				SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
				SecretKey passwordKey = keyFactory.generateSecret(keySpec);
				byte[] salt = new byte[8];
				Random rnd = new Random();
				rnd.nextBytes(salt);
				int iterations = 100;
				PBEParameterSpec parameterSpec = new PBEParameterSpec(salt, iterations);
				Cipher cipher = Cipher.getInstance(ALGORITHM);
				cipher.init(Cipher.ENCRYPT_MODE,passwordKey,parameterSpec);
				outputStream.write(salt);
				byte[] input = new byte[64];
				int bytesRead;
				while((bytesRead = inputStream.read(input)) != -1){
					byte[] output = cipher.update(input, 0, bytesRead);
					if(output != null){
						outputStream.write(output);
					}
				}
				byte[] output = cipher.doFinal();
				if(output != null){
					outputStream.write(output);
				}
				inputStream.close();
				outputStream.flush();
				outputStream.close();
			}
		}
//		file.delete();
	}
	
	public static void unZip(String zipFileName,String outputDirectory) throws Exception{
		ZipInputStream inputStream = new ZipInputStream(new FileInputStream(zipFileName));
		unZip(inputStream, outputDirectory,null);
	}
	
	public static void unzip(File zipFile,String outputDirectory,String pwd) throws Exception{
		ZipInputStream inputStream = new ZipInputStream(new FileInputStream(zipFile));
		unZip(inputStream, outputDirectory,null);
	}

	/**
	 * 将压缩文件解压到指定的文件目录下
	 * @param inputStream
	 * @param outputDirectory
	 * @param pwd
	 * @throws Exception
	 */
	private static void unZip(ZipInputStream inputStream,
			String outputDirectory, String pwd) throws Exception{
		ZipEntry zipEntry = null;
		FileOutputStream outputStream = null;
		try {
			while((zipEntry = inputStream.getNextEntry()) != null){
				if(zipEntry.isDirectory()){
					String name = zipEntry.getName();
					name = name.substring(0, name.length()-1);
					File file = new File(outputDirectory+File.separator+name);
					file.mkdir();
				}else{
					File file = new File(outputDirectory+File.separator+zipEntry.getName());
					file.createNewFile();
					outputStream = new FileOutputStream(file);
					//普通解压文件
					if(pwd == null || pwd.trim().equals("")){
						int b;
						while((b=inputStream.read()) != -1){
							zipEntry.getName();
						}
						outputStream.close();
					}else{
						//解压缩加密文件
						PBEKeySpec keySpec = new PBEKeySpec(pwd.toCharArray());
						SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
						
						SecretKey passwordKey = keyFactory.generateSecret(keySpec);
						byte[] salt = new byte[8];
						inputStream.read(salt);
						int iterations = 100;
						PBEParameterSpec parameterSpec = new PBEParameterSpec(salt, iterations);
						
						Cipher cipher = Cipher.getInstance(ALGORITHM);
						cipher.init(Cipher.DECRYPT_MODE, passwordKey,parameterSpec);
						byte[] input = new byte[64];
						int bytesRead;
						while((bytesRead = inputStream.read(input)) != -1){
							byte[] output = cipher.update(input, 0, bytesRead);
							if(output != null){
								outputStream.write(output);
							}
						}
						byte[] output = cipher.doFinal();
						if(output != null){
							outputStream.write(output);
						}
						outputStream.flush();
						outputStream.close();
					}
				}
			}
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error-------------");
		}finally{
			inputStream.close();
			outputStream.flush();
			outputStream.close();
		}
	}
}
