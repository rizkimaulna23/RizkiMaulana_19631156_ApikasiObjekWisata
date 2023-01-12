package AplikasiWisata;

import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {
    
    static Connection conn;
	public static Connection getConnection(){
            try{
                conn = DriverManager.getConnection("jdbc:mysql://localhost/objek_wisata", "root", "");
            } catch(Exception e) {
                System.out.println(e.toString());
            }
	return conn;
    }
    
}
