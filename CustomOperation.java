package build;

import data.ObjType;
import data.ReadableFile;
import data.WritableFile;
import operations.Operation;
import parser.Interpreter;

import java.io.IOException;
import java.util.HashMap;

public enum CustomOperation implements Operation {
    PING {
        @Override
        public ObjType[] getArguments() {
            return new ObjType[]{};
        }

        @Override
        public void execute(Object[] instruction, float[] memory, HashMap<String, WritableFile> writableFiles, HashMap<String, ReadableFile> readableFiles, HashMap<String, data.Array> arrays, String[] stringTable) throws IOException {
            System.out.println("Pong!");
        }

        @Override
        public String help() {
            return "Ping - Pong!";
        }
    },
    COS {
        @Override
        public ObjType[] getArguments() {
            return new ObjType[]{ObjType.NUMBER};
        }

        @Override
        public void execute(Object[] instruction, float[] memory, HashMap<String, WritableFile> writableFiles, HashMap<String, ReadableFile> readableFiles, HashMap<String, data.Array> arrays, String[] stringTable) throws IOException {
            memory[(Integer) instruction[8]] = (float) Math.cos(Interpreter.getValue(instruction[1], memory));
        }

        @Override
        public String help() {
            return "The cosine of arg0";
        }
    },
    SIN {
        @Override
        public ObjType[] getArguments() {
            return new ObjType[]{ObjType.NUMBER};
        }

        @Override
        public void execute(Object[] instruction, float[] memory, HashMap<String, WritableFile> writableFiles, HashMap<String, ReadableFile> readableFiles, HashMap<String, data.Array> arrays, String[] stringTable) throws IOException {
            memory[(Integer) instruction[8]] =  (float) Math.sin(Interpreter.getValue(instruction[1], memory));
        }

        @Override
        public String help() {
            return "The sine of arg0";
        }
    },
    ABS {
        @Override
        public ObjType[] getArguments() {
            return new ObjType[]{ObjType.NUMBER};
        }

        @Override
        public void execute(Object[] instruction, float[] memory, HashMap<String, WritableFile> writableFiles, HashMap<String, ReadableFile> readableFiles, HashMap<String, data.Array> arrays, String[] stringTable) throws IOException {
            memory[(Integer) instruction[8]] = (float) Math.abs(Interpreter.getValue(instruction[1], memory));
        }

        @Override
        public String help() {
            return "The absolute value of arg0";
        }
    },
    LOG {
        @Override
        public ObjType[] getArguments() {
            return new ObjType[]{ObjType.NUMBER};
        }

        @Override
        public void execute(Object[] instruction, float[] memory, HashMap<String, WritableFile> writableFiles, HashMap<String, ReadableFile> readableFiles, HashMap<String, data.Array> arrays, String[] stringTable) throws IOException {
            memory[(Integer) instruction[8]] = (float) Math.log(Interpreter.getValue(instruction[1], memory));
        }

        @Override
        public String help() {
            return "The logarithm of arg0";
        }
    },
    POW {
        @Override
        public ObjType[] getArguments() {
            return new ObjType[]{ObjType.NUMBER, ObjType.NUMBER};
        }

        @Override
        public void execute(Object[] instruction, float[] memory, HashMap<String, WritableFile> writableFiles, HashMap<String, ReadableFile> readableFiles, HashMap<String, data.Array> arrays, String[] stringTable) throws IOException {
            memory[(Integer) instruction[8]] = (float) Math.pow(Interpreter.getValue(instruction[1], memory), Interpreter.getValue(instruction[2], memory));
        }

        @Override
        public String help() {
            return "arg0 raised to the power of arg1";
        }
    },
    ROUND {
        @Override
        public ObjType[] getArguments() {
            return new ObjType[]{ObjType.NUMBER};
        }

        @Override
        public void execute(Object[] instruction, float[] memory, HashMap<String, WritableFile> writableFiles, HashMap<String, ReadableFile> readableFiles, HashMap<String, data.Array> arrays, String[] stringTable) throws IOException {
            memory[(Integer) instruction[8]] = (float) Math.round(Interpreter.getValue(instruction[1], memory));
        }

        @Override
        public String help() {
            return "Rounds the result to the closest integer";
        }
    };

    public CustomOperation value(String str) {
        return switch (str) {
            case "PING" -> PING;
            case "COS" -> COS;
            case "SIN" -> SIN;
            case "ABS" -> ABS;
            case "ROUND" -> ROUND;
            case "POW" -> POW;
            case "LOG" -> LOG;
            default -> null;
        };
    }

    CustomOperation() {
    }
}
