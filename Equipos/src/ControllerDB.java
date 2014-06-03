import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;


public class ControllerDB {
	private String Nombre="";
	
	//DB
	Connection conexion = null; //maneja la conexión
	ResultSet result = null;	//instruccionde consulta
	Statement instruction = null;	//maneja los resultados
	
	
	public ControllerDB() {
		Nombre="";
		//Nos conectamos a la base de datos
		crearConexion();
	}
	
	
	private void crearConexion(){
		//Conectarnos a la base de datos
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// establece la conexión a la base de datos
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/apuestas","root","tonphp");
		}catch( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
		}// fin de catch
		catch( ClassNotFoundException e )
		{
			e.printStackTrace();
		}// fin de catch			
	}
	
	//En este método leeremos de la base de datos los equipos existentes
	// 1.- Leer de la base de datos
	// 2.- Actualizar el combobox
	public void leerEquipos(JComboBox listadoEquipos){
		try {
			Statement instruction = (Statement) conexion.createStatement();
		}//fin de try
		catch (SQLException e) {
			e.printStackTrace();
		}// fin del catch
	}
	
	//Aquí realizaremos la consulta y actualización del combobox
	//En este método leeremos de la base de datos los equipos existentes
	// 1.- Crearemos la consulta a la base de datos (Statement)
	// 2.- Lanzaremos la consulta
	// 3.- Eliminaremos todos los elementos del combobox
	// 4.- Volveremos a rellenar el combobox
	public void insertarEquipos(int idLiga,String nombreEquipo,int golesFavor,int golesContra, int partidosGanados,int partidosPerdidos,JComboBox listadoEquipos){
		//Aquí realizaremos la consulta
		try{
			 instruction = (Statement) conexion.createStatement();
	            //Insertamos datos
	            String insertdata = "(idLiga, nombreEquipo,golesFavor,golesEnContra,partidosGanados,partidosPerdidos)";  //variables  
	            insertdata = insertdata + "("+idLiga+",'"+nombreEquipo+"',"+golesFavor+","+golesContra+","+partidosGanados+","+ ","+partidosPerdidos+")"; //valores
	            
	            }catch(SQLException excepcionSql ){
	                excepcionSql.printStackTrace();
	            }
		//borrar del combobox
		listadoEquipos.removeItem(listadoEquipos.getItemAt(listadoEquipos.getSelectedIndex()));
		//Actualización del combobox
		listadoEquipos.removeAllItems();
		leerEquipos(listadoEquipos);
	}
	
}