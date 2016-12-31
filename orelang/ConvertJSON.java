package orelang;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class ConvertJSON{
    public static String convert(String filePath){
        String target = "";

        try{
            target = readAll(filePath);
        }catch(IOException e){
            System.out.println(e);  
        }
        
        target = target.replaceAll("\\\\begin\\{(fujiwaLaTeX)\\}","[step,");
        target = target.replaceAll("\\\\end\\{(fujiwaLaTeX)\\}","]");
        target = target.replaceAll(";", ",");
        

        target = target.replaceAll("\\\\", "\\\\\"");       
        target = target.replaceAll("\\{", "\"\\{");
        target = target.replaceAll("\\}\"\\{", "\\}\\{");

        
        target = target.replaceAll("[\n\t]", "");
        target = target.replaceAll("\\\\", "\\[");
        target = target.replaceAll("\\}\\{", ",");
        target = target.replaceAll("\\{", ",");   
        target = target.replaceAll("\\}", "\\]"); 
        target = target.replaceAll(",\\]", "\\]");
      
        return target;
    }   

    public static String readAll(final String path) throws IOException {
        return Files.lines(Paths.get(path), Charset.forName("UTF-8"))
        .collect(Collectors.joining(System.getProperty("line.separator")));
    }
}