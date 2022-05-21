package Test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Form;
import swing2swt.layout.BoxLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Combo;

public class MainApp {
	protected Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text textExpName;
	private Text textDesName;
	private Text textExpPhone;
	private Text textExpMail;
	private Text textExpCity;
	private Text textDesCity;
	private Text textDesPhone;
	private Text textDesMail;
	private Text textOthWeight;
	
	// private InternalState deliveryState;
	private DataBackend backend;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainApp window = new MainApp();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public MainApp() {
		// this.deliveryState = new InternalState();
		this.backend = new DataBackend();
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(620, 728);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		Composite composite = formToolkit.createComposite(shell, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		composite.setBounds(0, 0, 607, 681);
		formToolkit.paintBordersFor(composite);
		
		textExpName = new Text(composite, SWT.BORDER);
		textExpName.setBounds(159, 72, 153, 26);
		formToolkit.adapt(textExpName, true, true);
		
		Label label = new Label(composite, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(353, 10, 2, 243);
		formToolkit.adapt(label, true, true);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setBounds(191, 35, 121, 20);
		formToolkit.adapt(lblNewLabel, true, true);
		lblNewLabel.setText("Expeditor");
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setAlignment(SWT.CENTER);
		lblNewLabel_1.setBounds(388, 35, 98, 20);
		formToolkit.adapt(lblNewLabel_1, true, true);
		lblNewLabel_1.setText("Destinatar");
		
		textDesName = new Text(composite, SWT.BORDER);
		textDesName.setBounds(388, 72, 153, 26);
		formToolkit.adapt(textDesName, true, true);
		
		textExpPhone = new Text(composite, SWT.BORDER);
		textExpPhone.setBounds(159, 173, 153, 26);
		formToolkit.adapt(textExpPhone, true, true);
		
		textExpMail = new Text(composite, SWT.BORDER);
		textExpMail.setBounds(159, 227, 153, 26);
		formToolkit.adapt(textExpMail, true, true);
		
		textExpCity = new Text(composite, SWT.BORDER);
		textExpCity.setBounds(159, 121, 153, 26);
		formToolkit.adapt(textExpCity, true, true);
		
		textDesCity = new Text(composite, SWT.BORDER);
		textDesCity.setBounds(388, 121, 153, 26);
		formToolkit.adapt(textDesCity, true, true);
		
		textDesPhone = new Text(composite, SWT.BORDER);
		textDesPhone.setBounds(388, 173, 153, 26);
		formToolkit.adapt(textDesPhone, true, true);
		
		textDesMail = new Text(composite, SWT.BORDER);
		textDesMail.setBounds(388, 227, 153, 26);
		formToolkit.adapt(textDesMail, true, true);
		
		Label label_1 = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(194, 287, 370, 2);
		formToolkit.adapt(label_1, true, true);
		
		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		lblNewLabel_2.setAlignment(SWT.CENTER);
		lblNewLabel_2.setBounds(303, 311, 90, 20);
		formToolkit.adapt(lblNewLabel_2, true, true);
		lblNewLabel_2.setText("Alte detalii");
		
		textOthWeight = new Text(composite, SWT.BORDER);
		textOthWeight.setText("1");
		textOthWeight.setBounds(272, 351, 153, 26);
		formToolkit.adapt(textOthWeight, true, true);
		
		Label lblNume = new Label(composite, SWT.NONE);
		lblNume.setText("Nume");
		lblNume.setAlignment(SWT.CENTER);
		lblNume.setBounds(32, 72, 121, 26);
		formToolkit.adapt(lblNume, true, true);
		
		Label lblOras = new Label(composite, SWT.NONE);
		lblOras.setText("Oras");
		lblOras.setAlignment(SWT.CENTER);
		lblOras.setBounds(32, 121, 121, 26);
		formToolkit.adapt(lblOras, true, true);
		
		Label lblTelefon = new Label(composite, SWT.NONE);
		lblTelefon.setText("Telefon");
		lblTelefon.setAlignment(SWT.CENTER);
		lblTelefon.setBounds(32, 173, 121, 26);
		formToolkit.adapt(lblTelefon, true, true);
		
		Label lblMail = new Label(composite, SWT.NONE);
		lblMail.setText("Mail");
		lblMail.setAlignment(SWT.CENTER);
		lblMail.setBounds(32, 227, 121, 26);
		formToolkit.adapt(lblMail, true, true);
		
		Label lblGrutate = new Label(composite, SWT.NONE);
		lblGrutate.setText("Grutate Pachet");
		lblGrutate.setAlignment(SWT.CENTER);
		lblGrutate.setBounds(135, 351, 121, 20);
		formToolkit.adapt(lblGrutate, true, true);
		
		Label lblTipPachet = new Label(composite, SWT.NONE);
		lblTipPachet.setText("Tip Pachet");
		lblTipPachet.setAlignment(SWT.CENTER);
		lblTipPachet.setBounds(135, 400, 121, 20);
		formToolkit.adapt(lblTipPachet, true, true);
		
		Combo comboOthType = new Combo(composite, SWT.NONE);
		comboOthType.setBounds(272, 400, 153, 28);
		formToolkit.adapt(comboOthType);
		formToolkit.paintBordersFor(comboOthType);
		
		Button btnDataAdd = new Button(composite, SWT.NONE);
		btnDataAdd.setBounds(248, 521, 90, 30);
		formToolkit.adapt(btnDataAdd, true, true);
		btnDataAdd.setText("Add Data");
		btnDataAdd.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
	        	// Add Customer Here
	        	Customer dest = new Customer(textDesName.getText(), textDesPhone.getText(), textDesMail.getText());
	        	Customer exp = new Customer(textExpName.getText(), textExpPhone.getText(), textExpMail.getText());
	        	
	        	int awb = backend.addNewItem(
	        				new Item(
        							exp,
        							dest,
        							textExpCity.getText(),
        							textDesCity.getText(),
        							comboOthType.getText(),
        							Integer.valueOf(textOthWeight.getText())
	        					)
	        			);
	        	
	        	/*
	        	deliveryState.addPackage(
	        				new PackageState(
	        							exp,
	        							dest,
	        							textExpCity.getText(),
	        							textDesCity.getText(),
	        							Integer.valueOf(textOthWeight.getText()),
	        							comboOthType.getText()
	        						)
	        			);
	        	*/
	        }
	      });

	}
}
