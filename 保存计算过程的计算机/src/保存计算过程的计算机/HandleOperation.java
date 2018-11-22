package 保存计算过程的计算机;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HandleOperation implements ActionListener{
	LinkedList<String> list;
	JTextField resultShow;
	JTextField showComputerProcess;
	JTextArea saveComputerProcess;
	HandleOperation(LinkedList<String> list,JTextField t1,JTextField t2,JTextArea t3){
		this.list=list;
		resultShow=t1;
		showComputerProcess=t2;
		saveComputerProcess=t3;
	}
	public void actionPerformed(ActionEvent e) {
		OperationButton b=(OperationButton) e.getSource();
		if(list.size()==1) {
			String fuhao=b.getOperateSin();
			list.add(fuhao);
			showComputerProcess.setText(""+list.get(0)+""+list.get(1));
		}
		else if(list.size()==2) {
			String fuhao=b.getOperateSin();
			list.set(1, fuhao);
			showComputerProcess.setText(""+list.get(0)+""+list.get(1));
		}
		else if(list.size()==3) {
			String numOne=list.getFirst();
			String numTwo=list.getLast();
			String 运算符号=list.get(1);
			String middleProcess=numOne+""+运算符号+numTwo;
			try {
				double n1 = Double.parseDouble(numOne);
				double n2 = Double.parseDouble(numTwo);
				double result = 0;
				if(运算符号.equals("+")) {
					result=n1+n2;
				}
				else if(运算符号.equals("-")) {
					result=n1-n2;
				}
				else if(运算符号.equals("*"))
					result=n1*n2;
				else if(运算符号.equals("/"))
					result=n1/n2;
				String fuhao=b.getOperateSin();
				list.clear();
				list.add(""+result);
				list.add(fuhao);
				String por = middleProcess+"="+result+""+list.get(1);
				showComputerProcess.setText(por);
				saveComputerProcess.append(""+middleProcess+"="+result+"\n");
				resultShow.setText(""+result);
			}
			catch(Exception ee) {}
		}
	}
}
