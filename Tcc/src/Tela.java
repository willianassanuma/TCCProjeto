import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Tela extends JFrame {
	private static int cam1 = 1;
	private static int cam2 = 2;
	private static int start = 0;
	private JPanel contentPane;
	private static VideoCap videoCapD = new VideoCap(1);
    private static VideoCap videoCapL = new VideoCap(2);
    static Integer hueStart = 100, saturationStart = 100, valueStart = 100, hueStop = 170, saturationStop = 180, valueStop = 250;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
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
	JLabel lblNewLabel = new JLabel("Cam L");
	JLabel lblNewLabel_1 = new JLabel("Cam D");
	JLabel lblMorph1 = new JLabel("Morph1");
	JLabel lblMorph2 = new JLabel("Morph2");
	JComboBox comboBoxEsquerda = new JComboBox();
	JComboBox comboBoxDireita = new JComboBox();
	private JTextField tfHueStart;
	private JTextField tfHuestop;
	private JTextField tfSaturationStart;
	private JTextField tfSaturationStop;
	private JTextField tfValueStart;
	private JTextField tfValueStop;


	public Tela() {
		setTitle("TCC");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblCameraEsquerda = new JLabel("Camera Esquerda:");
		lblCameraEsquerda.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCameraEsquerda.setBounds(10, 11, 93, 14);
		contentPane.add(lblCameraEsquerda);
		
		JLabel lblCameraDireita = new JLabel("Camera Direita:");
		lblCameraDireita.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCameraDireita.setBounds(180, 11, 93, 14);
		contentPane.add(lblCameraDireita);
		comboBoxEsquerda.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				Tela.cam1 = arg0.getStateChange(); 
			}
		});
		
		
		comboBoxEsquerda.setBounds(113, 8, 57, 20);
		contentPane.add(comboBoxEsquerda);
		comboBoxEsquerda.addItem(0);
		comboBoxEsquerda.addItem(1);
		comboBoxEsquerda.addItem(2);
		comboBoxEsquerda.setSelectedItem(1);
		comboBoxDireita.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Tela.cam1 = e.getStateChange(); 
			}
		});
		
		comboBoxDireita.setBounds(283, 8, 57, 20);
		contentPane.add(comboBoxDireita);
		comboBoxDireita.addItem(0);
		comboBoxDireita.addItem(1);
		comboBoxDireita.addItem(2);
		comboBoxDireita.setSelectedItem(2);
		
		lblNewLabel.setBounds(10, 50, 320, 240);
		contentPane.add(lblNewLabel);
		
	    
		lblNewLabel_1.setBounds(340, 50, 320, 240);
		contentPane.add(lblNewLabel_1);
		
		JToggleButton tglbtnStart = new JToggleButton("Start");
		tglbtnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tglbtnStart.isSelected()){
					start = 1;
				}else{
					start = 0;

				}
			}
		});
		tglbtnStart.setBounds(356, 7, 121, 23);
		contentPane.add(tglbtnStart);
		
		
		lblMorph1.setBounds(10, 301, 320, 240);
		contentPane.add(lblMorph1);
		
		lblMorph2.setBounds(340, 301, 320, 240);
		contentPane.add(lblMorph2);
		
		JLabel lblHuestart = new JLabel("HueStart");
		lblHuestart.setBounds(10, 552, 68, 14);
		contentPane.add(lblHuestart);
		
		JLabel lblHuestop = new JLabel("HueStop");
		lblHuestop.setBounds(10, 577, 68, 14);
		contentPane.add(lblHuestop);
		
		JLabel lblNewLabel_2 = new JLabel("SaturationStart");
		lblNewLabel_2.setBounds(180, 552, 93, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("SaturationStop");
		lblNewLabel_3.setBounds(180, 577, 93, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblValuestart = new JLabel("ValueStart");
		lblValuestart.setBounds(379, 552, 62, 14);
		contentPane.add(lblValuestart);
		
		JLabel lblValuestop = new JLabel("ValueStop");
		lblValuestop.setBounds(379, 577, 62, 14);
		contentPane.add(lblValuestop);
		
		tfHueStart = new JTextField();
		tfHueStart.setBounds(84, 549, 86, 20);
		contentPane.add(tfHueStart);
		tfHueStart.setColumns(10);
		tfHueStart.setText(hueStart.toString());
		
		tfHuestop = new JTextField();
		tfHuestop.setBounds(84, 574, 86, 20);
		contentPane.add(tfHuestop);
		tfHuestop.setColumns(10);
		tfHuestop.setText(hueStop.toString());
		
		tfSaturationStart = new JTextField();
		tfSaturationStart.setBounds(283, 549, 86, 20);
		contentPane.add(tfSaturationStart);
		tfSaturationStart.setColumns(10);
		tfSaturationStart.setText(saturationStart.toString());
		
		tfSaturationStop = new JTextField();
		tfSaturationStop.setBounds(283, 574, 86, 20);
		contentPane.add(tfSaturationStop);
		tfSaturationStop.setColumns(10);
		tfSaturationStop.setText(saturationStop.toString());
		
		tfValueStart = new JTextField();
		tfValueStart.setBounds(451, 549, 86, 20);
		contentPane.add(tfValueStart);
		tfValueStart.setColumns(10);
		tfValueStart.setText(valueStart.toString());
		
		tfValueStop = new JTextField();
		tfValueStop.setBounds(451, 574, 86, 20);
		contentPane.add(tfValueStop);
		tfValueStop.setColumns(10);
		tfValueStop.setText(valueStop.toString());
		
		JButton btnSetValor = new JButton("Set Valores");
		btnSetValor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hueStart = Integer.parseInt(tfHueStart.getText());
				hueStop = Integer.parseInt(tfHuestop.getText());
				saturationStart = Integer.parseInt(tfSaturationStart.getText());
				saturationStop = Integer.parseInt(tfSaturationStop.getText());
				valueStart = Integer.parseInt(tfValueStart.getText());
				valueStop = Integer.parseInt(tfValueStop.getText());
			}
		});
		btnSetValor.setBounds(547, 549, 113, 43);
		contentPane.add(btnSetValor);
		
		new MyThread().start();
		
	}
    	
	
    
    public void paint(){
    		lblNewLabel.setText("");
    		lblNewLabel_1.setText("");
    		lblMorph1.setText("");
    		lblMorph2.setText("");
    		lblNewLabel.setIcon(new javax.swing.ImageIcon(videoCapL.getOneFrame()));
    		lblNewLabel_1.setIcon(new javax.swing.ImageIcon(videoCapD.getOneFrame()));
    		lblMorph1.setIcon(new javax.swing.ImageIcon(videoCapL.getMorph()));
    		lblMorph2.setIcon(new javax.swing.ImageIcon(videoCapD.getMorph()));
    }
 
    class MyThread extends Thread{
        @Override
        public void run() {
            for (;;){
            	if(start==1) paint();
                
                try { Thread.sleep(30);
                } catch (InterruptedException e) {    }
            }  
        } 
    }
}
