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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pagina_expeditor frame = new Pagina_expeditor();
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
                	new CourierFrame().setVisible(true);
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
	public Pagina_expeditor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 179);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPlataDest = new JButton("Plateste");
		btnPlataDest.setBounds(21, 23, 119, 23);
		contentPane.add(btnPlataDest);
		
		JButton btnRetur = new JButton("Retrurneaza colet");
		btnRetur.setBounds(21, 66, 119, 23);
		contentPane.add(btnRetur);
		
		textField = new JTextField();
		textField.setBounds(261, 24, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSprePlata = new JButton("Spre plata");
		
		btnSprePlata.setBounds(392, 23, 119, 23);
		contentPane.add(btnSprePlata);
		
		JLabel lblPlataDest = new JLabel("Numar de zile:");
		lblPlataDest.setBounds(166, 27, 85, 14);
		contentPane.add(lblPlataDest);
		
		btnSprePlata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int zile;
				String z;
				try {
					z=textField.getText();
					zile=Integer.parseInt(z);
					new Pagina_plata().setVisible(true);
					Pagina_plata.txtCash2.setText(textField.getText());
					dispose();
				}
				catch(NumberFormatException p)
				{
					JOptionPane.showMessageDialog(null, "Trebuie introdus un numar de zile");
				}
				
				//lblCash2.setText(textField.getText());
				
				
			}
		});
	}
}
