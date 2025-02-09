package ejemploconexionbd;

import java.sql.*;
import java.util.Scanner;

public class Ejercicio4ConexionBD {

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
            
            System.out.println("Que Quieres insertar o eliminar algo de la tabla?");
            
            ResultSet miResultset = miStatement.executeQuery("select * from "+tb);
            
            while (miResultset.next()) {
                
            }
                
            miStatement.close();
            miResultset.close();
            miConexion.close();
        } catch (Exception e) {
            System.out.println("Problemas al acceder a la base de datos " + e.getMessage());
        }
    }

}
