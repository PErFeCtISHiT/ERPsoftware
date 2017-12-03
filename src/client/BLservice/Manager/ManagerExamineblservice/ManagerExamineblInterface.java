package client.BLservice.Manager.ManagerExamineblservice;

import server.Po.salePO;
import shared.ResultMessage;

public interface ManagerExamineblInterface {
  public ResultMessage insert(salePO po);
  public ResultMessage find(String id);
  public ResultMessage delete(salePO po);
  public ResultMessage modify(salePO po);
}
