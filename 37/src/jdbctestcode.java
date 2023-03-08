import java.sql.*;
import java.util.*;

public class jdbctestcode {
    public static void main(String[] args)  {

        //Connection是与数据库的连接
        Connection coon = null;
        //Statement是实现数据库的增删改查
        Statement stmt = null;
        //ResultSet是实现结果集的遍历
        ResultSet rs = null;

        try {
            ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
            String driver = bundle.getString("driver");
            String url = bundle.getString("url");
            String user = bundle.getString("user");
            String password= bundle.getString("password");

            Class.forName(driver);

            coon = DriverManager.getConnection(url,user,password);

            System.out.println("数据库连接成功" );

            //获取数据库操作对象（Statement专门执行sql语句），这句话一定有
            stmt = coon.createStatement();



//            //执行sql的插入语句
//            String sql = "insert into admin_information(admin_id,admin_password) values('hu',123456)";
//            //这个语句专门执行(insert delete update)
//            //其中count是“影响数据库中记录的条数”
//            int count = stmt.executeUpdate(sql);
//            if(count>0){
//                System.out.println("插入数据成功");
//            }else{
//                System.out.println("插入数据失败");
//            }
//            //执行完毕sql的插入语句


            /*
            //执行sql的删除语句
            String sql = "delete from admin_information where admin_id='wang'";
            //这个语句专门执行(insert delete update)
            //其中count是“影响数据库中记录的条数”
            int count = stmt.executeUpdate(sql);
            if(count>0){
                System.out.println("删除数据成功");
            }else{
                System.out.println("删除数据失败");
            }
            //执行完毕sql的删除语句
            */

            /*
            //执行sql的更新语句
            String sql = "update  admin_information set admin_password=12345 where admin_id='yang'";
            //这个语句专门执行(insert delete update)
            //其中count是“影响数据库中记录的条数”
            int count = stmt.executeUpdate(sql);
            if(count>0){
                System.out.println("修改数据成功");
            }else{
                System.out.println("修改数据失败");
            }
            //执行完毕sql的更新语句
             */


            //执行sql的查询语句
            rs = stmt.executeQuery("select id,good_name from goods");
            //查询结果集
            //.next()是如果有下一行，则返回true，如果没有下一行，就返回false
            //getString()方法的特点：不管数据库里面的数据类型是什么，最后都是以String出现
            //如果只要查询第一行数据，把while改成if
            while (rs.next()){
                int id = rs.getInt("id");
                String  good_name = rs.getString("good_name");

//                String id = rs.getString("id");
//                int good_name = rs.getInt("good_name");
                System.out.println(id + "," + good_name);
            }
            //执行完毕sql的查询语句


        }catch(Exception e){
            e.printStackTrace();
        }finally {
            //为了保证资源一定释放，在finally里面写
            //一定要从小到大关闭
            if (rs!=null){
                try{
                    rs.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if (stmt!=null){
                try{
                    stmt.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if (coon!=null){
                try{
                    coon.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
