package oblig3.calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

import org.xml.sax.InputSource;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Main {

	private JFrame frame;
	private JTextField inputField;
	private JLabel inputStorage;
	private String[] modifiers = {"/", "X", "+", "-"};
	private String[] leftPanelButtons = {"9", "8", "7", "6", "5", "4", "3", "2", "1", ",", "0", "="};
	private String[] rightPanelButtons = {"DEL", "/", "X", "+", "-"}; 
	private String activeModifier = "";
	private int calculatorState = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 350, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow,fill]", "[5px][][75px:75px:100px,fill][grow,fill]"));
		
		inputStorage = new JLabel("");
		inputStorage.setHorizontalAlignment(SwingConstants.LEFT);
		inputStorage.setVerticalAlignment(SwingConstants.TOP);
		inputStorage.setForeground(Color.WHITE);
		frame.getContentPane().add(inputStorage, "cell 0 1");
			
		inputField = new JTextField();
		inputField.setBackground(new Color(0, 0, 0));
		inputField.setForeground(new Color(255, 255, 255));
		inputField.setFont(new Font("Monospaced", Font.PLAIN, 28));
		inputField.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(inputField, "cell 0 2,grow");
		inputField.setColumns(10);
		// Remove old and make new invisible inner border
		inputField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		inputField.setCaretColor(new Color(255, 255, 255));
		
		JPanel panelMain = new JPanel();
		panelMain.setBackground(Color.BLACK);
		frame.getContentPane().add(panelMain, "cell 0 3");
		panelMain.setLayout(new MigLayout("", "[250px,grow,fill][150px,grow,fill]", "[grow,fill][grow,fill]"));
		
		JPanel panelLeft = new JPanel();
		panelMain.add(panelLeft, "cell 0 0 1 2,growy");
		panelLeft.setBackground(new Color(0, 0, 0));
		panelLeft.setLayout(new GridLayout(4, 3, 5, 5));
		
		JPanel panelRight = new JPanel();
		panelRight.setBackground(Color.BLACK);
		panelMain.add(panelRight, "cell 1 0 1 2,grow");
		panelRight.setLayout(new GridLayout(5, 1, 5, 5));

		Object[] tmpArray= new Object[leftPanelButtons.length];
