package 保存计算过程的计算机;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JTextField;

public class HandleBack implements ActionListener{
	LinkedList<String> list;
	JTextField resultShow;
	JTextField showComputerProcess;
	HandleBack(LinkedList<String> list,JTextField t1,JTextField t2){
		this.list = list;
		resultShow = t1;
		showComputerProcess = t2;
	}
	public void actionPerformed(ActionEvent e) {
		if(list.size()==1) {
			String num =(String) list.getFirst();
			if(num.length()>=1) {
				num=num.substring(0, num.length()-1);
				list.set(0, num);
				resultShow.setText(num);
				showComputerProcess.setText(""+num);
			}
			else {
				list.removeLast();
				resultShow.setText("0");
				showComputerProcess.setText("0");
			}
		}
		else if(list.size()==3) {
			String num =(String) list.getLast();
			if(num.length()>=1) {
				num = num.substring(0,num.length()-1);
				list.set(2, num);
				resultShow.setText(num);
				showComputerProcess.setText(num);
			}
			else {
				list.removeLast();
				resultShow.setText("0");
				showComputerProcess.setText("0");
			}
		}
	}
}
