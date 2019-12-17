package keyboard;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Primary
{	
	private static final long serialVersionUID = 1L;
    private static int    counter = 0; // �������
    private static JLabel label   = null;
    private static String TEMPL   = "�������� ���� (������� %d)";
    
    //�����������
	public Primary() {
		
		// ���������� ��� ������� �� ������ � ������ ����������
		class ListenerAction implements ActionListener {
			public void actionPerformed(ActionEvent e) {
	            System.out.println("\n" + "�� ������� -> ["+ 
	                                e.getActionCommand() + "]" + "\n");
	        }
		}
		
//		class ListenerChange implements ChangeListener {
//	        public void stateChanged(ChangeEvent e) {
//	            // �������� �������
//	            Object src = e.getSource();
//	            System.out.println("C�������� � ����� ��������� ������� : " 
//	                                + src.getClass());
//	        }
//	    }
		
		// �������� ���� � ����������
		JFrame frame = new JFrame("Primary");
		
		// Creates a JLabel instance with the specified text, image, and horizontal alignment.
		label = new JLabel(String.format(TEMPL, counter));
		
		JButton button = new JButton("����� ����!");
		JButton button2 = new JButton("���� ����!");
		
		// ������������� ������ ����������� � ���������� ������
        Container container = frame.getContentPane();
        container.setLayout(new FlowLayout( FlowLayout.LEFT, 10, 10));
		
		//�� ��������� ���� ����� [x]
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		//����������� �������� ����
		frame.addWindowListener(new WindowListener() {
			public void windowActivated (WindowEvent event) {}
			public void windowClosed (WindowEvent event) {}
			public void windowDeactivated (WindowEvent event) {}
			public void windowDeiconified(WindowEvent event) {}
            public void windowIconified  (WindowEvent event) {}
            public void windowOpened     (WindowEvent event) {}
            
            //���������� �������� ����, ��������� ������ ��������������������
            public void windowClosing (WindowEvent event) {

            	//���� �� ������� ������ ���� ��������� � ����� �����������
        		event.getWindow().setVisible(false);
        		System.exit(0);
            }
		});
		
		// ��������� ����������
		button.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent e) {  
	        	
	        	// ��������� ��������� ������
	            if(e.getKeyCode() == KeyEvent.VK_ENTER){
	            	System.out.println("������ ������� -> <ENTER>");
	            }
	            if(e.getKeyCode() == KeyEvent.VK_HOME){
	            	System.out.println("������ ������� -> <Home>");
	            }
	            
	            // ��� �������
	            else
	            	System.out.println("������ ������� -> " + e.getKeyChar());
	         }        
	     });
		
		// ����������� �������� ������� ������� �� ������ ����������
		button.addActionListener(new ListenerAction());
		button2.addActionListener(new ListenerAction());
		
		// ������������ ���������
		container.add(button);
		container.add(button2);
		
        // ��������� �������� ���� (�, �)
        frame.setPreferredSize(new Dimension(300, 80));
        
        // ������ �������� - �������� ����
        frame.pack();
        
        // ����� �� ����?
        frame.setVisible(true);
	}
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new Primary();
	}

}
