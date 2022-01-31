package ru.boss90.editor.utils;

import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import javax.swing.*;
import ru.boss90.editor.events.ActionButtonSaveClick;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JTextArea textInFile = new JTextArea();
	public static JScrollPane textInFile2 = new JScrollPane(textInFile);
	public static JButton save = new JButton("Сохранить");
	public static boolean isText=true;

	public GUI() {
		super("Редактор кода");
		
		try {
			
			setBounds(500, 500, 500, 500);
	    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	setVisible(true);
	    	List<String> lines = Files.readAllLines(new File("D:/Desktop/Test.txt").toPath(), StandardCharsets.UTF_8);
	    	lines.forEach(text -> {
	    		if(isText) {
	    			textInFile.setText(text);
	    			isText=false;
	    			return;
	    		} 
	    		textInFile.setText(textInFile.getText()+"\n"+text);
	    	});
	    	Container container = getContentPane();
	    	container.add(textInFile2, BorderLayout.WEST);
	    	container.add(save, BorderLayout.NORTH);
	    	textInFile.updateUI();
	    	save.addActionListener(new ActionButtonSaveClick());

		}catch(Exception ignored) {System.out.println("Error: "+ignored);}
		
	}
}