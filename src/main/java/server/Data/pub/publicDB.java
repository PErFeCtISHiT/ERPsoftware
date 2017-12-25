package server.Data.pub;

import server.Data.tools.hibtools;
import server.Dataservice.pubservice.pub;
import server.Po.*;
import server.hibernate.*;
import shared.ResultMessage;
import shared.copyclass;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: pis
 * @description: good good study
 * @date: create in 13:53 2017/11/26
 */
public class publicDB implements pub {
    private static hibtools hib = new hibtools();
    private Object obj;
    private String hql;
    private Object po;
    private String sql;

    /**
     * @author:pis
     * @description: 增删改查
     * @date: 15:39 2017/11/30
     */

    @Override
    public ResultMessage addObject(Object object, int type) {
        generate(type);
        copyclass.copy(object, obj);
        return hib.Save(obj);
    }

    @Override
    public ResultMessage deleteObject(Object object, int type) {
        generate(type);
        copyclass.copy(object, obj);
        return hib.Delete(obj);
    }

    @Override
    public ResultMessage modifyObject(Object object, int type) {
        generate(type);
        copyclass.copy(object, obj);
        return hib.Modify(obj);
    }

    @Override
    public List findAll(int type) {
        hibtools.session = hibtools.sessionFactory.getCurrentSession();
        hibtools.tx = hibtools.session.beginTransaction();
        generate(type);
        List Entities = hibtools.session.createQuery(hql).list();
        List POS = new ArrayList<>();
        for (Object i : Entities) {
            generate(type);
            copyclass.copy(i, po);
            POS.add(po);
        }
        hibtools.tx.commit();
        return POS;
    }

    @Override
    public List findbyNO(int type, String no) {
        hibtools.session = hibtools.sessionFactory.getCurrentSession();
        hibtools.tx = hibtools.session.beginTransaction();
        generate(type);
        hql += "where KEYNO = ?";
        List Entities = hibtools.session.createQuery(hql).setParameter(0, no).list();
        List POS = new ArrayList<>();
        for (Object i : Entities) {
            generate(type);
            copyclass.copy(i, po);
            POS.add(po);
        }
        hibtools.tx.commit();
        return POS;
    }

    /**
     * @author:pis
     * @description: 导出excel
     * @date: 13:24 2017/12/10
     */
    @Override
    public ResultMessage exportToExcel(int type, String path) throws IOException, InterruptedException {
        generate(type);
        File temp = new File(path);
        if (!temp.exists())
            temp.createNewFile();
        String Path = this.getClass().getClassLoader().getResource("sqlplusroot.sql").getPath();
        File file = new File(Path);
        String separ = System.getProperty("line.separator");
        String str = "set linesize 200" + separ + "set term off verify off feedback off pagesize 999"
                + separ + "set markup html on entmap ON spool on preformat off" + separ +
                "spool " + path + separ + sql + ";" + separ + "spool off" + separ + "exit";
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(str);
        bufferedWriter.close();
        String exp = "sqlplus pis/liuyitong@172.26.71.52:1521/pis.exercise @" + file.getAbsolutePath();
        Runtime.getRuntime().exec(exp);
        Thread.sleep(1000);
        Runtime.getRuntime().exec("cmd /c start " + path);
        return ResultMessage.Success;
    }

    /**
     * @author:pis
     * @description: 产生Entity对象
     * @date: 10:11 2017/11/28
     */
    private void generate(int type) {
        switch (type) {
            case 0: {
                obj = new GoodsEntity();
                po = new goodsPO();
                hql = "from GoodsEntity ";
                sql = "select * from goods ";
                break;
            }
            case 1: {
                obj = new GoodskindsEntity();
                po = new goodskindsPO();
                hql = "from GoodskindsEntity ";
                sql = "select * from goodskinds ";
                break;
            }
            case 2: {
                obj = new ConsumerEntity();
                po = new consumerPO();
                hql = "from ConsumerEntity ";
                sql = "select * from consumer ";
                break;
            }
            case 3: {
                obj = new BuyinEntity();
                po = new buyinPO();
                hql = "from BuyinEntity ";
                sql = "select * from buyin ";
                break;
            }
            case 4: {
                obj = new SelloutEntity();
                po = new selloutPO();
                hql = "from SelloutEntity ";
                sql = "select * from sellout ";
                break;
            }
            case 5: {
                obj = new MoneyEntity();
                po = new moneyPO();
                hql = "from MoneyEntity ";
                sql = "select * from money";
                break;
            }
            case 6: {
                obj = new GiftEntity();
                po = new giftPO();
                hql = "from GiftEntity ";
                sql = "select * from gift ";
                break;
            }
            case 7: {
                obj = new StockexceptionEntity();
                po = new stockexceptionPO();
                hql = "from StockexceptionEntity ";
                sql = "select * from stockexception ";
                break;
            }
            case 8: {
                obj = new StockexceptionEntity();
                po = new stockexceptionPO();
                hql = "from StockexceptionEntity ";
                sql = "select * from stockexception ";
                break;
            }
            case 9: {
                obj = new WarningEntity();
                po = new WarningPO();
                hql = "from WarningEntity ";
                sql = "select * from warning ";
                break;
            }
            case 10: {
                obj = new CoEntity();
                po = new coPO();
                hql = "from CoEntity ";
                sql = "select * from co ";
                break;
            }
            case 11: {
                obj = new ConsumerEntity();
                po = new consumerPO();
                hql = "from ConsumerEntity ";
                sql = "select * from consumer ";
                break;
            }
            case 12: {
                obj = new CutEntity();
                po = new cutPO();
                hql = "from CutEntity ";
                sql = "select * from cut ";
                break;
            }
            case 13: {
                obj = new LogEntity();
                po = new logPO();
                hql = "from LogEntity ";
                sql = "select * from log ";
                break;
            }
            case 14: {
                obj = new PackEntity();
                po = new packPO();
                hql = "from PackEntity ";
                sql = "select * from pack ";
                break;
            }
            case 15: {
                obj = new UseEntity();
                po = new userPO();
                hql = "from UseEntity ";
                sql = "select * from use ";
                break;
            }
            case 16: {
                obj = new SaleEntity();
                po = new salePO();
                hql = "from SaleEntity ";
                sql = "select * from sale ";
                break;
            }
            case 17: {
                obj = new GoodsoutlistEntity();
                po = new goodsOutListPO();
                hql = "from GoodsoutlistEntity ";
                sql = "select * from goodsoutlist ";
                break;
            }
            case 18: {
                obj = new MoneylistEntity();
                po = new moneyListPO();
                hql = "from MoneylistEntity ";
                sql = "select * from moneylist ";
                break;
            }
            case 19: {
                obj = new StockgoodsEntity();
                po = new stockGoodsPO();
                hql = "from StockgoodsEntity ";
                sql = "select * from stockgoods ";
                break;
            }
            case 20: {
                obj = new AccountInitEntity();
                po = new AccountInitPO();
                hql = "from AccountInitEntity ";
                sql = "select * from AccountInit ";
                break;
            }
        }
    }

}