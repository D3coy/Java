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
    private static int    counter = 0; // счетчик
    private static JLabel label   = null;
    private static String TEMPL   = "Закрытие окна (попыток %d)";
    
    //конструктор
	public Primary() {
		
		// Обработчик при нажатии на кнопки в окошке интерфейса
		class ListenerAction implements ActionListener {
			public void actionPerformed(ActionEvent e) {
	            System.out.println("\n" + "Вы выбрали -> ["+ 
	                                e.getActionCommand() + "]" + "\n");
	        }
		}
		
//		class ListenerChange implements ChangeListener {
//	        public void stateChanged(ChangeEvent e) {
//	            // Источник события
//	            Object src = e.getSource();
//	            System.out.println("Cообщение о смене состояния объекта : " 
//	                                + src.getClass());
//	        }
//	    }
		
		// Создание окна с заголовком
		JFrame frame = new JFrame("Primary");
		
		// Creates a JLabel instance with the specified text, image, and horizontal alignment.
		label = new JLabel(String.format(TEMPL, counter));
		
		JButton button = new JButton("Старт игры!");
		JButton button2 = new JButton("Стоп игры!");
		
		// инициализация панели содержимого и размещение лейбла
        Container container = frame.getContentPane();
        container.setLayout(new FlowLayout( FlowLayout.LEFT, 10, 10));
		
		//Не закрывать окно через [x]
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		//подключение монитора окна
		frame.addWindowListener(new WindowListener() {
			public void windowActivated (WindowEvent event) {}
			public void windowClosed (WindowEvent event) {}
			public void windowDeactivated (WindowEvent event) {}
			public void windowDeiconified(WindowEvent event) {}
            public void windowIconified  (WindowEvent event) {}
            public void windowOpened     (WindowEvent event) {}
            
            //Обработчик закрытия окна, остальные просто проинициализированны
            public void windowClosing (WindowEvent event) {

            	//если на крестик нажато окно пропадает и прога завершается
        		event.getWindow().setVisible(false);
        		System.exit(0);
            }
		});
		
		// слушатель клавиатуры
		button.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent e) {  
	        	
	        	// отдельная обработка кнопок
	            if(e.getKeyCode() == KeyEvent.VK_ENTER){
	            	System.out.println("Нажата клавиша -> <ENTER>");
	            }
	            if(e.getKeyCode() == KeyEvent.VK_HOME){
	            	System.out.println("Нажата клавиша -> <Home>");
	            }
	            
	            // все нажатые
	            else
	            	System.out.println("Нажата клавиша -> " + e.getKeyChar());
	         }        
	     });
		
		// подключение монитора событий нажатия на кнопки интерфейса
		button.addActionListener(new ListenerAction());
		button2.addActionListener(new ListenerAction());
		
		// Расположение элементов
		container.add(button);
		container.add(button2);
		
        // установка размеров окна (ш, в)
        frame.setPreferredSize(new Dimension(300, 80));
        
        // подбор размеров - упаковка окна
        frame.pack();
        
        // видно ли окно?
        frame.setVisible(true);
	}
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new Primary();
	}

}
