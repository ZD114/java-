package �������ϵͳ;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import javax.swing.*;

public class Record extends JDialog implements ActionListener{
	int time=0;
	JTextField yourName;
	JLabel label;
	JButton enter,cancel;
	File gradeFile;
	
	public Record() {
		setBounds(100,100,330,160);
		setResizable(false);
		setModal(true);
		setVisible(false);
		enter = new JButton("ȷ��");
		cancel = new JButton("ȡ��");
		yourName = new JTextField(8);
		yourName.setText("����");
		enter.addActionListener(this);
		cancel.addActionListener(this);
		setLayout(new GridLayout(2,1));
		label = new JLabel();
		add(label);
		JPanel p = new JPanel();
		p.add(yourName);
		p.add(enter);
		p.add(cancel);
		add(p);
	}
	
	public void setGreadeFile(File f) {
		gradeFile = f;
		setTitle("����ɼ���"+gradeFile.getName());
		label.setText("����ɼ���"+gradeFile.getName());
	}
	
	public void setTime(int time) {
		this.time=time;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==enter) {
			LinkedList<People>list=new LinkedList<People>();
			try {
				RandomAccessFile out = new RandomAccessFile(gradeFile,"rw");
				out.seek(out.length());
				out.writeUTF(yourName.getText());
				out.writeInt(time);
				out.close();
			}
			catch(Exception event) {
			}
			setVisible(false);
		}
		if(e.getSource()==cancel) {
			setVisible(false);
		}
	}
}



