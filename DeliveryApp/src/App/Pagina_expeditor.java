package App;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;

public class Pagina_expeditor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private long time_expeditor;
	private DataBackend databackend;
	public int awb;
	public static JTextField txtAscuns;
	private int c;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pagina_expeditor frame = new Pagina_expeditor(new DataBackend());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void timp()
    {
		long eventMask = AWTEvent.KEY_EVENT_MASK | AWTEvent.MOUSE_EVENT_MASK;

    Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
        public void eventDispatched(AWTEvent e) {
            time_expeditor = System.currentTimeMillis();
        }
    }, eventMask);

    time_expeditor = System.currentTimeMillis();
    new Thread(new Runnable() {

        @Override
        public void run() {
        	
            while (true) {
                if (System.currentTimeMillis() - time_expeditor > 10000) {
                	new CourierFrame(new DataBackend()).setVisible(true);
                    dispose();
                    break;
                }
            }
        }
    }).start();
    }
	
	public float calcul(int numarzile,int categorie, int greutate)
	{
		float suma=1;
		float cat1=0.1f,cat2=02.f,cat3=0.3f;
		if(categorie==1)
			suma=suma*numarzile*greutate*cat1;
		if(categorie==2)
			suma=suma*numarzile*greutate*cat2;
		if(categorie==3)
			suma=suma*numarzile*greutate*cat3;
		return suma;
	}
	
	public int categorie(String cat)
	{
		int categ=0;
		if(cat.equals("Fragil"))
			categ=1;
		if(cat.equals("Pretios"))
			categ=2;
		if(cat.equals("Periculos"))
			categ=3;
		
		return categ;
			
	}

	/**
	 * Create the frame.
	 */
	public Pagina_expeditor(DataBackend backend) {
		this.databackend=backend;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 179);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPlataDest = new JButton("Plateste");
		
		btnPlataDest.setBounds(21, 23, 143, 23);
		contentPane.add(btnPlataDest);
		
		JButton btnRetur = new JButton("Retrurneaza colet");
		
		btnRetur.setBounds(21, 66, 143, 23);
		contentPane.add(btnRetur);
		
		textField = new JTextField();
		textField.setBounds(287, 24, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
		
		JButton btnSprePlata = new JButton("Spre plata");
		btnSprePlata.setVisible(false);
		
		btnSprePlata.setBounds(441, 23, 119, 23);
		contentPane.add(btnSprePlata);
		
		JLabel lblPlataDest = new JLabel("Numar de zile:");
		lblPlataDest.setBounds(201, 27, 85, 14);
		contentPane.add(lblPlataDest);
		
		txtAscuns = new JTextField();
		txtAscuns.setBounds(287, 84, 86, 20);
		contentPane.add(txtAscuns);
		txtAscuns.setColumns(10);
		lblPlataDest.setVisible(false);
		txtAscuns.setVisible(false);
		
		btnSprePlata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pagina_destinatar dest= new Pagina_destinatar(new DataBackend());
				Pagina_plata plat=new Pagina_plata();
				int zile;
				String z;
				String sir;
				float sum;
				int partial;
				String cod_awb=txtAscuns.getText();
				int awb=Integer.parseInt(cod_awb);
				try {
					z=textField.getText();
					zile=Integer.parseInt(z);
					Item item=databackend.getItem(awb);
					sum=calcul(zile,categorie(item.getPackType()),item.getPackWeight());
					new Pagina_plata().setVisible(true);
					sir=String.valueOf(sum);
					Pagina_plata.txtCash2.setText(sir);
					
					dispose();
				}
				catch(NumberFormatException p)
				{
					JOptionPane.showMessageDialog(null, "Trebuie introdus un numar de zile");
				}
			}
		});
		
		btnPlataDest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setVisible(true);
				lblPlataDest.setVisible(true);
				btnSprePlata.setVisible(true);
			}
		});
		
		btnRetur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String livrare="in tranzit retur";
				String cod_awb=txtAscuns.getText();
				int awb=Integer.parseInt(cod_awb);
				Item item=databackend.getItem(awb);
				item.setStatus(livrare);
				databackend.updateAwb(awb,item);
				dispose();
				
			}
		});
	}
}