//	    List<JButton> buttons = new ArrayList<JButton>();
		
		
		Map<String, JButton> Buttons = new HashMap<>();
		
		for (int i = 0; i < leftPanelButtons.length; i++) {
			JButton tmpBtn = new JButton(leftPanelButtons[i]);
			tmpBtn.setForeground(Color.WHITE);
			tmpBtn.setFont(new Font("Monospaced", Font.PLAIN, 20));
			tmpBtn.setBackground(Color.BLACK);
			tmpBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			
			Buttons.put(leftPanelButtons[i], tmpBtn);
			
			tmpBtn.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {
					inputField.requestFocus();
					String key = ((JButton) e.getSource()).getText();
					key = getCalculatorKey(key, e.getModifiers());
					inputField.setText(inputField.getText() + key);
					checkForAction(key);
				}

				@Override public void mousePressed(MouseEvent e) {}
				@Override public void mouseExited(MouseEvent e) {}
				@Override public void mouseEntered(MouseEvent e) {}
				@Override public void mouseClicked(MouseEvent e) {}
			});
			panelLeft.add(tmpBtn);
		}
		
		for (int i = 0; i < rightPanelButtons.length; i++) {
			JButton tmpBtn = new JButton(rightPanelButtons[i]);
			tmpBtn.setForeground(Color.WHITE);
			tmpBtn.setFont(new Font("Monospaced", Font.PLAIN, 20));
			tmpBtn.setBackground(Color.BLACK);
			tmpBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			panelRight.add(tmpBtn);
			
			Buttons.put(rightPanelButtons[i], tmpBtn);
			
			tmpBtn.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {
					inputField.requestFocus();
					String key = ((JButton) e.getSource()).getText();
					key = getCalculatorKey(key, e.getModifiers());
//					inputField.setText(inputField.getText() + key);
					checkForAction(key);
				}
				
				@Override public void mousePressed(MouseEvent e) {}
				@Override public void mouseExited(MouseEvent e) {}
				@Override public void mouseEntered(MouseEvent e) {}
				@Override public void mouseClicked(MouseEvent e) {}
			});
		}
		
		inputField.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (inputStorage.getText().length() == 0) {
					calculatorState = 1;
				} else {
					calculatorState = 2;
				}
				String key = getCalculatorKey(e.getKeyText(e.getKeyCode()), e.getModifiers());
				changeKeyColor(key, new Color(0, 0, 0), new Color(255, 255, 255));
				inputField.requestFocus();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				String key = getCalculatorKey(e.getKeyText(e.getKeyCode()), e.getModifiers());
				checkForAction(key);
				changeKeyColor(key, new Color(255, 255, 255), new Color(0, 0, 0));
			}
			
			public void changeKeyColor(String key, Color background, Color foreground) {
				if (Arrays.asList(leftPanelButtons).contains(key) || Arrays.asList(rightPanelButtons).contains(key)) {
					Buttons.get(key).setForeground(foreground);
					Buttons.get(key).setBackground(background);
				}
			}
			
			@Override public void keyTyped(KeyEvent e) {}
		});
		
		PlainDocument doc = new PlainDocument();
		doc.setDocumentFilter(new DocumentFilter() {
		    @Override
		    public void insertString(FilterBypass fb, int off, String str, AttributeSet attr) 
	        throws BadLocationException {
	        	fb.insertString(off, str.replaceAll("[^0-9\\.\\,\\-]+", ""), attr);  // remove non-digits
	    	} 
		    
		    @Override
		    public void replace(FilterBypass fb, int off, int len, String str, AttributeSet attr) 
	        throws BadLocationException {
		    	fb.replace(off, len, str.replaceAll("[^0-9\\.\\,\\-]+", ""), attr);  // remove non-digits
		    }
		});
		
		inputField.setDocument(doc);
		inputField.requestFocus();
		frame.setLocationRelativeTo(null);
	}
	
	// For special chars and calc operators 
	public String getCalculatorKey(String key, int modifiers) {
		int shift = 1;
		int ctrl = 2;
		int ctrlShift = 3;
		
		switch (key) {	
		case "0":
				if (modifiers == shift) {
					return "=";
				}
				return key;
			case "'":
			case "Quote":
			case "M":
			case "*":
				return "X";
			case "A":
			case "P":
			case "Plus":
				return "+";
			case "S":
			case "Minus":
				return "-";
			case "Delete":
				return "DEL";
			case "D":
				return "/";
			case "7":
				if (modifiers == shift) {
					return "/";
				}

				return key;
			case "W":
			case "Q":
				if (modifiers == 2) {
					System.exit(0);
				}
				
				return key;
			default:
				return key;
		}
	}
	
	// Did the user click an operator?
	public void checkForAction(String key) {
		if (Arrays.asList(modifiers).contains(key)) {
			if (key == "-") {
				if (inputField.getText().length() != 0) {
					setModifier(key);
				}
			} else {
				setModifier(key);
			}			
		}
		
		if (key == "DEL") {
			switch (calculatorState) {
				case 3:
					activeModifier = null;
					inputField.setText("");
					inputStorage.setText("");
					break;
				default:
					if (inputField.getText().length() != 0) {
						inputField.setText(inputField.getText().substring(0, inputField.getText().length()-1));
					} else if (inputField.getText().length() == 0) {
						activeModifier = "";
						inputField.setText("");
						inputStorage.setText("");
					}
					break;
			}
		}
		
		if (key == "=") {
			calculate();
		}
	}
	
	// Set 
	public void setModifier(String key) {
		if (inputField.getText().length() == 0 && inputStorage.getText().length() == 0) {
			return;
		}
		
		calculatorState = 2;
		
		if (activeModifier.length() != 0) {
			inputStorage.setText(inputStorage.getText().substring(0, inputStorage.getText().length()-2));
		} else {
			inputStorage.setText(inputField.getText());
			inputField.setText("");
		}
		
		activeModifier = key;
		inputStorage.setText(inputStorage.getText() + " " + activeModifier);
	}
	
	public void calculate() {
		try {
			if (inputField.getText().length() == 0 || inputStorage.getText().length() == 0) {
				return;
			}
			
			calculatorState = 3;
			BigDecimal answer = null;
			// Convert from string to BigDecimal. Remove all excess operator signs that might be because of errors
			BigDecimal numb1 = new BigDecimal(inputStorage.getText().substring(0, inputStorage.getText().length()-2).replaceAll("\\" + activeModifier + "", ""));
			BigDecimal numb2 = new BigDecimal(inputField.getText().replaceAll("\\" + activeModifier + "", ""));
			
			switch (activeModifier) {
				case "+":
					answer = numb1.add(numb2);
					break;
				case "-":
					answer = numb1.subtract(numb2);
					break;
				case "X":
					answer = numb1.multiply(numb2);
					break;
				case "/":
					answer = numb1.divide(numb2);
					break;
				default:
					break;
			}

			inputStorage.setText(inputStorage.getText() + " " + inputField.getText());
			System.out.println(answer.toString());
			
			inputField.setText(answer.toString());
			
			inputStorage.setText("");
			activeModifier = "";
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frame, "Noe gikk galt: " + e);
		}
	}
}
