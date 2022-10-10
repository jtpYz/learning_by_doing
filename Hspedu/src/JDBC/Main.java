package JDBC;

import DAO.GoodsDAO;
import JDBCUtils.JDBCUtils;
import domain.Goods;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Connection connection =JDBCUtils.getConnection();
        GoodsDAO goodsDAO = new GoodsDAO();
        List<Goods> goods = goodsDAO.queryMulti("select *from Goods", Goods.class);
        for (Goods good : goods) {
            System.out.println(good);
        }
        JDBCUtils.close(null,null,connection);
    }
}
