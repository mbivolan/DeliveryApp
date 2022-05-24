package App;

import java.awt.AWTEvent;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionEvent;

public class Pagina_destinatar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField textField;
	public static JTextField textField_1;
	public boolean adevar;
	private long time;
	public int numar_secunde;
	public String nume_expeditor;
	private DataBackend databackend;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pagina_destinatar frame = new Pagina_destinatar(new DataBackend());
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
            time = System.currentTimeMillis();
        }
    }, eventMask);

    time = System.currentTimeMillis();
    new Thread(new Runnable() {
    	
        @Override
        public void run() {
            while (true) {
                if (System.currentTimeMillis() - time > 5000) {
                	//new CourierFrame(new DataBackend()).setVisible(true);
                	dispose();
                    break;
                }
            }
        }
        
    }).start();
    }
	
	


	/**
	 * Create the frame.
	 */
	public Pagina_destinatar(DataBackend backend) {
		
		this.databackend=backend;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDestinatar = new JLabel("Coletul de la: ");
		lblDestinatar.setBounds(34, 119, 80, 14);
		contentPane.add(lblDestinatar);

		textField = new JTextField();
		textField.setBounds(124, 116, 113, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblDestinatar2 = new JLabel("avand codul:");
		lblDestinatar2.setBounds(244, 119, 76, 14);
		contentPane.add(lblDestinatar2);

		textField_1 = new JTextField();
		textField_1.setBounds(320, 116, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblDestinatar3 = new JLabel("a ajuns.");
		lblDestinatar3.setBounds(416, 119, 136, 14);
		contentPane.add(lblDestinatar3);

		JLabel lblDestinatar4 = new JLabel("Doriti sa il ridicati?");
		lblDestinatar4.setBounds(34, 175, 109, 14);
		contentPane.add(lblDestinatar4);

		JRadioButton rdbtnDa = new JRadioButton("Da");
		rdbtnDa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnDa.isSelected())
				{
					String cod_awb=textField_1.getText();
					String livrat="livrat";
					int awb=Integer.parseInt(cod_awb);
					Item item=databackend.getItem(awb);
					item.setStatus(livrat);
					databackend.updateAwb(awb,item);
					dispose();
					
				}
			}
		});
		rdbtnDa.setBounds(34, 209, 109, 23);
		contentPane.add(rdbtnDa);
		
		JRadioButton rdbtnNU = new JRadioButton("Nu");
		rdbtnNU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cod_awb=textField_1.getText();
				String livrare="in tranzit retur";
				int awb=Integer.parseInt(cod_awb);
				Item item=databackend.getItem(awb);
				item.setStatus(livrare);
				databackend.updateAwb(awb,item);
				dispose();
				
			}
		});
		rdbtnNU.setBounds(34, 247, 109, 23);
		contentPane.add(rdbtnNU);
		timp();
	}
}
