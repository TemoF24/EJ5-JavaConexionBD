package ejemploconexionbd;
import java.sql.*;
public class EjemploConexionBD {

    public static void main(String[] args) {
        try {
        //Paso1: Establecemos la conexion con la BD, necesitamos try-catch y el metodo
        //estatico getConnection de la clase DriverManager
        Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/despliegue", "daw2","1234");
            System.out.println("Conectando con la BD");
            //Paso2: Generamos el Statement que sera el objeto que utilizare para ejecutar las querys de BD
            Statement miStatement=miConexion.createStatement();
            //Paso3: Creamos el Resulset ejecutando la consulta deseada en el objeto statement
            ResultSet miResultset=miStatement.executeQuery("select * from productos");
            //Paso4: Recorremos el Resulset y mostramos los resultados
            while(miResultset.next()){
                //Al hacer next() no solo me devuelve true or false dependiendo de si hay registros o no, sino 
                //que ademas mueve el cursor al siguiente registro, al principio el cursor apunta fuera de la tabla
                System.out.println(miResultset.getString("CODIGOARTICULO")+" "+miResultset.getString("NOMBREARTICULO")
                        +" "+miResultset.getString("PAISDEORIGEN"));
            }//Paso5: Si deseo terminar el rpograma debo cerrar las conexiones ordenadamente
            miStatement.close();
            miResultset.close();
            miConexion.close();
        } catch (Exception e) {
            System.out.println("Problemas al acceder a la base de datos" + e.getMessage());
            
        }
    }
}