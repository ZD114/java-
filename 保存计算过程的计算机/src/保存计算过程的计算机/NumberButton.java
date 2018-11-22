package ���������̵ļ����;

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
