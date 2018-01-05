package stub;

import server.Dataservice.Cutdataservice.cut;
import shared.ResultMessage;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

public class cutdataservice_stub implements cut {

    String NO;
    int level;
    double cut;
    double voucher;
    String packNO;

    public cutdataservice_stub(String n, int l, double c, double v, String p) {
        NO = n;
        level = l;
        cut = c;
        voucher = v;
        packNO = p;
    }

    public String getNO() {
        return NO;
    }

    public int getLevel() {
        return level;
    }

    public double getCut() {
        return cut;
    }

    public double getVoucher() {
        return voucher;
    }

    public String getpackNO() {
        return packNO;
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
