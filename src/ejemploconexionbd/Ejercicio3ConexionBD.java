package ejemploconexionbd;
import java.sql.*;

public class Ejercicio3ConexionBD {
    public static void main(String[] args) {
        try{
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"despliegue","daw2","1234");
            Statement miStatement =miConexion.createStatement();
            
            String insercionSQL="INSERT INTO PRODUCTOS (CODIGOARTICULO,NOMBREARTICULO,"+"PRECIO)VALUES('AR42','PANTALON','20.25')";
            String modificaValorSQL="UPDATE PRODUCTOS SET PRECIO=PRECIO*2 "+"WHERE CODIGOARTICULO='AR42'";
            String eliminaAQL="DELETE FROM PRODUCTOS WHERE CODIGOARTICULO='AR42'";
            
            miStatement.executeUpdate(insercionSQL);
            System.out.println("Registro introducido");
            miStatement.close();
            miConexion.close();
        }
        catch(Exception e){
            System.out.println("NO conecta");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
