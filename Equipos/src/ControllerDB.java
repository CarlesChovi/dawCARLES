import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import javax.swing.JComboBox;


public class ControllerDB {
	Connection conexion = null; //maneja la conexión
	Statement instruccion = null;// instrucción de consulta
	ResultSet conjuntoResultados = null;// maneja los resultados
	private JComboBox<Equipo> listadoEquipos;
	
	public ControllerDB(JComboBox listadoEquipos) {
		// TODO Auto-generated constructor stub
				crearconexion();
				this.listadoEquipos=listadoEquipos;
	}
		
		public void crearconexion (){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// establece la conexión a la base de datos
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/apuestas","root","tonphp");
			
		}catch( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
		}// fin de catch
		catch( ClassNotFoundException noEncontroClase )
		{
			noEncontroClase.printStackTrace();
		}// fin de catch
	}
		
	public void leerEquipo(){
		try{
		// crea objeto Statement para consultar la base de datos
					instruccion = (Statement) conexion.createStatement();
					// consulta la base de datos
					conjuntoResultados = instruccion.executeQuery("SELECT Nombre, GolesFavor, GolesEnContra, PartidosGanados, PartidosPerdidos, ID FROM equipos");
					//Mostrar por pantalla
					while (conjuntoResultados.next())
					{
						
						 System.out.println("id="+conjuntoResultados.getObject("ID")+
							      ", Nombre="+conjuntoResultados.getObject("Nombre"));						 
							   Equipo equip=new Equipo ((int)conjuntoResultados.getObject("ID"),
									   							(String)conjuntoResultados.getObject("Nombre"),
									   							(int)conjuntoResultados.getObject("GolesFavor"),
									   							(int)conjuntoResultados.getObject("GolesEnContra"),
									   							(int)conjuntoResultados.getObject("PartidosGanados"),
							   									(int)conjuntoResultados.getObject("PartidosPerdidos"));
							  listadoEquipos.addItem(equip);								
					}
					conjuntoResultados.close();
	}
		catch( SQLException excepcionSql ){
			excepcionSql.printStackTrace();}
	}
	
	public int insertarEquipo(String nombre, int golFavor, int golContra, int partGanados, int partPerdidos){
		// crea objeto Statement para consultar la base de datos
		try {
			instruccion = (Statement) conexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//inserción en base de datos
		try{
			String sql="INSERT INTO `apuestas`.`equipos` (`idEquipo`, `idLiga`, `nombreEquipo`, `golesFavor`, `golesEnContra`, `partidosGanados`, `partidosPerdidos`) VALUES ("
														+"'"+nombre+"', '"+golFavor+"', '"+golContra+"', '"+partGanados+"', '"+partPerdidos+"');";
			instruccion.executeUpdate(sql);
			
			//PARA GUARDAR EL ID
			sql = "SELECT * FROM apuestas ORDER BY ID DESC LIMIT 1";
			conjuntoResultados = instruccion.executeQuery(sql);
			int ID=-1;
			//Mostrar por pantalla
			while (conjuntoResultados.next())
			{
				ID=(int)conjuntoResultados.getObject("ID");
			}
			conjuntoResultados.close();	
			return ID;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
			}
		}
			
	
	public void modificarEquipo (int idEquipo, String nombre, int golFavor, int golContra, int partGanados, int partPerdidos){
		// crea objeto Statement para consultar la base de datos
					try {
						instruccion = (Statement) conexion.createStatement();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// insercion en base de datos
					try {
						String sql="UPDATE  `apuestas`.`equipos` SET "
								+ "`Nombre` = '"+nombre+"',"
								+"`GolesFavor` =  '"+golFavor+"',"
								+"`GolesEnContra` =  '"+golContra+"',"
								+"`PartidosGanados` =  '"+partGanados+"'"
								+"`PartidosPerdidos` = '"+partPerdidos+"'"+
								 " WHERE  `equipo`.`ID` ="+idEquipo+"";
						instruccion.executeUpdate(sql);
					}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						}
					}
	public void remove (int ID){
		try {
			instruccion = (Statement) conexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// insercion en base de datos
		try {
			String sql="DELETE FROM `apuestas`.`equipos` WHERE  `equipos`.`ID` ="+ID+"";
			instruccion.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
}
}