package com.gxf.how_tomcat.chapter7;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 58 on 2018/4/10.
 * 1. log文件名：yyyy-MM-dd-gxf.log
 * 2. log内容格式：日期yyyy-MM-dd
 */
public class FileLogDemo {
    private static String logFileSuffix = "-gxf-log";
    private static File logFile;

    public static void main(String[] args) {
        //打开日志文件
        open(0);
        int index = 0;
        //写日志
        while(true){
            String msg = "log msg ";
            String data = getDateStringFormat(new Date(), "yyyy-MM-dd");
            msg = data + msg;
            writeLog(msg, index ++);
            System.out.println("write log : " + msg);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void open(int index){
        String logFilePath = getLogFilePath(index);
        System.out.println("logFilePath: " + logFilePath);
        logFile = new File(logFilePath);
        if(!logFile.exists()){
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(File logFile){
        logFile = null;
    }

    public static void writeLog(String logMsg, int index){
        try {
            if(index > 10 && index < 12){
                //切到新日志文件
                open(index);
            }
            FileWriter fileWriter = new FileWriter(logFile, true);
            fileWriter.write(logMsg + "\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getLogFilePath(int index){
        String fileName = getDateStringFormat(new Date(), "yyyy-MM-dd")  + index + logFileSuffix + ".log";
        String res = getCurPath() + "/" + fileName;
        return res;
    }

    private static String getCurPath(){
        return System.getProperty("user.dir");
    }

    private static String getDateStringFormat(Date date, String format){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

}
