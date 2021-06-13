package calulator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Calculator extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 9159895118851153685L;


	static JFrame frame;
	static JTextField textfield;
	String first,second,operator;
	
	Calculator(){
		first=second=operator="";
	}
	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		// TODO Auto-generated method stub
		frame=new JFrame("cal");
		UIManager.setLookAndFeel(UIManager.getLookAndFeel());
       Calculator calaculator=new Calculator();
       textfield =new JTextField(16);
       textfield.setEditable(false);
       frame.setUndecorated(false);

       
       JButton btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnAdd,btnSub,btnMul,btnDiv,btnDot,btnClr,btnEq;
       

       btn0 = new JButton("0");
       btn1 = new JButton("1");
       btn2 = new JButton("2");
       btn3 = new JButton("3");
       btn4 = new JButton("4");
       btn5 = new JButton("5");
       btn6 = new JButton("6");
       btn7 = new JButton("7");
       btn8 = new JButton("8");
       btn9 = new JButton("9");
       
       btnEq = new JButton("=");
       btnAdd = new JButton("+");
       btnSub = new JButton("-");
       btnDiv = new JButton("/");
       btnMul = new JButton("*");
       btnClr = new JButton("C");
       
       btnDot = new JButton(".");
       
      btnMul.addActionListener(calaculator);
      btnSub.addActionListener(calaculator);
      btnDiv.addActionListener(calaculator);
      btnAdd.addActionListener(calaculator);
      btnDot.addActionListener(calaculator);
      btnEq.addActionListener(calaculator);
      btnClr.addActionListener(calaculator);
      btn0.addActionListener(calaculator);
      btn1.addActionListener(calaculator);
      btn2.addActionListener(calaculator);
      btn3.addActionListener(calaculator);
      btn4.addActionListener(calaculator);
      
      btn5.addActionListener(calaculator);
      btn6.addActionListener(calaculator);
      btn7.addActionListener(calaculator);
      btn8.addActionListener(calaculator);
      btn9.addActionListener(calaculator);
     
      JPanel panel=new JPanel();
      panel.add(textfield);
      panel.add(btn7);
      panel.add(btn8);
      panel.add(btn9);
      panel.add(btnDiv);
      panel.add(btn4);
      panel.add(btn5);
      panel.add(btn6);
      panel.add(btnMul);
      panel.add(btn1);
      panel.add(btn2);
      panel.add(btn3);
      panel.add(btnSub);
      panel.add(btnEq);
      panel.add(btn0);
      panel.add(btnClr);
      panel.add(btnAdd);
      panel.add(btnDot);
      
      panel.setBackground(Color.BLACK);
      frame.add(panel);
      frame.setSize(200,220);
      frame.show();
      
      
      
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action = e.getActionCommand();
		if((action.charAt(0) >='0' && action.charAt(0) <= '9') || action.charAt(0) == '.') {
			if(action.equals(".") && first.contains(".")) {
				
			}
			else if(!operator.equals(""))
				second = second + action;
			else
				first = first + action;
		textfield.setText(first + operator +second);
		}
		else if(action.charAt(0) == 'C') {
			operator = second ="";
			first =" ";
			
			textfield.setText(first + operator + second);
			
		}
		else if(action.charAt(0) == '=' && !first.equalsIgnoreCase("") && !second.equalsIgnoreCase("")) {
			
			double result = 0;
			if(operator.equals("+"))
				result = (Double.parseDouble(first) + Double.parseDouble(second));
			else if(operator.equals("-"))
				result = (Double.parseDouble(first) - Double.parseDouble(second));
			else if(operator.equals("/"))
				result = (Double.parseDouble(first) / Double.parseDouble(second));
			else 
				result = (Double.parseDouble(first) * Double.parseDouble(second));
			
			textfield.setText(first+operator +second+"="+ result);
			first = Double.toString(result);
			operator =second ="";
			
			
		}
		else {
			if(operator.equals("") || second.equals(""))
				operator = action;
			else {
				double result;
				if(operator.equals("+"))
					result = (Double.parseDouble(first) + Double.parseDouble(second));
				if(operator.equals("-"))
					result = (Double.parseDouble(first) - Double.parseDouble(second));
					
				if(operator.equals("/"))
					result = (Double.parseDouble(first) / Double.parseDouble(second));
				else
					result = (Double.parseDouble(first) * Double.parseDouble(second));
				first = Double.toString(result);
				operator = action;
				second ="";
				
			}
			if(first.equals("")) {
				first = operator = "";
				
			}else if(second.equals("") && operator.equals("=")) {
				operator = "";
				
			}
			textfield.setText(first + operator + second );
		}
		
	}

}
