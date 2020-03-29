package from_21_03_20;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class AviaSQL {
    public static void main (String [] args) {
        Connection conn = null;
        Statement statement = null;
        ResultSet rejsSet = null, aeroportSet1 = null, aeroportSet2 = null, samoletSet = null;
        try {
            String url = "jdbc:mysql://195.19.44.146:3306/user7?useUnicode=true&serverTimezone=UTC";
            Class.forName ("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection (url, "user7", "user7");
            System.out.println ("Connected...!");
            statement = conn.createStatement ();
            rejsSet = statement.executeQuery ("select * from Rejs");
            Scanner scan = new Scanner (System.in);
            int n = scan.nextInt ();
            while (n != 1) {
                rejsSet.next ();
                -- n;
            }
            aeroportSet1 = statement.executeQuery ("select * from Aeroport");
            n = Integer.parseInt (rejsSet.getString (2));
            while (n != 1) {
                aeroportSet1.next ();
                -- n;
            }
            aeroportSet2 = statement.executeQuery ("select * from Aeroport");
            n = Integer.parseInt (rejsSet.getString (3));
            while (n != 1) {
                aeroportSet2.next ();
                -- n;
            }
            samoletSet = statement.executeQuery ("select * from Samolet");
            n = Integer.parseInt (rejsSet.getString (4));
            while (n != 1) {
                samoletSet.next ();
                -- n;
            }
            System.out.println ("From: " + aeroportSet1.getString (2));
            System.out.println ("To: " + aeroportSet2.getString (2));
            System.out.println ("Plane model: " + samoletSet.getString (3));
            System.out.println ("Plane type: " + samoletSet.getString (4));
            System.out.print ("Plane capacity: " + samoletSet.getString (5));
        }
        catch (Exception e) {
            e.printStackTrace ();
        }
    }
}