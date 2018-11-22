package 保存计算过程的计算机;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OperationButton extends JButton{
	String operateSign;
	public OperationButton(String s) {
		super(s);
		operateSign = s;
		setForeground(Color.RED);
	}
	public String getOperateSin() {
		return operateSign;
	}
}
