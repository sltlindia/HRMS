package com.hrms.PayrollBalance;

import java.io.*;
import java.text.*;
import java.util.*;

    public class Logger {
    protected static String defaultLogFile = null;
   
        public static void write(String logdata , String location , String fileName) throws IOException {
        defaultLogFile = location+"\\"+fileName;
        write(defaultLogFile, logdata);
        }
   
        public static void write(String f, String logdata) throws IOException {
        TimeZone tz = TimeZone.getTimeZone("EST"); // or PST, MID, etc ...
        Date now = new Date();
        
        FileWriter aWriter = new FileWriter(f, true);
        String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.
        aWriter.write(newLine+""+logdata);
        System.out.println("LOG WRITTEN");
        aWriter.flush();
        aWriter.close();
    }
        
        
}
