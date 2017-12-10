package server.Start;

import server.Data.pub.publicDB;
import server.RMIservice.RemoteHelper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class start {

    public static void main(String[] args) throws IOException {
        new RemoteHelper();
    }
}
