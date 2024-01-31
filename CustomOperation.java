package build;

import data.ObjType;
import data.ReadableFile;
import data.WritableFile;
import operations.Operation;
import parser.Interpreter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

public enum CustomOperation implements Operation {
    PING {
        @Override
        public ObjType[] getArguments() {
            return new ObjType[]{};
        }

        @Override
        public void execute(Object[] instruction, HashMap<String, Float> memory, HashMap<String, WritableFile> writableFiles, HashMap<String, ReadableFile> readableFiles) throws IOException {
            System.out.println("Pong!");
        }
    },
    COS {
        @Override
        public ObjType[] getArguments() {
            return new ObjType[]{ObjType.NUMBER};
        }

        @Override
        public void execute(Object[] instruction, HashMap<String, Float> memory, HashMap<String, WritableFile> writableFiles, HashMap<String, ReadableFile> readableFiles) throws IOException {
            memory.put((String) instruction[8], (float) Math.cos(Interpreter.getValue(instruction[1], memory)));
        }
    },
    SIN {
        @Override
        public ObjType[] getArguments() {
            return new ObjType[]{ObjType.NUMBER};
        }

        @Override
        public void execute(Object[] instruction, HashMap<String, Float> memory, HashMap<String, WritableFile> writableFiles, HashMap<String, ReadableFile> readableFiles) throws IOException {
            memory.put((String) instruction[8], (float) Math.sin(Interpreter.getValue(instruction[1], memory)));
        }
    },
    ABS {
        @Override
        public ObjType[] getArguments() {
            return new ObjType[]{ObjType.NUMBER};
        }

        @Override
        public void execute(Object[] instruction, HashMap<String, Float> memory, HashMap<String, WritableFile> writableFiles, HashMap<String, ReadableFile> readableFiles) throws IOException {
            memory.put((String) instruction[8], (float) Math.abs(Interpreter.getValue(instruction[1], memory)));
        }
    },
    LOG {
        @Override
        public ObjType[] getArguments() {
            return new ObjType[]{ObjType.NUMBER};
        }

        @Override
        public void execute(Object[] instruction, HashMap<String, Float> memory, HashMap<String, WritableFile> writableFiles, HashMap<String, ReadableFile> readableFiles) throws IOException {
            memory.put((String) instruction[8], (float) Math.log(Interpreter.getValue(instruction[1], memory)));
        }
    },
    POW {
        @Override
        public ObjType[] getArguments() {
            return new ObjType[]{ObjType.NUMBER, ObjType.NUMBER};
        }

        @Override
        public void execute(Object[] instruction, HashMap<String, Float> memory, HashMap<String, WritableFile> writableFiles, HashMap<String, ReadableFile> readableFiles) throws IOException {
            memory.put((String) instruction[8], (float) Math.pow(Interpreter.getValue(instruction[1], memory), Interpreter.getValue(instruction[2], memory)));
        }
    },
    ROUND {
        @Override
        public ObjType[] getArguments() {
            return new ObjType[]{ObjType.NUMBER};
        }

        @Override
        public void execute(Object[] instruction, HashMap<String, Float> memory, HashMap<String, WritableFile> writableFiles, HashMap<String, ReadableFile> readableFiles) throws IOException {
            memory.put((String) instruction[8], (float) Math.round(Interpreter.getValue(instruction[1], memory)));
        }
    };

    public CustomOperation value(String str) {
        switch (str) {
            case "PING":
                return PING;

            case "COS":
                return COS;

            case "SIN":
                return SIN;

            case "ABS":
                return ABS;

            case "ROUND":
                return ROUND;

            case "POW":
                return POW;

            case "LOG":
                return LOG;

            default:
                return null;
        }
    }

    CustomOperation() {
    }
}
