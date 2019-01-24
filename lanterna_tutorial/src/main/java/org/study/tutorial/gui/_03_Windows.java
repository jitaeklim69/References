package org.study.tutorial.gui;

import java.io.IOException;
import java.util.Arrays;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.DefaultWindowManager;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class _03_Windows {

	public static void main(String[] args) {
		
		try {
			Terminal terminal = new DefaultTerminalFactory().createTerminal();
			Screen screen = new TerminalScreen(terminal);
			screen.startScreen();
			
			BasicWindow window = new BasicWindow();
			window.setHints(Arrays.asList(Window.Hint.FULL_SCREEN,
					Window.Hint.CENTERED));
			
			
			MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(),
					new EmptySpace(TextColor.ANSI.BLUE));
			gui.addWindowAndWait(window);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
