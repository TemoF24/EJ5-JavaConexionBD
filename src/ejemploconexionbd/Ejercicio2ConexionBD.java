package ejemploconexionbd;

import java.sql.*;
import java.util.Scanner;

public class Ejercicio2ConexionBD {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("A que base de datos deseas conectarte?");
        String bd = sc.next();
        System.out.println("Que tabla te gustaria consultar?");
        String tb = sc.next();
        System.out.println("Dame tu nombre de usuario");
        String nb = sc.next();
        System.out.println("Dame tu contraseña");
        String pw = sc.next();

        try {
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+bd,nb,pw);
            System.out.println("Conectando con la BD");
            
            Statement miStatement = miConexion.createStatement();
            
            System.out.println("Que 3 campos quieres visualizar?");
            String camp1=sc.next();
            String camp2=sc.next();
            String camp3=sc.next();
            
            ResultSet miResultset = miStatement.executeQuery("select * from "+tb);
            
            while (miResultset.next()) {
                System.out.println(miResultset.getString(camp1) + " | " + miResultset.getString(camp2) + " | " + miResultset.getString(camp3));
            }
                
            miStatement.close();
            miResultset.close();
            miConexion.close();
        } catch (Exception e) {
            System.out.println("Problemas al acceder a la base de datos " + e.getMessage());
        }
    }

}
