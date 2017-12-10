package server.Start;

import server.Data.Financedata.accountInitDB;
import server.Data.pub.publicDB;
import server.Po.AccountInitPO;
import server.RMIservice.RemoteHelper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class start {

    public static void main(String[] args) {
        new RemoteHelper();

    }
}
