package com.sys.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
/**
 * ���ݿ����
 * @author �ܿ� ΰ
 *
 */
public class DatabaseBackup {
	/**
	 * ���ݿⱸ��
	 */
	public static void backup() {
        try {
            Runtime rt = Runtime.getRuntime();
 
            // ���� ����mysql�İ�װĿ¼������
            Process child = rt
//                    .exec("e:\\MySQL\\bin\\mysqldump -h localhost -uroot -p123 db_name");
            		.exec("C:\\ProgramFiles (x86)\\MySQL\\MySQL Server 5.5\bin\\mysqldump -h192.168.0.104 -p3306-uroot -p123456 policesystem");
            // ���õ�������Ϊutf-8�����������utf-8
            // �ѽ���ִ���еĿ���̨�����Ϣд��.sql�ļ����������˱����ļ���ע��������Կ���̨��Ϣ���ж�������ᵼ�½��̶����޷�����
            InputStream in = child.getInputStream();// ����̨�������Ϣ��Ϊ������
 
            InputStreamReader xx = new InputStreamReader(in, "utf-8");
            // �������������Ϊutf-8�����������utf-8����������ж����������
 
            String inStr;
            StringBuffer sb = new StringBuffer("");
            String outStr;
            // ��Ͽ���̨�����Ϣ�ַ���
            BufferedReader br = new BufferedReader(xx);
            while ((inStr = br.readLine()) != null) {
                sb.append(inStr + "\r\n");
            }
            outStr = sb.toString();
 
            // Ҫ�����������õ�sqlĿ���ļ���
            FileOutputStream fout = new FileOutputStream("c:\\test.sql");
            OutputStreamWriter writer = new OutputStreamWriter(fout, "utf-8");
            writer.write(outStr);
            writer.flush();
            in.close();
            xx.close();
            br.close();
            writer.close();
            fout.close();
 
            System.out.println("");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
	/**
	 * ���ݿ⻹ԭ
	 * @param databaseName
	 */
	public static void restore(String databaseName) {
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime
                    .exec("e:\\MySQL\\bin\\mysql.exe -hlocalhost -uroot -p123 --default-character-set=utf8 "
                            + databaseName);
            OutputStream outputStream = process.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream("C:\\test.sql"), "utf-8"));
            String str = null;
            StringBuffer sb = new StringBuffer();
            while ((str = br.readLine()) != null) {
                sb.append(str + "\r\n");
            }
            str = sb.toString();
            // System.out.println(str);
            OutputStreamWriter writer = new OutputStreamWriter(outputStream,
                    "utf-8");
            writer.write(str);
            writer.flush();
            outputStream.close();
            br.close();
            writer.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
