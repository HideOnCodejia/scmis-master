package com.xx.sm.framework.model.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtilTest {
    public static void main(String[] args) {
        DBUtil db = new DBUtil();
        //String sql = "insert into orgtype(orgTypeId, orgTypeName, orgTypeMemo) values('888', '数据挖掘', '基础课程')";

        //String sql = "delete from orgtype where orgTypeId = '888'";

        //int n = db.update(sql);
//        if(n > 0) {
//            System.out.println("更新成功！");
//        }
        String sql = "select * from student where Sno = 'S001'";
        ResultSet rs = db.query(sql);
        try {
            while (rs.next()) {
                System.out.println(rs.getString("Sno"));
                System.out.println(rs.getString("sname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }
}
