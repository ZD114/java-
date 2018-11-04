package �������ϵͳ;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.TreeSet;
import javax.swing.*;

import com.sun.glass.events.WindowEvent;

public class ShowRecordDialog extends JDialog implements ActionListener{
	File gradeFile;
	JButton clear;
	JTextArea showArea;
	TreeSet<People> treeSet;
	
	public ShowRecordDialog() {
		treeSet = new TreeSet<People>();
		showArea = new JTextArea(6,4);
		showArea.setFont(new Font("����",Font.BOLD,20));
		clear = new JButton("������а�");
		clear.addActionListener(this);
		add(new JScrollPane(showArea),BorderLayout.CENTER);
		add(clear,BorderLayout.SOUTH);
		setBounds(100,100,320,185);
		setModal(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
	}

	public void setGradeFile(File f) {
		gradeFile = f;
		setTitle(f.getName());
	}
	public void showRecord() {
		showArea.setText(null);
		treeSet.clear();
		try {
			RandomAccessFile in = new RandomAccessFile(gradeFile,"rw");
			long readPosition = 0;
			long fileLength = in.length();
			while(readPosition<fileLength) {
				String name = in.readUTF();
				int time = in.readInt();
				readPosition = in.getFilePointer();
				People people = new People(name,time);
				treeSet.add(people);
			}
			in.close();
			Iterator<People>iter = treeSet.iterator();
			while(iter.hasNext()) {
				People p = iter.next();
				showArea.append("����:"+p.getName()+",�ɼ�"+p.getTime()+"��");
				showArea.append("\n");
			}
		}catch(IOException exp) {
			System.out.println(exp);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==clear) {
			try {
				File f = gradeFile.getAbsoluteFile();
				gradeFile.delete();
				f.createNewFile();
				showArea.setText("���а����");
			}catch(Exception ee) {}
		}
	}
}
