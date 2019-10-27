package com.sys.util;
import java.io.*;  
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  

public class FileTool {

	/**
	 * �÷��������ҵ�ָ����·���µģ���������reg�������ļ�
	 * @param path
	 * @param reg
	 */
	public static void findFiles(String path,String reg){  
        Pattern pat=Pattern.compile(reg);  
        File file=new File(path);  
        File[] arr=file.listFiles();  
        for(int i=0;i<arr.length;i++){  
            //�ж��Ƿ����ļ��У�����ǵĻ����ٵ���һ��find����  
            if(arr[i].isDirectory()){  
            	findFiles(arr[i].getAbsolutePath(),reg);  
            }  
            Matcher mat=pat.matcher(arr[i].getAbsolutePath());  
            //����������ʽ��Ѱ��ƥ����ļ�  
            if(mat.matches()){  
                //���getAbsolutePath()��������һ��String���ļ�����·��  
                System.out.println(arr[i].getAbsolutePath());  
            }  
        }  
    }  
	/**
	 * �÷��������ҵ�ָ����·���µ�
	 * @param path
	 * @param reg
	 * @return 
	 */
	public static ArrayList<String> findFolders(String path){  
		ArrayList<String> list=new ArrayList<String>();
        File file=new File(path);  
        File[] arr=file.listFiles();  
        for(int i=0;i<arr.length;i++){  
            //�ж��Ƿ����ļ��У�����ǵĻ�,�ͼ���list
            if(arr[i].isDirectory()){  
            	list.add(arr[i].getName());
            }  
        }  
        Collections.sort(list);
        return list;
    } 
    public static void main(String[] args) throws IOException{  
        new FileTool().findFolders("d:\\javaС����");  
    }  
}
