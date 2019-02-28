package os2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textpumpnums;
	private JTextField textclientnums;
	private JTextField textclientnames;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterNumberOf = new JLabel("Enter number of pumps");
		lblEnterNumberOf.setBounds(12, 13, 163, 16);
		contentPane.add(lblEnterNumberOf);
		
		textpumpnums = new JTextField();
		textpumpnums.setBounds(12, 31, 408, 22);
		contentPane.add(textpumpnums);
		textpumpnums.setColumns(10);
		
		JLabel lblEnterNumberOf_1 = new JLabel("Enter number of clients");
		lblEnterNumberOf_1.setBounds(12, 63, 138, 16);
		contentPane.add(lblEnterNumberOf_1);
		
		textclientnums = new JTextField();
		textclientnums.setBounds(12, 83, 408, 22);
		contentPane.add(textclientnums);
		textclientnums.setColumns(10);
		
		JLabel lblEnterNameOf = new JLabel("Enter name of clients");
		lblEnterNameOf.setBounds(12, 112, 138, 16);
		contentPane.add(lblEnterNameOf);
		
		textclientnames = new JTextField();
		textclientnames.setBounds(12, 130, 408, 22);
		contentPane.add(textclientnames);
		textclientnames.setColumns(10);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			     int pumpnumber =  Integer.parseInt(textpumpnums.getText());
			     int clientnumber = Integer.parseInt(textclientnums.getText()); 
			     String[] clientnames = textclientnames.getText().split(" ");
			     
			     //For dynamic gui
			     
			        DGUI guipumps=new DGUI(pumpnumber);
	                guipumps.setVisible(true);
			     
			     ///
			    
			     Semaphore sem = new Semaphore(pumpnumber);
			     Client[] threads = new Client[clientnumber];
			     pump[] pumps = new pump[pumpnumber];
	             Font Size=new Font("Verdana",Font.BOLD,20);
			     for(int i=0;i<pumpnumber;i++) {
			    	 pumps[i] = new pump("pump " + Integer.toString(i),0);
	                 guipumps.myPump.elementAt(i).setFont(Size);
			     }
			     int time;
					Random r = new Random();
			    	
			    	for(int i=0;i<clientnumber;i++){
			    		//System.out.println(clientnums);
			    		time = r.nextInt(10);		
			    	   	try {
			    			//TimeUnit.SECONDS.sleep(time);
			    	   		Thread.sleep(time*1000);
			    		} catch (InterruptedException e) {
			    			// TODO Auto-generated catch block
			    			e.printStackTrace();
			    		}
			    		threads[i] = new Client(sem,clientnames[i],guipumps,pumps);
			    		threads[i].start();
			    	}
			    	/*for(int i=0;i<clientnumber;i++){
			    		try {
							threads[i].join();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    	}*/



			}
		});
		btnStart.setBounds(161, 165, 97, 25);
		contentPane.add(btnStart);
	}
}
