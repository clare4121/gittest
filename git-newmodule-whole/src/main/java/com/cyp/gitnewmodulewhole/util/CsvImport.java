package com.cyp.gitnewmodulewhole.util;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class CsvImport {
    public static List<List> importCsv(File file) {
        List<List> dataList = new ArrayList<List>();
        BufferedReader br = null;
        try {
            DataInputStream in = new DataInputStream(new FileInputStream(file));
            br = new BufferedReader(new InputStreamReader(in, "GBK"));
            String line = "";

            while ((line = br.readLine()) != null) {
                String[] str = new String[3];
                // str=line.split(",");
                str = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                List list = new ArrayList();
                if (str.length == 3) {
                    list.add(str[0]);
                    list.add(str[1]);
                    list.add(str[2]);
                    list.add(" ");
                } else if (str.length == 4) {
                    list.add(str[0]);
                    list.add(str[1]);
                    list.add(str[2]);
                    list.add(str[3]);
                } else if (str.length == 2) {
                    list.add(str[0]);
                    list.add(str[1]);
                    list.add(" ");
                    list.add(" ");
                }
                dataList.add(list);
            }
        } catch (Exception e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                    br = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return dataList;
    }

    public void sqlInsert(List list, Connection connection) {
        try {
            StringBuffer sql = new StringBuffer();
            sql.append(" INSERT INTO   T_HUAXIAO_EXPAND_INFO_TMP( DEVICE_NUMBER ,VAR1,VAR2, VAR3 ) VALUES (?,?,?,?)");
            connection.setAutoCommit(false);
            PreparedStatement pst = (PreparedStatement) connection.prepareStatement(sql.toString());
            for (int i = 1; i < list.size(); i++) {
                ArrayList list1 = (ArrayList) list.get(i);
                pst.setString(1, list1.get(0).toString());
                pst.setString(2, list1.get(1).toString());
                pst.setString(3, list1.get(2).toString());
                pst.setString(4, list1.get(3).toString());
                // 把一个SQL命令加入命令列表
                pst.addBatch();
            }
            // 执行批量更新
            pst.executeBatch();
            // 语句执行完毕，提交本事务
            connection.commit();
            pst.close();
            connection.close();
        } catch (
                Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("执行结束");
        }
    }
}
