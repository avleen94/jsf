package application;

import java.sql.*;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@RequestScoped
public class LoginBean {
    
    String username;
    String password;
    String dbUsername;
    String dbPassword;
    
    Connection con;
    Statement stmt;
    ResultSet rs;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getDbUsername() {
        return dbUsername;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }
    
        
    public void dbUsers(String userName)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtech","root","");
            stmt = con.createStatement();
            String sql = "Select username,password from users where username like ('" + userName +"')";
            rs = stmt.executeQuery(sql);
            rs.next();
            dbUsername = rs.getString(1).toString();
            dbPassword = rs.getString(2).toString();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
     
    public String checkValidUser()
    {
        dbUsers(username);
    
        if(username.equals(dbUsername))
        {
  
            if(password.equals(dbPassword)){
                return "filme.xhtml";
            }
                
            else
            {
                return "index.html";
            }
        }
        else
        {
            return "index.html";
        }
    }

    
}
