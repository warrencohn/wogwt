package wogwt.tool;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WOGWTToolMain extends JFrame {

	public static void main(String[] args) {
		WOGWTToolMain frame = new WOGWTToolMain();
		frame.pack();
		frame.setSize(frame.getWidth() + 50, frame.getHeight() + 50);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public WOGWTToolMain() {
		super();
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints mainConstraints = new GridBagConstraints();
		mainConstraints.gridx = 0;
		mainConstraints.anchor = GridBagConstraints.EAST;
		
		JLabel label = new JLabel("<html>WOGWT Tool - this will add WOGWT to an existing WO application.<br><br>" +
				"Before you run this app you should do these things:<br><br>" +
				"Step 1: Commit or backup your project<br><br>" +
				"Step 2: Add the frameworks \"WOGWT\" and \"JavaWOJSPServlet\" to your project's build path.<br><br></html>");
		this.add(label, mainConstraints);
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridBagLayout());
		this.add(topPanel, mainConstraints);
		
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
		
		
		final JCheckBox chkUseGWTSourceProject = new JCheckBox("Use the WOGWT source project instead of the binary framework");
		this.add(chkUseGWTSourceProject, mainConstraints);
		
		JButton runButton = new JButton("Add WOGWT to Project");
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ProjectCreator.main(new String[] {projectPath.getText(), chkUseGWTSourceProject.isSelected() + ""});
					JOptionPane.showMessageDialog(WOGWTToolMain.this, "WOGWT has been added to your project");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		mainConstraints.anchor = GridBagConstraints.CENTER;
		this.add(runButton, mainConstraints);
	}
}
