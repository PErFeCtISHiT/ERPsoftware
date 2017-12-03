package client.BLservice.Manager.ManagerMakeCutblservice;
import server.Po.*;
import client.Vo.*;
import shared.ResultMessage;
public interface ManagerMakeCutblInterface {
    public ResultMessage insert(salePO po);
    public ResultMessage delete(salePO po);
    public ResultMessage find(salePO po);
    public ResultMessage modify(salePO po);
}
