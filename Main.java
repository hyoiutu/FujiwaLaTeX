import orelang.ConvertJSON;
import orelang.Engine;
import net.arnx.jsonic.JSON;
import java.io.*;

class Main{
        public static void main(String[] args){
                Engine engine = new Engine();
                // fujiwaLaTeX
                
                String converted = ConvertJSON.convert(args[0]);
                Object result = engine.eval(JSON.decode(converted));

                // orelang
                /*
                try{
                        Object result = engine.eval(JSON.decode(new FileReader("example.json")));
                }catch(FileNotFoundException e){
                        System.out.println(e);
                }catch(IOException e){
                        System.out.println(e);
                }
                */
        }
}