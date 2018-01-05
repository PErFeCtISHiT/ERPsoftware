package stub;

import server.Dataservice.Consumerdataservice.Consumer;
import shared.ResultMessage;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

public class consumerdataservice_stub implements Consumer {

    String NO;
    int kind;
    int level;
    String name;
    String tel;
    String mail;
    String email;
    double capacity;
    double receive;
    double pay;
    String server;
    String account;

    public consumerdataservice_stub(String n1, int k, int l, String n2, String t, String m, String e, double c, double r, double p, String s, String a) {
        NO = n1;
        kind = k;
        level = l;
        name = n2;
        tel = t;
        mail = m;
        email = e;
        capacity = c;
        receive = r;
        pay = p;
        server = s;
        account = a;
    }

    public String getNO() {
        return NO;
    }

    public int getKind() {
        return kind;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    public String getMail() {
        return mail;
    }

    public String getEmail() {
        return email;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getReceive() {
        return receive;
    }

    public double getPay() {
        return pay;
    }

    public String getServer() {
        return server;
    }

    public String getAccout() {
        return account;
    }


    @Override
    public List findConsumer(String keyword) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage addObject(Object object, int type) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage deleteObject(Object object, int type) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage modifyObject(Object object, int type) throws RemoteException {
        return null;
    }

    @Override
    public List findAll(int type) throws RemoteException {
        return null;
    }

    @Override
    public List findbyNO(int type, String no) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage exportToExcel(int type, String path) throws RemoteException, IOException, InterruptedException {
        return null;
    }
}
