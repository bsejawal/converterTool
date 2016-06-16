package com.fpp.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.fpp.converter.AbstractFactory;
import com.fpp.converter.BadInputException;
import com.fpp.converter.Converter;
import com.fpp.converter.FactoryProducer;

import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class ConvertorFrame extends JFrame {

	private static JPanel contentPane;
	private JTextField txtUserValue;
	private JTextField txtResult;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	String[] weights = new String[] { "KG", "LBS" };
	String[] temps = new String[] { "CELSIUS", "FAHRENHEIT" };
	static String[] distance = new String[] { "KM", "MILES" };

	static JCheckBox weightCheckBox;
	static JCheckBox lengthCheckBox;
	static JCheckBox tempCheckBox;
	// current list of items that is being shown
	static String[] displayList;

	static JComboBox fromList;
	static JComboBox toList;

	// current selected item for from
	static String from;
	// current selected item for to
	static String to;

	//
	double userValue;
	AbstractFactory convertFactory = null;

	// create super class instance for converting all
	// SuoerConversionClass selectedClass;

	// current selected conversion class
	String selectedConversion;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { ConvertorFrame frame = new
	 * ConvertorFrame(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } });
	 * 
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public ConvertorFrame() {
		setTitle("FPP GROUP THREE INC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 421);
		setLocationRelativeTo(null); // *** this will center your app ***
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		weightCheckBox = new JCheckBox("Weight");
		buttonGroup.add(weightCheckBox);
		weightCheckBox.setBounds(91, 77, 115, 48);
		contentPane.add(weightCheckBox);

		lengthCheckBox = new JCheckBox("Length");
		buttonGroup.add(lengthCheckBox);
		lengthCheckBox.setBounds(209, 77, 112, 48);
		lengthCheckBox.setSelected(true);
		contentPane.add(lengthCheckBox);

		tempCheckBox = new JCheckBox("Temparature");
		buttonGroup.add(tempCheckBox);
		tempCheckBox.setBounds(323, 77, 97, 48);
		contentPane.add(tempCheckBox);
		// buttonGroup.setSelected(m, b);

		weightCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				convertFactory = FactoryProducer.getFactory("WEIGHT");
				JCheckBox cb = (JCheckBox) event.getSource();
				if (cb.isSelected()) {
					// do something if check box is selected
					selectedConversion = cb.getText();
					// System.out.println(selectedConversion);
					displayList = weights;
					changeList(displayList);
				} else {
					// check box is unselected, do something else
				}
			}
		});
		lengthCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				convertFactory = FactoryProducer.getFactory("LENGTH");
				JCheckBox cb = (JCheckBox) event.getSource();
				if (cb.isSelected()) {
					// do something if check box is selected
					selectedConversion = cb.getText();
					// System.out.println(selectedConversion);
					displayList = distance;
					changeList(displayList);
				} else {
					// check box is unselected, do something else
				}
			}
		});
		tempCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				convertFactory = FactoryProducer.getFactory("TEMPERATURE");
				JCheckBox cb = (JCheckBox) event.getSource();
				if (cb.isSelected()) {
					// do something if check box is selected
					selectedConversion = cb.getText();
					// System.out.println(selectedConversion);
					displayList = temps;
					changeList(displayList);
				} else {
					// check box is unselected, do something else
				}
			}
		});
		// get the selected item:
		// String selectedBook = (String) buttonGroup.getSelectedItem();
		// System.out.println("You seleted the book: " + selectedBook);

		txtUserValue = new JTextField();
		txtUserValue.setBounds(91, 147, 149, 28);
		contentPane.add(txtUserValue);
		txtUserValue.setColumns(10);

		txtResult = new JTextField();
		txtResult.setColumns(10);
		txtResult.setBounds(260, 147, 92, 28);
		txtResult.setEditable(false);
		txtResult.setEnabled(false);
		contentPane.add(txtResult);

		JLabel lblUnitConverstionTool = new JLabel("Unit Converstion Tool");
		lblUnitConverstionTool.setFont(new Font("Microsoft JhengHei", Font.BOLD, 20));
		lblUnitConverstionTool.setBounds(140, 11, 240, 28);
		contentPane.add(lblUnitConverstionTool);

		JButton btnGo = new JButton("GO");
		// action on button clicked
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// get the selected item:
				// String selectedConversion = (String) buttonGroup.
				// System.out.println("You seleted the book: " +
				// selectedConversion);
				double convertedValue = 0.0;
				try {
					userValue = Double.parseDouble(txtUserValue.getText());
					System.out.println("Result: " + txtResult.getText());
					System.out.println("User Value : " + txtUserValue.getText());
					System.out.println(txtResult.getText());
					System.out.println("ToList : " + toList.getSelectedItem().toString());
					System.out.println("fromList: " + fromList.getSelectedItem().toString());
					// System.out.println(tempCheckBox.getText());
					Converter con = getInstance(fromList.getSelectedItem().toString(),
							toList.getSelectedItem().toString(), convertFactory);
					double inputVal = Double.parseDouble(txtUserValue.getText().toString());

					System.out.println("inpuvalue :: " + inputVal);

					convertedValue = con.convert(inputVal);
					System.out.println(
							fromList.getSelectedItem().toString() + " to " + toList.getSelectedItem().toString() + " ( "
									+ txtUserValue.getText() + " ) :" + convertedValue);

				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(contentPane, "Please input numbers only", "Warning",
							JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				} catch (BadInputException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String selectedClass = selectedConversion;
				txtResult.setText(String.format("%1$,.2f", convertedValue));

			}
		});
		btnGo.setBounds(349, 147, 71, 28);
		contentPane.add(btnGo);

		fromList = new JComboBox(distance);
		fromList.setBounds(91, 200, 149, 20);
		contentPane.add(fromList);
		// JComboBox comboBox_1 = new JComboBox(weights);
		toList = new JComboBox(distance);
		toList.setBounds(263, 200, 157, 20);
		contentPane.add(toList);
	}

	public Converter getInstance(String from, String to, AbstractFactory convertFactory) {
		Converter con = null;
		if (from.equalsIgnoreCase("KM") && to.equalsIgnoreCase("MILES")) {
			con = convertFactory.getLength("Km2Mile");
		} else if (from.equalsIgnoreCase("KM") && to.equalsIgnoreCase("MILES")) {
			con = convertFactory.getLength("Mile2Km");
		} else if (from.equalsIgnoreCase("CELSIUS") && to.equalsIgnoreCase("FAHRENHEIT")) {
			con = convertFactory.getTemperature("Celsius2Fahrenheit");
		} else if (from.equalsIgnoreCase("FAHRENHEIT") && to.equalsIgnoreCase("CELSIUS")) {
			con = convertFactory.getTemperature("Fahrenheit2Celsius");
		} else if (from.equalsIgnoreCase("KG") && to.equalsIgnoreCase("LBS")) {
			con = convertFactory.getWeight("Kg2Lbs");
		} else if (from.equalsIgnoreCase("LBS") && to.equalsIgnoreCase("KG")) {
			con = convertFactory.getWeight("Lbs2Kg");
		}
		return con;

	}

	// function to change list as per the checkbox
	public static void changeList(String[] displayList) {
		fromList.removeAllItems();
		for (String s : displayList)
			fromList.addItem(s);
		toList.removeAllItems();
		for (String s : displayList)
			toList.addItem(s);
		toList.setSelectedIndex(0);

	}
}
