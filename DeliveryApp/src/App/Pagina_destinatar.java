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
	public JTextField textField;
	public static JTextField textField_1;
	public boolean adevar;
	private long time;
	public int numar_secunde;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pagina_destinatar frame = new Pagina_destinatar();
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
        	//System.out.println(numar_secunde);
            while (true) {
                if (System.currentTimeMillis() - time > (numar_secunde*1000)) {
                	new CourierFrame().setVisible(true);
                    dispose();
                    break;
                }
            }
        }
    }).start();
    }
	
	public void secunde(int a) {
		numar_secunde=a;
	}


	/**
	 * Create the frame.
	 */
	public Pagina_destinatar() {
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
					//schimba statusul coletului in livrat
					dispose();
				}
			}
		});
		rdbtnDa.setBounds(34, 209, 109, 23);
		contentPane.add(rdbtnDa);
		//timp();
	}

	
}