package server.Start;

import server.RMIservice.RemoteHelper;

import java.io.File;
import java.io.IOException;

public class start {

    public static void main(String[] args) throws IOException {
        String cmd = "sqlplus pis/liuyitong@sid @g://123.txt";
        Process process = Runtime.getRuntime().exec(cmd);
        //new RemoteHelper();
    }
}
