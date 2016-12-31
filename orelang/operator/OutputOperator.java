package orelang.operator;

import java.util.List;
import java.util.regex.*;
import java.util.ArrayList;

import orelang.Engine;

public class OutputOperator implements IOperator {
    @Override
    public Object call(Engine engine, List<?> args) {
        Object value = engine.eval(args.get(0));
        String lawString =  (String)value;
        //lawString = lawString.replaceAll(" ", "");
        String[] strings = lawString.split("\\+", 0);
        Pattern p = Pattern.compile("\'(.+?)\'");
        ArrayList<String> values = new ArrayList<String>();
        for(String str: strings){
            Matcher m = p.matcher(str);
            if (!m.find()){
                str = str.replaceAll(" ", "");
                System.out.print(engine.variables.get(str));
            }
            else{
                System.out.print(m.group(1));
            }
        }
        System.out.println();
        return value;
    }
}