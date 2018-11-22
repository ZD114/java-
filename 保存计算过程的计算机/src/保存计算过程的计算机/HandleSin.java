package 保存计算过程的计算机;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HandleSin implements ActionListener{
	LinkedList<String> list;
	JTextField resultShow;
	JTextField showComputerProcess;
	JTextArea saveComputerProcess;
	HandleSin(LinkedList<String> list,JTextField t1,JTextField t2,JTextArea t3){
		this.list=list;
		resultShow = t1;
		showComputerProcess = t2;
		saveComputerProcess = t3;
	}
	public void actionPerformed(ActionEvent e) {
		if(list.size()==1||list.size()==2) {
			String numOne = list.getFirst();
			try {
				double x = Double.parseDouble(numOne);
				double result = Math.sin(x);
				String str = String.valueOf(result);
				list.set(0, str);
				resultShow.setText(str);
				String process = "sin("+numOne+")="+result;
				showComputerProcess.setText(process);
				saveComputerProcess.append(""+process+"\n");
				if(list.size()==2)
					list.removeLast();
			}catch(Exception ee) {}
		}
		else if(list.size()==3) {
			String numTwo = list.getLast();
			try {
				double x = Double.parseDouble(numTwo);
				double result = Math.sin(x);
				String str = String.valueOf(result);
				list.set(0, str);
				resultShow.setText(str);
				String process = "sin("+numTwo+")="+result;
				showComputerProcess.setText(process);
				saveComputerProcess.append(""+process+"\n");
				list.removeLast();
				list.removeLast();
			}catch(Exception ee) {}
		}

	}
}
