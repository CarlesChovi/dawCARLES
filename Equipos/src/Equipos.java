import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Equipos extends JFrame {

	private JPanel contentPane;
	private JTextField nombreEquipo;
	private JTextField golesFavor;
	private JTextField golesEnContra;
	private JTextField partidosGanados;
	private JTextField partidosPerdidos;
	private JTextField textField_5;
	private Equipo equipo;
		
	private JComboBox<Equipo> listadoEquipos;
	
	//Objeto Base de Datos
	private ControllerDB baseDatos;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Equipos frame = new Equipos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Equipos() {
		inicializarVentana();
	}
	
	private void inicializarVentana(){
		setTitle("Equipos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		listadoEquipos = new JComboBox<Equipo>();
		listadoEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//seleccionar la posicion para devolver los datos
				equipo=listadoEquipos.getItemAt(listadoEquipos.getSelectedIndex());
				if(equipo!=null)
				{					
					// Muestre los datos
					nombreEquipo.setText(String.valueOf(equipo.getNombre()));
					golesFavor.setText(String.valueOf(equipo.getgolesFavor()));
					golesEnContra.setText(String.valueOf(equipo.getgolesContra()));
					partidosGanados.setText(String.valueOf(equipo.getpartGanados()));
					partidosPerdidos.setText(String.valueOf(equipo.getpartPerdidos()));
					
					textField_5.setText(String.valueOf(equipo.getid()));
				}
			}
		});
		listadoEquipos.setBounds(0, 36, 424, 20);
		contentPane.add(listadoEquipos);
		
		JLabel lblEquiposDeFutbol = new JLabel("Equipos de Futbol");
		lblEquiposDeFutbol.setBounds(0, 11, 289, 14);
		contentPane.add(lblEquiposDeFutbol);
		
		JLabel label = new JLabel("Nombre del Equipo");
		label.setBounds(0, 81, 106, 14);
		contentPane.add(label);
		
		nombreEquipo = new JTextField();
		nombreEquipo.setBounds(127, 78, 297, 20);
		contentPane.add(nombreEquipo);
		nombreEquipo.setColumns(10);
		
		JLabel label_1 = new JLabel("Goles a Favor");
		label_1.setBounds(0, 117, 106, 14);
		contentPane.add(label_1);
		
		golesFavor = new JTextField();
		golesFavor.setColumns(10);
		golesFavor.setBounds(108, 114, 88, 20);
		contentPane.add(golesFavor);
		
		JLabel label_2 = new JLabel("Goles en Contra");
		label_2.setBounds(0, 154, 106, 14);
		contentPane.add(label_2);
		
		golesEnContra = new JTextField();
		golesEnContra.setColumns(10);
		golesEnContra.setBounds(108, 151, 88, 20);
		contentPane.add(golesEnContra);
		
		JLabel label_3 = new JLabel("Partidos Ganados");
		label_3.setBounds(0, 194, 106, 14);
		contentPane.add(label_3);
		
		partidosGanados = new JTextField();
		partidosGanados.setColumns(10);
		partidosGanados.setBounds(108, 192, 88, 20);
		contentPane.add(partidosGanados);
		
		JLabel label_4 = new JLabel("Partidos Perdidos");
		label_4.setBounds(0, 234, 106, 14);
		contentPane.add(label_4);
		
		partidosPerdidos = new JTextField();
		partidosPerdidos.setColumns(10);
		partidosPerdidos.setBounds(108, 231, 88, 20);
		contentPane.add(partidosPerdidos);
		
		
		JButton btnGuardarEquipoEn = new JButton("Guardar equipo en DB");
		btnGuardarEquipoEn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Aqu� realizaremos los siguientes pasos
				//1.- Comprobaremos que todos los campos est�n completados

				if((nombreEquipo.getText()).equals("")){
					JOptionPane.showMessageDialog(null,"No has indicado el nombre del equipo");
				}
				else if ((golesFavor.getText()).equals("")){
					JOptionPane.showMessageDialog(null,"No has indicado los goles a favor del equipo");
				}
				else if ((golesEnContra.getText()).equals("")){
					JOptionPane.showMessageDialog(null,"No has indicado los goles en contra del equipo");
				}
				else if ((partidosGanados.getText()).equals("")){
					JOptionPane.showMessageDialog(null,"No has indicado los partidos ganados del equipo");
				}
				else if ((partidosPerdidos.getText()).equals("")){
					JOptionPane.showMessageDialog(null,"No has indicado los partidos perdidos del equipo");
				}
				

				//2.- Creamos un nuevo objeto
				else  {
				
					
					Equipo eq=new Equipo();
					int ID=0;
					//ID=datos.insertarEquipo(nombreEquipo, golesFavor, golesEnContra, partidosGanados, partidosPerdidos);
					ID=baseDatos.insertarEquipo((nombreEquipo.getText()), Integer.parseInt(golesFavor.getText()), Integer.parseInt(golesEnContra.getText()), Integer.parseInt(partidosGanados.getText()), Integer.parseInt(partidosPerdidos.getText()));
					eq.setNombre(nombreEquipo.getText());
					eq.setgolesFavor(Integer.parseInt(golesFavor.getText()));
					eq.setgolesContra(Integer.parseInt(golesEnContra.getText()));
					eq.setpartGanados(Integer.parseInt(partidosGanados.getText()));
					eq.setpartPerdidos(Integer.parseInt(partidosGanados.getText()));
					eq.setid(ID);

				//3.- Lo almacenaremos en el ComboBox
				listadoEquipos.addItem(eq);
				}
			}
		});
		btnGuardarEquipoEn.setBounds(0, 283, 166, 23);
		contentPane.add(btnGuardarEquipoEn);
		
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				//seleccionar
				baseDatos.modificarEquipo(Integer.parseInt(textField_5.getText()), (nombreEquipo.getText()), Integer.parseInt(golesFavor.getText()), Integer.parseInt(golesEnContra.getText()), Integer.parseInt(partidosGanados.getText()), Integer.parseInt(partidosPerdidos.getText()));
				equipo.setNombre(nombreEquipo.getText());
				equipo.setgolesFavor(Integer.parseInt(golesFavor.getText()));
				equipo.setgolesContra(Integer.parseInt(golesEnContra.getText()));
				equipo.setpartGanados(Integer.parseInt(partidosGanados.getText()));
				equipo.setpartPerdidos(Integer.parseInt(partidosPerdidos.getText()));
			}
		});
		btnModificar.setBounds(188, 283, 89, 23);
		contentPane.add(btnModificar);
		
		
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				listadoEquipos.removeItem(equipo);
				baseDatos.remove(Integer.parseInt(textField_5.getText()));
			}
		});
		btnBorrar.setBounds(305, 283, 89, 23);
		contentPane.add(btnBorrar);
		
		
		
		//Conectamos con la base de datos
		baseDatos =new ControllerDB(listadoEquipos);
		
		JLabel lblIdliga = new JLabel("IdLiga");
		lblIdliga.setBounds(314, 117, 50, 14);
		contentPane.add(lblIdliga);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setText("0");
		textField_5.setColumns(10);
		textField_5.setBounds(374, 114, 50, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		baseDatos.leerEquipo();
	}	
}
