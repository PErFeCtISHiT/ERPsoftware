package client.BLservice.Stockman.StockmanStockGlanceblservevice;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 10:05 2017/11/26
 */
public interface stockGlance {
    List stockglance(LocalDate from, LocalDate to) throws RemoteException, ParseException;
}
