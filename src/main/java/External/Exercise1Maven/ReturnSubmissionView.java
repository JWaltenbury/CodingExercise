package External.Exercise1Maven;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * User Interface class for the T3 Submission form. Also includes processing and state management of the form
 */
public class ReturnSubmissionView extends JFrame implements ActionListener {

	//Fields
	//TODO: Should add HashMap<String, T3Return> to hold the imported CSV records. Add to constructor as well
	private static final long serialVersionUID = 1L; //Default value required by JFrame
	private static final String title = "Code Exercise 1";
	private static final GridLayout layout = new GridLayout(0, 2, 0, 10);
	private static final JLabel lblTan = new JLabel("TAN:");
	private static final JTextField txtTan = new JTextField("");
	private static final JLabel lblNot = new JLabel("NOT:");
	private static final JTextField txtNot = new JTextField("");
	private static final JLabel lblCity = new JLabel("City:");
	private static final JTextField txtCity = new JTextField("");
	private static final JLabel lblProvince = new JLabel("Province:");
	private static final JTextField txtProvince = new JTextField("");
	private static final JLabel lblPi = new JLabel("PI:");
	private static final JTextField txtPi = new JTextField("");
	private static final JLabel lblRi = new JLabel("RI:");
	private static final JTextField txtRi = new JTextField("");
	private static final JButton btnSubmit = new JButton("Submit");
	private final JLabel lblSubmissionStatus = new JLabel("");
	
	
	//Constructors
	public ReturnSubmissionView()
	{
		//Initialize frame
		this.setTitle(title);
		this.setLayout(layout);
		
		//Alignment & spacing
		lblTan.setHorizontalAlignment(JLabel.CENTER);
		lblNot.setHorizontalAlignment(JLabel.CENTER);
		lblCity.setHorizontalAlignment(JLabel.CENTER);
		lblProvince.setHorizontalAlignment(JLabel.CENTER);
		lblPi.setHorizontalAlignment(JLabel.CENTER);
		lblRi.setHorizontalAlignment(JLabel.CENTER);
		lblSubmissionStatus.setHorizontalAlignment(JLabel.CENTER);
		
		//Add controls
		//TODO: Change layout style (GridBag) and remove filler controls
		this.add(new JLabel("")); //Filler
		this.add(new JLabel("")); //Filler
		this.add(lblTan);
		this.add(txtTan);
		this.add(lblNot);
		this.add(txtNot);
		this.add(lblCity);
		this.add(txtCity);
		this.add(lblProvince);
		this.add(txtProvince);
		this.add(lblPi);
		this.add(txtPi);
		this.add(lblRi);
		this.add(txtRi);
		this.add(new JLabel("")); //Filler
		this.add(new JLabel("")); //Filler
		
		this.add(btnSubmit);
		btnSubmit.addActionListener(this);
		
		this.lblSubmissionStatus.setVisible(false); //Do not want result message visible until submission
		this.add(lblSubmissionStatus);
		
		this.setSize(400,300);
		this.setResizable(false);
		this.setLocationRelativeTo(null); //Centers on screen
		this.setVisible(true);
	}
	
	
	//Methods
	/**
	 * Validates user input for the T3 return then returns the record
	 * @return T3Return - The submitted T3 object if valid submission, else null
	 */
	public T3Return processSubmission() {
		
		System.out.println("\n---------- Return Submission ----------");

		if(!Validations.isValidStringInput(txtTan.getText())) { System.out.println("ERROR: TAN is missing"); }
		else if(!Validations.isValidStringInput(txtNot.getText())){ System.out.println("ERROR: NOT is missing"); }
		else if(!Validations.isValidStringInput(txtCity.getText())){ System.out.println("ERROR: City is missing"); }
		else if(!Validations.isValidStringInput(txtProvince.getText())){ System.out.println("ERROR: Province is missing"); }
		else if(!Validations.isValidNonNegativeIntegerInput(txtPi.getText())){ System.out.println("ERROR: PI must be a positive integer value"); }
		else if(!Validations.isValidNonNegativeIntegerInput(txtRi.getText())){ System.out.println("ERROR: RI must be a positive integer value"); }
		else
		{
			//Valid
			lblSubmissionStatus.setForeground(Color.GREEN);
			lblSubmissionStatus.setText("Accepted return");
			lblSubmissionStatus.setVisible(true);
			
			T3Return returnObject = new T3Return(txtTan.getText(), txtNot.getText(), txtCity.getText(), txtProvince.getText(), txtPi.getText(), txtRi.getText());
			System.out.println(returnObject);
			System.out.println("STATUS: Accepted return"); 
			
			return returnObject;
		}
		
		//Invalid
		lblSubmissionStatus.setForeground(Color.RED);
		lblSubmissionStatus.setText("Rejected return");
		lblSubmissionStatus.setVisible(true);
		System.out.println("STATUS: Rejected return");
		
		return null; 
	}
	
	/**
	 * Event manager for the UI, handles submission of new T3 returns
	 */
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();  
	
		if( command.equals( "Submit" ))  {
			@SuppressWarnings("unused")
			T3Return returnObject = this.processSubmission(); //NOTE: Using this object is out of scope for the exercise
		}
	}
}
