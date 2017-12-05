package client.BLservice.Manager.ManagerMakeCutblservice;
import server.Po.*;
import client.Vo.*;
import shared.ResultMessage;
public interface ManagerMakeCutblInterface {
    ResultMessage insert(salePO po);
    ResultMessage delete(salePO po);
    ResultMessage find(salePO po);
    ResultMessage modify(salePO po);
}
