package server.Start;

import server.RMIservice.RemoteHelper;

import java.io.IOException;

public class start {
    public static void main(String[] args) throws IOException {
        new RemoteHelper();
        String cmd="sqlplus pis/liuyitong@sid @shared.sqlplusroot";
        Process process = Runtime.getRuntime().exec(cmd);

    }
}
