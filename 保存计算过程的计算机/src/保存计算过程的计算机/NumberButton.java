package 保存计算过程的计算机;

import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;


public class NumberButton extends JButton{
	int number;
	public NumberButton(int number) {
		super(""+number);
		this.number=number;
		setForeground(Color.BLUE);
	}
	public int getNumber() {
		return number;
	}
}
