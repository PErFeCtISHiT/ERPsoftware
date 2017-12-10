package server.Start;

import server.Data.Financedata.accountInitDB;
import server.Data.pub.publicDB;
import server.RMIservice.RemoteHelper;

import java.beans.IntrospectionException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class start {

    public static void main(String[] args) throws IOException, IllegalAccessException, IntrospectionException, InvocationTargetException {
        new RemoteHelper();
    }
}
