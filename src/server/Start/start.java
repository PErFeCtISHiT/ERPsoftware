package server.Start;

import server.RMIservice.RemoteHelper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class start {

    public static void main(String[] args) throws IOException {
        File file = new File("./src/shared/sqlplusroot");
        System.out.println(file.getAbsolutePath());
        String cmd = "sqlplus pis/liuyitong@172.26.71.52:1521/pis.exercise @";
        cmd += file.getAbsolutePath();
        System.out.print(cmd);
        Runtime.getRuntime().exec(cmd);
        //new RemoteHelper();
    }
}
