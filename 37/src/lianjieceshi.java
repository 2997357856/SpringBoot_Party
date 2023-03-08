import java.sql.*;
import java.util.*;

public class lianjieceshi {
    public static void main(String args[])
    {
        Statement statement=null;
        ResultSet resultset=null;
        Connection conn=null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.创建连接
            /****其中test1是我创建的数据库名，
             root是我数据库用户名，
             "123456"是我数据库密码********/
            String url="jdbc:mysql://localhost:3306/test1?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
            conn = DriverManager.getConnection(url,"root","123456");
            System.out.println("数据库连接成功" );
            //3.sql语句
            String sql="select * from goods";
            //4.得到statement对象
            statement = conn.prepareStatement(sql);
            //5.执行sql
            resultset = statement.executeQuery(sql);
            // 6.处理结果集
            while(resultset.next())
            {
                System.out.println("id: "+resultset.getString(1));
                System.out.println("good_name: "+resultset.getString(2));
                System.out.println("kc: "+resultset.getString(3));
                System.out.println("           ");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            //7.关闭连接
            if (resultset!=null){
                try{
                    resultset.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try{
                    conn.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(statement!=null) {
                try{
                    statement.close();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
