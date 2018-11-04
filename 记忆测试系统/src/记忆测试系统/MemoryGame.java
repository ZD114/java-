package 记忆测试系统;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MemoryGame extends JFrame implements ActionListener {
	JMenuBar bar;
	JMenu menuGrade,menuResult,menuIcon;
	JMenuItem oneGradeItem,twoGradeItem,threeGradeItem;
	JMenuItem oneGradeResult,twoGradeResult,threeGradeResult;
	JMenuItem carImageIcon,animalImageIcon;
	File fileOneGrade,fileTwoGrade,fileThreeGrade,gradeFile;
	String[]imageName;
	MemoryTestArea memoryArea;
	ShowRecordDialog showDialog=null;
	int m=5,n;
	final int imageNumber=7;
	MemoryGame(){
		fileOneGrade = new File("初级排行榜.txt");
		fileTwoGrade = new File("中级排行榜.txt");
		fileThreeGrade = new File("高级排行榜.txt");
		bar = new JMenuBar();
		menuGrade = new JMenu("选择级别");
		oneGradeItem = new JMenuItem("初级");
		twoGradeItem = new JMenuItem("中级");
		threeGradeItem = new JMenuItem("高级");
		menuGrade.add(oneGradeItem);
		menuGrade.add(twoGradeItem);
		menuGrade.add(threeGradeItem);
		menuResult = new JMenu("查看排行榜");
		oneGradeResult = new JMenuItem("初级排行榜");
		twoGradeResult = new JMenuItem("中级排行榜");
		threeGradeResult = new JMenuItem("高级排行榜");
		menuResult.add(oneGradeResult);
		menuResult.add(twoGradeResult);
		menuResult.add(threeGradeResult);
		menuIcon = new JMenu("选择图标");
		carImageIcon = new JMenuItem("汽车图标");
		animalImageIcon = new JMenuItem("动物图标");
		animalImageIcon.addActionListener(this);
		carImageIcon.addActionListener(this);
		menuIcon.add(carImageIcon);
		menuIcon.add(animalImageIcon);
		bar.add(menuGrade);
		bar.add(menuResult);
		bar.add(menuIcon);
		setJMenuBar(bar);
		oneGradeItem.addActionListener(this);
		twoGradeItem.addActionListener(this);
		threeGradeItem.addActionListener(this);
		oneGradeResult.addActionListener(this);
		twoGradeResult.addActionListener(this);
		threeGradeResult.addActionListener(this);
		if(!fileOneGrade.exists()) {
			try {
				fileOneGrade.createNewFile();
			}catch(IOException exp){}
		}
		if(!fileTwoGrade.exists()) {
			try {
				fileTwoGrade.createNewFile();
			}catch(IOException exp){}
		}
		if(!fileThreeGrade.exists()) {
			try {
				fileThreeGrade.createNewFile();
			}catch(IOException exp){}
		}
		setBounds(100,100,400,360);
		setVisible(true);
		memoryArea = new MemoryTestArea();
		imageName = new String[imageNumber];
		for(int i=0;i<imageName.length;i++) {
			imageName[i] = new String("car"+i+".jpg");
		}
		m=5;
		n=6;
		gradeFile = fileOneGrade;
		memoryArea.initBlock(m, n, imageName, gradeFile);
		add(memoryArea,BorderLayout.CENTER);
		showDialog = new ShowRecordDialog();
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==oneGradeItem) {
			m=5;
			n=6;
			gradeFile = fileOneGrade;
			memoryArea.initBlock(m,n,imageName,gradeFile);
		}
		if(event.getSource()==twoGradeItem) {
			m=6;
			n=7;
			gradeFile = fileTwoGrade;
			memoryArea.initBlock(m,n,imageName,gradeFile);
		}
		if(event.getSource()==threeGradeItem) {
			m=7;
			n=8;
			gradeFile = fileThreeGrade;
			memoryArea.initBlock(m,n,imageName,gradeFile);
		}
		if(event.getSource()==carImageIcon) {
			for(int i=0;i<imageName.length;i++) {
				imageName[i] = new String("car"+i+".jpg");
			}
			memoryArea.setImageName(imageName);
			memoryArea.initBlock(m, n, imageName, gradeFile);
		}
		if(event.getSource()==animalImageIcon) {
			for(int i=0;i<imageName.length;i++) {
				imageName[i] = new String("ani"+i+".jpg");
			}
			memoryArea.setImageName(imageName);
			memoryArea.initBlock(m, n, imageName, gradeFile);
		}
		if(event.getSource()==oneGradeResult) {
			showDialog.setGradeFile(fileOneGrade);
			showDialog.showRecord();
			showDialog.setVisible(true);
		}
		if(event.getSource()==twoGradeResult) {
			showDialog.setGradeFile(fileTwoGrade);
			showDialog.showRecord();
			showDialog.setVisible(true);
		}
		if(event.getSource()==threeGradeResult) {
			showDialog.setGradeFile(fileThreeGrade);
			showDialog.showRecord();
			showDialog.setVisible(true);
		}
	}
	public static void main(String args[]) {
		new MemoryGame();
	}
}
