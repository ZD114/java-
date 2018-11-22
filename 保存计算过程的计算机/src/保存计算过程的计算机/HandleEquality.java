package ���������̵ļ����;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HandleEquality implements ActionListener{
	LinkedList<String> list;
	JTextField resultShow;
	JTextField showComputerProcess; 
	JTextArea saveComputerProcess;
	HandleEquality(LinkedList<String> list,JTextField t1,JTextField t2,JTextArea t3){
		this.list=list;
		resultShow = t1;
		showComputerProcess = t2;
		saveComputerProcess = t3;
	}
	public void actionPerformed(ActionEvent e) {
		if(list.size()==1) {
			String num = list.getFirst();
			resultShow.setText(""+num);
			showComputerProcess.setText(list.get(0));
		}
		if(list.size()==2) {
			String num = list.getFirst();
			String ������� = list.get(1);
			try {
				double n1 = Double.parseDouble(num);
				double n2 = Double.parseDouble(num);
				double result = 0;
				if(�������.equals("+"))
					result = n1 +n2;
				else if(�������.equals("-"))
					result = n1-n2;
				else if(�������.equals("*"))
					result = n1*n2;
				else if(�������.equals("/"))
					result = n1/n2;
				resultShow.setText(""+result);
				String process = num+""+�������+""+num+"="+result;
				showComputerProcess.setText(process);
				saveComputerProcess.append(""+process+"\n");
				list.set(0,""+ result);
			}catch(Exception ee ) {}
		}
			else if(list.size()==3) {
				String numOne = list.getFirst();
				String ������� = list.get(1);
				String numTwo = list.getLast();
				try {
					double n1 = Double.parseDouble(numOne);
					double n2 = Double.parseDouble(numTwo);
					double result = 0;
					if(�������.equals("+"))
						result = n1 +n2;
					else if(�������.equals("-"))
						result = n1-n2;
					else if(�������.equals("*"))
						result = n1*n2;
					else if(�������.equals("/"))
						result = n1/n2;
					resultShow.setText(""+result);
					String process = numOne+""+�������+""+numTwo+"="+result;
					showComputerProcess.setText(process);
					saveComputerProcess.append(" "+process+"\n");
					list.set(0,""+ result); 
					list.removeLast();
					list.removeLast();
				}catch(Exception ee) {}
			}
	}
}
