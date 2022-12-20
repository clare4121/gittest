package com.bee.sample.chl.jdbcDemo;

import java.io.UnsupportedEncodingException;
import java.sql.*;


public class Date {
        static String name;
        static int age;
        static String address;
        static String wage;
        public static void main(String[] dd) {
            select();
            }
            public static void select() {
            Connection con = getConnection();
            Statement st;
            try {
                st = con.createStatement();
                //创建一个Statement对象
                ResultSet rs = st.executeQuery("select * from crawler_gp_build_grid_company_record ");
                //执行SQL命令，返回一个结果集合
                while (rs.next()) {
                name = new String(rs.getString("ID"));
                //对中文进行乱码处理
                age = rs.getInt("GP_ID");
                //从结果集中将age字段的内容取出来
                address = new String(rs.getString("ADDRESS"));
                wage = rs.getString("BUILD_NAME");
                System.out.println(name + "," + age+","+address+","+wage);
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }





        public static Connection getConnection() {
            Connection con = null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                //加载相关数据库的JDBC驱动
                con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
                con.setAutoCommit(false);
                //创建连接
            } catch (Exception e) {
                e.printStackTrace();
            }
            return con;
        }

}