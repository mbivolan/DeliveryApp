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

class Integer_pozitiv extends Exception
{
	int a;
	private static final long serialVersionUID = 1L;

	public Integer_pozitiv(int a)
	{
		this.a=a;
	}
	
	public String toString()
	{
		return "Greutatea trebuie sa fie pozitiva";
	}
		
}

class Integerpozitiv
{
	public static void Verificare(int a) throws Integer_pozitiv
	{
		if(a<1)
			throw new Integer_pozitiv(a);
	}
}

class String_email extends Exception
{
	String s;
	private static final long serialVersionUID = 1L;

	public String_email(String s)
	{
		this.s=s;
	}
	
	public String toString()
	{
		return "Adresa de email nu este valida!";
	}
}

class Stringemail
{
	static String regex="^(.+)@(.+)$";
	public static void Verificare(String s) throws String_email
	{
		
		 boolean bool;
			bool=s.matches(regex);
			if(bool==false)
				throw new String_email(s);
			
	}
}

class String_telefon extends Exception
{
	String s;
	private static final long serialVersionUID = 1L;

	public String_telefon(String s)
	{
		this.s=s;
	}
	
	public String toString()
	{
		return "Numar de telefon invalid!";
	}
}

class Stringtelefon
{
	static String regex="^(\\+4|)?(07[0-8]{1}[0-9]{1}|02[0-9]{2}|03[0-9]{2}){1}?(\\s|\\.|\\-)?([0-9]{3}(\\s|\\.|\\-|)){2}$";
	public static void Verificare(String s) throws String_telefon
	{
		
		boolean bool;
		bool=s.matches(regex);
		if(bool==false)
			throw new String_telefon(s);
	}
}

class String_gol extends Exception {
	
	String s;
	private static final long serialVersionUID = 1L;

	public String_gol(String s)
	{
		this.s=s;
	}
	
	public String toString()
	{
		return "Camp gol!";
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
	private String pretul_total;
	private float pr;
	private int awb;
	
	public void setAwb(int awb) {
		this.awb = awb;
	}
	
	
	
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
		
		//JOptionPane.showMessageDialog(null, numar_zile);
		txtCash2.setText(pretul_total);

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
				int ok1=0,ok2=0,ok3=0;
				
				
				if(plata_card==true)
				{
					try {
						
						nume=txtNume.getText();
						Stringgol.Verificare(nume);
						Stringnume.Verificare(nume);
						ok1=1;
					}
					catch(String_gol f)
					{
						JOptionPane.showMessageDialog(null,f);
					}
					catch (String_nume g)
					{
						JOptionPane.showMessageDialog(null, g);
					}
					try
					{
						numar=txtNumar.getText();
						Stringgol.Verificare(numar);
						Stringcard.Verificare(numar);
						ok2=1;
					}
					catch(String_gol h)
					{
						JOptionPane.showMessageDialog(null, h);
					}
					catch(String_card i)
					{
						JOptionPane.showMessageDialog(null, i);
					}
					try
					{
						cvv=txtCVV.getText();
						Stringgol.Verificare(cvv);
						ok=Integer.parseInt(cvv);
						Stringcvv.Verificare(cvv);
						ok3=1;
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
					if(ok1==1 && ok2==1 && ok3==1)
					{
						JOptionPane.showMessageDialog(null,"Plata realizata cu succes");
						DataBackend backend = new DataBackend().getInstance();
						Item item = backend.getItem(awb);
						item.setStatus("In Curs Livrare");
						backend.updateAwb(awb, item);
						new DeliveryApp().setVisible(true);
						dispose();
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Plata realizata cu succes");
					DataBackend backend = new DataBackend().getInstance();
					Item item = backend.getItem(awb);
					item.setStatus("In Curs Livrare");
					backend.updateAwb(awb, item);
					new DeliveryApp().setVisible(true);
					
					
					dispose();
					
					
				}
				

			}
		});
	}
}

