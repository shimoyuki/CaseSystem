package com.sys.util;
import java.io.*;  
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  

public class FileTool {

	/**
	 * 该方法可以找到指定的路径下的，符合正则reg的所有文件
	 * @param path
	 * @param reg
	 */
	public static void findFiles(String path,String reg){  
        Pattern pat=Pattern.compile(reg);  
        File file=new File(path);  
        File[] arr=file.listFiles();  
        for(int i=0;i<arr.length;i++){  
            //判断是否是文件夹，如果是的话，再调用一下find方法  
            if(arr[i].isDirectory()){  
            	findFiles(arr[i].getAbsolutePath(),reg);  
            }  
            Matcher mat=pat.matcher(arr[i].getAbsolutePath());  
            //根据正则表达式，寻找匹配的文件  
            if(mat.matches()){  
                //这个getAbsolutePath()方法返回一个String的文件绝对路径  
                System.out.println(arr[i].getAbsolutePath());  
            }  
        }  
    }  
	/**
	 * 该方法可以找到指定的路径下的
	 * @param path
	 * @param reg
	 * @return 
	 */
	public static ArrayList<String> findFolders(String path){  
		ArrayList<String> list=new ArrayList<String>();
        File file=new File(path);  
        File[] arr=file.listFiles();  
        for(int i=0;i<arr.length;i++){  
            //判断是否是文件夹，如果是的话,就加入list
            if(arr[i].isDirectory()){  
            	list.add(arr[i].getName());
            }  
        }  
        Collections.sort(list);
        return list;
    } 
    public static void main(String[] args) throws IOException{  
        new FileTool().findFolders("d:\\java小程序");  
    }  
}
