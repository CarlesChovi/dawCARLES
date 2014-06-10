
public class Equipo{

	private int id;
	private String nombreEquipo;
	private int golesFavor;
	private int golesEnContra;
	private int partidosGanados;
	private int partidosPerdidos;
	
	public Equipo() {
		// TODO Auto-generated constructor stub
		
	id=0;	
	nombreEquipo="";
	golesFavor=0;
	golesEnContra=0;
	partidosGanados=0;
	partidosPerdidos=0;
	}
	public Equipo(int ID, String Nombre, int GolesFavor, int GolesEnContra, int PartidosGanados, int PartidosPerdidos) {
		id=ID;
		nombreEquipo=Nombre;
		golesFavor=GolesFavor;
		golesEnContra=GolesEnContra;
		partidosGanados=PartidosGanados;
		partidosPerdidos=PartidosPerdidos;
		
	}
	public void setid(int id){
		this.id=id;
	}
	/*public void setliga(int liga){
		this.liga=liga;
	}
	*/
	public void setNombre(String nombreEquipo){
		this.nombreEquipo=nombreEquipo;
	}
	public void setgolesFavor(int golesFavor){
		this.golesFavor=golesFavor;
	}
	public void setgolesContra(int golesEnContra){
		this.golesEnContra=golesEnContra;
	}
	public void setpartGanados(int partidosGanados){
		this.partidosGanados=partidosGanados;
	}
	public void setpartPerdidos(int partidosPerdidos){
		this.partidosPerdidos=partidosPerdidos;
	}
	public void setId(int id) {
		id=id;
	}
	
	
	public int getid(){
		return id;
	}
	/*public int getliga(){
		return liga;
	}
	*/
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
	public int getId() {
		return id;
	}
	//Falta por crear
	//El método toString para que aparezca en el comboBox
	public String toString(){
		return this.nombreEquipo;
	}
	
}
