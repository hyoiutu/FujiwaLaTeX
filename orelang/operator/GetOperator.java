package orelang.operator;

import java.util.List;

import orelang.Engine;

public class GetOperator implements IOperator {
    @Override
    public Object call(Engine engine, List<?> args) {
        return engine.variables.get(engine.eval(args.get(0)));
    }
}