package App;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

class String_gol extends Exception {
	
	String s;
	private static final long serialVersionUID = 1L;

	public String_gol(String s)
	{
		this.s=s;
	}
	
	public String toString()
	{
		return "Introduceti numele!";
	}

}

class Stringgol {

	public static void Verificare(String s) throws String_gol
	{
		if(s.isEmpty())
			throw new String_gol(s);
	}
}

class String_nume extends Exception
{
	String s;
	private static final long serialVersionUID=1L;
	public String_nume(String s)
	{
		this.s=s;
	}
	public String toString()
	{
		return "Reintroduceti numele complet";
	}
}

class Stringnume
{
	static String regex="^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$";
	public static void Verificare(String s) throws String_nume
	{
		boolean bool;
		bool=s.matches(regex);
		if(bool==false)
			throw new String_nume(s);
	}
}

class String_card extends Exception{
	
	String s;
	private static final long serialVersionUID=1L;
	public String_card(String s)
	{
		this.s=s;
	}
	public String toString()
	{
		return "Reintroduceti codul cardului";
	}
	
}

class Stringcard
{
	static String regex="^4[0-9]{12}(?:[0-9]{3})?$";
	public static void Verificare(String s) throws String_card
	{
		boolean bool;
		bool=s.matches(regex);
		if(bool==false)
			throw new String_card(s);
	}
}

class String_cvv extends Exception{
	
	String s;
	private static final long serialVersionUID=1L;
	public String_cvv(String s)
	{
		this.s=s;
	}
	public String toString()
	{
		return "CVV-ul introdus trebuie sa aiba 3 cifre";
	}
}

class Stringcvv
{
	public static void Verificare(String s)throws String_cvv
	{
		int i;
		i=Integer.parseInt(s);
		if(i<100 || i>999)
			throw new String_cvv(s);
	}
	
}


public class Pagina_plata extends JFrame {

	private JPanel contentPane;
	private JTextField txtNume;
	private JTextField txtNumar;
	private JTextField txtCVV;
	private boolean plata_card=false;
	int ok;
	public static JTextField txtCash2;
	public int numar_zile;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pagina_plata frame = new Pagina_plata();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public float calcul(int greutate, int categorie)
	{
		float suma=1;
		float cat1=0.1f,cat2=02.f,cat3=0.3f;
		if(categorie==1)
			suma=suma*numar_zile*greutate*cat1;
		if(categorie==2)
			suma=suma*numar_zile*greutate*cat2;
		if(categorie==3)
			suma=suma*numar_zile*greutate*cat3;
		return suma;
	}

	/**
	 * Create the frame.
	 */
	public Pagina_plata() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCash = new JButton("Plata cash");

		btnCash.setBounds(10, 22, 109, 23);
		contentPane.add(btnCash);

		JButton btnCard = new JButton("Plata card");

		btnCard.setBounds(10, 68, 109, 23);
		contentPane.add(btnCard);

		JLabel lblCash1 = new JLabel("Total de plata:");
		lblCash1.setBounds(137, 26, 83, 14);
		contentPane.add(lblCash1);
		lblCash1.setVisible(true);

		JButton btnPlata = new JButton("Plateste");
		btnPlata.setBounds(470, 22, 89, 23);
		contentPane.add(btnPlata);
		btnPlata.setVisible(false);

		JLabel lblCard1 = new JLabel("Detinator card:");
		lblCard1.setBounds(135, 72, 98, 14);
		contentPane.add(lblCard1);
		lblCard1.setVisible(false);

		txtNume = new JTextField();
		txtNume.setBounds(247, 69, 198, 20);
		contentPane.add(txtNume);
		txtNume.setColumns(10);
		txtNume.setVisible(false);

		JLabel lblCard2 = new JLabel("Numar card:");
		lblCard2.setBounds(150, 103, 71, 14);
		contentPane.add(lblCard2);
		lblCard2.setVisible(false);

