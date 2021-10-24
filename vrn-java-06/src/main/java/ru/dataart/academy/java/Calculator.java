package ru.dataart.academy.java;
import java.io.*;
import java.util.zip.*;
import java.util.Scanner;

public class Calculator {
    /**
     * @param zipFilePath -  path to zip archive with text files
     * @param character   - character to find
     * @return - how many times character is in files
     */
    public Integer getNumberOfChar(String zipFilePath, char character) {
        int result=0;
        try(ZipInputStream zip = new ZipInputStream(new FileInputStream(zipFilePath)))
        {
            ZipEntry entry;
            while((entry=zip.getNextEntry())!=null){

                FileReader reader=null;
                try{
                    Scanner in = new Scanner(zip, "UTF-8");
                    String c="";
                    while (in.hasNext()) {
                        c = in.next();
                        for(int i=0;i<c.length();i++){
                            if(c.charAt(i)==character)
                                result++;
                        }
                    }
                }finally{
                    if(reader!=null)
                        reader.close();
                }
                zip.closeEntry();
            }
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        return result;
    }

    /**
     * @param zipFilePath - path to zip archive with text files
     * @return - max length
     */

    public Integer getMaxWordLength(String zipFilePath) {
        int result=0;
        try(ZipInputStream zip = new ZipInputStream(new FileInputStream(zipFilePath)))
        {
            ZipEntry entry;
            while((entry=zip.getNextEntry())!=null){
                FileReader reader=null;
                try{
                    Scanner in = new Scanner(zip, "UTF-8");
                    String c="";
                    while (in.hasNext()) {
                        c = in.next();
                        int tmp=0;
                        for(int i=0;i<c.length();i++){
                            tmp++;
                        }
                        if(tmp>result){
                            result=tmp;
                        }
                    }
                }finally{
                    if(reader!=null)
                        reader.close();
                }
                zip.closeEntry();
            }
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        return result;
    }

}
