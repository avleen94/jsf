
package application;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import java.sql.*;

@ManagedBean
@RequestScoped
public class FilmBean {

    private String titel;
    private String regisseur;
    private int erscheinungsjahr;
    private String genre;
    private String actor;    

    public String getActor() {
        return actor;
    }

    public void setActor(String actor1) {
        this.actor = actor1;
    }

    public String getTitel() {
        return titel;
    }
    
    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getRegisseur() {
        return regisseur;
    }
    
    public void setRegisseur(String regisseur) {
        this.regisseur = regisseur;
    }

    public int getErscheinungsjahr() {
        return erscheinungsjahr;
    }
    
    public void setErscheinungsjahr(int erscheinungsjahr) {
        this.erscheinungsjahr = erscheinungsjahr;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public String insertData() throws Exception{
        int result = 0;  
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtech","root","");
            if(con==null)
                throw new SQLException("ConnectionProblem");
            PreparedStatement ps = con.prepareStatement("insert into filme (titel,regisseur,erscheinungsjahr,genre,schauspieler) values(?,?,?,?,?)");
            ps.setString(1,this.getTitel()); ps.setString(2,this.getRegisseur()); 
            ps.setInt(3,this.getErscheinungsjahr()); ps.setString(4,this.getGenre()); ps.setString(5,this.getActor());
            result = ps.executeUpdate();
 
        }catch(Exception e){  
            System.out.println(e);  
        }  
        if(result == 1){  
            return "filme.xhtml";  
        }else return "index.xhtml";  
    } 
    
}
