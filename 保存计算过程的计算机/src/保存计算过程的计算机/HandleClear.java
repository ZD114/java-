package 保存计算过程的计算机;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JTextField;

public class HandleClear implements ActionListener {
	LinkedList<String> list;
	JTextField resultShow;
	JTextField showComputerProcess;
	HandleClear(LinkedList<String> list,JTextField t1,JTextField t2){
		this.list = list;
		resultShow = t1;
		showComputerProcess = t2;
	}
	public void actionPerformed(ActionEvent e) {
		resultShow.setText("0");
		list.clear();
		showComputerProcess.setText(null);
	}
}
