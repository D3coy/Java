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
import java.util.Random;
import java.util.Scanner;

public class Primary
{	
	private static final long serialVersionUID = 1L;
    private static int    counter = 0; // счетчик
    private static JLabel label   = null;
    private static String TEMPL   = "Закрытие окна (попыток %d)";
    
	// Создание окна с заголовком
	private JFrame frame = new JFrame("Blind print");
	
	static JButton button = new JButton("Старт игры!");
	static JButton button2 = new JButton("Стоп игры!");
	
	static String chars = "abcdefghijklmnopqrstuvwxyz";
	static String letters = "1234567890";
	
	//конструктор
	public Primary() {
		
		// Creates a JLabel instance with the specified text, image, and horizontal alignment.
		label = new JLabel(String.format(TEMPL, counter));
		
		// инициализация панели содержимого и размещение лейбла
        Container container = this.frame.getContentPane();
        container.setLayout(new FlowLayout( FlowLayout.LEFT, 10, 10));
		
		//Не закрывать окно через [x]
		this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		//подключение монитора окна
		this.frame.addWindowListener(new WindowListener() {
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
		
		//Обработчик при нажатии на кнопки в окошке интерфейса
		class ListenerAction_start implements ActionListener {
			public void actionPerformed(ActionEvent e) {
		        System.out.println("\n" + "Вы выбрали -> ["+ 
		                            e.getActionCommand() + "]" + "\n");
		        Start_main();
		    }
		}
		
		class ListenerAction_stop implements ActionListener {
			public void actionPerformed(ActionEvent e) {
		        System.out.println("\n" + "Вы выбрали -> ["+ 
		                            e.getActionCommand() + "]" + "\n");
		    }
		}
		
		// подключение монитора событий нажатия на кнопки интерфейса
		button.addActionListener(new ListenerAction_start());
		button2.addActionListener(new ListenerAction_stop());
		
//		System.out.println(button.getText());

		// Расположение элементов
		container.add(button);
		container.add(button2);
		
        // установка размеров окна (ш, в)
        this.frame.setPreferredSize(new Dimension(300, 80));
        
        // подбор размеров - упаковка окна
        this.frame.pack();
        
        // видно ли окно?
        this.frame.setVisible(true);
	}
	
	public void Start_main() {
		
		// условие буква -> клавиш
		//System.out.println(chars);
		//System.out.println(letters);
		
		// new array from chars and numbers
		char[] symbols = new char[chars.length() + letters.length()];

		// copy to new array [src, posStart_src, dest, destPos, src.length]
    	System.arraycopy(chars.toCharArray(), 0, symbols, 0, chars.length());
    	System.arraycopy(letters.toCharArray(), 0, symbols, chars.length(), letters.length());
		char symbol = symbols[getRandom(symbols)];
		
		System.out.println("\n" + symbol);
		 Scanner in = new Scanner(System.in);
		 boolean flag = true;
		 
		 while (flag) {
			 System.out.print("Input: ");
			 
			 // first from input
			 String num = in.next();
			 
			 // first element of string to char 
			 char num_char = num.charAt(0);
			 
			 if (num_char == symbol) {
				 System.out.println("Correct answer");
				
				 Start_main();
			 }
			 else
				 continue;
		 }

	}
	
	public static int getRandom(char[] array) {
		int[] numbers = new int[array.length];
		int rnd = new Random().nextInt(array.length);
		
		return rnd;
	}
	
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new Primary();
	}
}



// слушатель клавиатуры (если нажато старт игры)
//button.addKeyListener(new KeyAdapter() {
//     public void keyPressed(KeyEvent e) {
//    	 
//    	// отдельная обработка кнопок
//        if(e.getKeyCode() == KeyEvent.VK_ENTER){
//        	System.out.println("Нажата клавиша -> <ENTER>");
//        }
//        if(e.getKeyCode() == KeyEvent.VK_HOME){
//        	System.out.println("Нажата клавиша -> <Home>");
//        }
//        
//        // все нажатые
//        else
//        	System.out.println("Нажата клавиша -> " + e.getKeyChar());
//     }        
// });
