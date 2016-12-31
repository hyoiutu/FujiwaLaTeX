package orelang.operator;

import java.util.List;
import java.util.regex.*;
import java.util.ArrayList;
import java.io.*;
import java.math.BigDecimal;


import orelang.Engine;

public class InputOperator implements IOperator{
    @Override
    public Object call(Engine engine, List<?> args){
        Object value = new Object();
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            value = new BigDecimal(in.readLine());
            engine.variables.put((String)engine.eval(args.get(0)), value);
        }catch(IOException e){
            System.out.println(e);
        }
        return value;
    }
}

