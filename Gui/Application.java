

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.border.EtchedBorder;
import javax.swing.JTabbedPane;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Application {
	private static int pageCounter = 0;
	private JFrame frame;
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Dimension screenSize = toolkit.getScreenSize();
	int screenWidth = screenSize.width;
	int screenHeight = screenSize.height;
	int applicationWidth = screenWidth / 2;
	int applicationHeight = (5 * screenHeight) / 9;
	private JTextPane txtpnFreeAndBuilt;
	
	public int getPosX() {
		return screenWidth / 2 - applicationWidth / 2;
	}

	public int getPosY() {
		return screenHeight / 2 - applicationHeight / 2;
	}
	
	public int percentage(double num) {
		return (int) ((applicationWidth + applicationHeight) / 100 * num);
	}
	
	public ImageIcon resizeImage(JLabel label, ImageIcon icon) {
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(imgScale);
		return scaledIcon;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Application() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(480, 270, 960, 600);
		frame.setBounds(getPosX(), getPosY(), applicationWidth, applicationHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, -24, applicationWidth,(int)(applicationHeight*0.85) );
		frame.getContentPane().add(tabbedPane);
		
		JPanel welcome = new JPanel();
		tabbedPane.addTab("New tab", null, welcome, null);
		welcome.setBackground(new Color(255,255,255));
		welcome.setLayout(null);
		
		JLabel header = new JLabel("Welcome  to Ezybit");
		header.setForeground(Color.BLACK);
		header.setFont(new Font("Arial", Font.BOLD, percentage(2)));
		header.setBounds(30, 33, 331, 43);
		welcome.add(header);
		
		JLabel floater = new JLabel();
		floater.setBounds(0, 0, 944, 232);
		ImageIcon icon = new ImageIcon(Application.class.getResource("/Images/floater.png"));
		ImageIcon scaledIcon = resizeImage(floater, icon);
		floater.setIcon(scaledIcon);
		welcome.add(floater);
		
		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon(Application.class.getResource("/Images/EZ.png")));
		logo.setBounds(33, 202, 285, 278);
		welcome.add(logo);
		
		JLabel lblNewLabel = new JLabel("Download Ezybit");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 21));
		lblNewLabel.setBounds(541, 171, 210, 43);
		welcome.add(lblNewLabel);
		
		txtpnFreeAndBuilt = new JTextPane();
		txtpnFreeAndBuilt.setFont(new Font("Arial", Font.PLAIN, 14));
		txtpnFreeAndBuilt.setEnabled(false);
		txtpnFreeAndBuilt.setDisabledTextColor(new Color(0, 0, 0));
		txtpnFreeAndBuilt.setEditable(false);
		txtpnFreeAndBuilt.setText("Free and built in open source. Integrated debugging and extension \n\n" +
				"Ezybit is an intuitive software that automates the installation of \n"
				+ "programming languages. With a user-friendly interface, it detects \n"
				+ "system requirements and swiftly sets up languages like Python, Java, \n"
				+ "C++, and more, streamlining the development process effortlessly.\n\n"
				+ "With a single click, users can initiate the installation process for their \n"
				+ "preferred programming Application, saving valuable time and effort \n"
				+ "compared to traditional manual installations.");
		txtpnFreeAndBuilt.setBackground(new Color(0, 0, 0, 0));
		txtpnFreeAndBuilt.setBounds(439, 243, 460, 215);
		welcome.add(txtpnFreeAndBuilt);
		
		JPanel footer = new JPanel();
		footer.setBackground(new Color(192, 192, 192));
		footer.setBounds(0, 484, 944, 77);
		frame.getContentPane().add(footer);
		
		JButton Next_btn = new JButton("Next");
		Next_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pageCounter++;
				System.out.println(pageCounter);
				if(pageCounter>3) {
					frame.dispose();
				}
				tabbedPane.setSelectedIndex(pageCounter);
			}
		});
		
		footer.setLayout(null);

		Next_btn.setRolloverEnabled(false);
		Next_btn.setRequestFocusEnabled(false);
		Next_btn.setIgnoreRepaint(true);
		Next_btn.setFocusable(false);
		Next_btn.setFocusTraversalKeysEnabled(false);
		Next_btn.setFocusPainted(false);
		Next_btn.setBackground(new Color(0, 0, 0, 0));
		Next_btn.setBounds(703, 23, 89, 23);
		footer.add(Next_btn);

		JButton Cancel_btn = new JButton("Cancel");
		Cancel_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pageCounter--;
				tabbedPane.setSelectedIndex(pageCounter);
			}
		});
		Cancel_btn.setRolloverEnabled(false);
		Cancel_btn.setRequestFocusEnabled(false);
		Cancel_btn.setIgnoreRepaint(true);
		Cancel_btn.setFocusable(false);
		Cancel_btn.setFocusTraversalKeysEnabled(false);
		Cancel_btn.setFocusPainted(false);
		Cancel_btn.setBackground(new Color(0, 0, 0, 0));
		Cancel_btn.setBounds(817, 23, 89, 23);
		footer.add(Cancel_btn);
		
		JPanel Select_language = new JPanel();
		tabbedPane.addTab("New tab", null, Select_language, null);
		Select_language.setLayout(null);
		
		JLabel Heading = new JLabel("Download our top extentions");
		Heading.setForeground(Color.WHITE);
		Heading.setFont(new Font("Arial", Font.PLAIN, 28));
		Heading.setBounds(10, 59, 407, 78);
		Select_language.add(Heading);
		
		JLabel logo1 = new JLabel();
		logo1.setBounds(761, 30, 133, 107);
		ImageIcon logoimg = new ImageIcon(Application.class.getResource("/Images/EZ.png"));
		ImageIcon scaledlogoimg = resizeImage(logo1, logoimg);
		logo1.setIcon(scaledlogoimg);
		Select_language.add(logo1);
		
		JLabel Header = new JLabel();
		Header.setIcon(new ImageIcon(Application.class.getResource("/Images/Gradient.png")));
		Header.setBounds(0, 1, 944, 170);
		Select_language.add(Header);
		
		JLabel selectlang = new JLabel("Please select the languages you want to install:");
		selectlang.setFont(new Font("Arial", Font.BOLD, 20));
		selectlang.setBounds(10, 252, 457, 47);
		Select_language.add(selectlang);
		
		JTextPane txtpnEzybitIsA = new JTextPane();
		txtpnEzybitIsA.setText("Ezybit is a one hand tool which provides and support all types of programming Application. Here are some of the programming languages which you can use for your personal projects. ");
		txtpnEzybitIsA.setFont(new Font("Arial", Font.PLAIN, 14));
		txtpnEzybitIsA.setEditable(false);
		txtpnEzybitIsA.setBackground(new Color(255, 255, 255, 0));
		txtpnEzybitIsA.setBounds(21, 310, 477, 78);
		Select_language.add(txtpnEzybitIsA);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(688, 226, 180, 234);
		Select_language.add(panel_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("C/C++");
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setBounds(6, 43, 97, 23);
		panel_1.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Python");
		chckbxNewCheckBox_1.setBackground(Color.WHITE);
		chckbxNewCheckBox_1.setBounds(6, 69, 97, 23);
		panel_1.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Java");
		chckbxNewCheckBox_2.setBackground(Color.WHITE);
		chckbxNewCheckBox_2.setBounds(6, 95, 97, 23);
		panel_1.add(chckbxNewCheckBox_2);
		
		JLabel selectLang = new JLabel("Select the Languges:");
		selectLang.setFont(new Font("Arial Black", Font.BOLD, 12));
		selectLang.setBounds(10, 0, 196, 36);
		panel_1.add(selectLang);
		
		JPanel Loading = new JPanel();
		tabbedPane.addTab("New tab", null, Loading, null);
		Loading.setLayout(null);
		
		JLabel installing_label = new JLabel("Installing...");
		installing_label.setFont(new Font("Arial", Font.BOLD, 18));
		installing_label.setBounds(10, 11, 239, 39);
		Loading.add(installing_label);
		
		JLabel lblNewLabel_1 = new JLabel("Setup is installing in your device");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 46, 248, 29);
		Loading.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Status: Downloading files...");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 114, 248, 23);
		Loading.add(lblNewLabel_2);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(10, 148, 920, 39);
		Loading.add(progressBar);
		progressBar.setStringPainted(true);
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(225, 225, 225));
		panel_2.setBounds(10, 198, 920, 250);
		Loading.add(panel_2);
		
		JPanel Completed = new JPanel();
		tabbedPane.addTab("New tab", null, Completed, null);
		Completed.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(20, 59, 182, 127);
		ImageIcon logoimglast = new ImageIcon(Application.class.getResource("/Images/EZ.png"));
		ImageIcon scaledlogoimglast = resizeImage(lblNewLabel_3, logoimglast);
		lblNewLabel_3.setIcon(scaledlogoimglast);
		Completed.add(lblNewLabel_3);
		
		JLabel Grad = new JLabel("");
		Grad.setIcon(new ImageIcon(Application.class.getResource("/Images/grad2.png")));
		Grad.setBounds(0, 0, 215, 482);
		Completed.add(Grad);
		
		JLabel lblNewLabel_4 = new JLabel("Ezybit setup 1.0.0 complted");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4.setBounds(276, 114, 317, 32);
		Completed.add(lblNewLabel_4);
		
		JTextPane txtpnSetupHasFinished = new JTextPane();
		txtpnSetupHasFinished.setBackground(new Color(0,0,0,0));
		txtpnSetupHasFinished.setText("Setup has finished installing Ezybit version 1.0.0. Click on finish button to exit the setup.");
		txtpnSetupHasFinished.setFont(new Font("Arial", Font.PLAIN, 14));
		txtpnSetupHasFinished.setBounds(276, 157, 630, 80);
		Completed.add(txtpnSetupHasFinished);
		
		
		
		
		
		
		
		
		
	}
}
