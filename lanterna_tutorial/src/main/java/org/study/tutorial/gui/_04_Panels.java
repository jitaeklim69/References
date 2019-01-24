package org.study.tutorial.gui;

import java.io.IOException;
import java.util.Arrays;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Borders;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.DefaultWindowManager;
import com.googlecode.lanterna.gui2.Direction;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.LinearLayout;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class _04_Panels {

	public static void main(String[] args) {
		
		try {
			Terminal terminal = new DefaultTerminalFactory().createTerminal();
			Screen screen = new TerminalScreen(terminal);
			screen.startScreen();
			
			BasicWindow window = new BasicWindow();
			window.setHints(Arrays.asList(Window.Hint.FULL_SCREEN,
					Window.Hint.CENTERED));
			
			Panel mainPanel = new Panel();
			//mainPanel.setLayoutManager(new LinearLayout(Direction.HORIZONTAL));
			mainPanel.setLayoutManager(new GridLayout(2));
			
			Panel leftPanel = new Panel();
			leftPanel.setPreferredSize(new TerminalSize(10, 10));
			mainPanel.addComponent(leftPanel.withBorder(Borders.singleLine("Left Panel"))
					.setLayoutData(GridLayout.createHorizontallyFilledLayoutData(1)) );
			
			Panel rightPanel = new Panel();
			rightPanel.setPreferredSize(new TerminalSize(10, 10));
			mainPanel.addComponent(rightPanel.withBorder(Borders.singleLine("Right Panel"))
					.setLayoutData(GridLayout.createHorizontallyFilledLayoutData(1)));
			
			window.setComponent(mainPanel.withBorder(Borders.singleLine("Main Panel")));
			
			MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(),
					new EmptySpace(TextColor.ANSI.BLUE));
			gui.addWindowAndWait(window);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
