package client2;
import bus2.*;
import java.awt.EventQueue;
import Data.*;
import bus.RaiseException;
import bus2.CustomerDB;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class WindowsCustomerBuilder {

	private JFrame frame;
	private JTextField txtCustomerID;
	private JTextField txtFname;
	private JTextField txtLname;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private JTextField txtPin;
	private JTextField txtPhoneNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowsCustomerBuilder window = new WindowsCustomerBuilder();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowsCustomerBuilder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer ID:");
		lblNewLabel.setBounds(25, 25, 71, 13);
		frame.getContentPane().add(lblNewLabel);
		
		txtCustomerID = new JTextField();
		txtCustomerID.setBounds(22, 48, 96, 19);
		frame.getContentPane().add(txtCustomerID);
		txtCustomerID.setColumns(10);
		
		txtFname = new JTextField();
		txtFname.setBounds(25, 113, 96, 19);
		frame.getContentPane().add(txtFname);
		txtFname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("First Name:");
		lblNewLabel_1.setBounds(25, 90, 60, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtLname = new JTextField();
		txtLname.setColumns(10);
		txtLname.setBounds(22, 173, 96, 19);
		frame.getContentPane().add(txtLname);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name:");
		lblNewLabel_2.setBounds(25, 150, 71, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(161, 48, 96, 19);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setBounds(165, 25, 45, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(161, 113, 96, 19);
		frame.getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Address:");
		lblNewLabel_4.setBounds(165, 90, 45, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		txtPin = new JTextField();
		txtPin.setText("000");
		txtPin.setBounds(161, 173, 96, 19);
		frame.getContentPane().add(txtPin);
		txtPin.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Pin");
		lblNewLabel_5.setBounds(165, 150, 45, 13);
		frame.getContentPane().add(lblNewLabel_5);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setBounds(294, 48, 96, 19);
		frame.getContentPane().add(txtPhoneNumber);
		txtPhoneNumber.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Phone Number:");
		lblNewLabel_6.setBounds(294, 25, 96, 13);
		frame.getContentPane().add(lblNewLabel_6);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fname, lname, email, address, phonenumber,result;
				long id;
				int pin;
				if(txtPin.getText()==null) {
					txtPin.setText("0");
				}
				fname= txtFname.getText();
				lname = txtLname.getText();
				email = txtEmail.getText();
				pin =    Integer.valueOf(txtPin.getText()) ;
				address = txtAddress.getText();
				phonenumber= txtPhoneNumber.getText();
				id =  Long.parseLong(txtCustomerID.getText());

				Customer c1 = null;
					c1 = new Customer(fname, lname, email, id, pin, address, phonenumber);

					try {
						result=CustomerDB.AddCustomer(c1);
					JOptionPane.showMessageDialog(null, result);	
					} catch (NumberFormatException | SQLException | RaiseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}


				

				txtCustomerID.setText(null);
				txtFname.setText(null);
				txtLname.setText(null);
				txtEmail.setText(null);
				txtPin.setText(null);
				txtAddress.setText(null);
				txtPhoneNumber.setText(null);
				
			}
		});
		btnAdd.setBounds(294, 86, 85, 21);
		frame.getContentPane().add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fname, lname, email, address, phonenumber,result;
				long id;
				int pin;
				fname= "";
				lname = "";
				email ="";		
				id = Long.parseLong(txtCustomerID.getText());
				pin =  0 ;
				address = "";
				phonenumber= "";
				Customer c1 = null;

						try {
							c1 = new Customer(fname, lname, email, id, pin, address, phonenumber);
							result=CustomerDB.RemoveCustomer(c1);
						JOptionPane.showMessageDialog(null, result);						
						} catch (RaiseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						

					


				txtCustomerID.setText(null);
				txtFname.setText(null);
				txtLname.setText(null);
				txtEmail.setText(null);
				txtPin.setText(null);
				txtAddress.setText(null);
				txtPhoneNumber.setText(null);
			}
		});
		btnDelete.setBounds(294, 127, 85, 21);
		frame.getContentPane().add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fname, lname, email, address, phonenumber,result;
				long id;
				int pin;
				fname= txtFname.getText();
				lname = txtLname.getText();
				email = txtEmail.getText();
				pin =    Integer.valueOf(txtPin.getText()) ;
				address = txtAddress.getText();
				phonenumber= txtPhoneNumber.getText();
				id =  Long.parseLong(txtCustomerID.getText());
				

				Customer c1 = null;

					c1 = new Customer(fname, lname, email, id, pin, address, phonenumber);

				
					try {
						result=CustomerDB.UpdateCustomer(c1);
						JOptionPane.showMessageDialog(null, result);
					} catch (NumberFormatException | SQLException | RaiseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}



				txtCustomerID.setText(null);
				txtFname.setText(null);
				txtLname.setText(null);
				txtEmail.setText(null);
				txtPin.setText(null);
				txtAddress.setText(null);
				txtPhoneNumber.setText(null);
			}
		});
		btnUpdate.setBounds(294, 158, 85, 21);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname, lname, email, address, phonenumber,result;
				long id;
				int pin;
				fname= "";
				lname = "";
				email ="";
					pin =  0;
				address = "";
				phonenumber= "";
				id =  Long.parseLong(txtCustomerID.getText());
				

				Customer c1 = null;

					c1 = new Customer(fname, lname, email, id, pin, address, phonenumber);
					try {
						c1 = CustomerDB.SearchCustomer(id);
					} catch (NumberFormatException | SQLException | RaiseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, c1);


				txtCustomerID.setText(null);
				txtFname.setText(null);
				txtLname.setText(null);
				txtEmail.setText(null);
				txtPin.setText(null);
				txtAddress.setText(null);
				txtPhoneNumber.setText(null);
			}
		});
		btnSearch.setBounds(294, 189, 85, 21);
		frame.getContentPane().add(btnSearch);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
String result;
				ArrayList<Customer> CustomerList = null;
				
    
				try {
					CustomerList =  CustomerDB.DisplayAllCustomers();
				} catch (NumberFormatException | SQLException | RaiseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				result= CustomerList.toString();
				JOptionPane.showMessageDialog(null, result);
				txtCustomerID.setText(null);
				txtFname.setText(null);
				txtLname.setText(null);
				txtEmail.setText(null);
				txtPin.setText(null);
				txtAddress.setText(null);
				txtPhoneNumber.setText(null);
			}
		});
		btnDisplay.setBounds(294, 220, 85, 21);
		frame.getContentPane().add(btnDisplay);
	}
}
