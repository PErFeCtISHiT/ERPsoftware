package server.Start;

import server.Data.pub.publicDB;
import server.RMIservice.RemoteHelper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class start {

    public static void main(String[] args) throws IOException {
        //publicDB publicDB = new publicDB();
        //publicDB.exportToExcel(0,"C:\\java\\1.xlsx");
        System.out.println(Runtime.getRuntime().exec("sqlplus pis/liuyitong@172.26.71.52:1521/pis.exe" +
                "rcise @C:\\java\\ERP\\ERPsoftware\\.\\src\\source\\sqlpl" +
                "usroot.sql"));
        //new RemoteHelper();
    }
}
