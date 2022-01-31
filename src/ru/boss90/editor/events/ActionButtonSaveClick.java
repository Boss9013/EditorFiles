package ru.boss90.editor.events;

import java.awt.event.*;
import java.io.FileWriter;

import ru.boss90.editor.utils.GUI;

public class ActionButtonSaveClick implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		
		try {
			FileWriter writer = new FileWriter("D:/Desktop/Test.txt", false);
			writer.write(GUI.textInFile.getText());
			System.out.println(GUI.textInFile.getText());
			writer.flush();
			writer.close();
		}catch(Exception ignored) {}
		
	}

	
}
