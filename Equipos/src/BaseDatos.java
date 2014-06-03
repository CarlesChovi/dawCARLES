import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import java.sql.Statement;


public class BaseDatos {
	Connection conexion = null; //maneja la conexión
	Statement instruccion = null;// instrucción de consulta
	ResultSet conjuntoResultados = null;// maneja los resultados
	JComboBox<Equipos> equipo;
	
	public BaseDatos(JComboBox liga) {

		try{
			Class.forName("com.mysql.jdbc.Driver");
			// establece la conexión a la base de datos
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/apuestas","root","tonphp");
			// crea objeto Statement para consultar la base de datos
			instruccion = (Statement) conexion.createStatement();
			this.equipo=equipo;
		}catch( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
		}// fin de catch
		catch( ClassNotFoundException noEncontroClase )
		{
			noEncontroClase.printStackTrace();
		}// fin de catch
	}
	
	public void leerequipos(){
		try{
			instruccion = (Statement) conexion.createStatement();
			// consulta la base de datos
			conjuntoResultados = instruccion.executeQuery("SELECT idLiga,Nombre FROM liga");
			//Mostrar por pantalla
			while (conjuntoResultados.next())
			{
				Equipos l=new Equipos();
				l.setName((String)conjuntoResultados.getObject("Nombre"));
				equipo.addItem(l);
			   System.out.println("id="+conjuntoResultados.getObject("idLiga")+
			      ", Nombre="+conjuntoResultados.getObject("Nombre"));
			}
			conjuntoResultados.close();
		}catch( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
		}// fin de catch	
	}

}
