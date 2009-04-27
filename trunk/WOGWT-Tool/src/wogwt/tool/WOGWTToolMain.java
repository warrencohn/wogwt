package wogwt.tool;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WOGWTToolMain extends JFrame {

	public static void main(String[] args) {
		WOGWTToolMain frame = new WOGWTToolMain();
		frame.pack();
		frame.setVisible(true);
	}
	
	public WOGWTToolMain() {
		super();
		
		setLayout(new GridLayout(3, 1));
		
		JPanel headerPanel = new JPanel();
		this.add(headerPanel);
		
		JLabel label = new JLabel("WOGWT Tool - this will add WOGWT to an existing WO application.");
		headerPanel.add(label);
		
		JPanel topPanel = new JPanel();
		this.add(topPanel);
		
		JLabel pathLabel = new JLabel("Project folder: ");
		topPanel.add(pathLabel);
		
		final JTextField projectPath = new JTextField(30);
		topPanel.add(projectPath);
		
		final JFileChooser dialog = new JFileChooser();
		dialog.setDialogTitle("Select the project directory");
		dialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		JButton browseButton = new JButton("Browse");
		browseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = dialog.showOpenDialog(WOGWTToolMain.this);
				if (result == JFileChooser.APPROVE_OPTION) {
					projectPath.setText(dialog.getSelectedFile().getAbsolutePath());
				}
			}
		});
		topPanel.add(browseButton);
		
		JPanel lowerPanel = new JPanel();
		this.add(lowerPanel);
		
		JButton runButton = new JButton("Add WOGWT to Project");
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// show confirmation dialog prompting to backup
				try {
					ProjectCreator.main(new String[] {projectPath.getText()});
					// show success dialog telling to add WOGWT and JavaWOJSPServlet to classpath
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		lowerPanel.add(runButton);
	}
}
