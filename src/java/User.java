import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rishav Saxena
 */
public class User {
    private String name;
    private int age;
    private String address;
    private String email;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    private static Connection getConnection()
    {
        Connection con=null;
        //if (System.getProperty("RDS_HOSTNAME") != null) {
            try{
                /*
                String dbName = System.getProperty("RDS_DB_NAME");
                String userName = System.getProperty("RDS_USERNAME");
                String password = System.getProperty("RDS_PASSWORD");
                String hostname = System.getProperty("RDS_HOSTNAME");
                String port = System.getProperty("RDS_PORT");*/
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection(  
		"jdbc:mysql://cloudproject.cazz0vvhfdda.us-east-1.rds.amazonaws.com:3306/cloudproject","root","rishavrocks");
                return con;
                /*Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cloudproject","root","rishavrocks");*/
            }
            catch(Exception e){System.out.println(e); return null;}
        
    }
    public String writeDatabase()
    {
        try{
            Connection con=getConnection();
            PreparedStatement ps=con.prepareStatement("insert into user(username,age,address,email,password) values(?,?,?,?,?)");
            ps.setString(1,this.getName());
            ps.setString(2,""+this.getAge());
            ps.setString(3,this.getAddress());
            ps.setString(4,this.getEmail());
            ps.setString(5,this.getPassword());
            ps.executeUpdate();
            con.close();
            return "1";
        }
        catch(Exception e){/*System.out.println(e);*/return e.toString();}
    }
    public static boolean validate(String email,String password){
        Connection con=getConnection();
        try{
            PreparedStatement ps=con.prepareStatement("select email,password from user where email=? and password=?");
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return true;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
        return false;
    }
    public int updateDatabase(String email)
    {
        Connection con=getConnection();
        try{
            PreparedStatement ps=con.prepareStatement("delete from user where email=?");
            ps.setString(1,email);
            ps.executeUpdate();
            ps=con.prepareStatement("insert into user(username,age,address,email,password) values(?,?,?,?,?)");
            ps.setString(1,this.getName());
            ps.setString(2,""+this.getAge());
            ps.setString(3,this.getAddress());
            ps.setString(4,this.getEmail());
            ps.setString(5,this.getPassword());
            ps.executeUpdate();
            con.close();
            return 1;
        }
        catch(Exception e){
            System.out.println(e);
            return 0;
        }
    }
    public static void deleteAccount(String email)
    {
        Connection con=getConnection();
        try{
            PreparedStatement ps=con.prepareStatement("delete from user where email=?");
            ps.setString(1,email);
            ps.executeUpdate();
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
