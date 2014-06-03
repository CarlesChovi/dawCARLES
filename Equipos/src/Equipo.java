
public class Equipo extends Equipos{

	String nombreEquipo;
	int golesFavor;
	int golesEnContra;
	int partidosGanados;
	int partidosPerdidos;
	
	public Equipo() {
		// TODO Auto-generated constructor stub
		
		
	nombreEquipo="";
	golesFavor=0;
	golesEnContra=0;
	partidosGanados=0;
	partidosPerdidos=0;
	}
	
	public void setNombre(String a){
		nombreEquipo=a;
	}
	public void setgolesFavor(int b){
		golesFavor=b;
	}
	public void setgolesContra(int c){
		golesEnContra=c;
	}
	public void setpartGanados(int d){
		partidosGanados=d;
	}
	public void setpartPerdidos(int d){
		partidosPerdidos=d;
	}
	
	public String getNombre(){
		return nombreEquipo;
	}
	public int getgolesFavor(){
		return golesFavor;
	}
	public int getgolesContra(){
		return golesEnContra;
	}
	public int getpartGanados(){
		return partidosGanados;
	}
	public int getpartPerdidos(){
		return partidosPerdidos;
	}
	//Falta por crear
	//El método toString para que aparezca en el comboBox
	public String toString(){
		return nombreEquipo;
	}
}
