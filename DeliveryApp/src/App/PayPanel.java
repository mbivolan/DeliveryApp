package App;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PayPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public PayPanel(JFrame frame, DataBackend backend, int awb) {
		setBounds(100, 100, 751, 595);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JButton btnPay = new JButton("Plateste");
		btnPay.setBounds(278, 386, 85, 21);
		add(btnPay);
		
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var item = backend.getItem(awb);
				item.setStatus("ToBeDelivered");
				backend.updateAwb(awb, item);
				
				var newPanel = new ConfirmPanel(frame, backend, awb);
				frame.setContentPane(newPanel);
				frame.repaint();
				frame.setVisible(true);
			}
		});
	}

}