		txtNumar = new JTextField();
		txtNumar.setBounds(247, 100, 198, 20);
		contentPane.add(txtNumar);
		txtNumar.setColumns(10);
		txtNumar.setVisible(false);

		JLabel lblCard3 = new JLabel("Data expirare: Luna ");
		lblCard3.setBounds(114, 134, 119, 14);
		contentPane.add(lblCard3);
		lblCard3.setVisible(false);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox.setBounds(247, 130, 47, 22);
		contentPane.add(comboBox);
		comboBox.setVisible(false);

		JLabel lblCard4 = new JLabel("An");
		lblCard4.setBounds(312, 134, 26, 14);
		contentPane.add(lblCard4);
		lblCard4.setVisible(false);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"22", "23", "24", "25", "26", "27", "28", "29", "30"}));
		comboBox_1.setBounds(348, 130, 39, 22);
		contentPane.add(comboBox_1);
		comboBox_1.setVisible(false);

		JLabel lblCard5 = new JLabel("CVV");
		lblCard5.setBounds(163, 165, 46, 14);
		contentPane.add(lblCard5);
		lblCard5.setVisible(false);

		txtCVV = new JTextField();
		txtCVV.setBounds(247, 162, 198, 20);
		contentPane.add(txtCVV);
		txtCVV.setColumns(10);
		
		txtCash2 = new JTextField();
		txtCash2.setBounds(247, 23, 86, 20);
		contentPane.add(txtCash2);
		txtCash2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("lei");
		lblNewLabel.setBounds(348, 26, 46, 14);
		contentPane.add(lblNewLabel);
		txtCVV.setVisible(false);

		btnCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCash1.setVisible(true);
				btnPlata.setVisible(true);
				txtCash2.setVisible(true);
				lblCard1.setVisible(false);
				txtNume.setVisible(false);
				lblCard2.setVisible(false);
				txtNumar.setVisible(false);
				lblCard3.setVisible(false);
				comboBox.setVisible(false);
				lblCard4.setVisible(false);
				comboBox_1.setVisible(false);
				lblCard5.setVisible(false);
				txtCVV.setVisible(false);

			}
		});

		btnCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lblCash1.setVisible(true);
				btnPlata.setVisible(true);
				txtCash2.setVisible(true);
				lblCard1.setVisible(true);
				txtNume.setVisible(true);
				lblCard2.setVisible(true);
				txtNumar.setVisible(true);
				lblCard3.setVisible(true);
				comboBox.setVisible(true);
				lblCard4.setVisible(true);
				comboBox_1.setVisible(true);
				lblCard5.setVisible(true);
				txtCVV.setVisible(true);
				plata_card=true;
				

			}
		});

		btnPlata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nume,numar,cvv;
				String expresie_nume="^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$";
				
				
				if(plata_card==true)
				{
					//nume
					try {
						
						nume=txtNume.getText();
						Stringgol.Verificare(nume);
						Stringnume.Verificare(nume);
					}
					catch(String_gol f)
					{
						JOptionPane.showMessageDialog(null,f);
					}
					catch (String_nume g)
					{
						JOptionPane.showMessageDialog(null, g);
					}
					//numar
					try
					{
						numar=txtNumar.getText();
						Stringgol.Verificare(numar);
						Stringcard.Verificare(numar);
					}
					catch(String_gol h)
					{
						JOptionPane.showMessageDialog(null, h);
					}
					catch(String_card i)
					{
						JOptionPane.showMessageDialog(null, i);
					}
					//CVV
					try
					{
						cvv=txtCVV.getText();
						Stringgol.Verificare(cvv);
						ok=Integer.parseInt(cvv);
						Stringcvv.Verificare(cvv);
					}
					catch(String_gol cvv1)
					{
						JOptionPane.showMessageDialog(null, cvv1);
					}
					catch(NumberFormatException cvv2)
					{
						JOptionPane.showMessageDialog(null, "Nu ati introdus un numar");
					}
					catch(String_cvv cvv3)
					{
						JOptionPane.showMessageDialog(null, cvv3);
					}
					
					
				}
				

			}
		});
	}
}

