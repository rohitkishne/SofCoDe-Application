/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_components;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author dell
 */
public class compressor {
    public static void method(File file) throws IOException{
        String fileDirectory = file.getParent();
        
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDirectory+"/compressedDone");
        GZIPOutputStream gZipOS = new GZIPOutputStream(fos);
        
        byte[] buffer = new byte[1024];
        int len;
        
        while((len=fis.read(buffer))!=-1)
        {
            gZipOS.write(buffer,0,len);
        }
        
        gZipOS.close();
        fis.close();
        fos.close();  
    }
    public static void main(String[] args) throws IOException{
        File path = new File("C:\\Users\\dell\\Downloads");
        method(path);
   }
}
