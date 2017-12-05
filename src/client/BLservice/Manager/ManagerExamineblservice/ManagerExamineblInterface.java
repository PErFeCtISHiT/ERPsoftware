package client.BLservice.Manager.ManagerExamineblservice;

import server.Po.salePO;
import shared.ResultMessage;

public interface ManagerExamineblInterface {
  ResultMessage insert(salePO po);
  ResultMessage find(String id);
  ResultMessage delete(salePO po);
  ResultMessage modify(salePO po);
}
