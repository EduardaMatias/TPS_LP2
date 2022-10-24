package LP2_TP3;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

public class FormCalcular extends JFrame {

	public FormCalcular() {
		super();
		this.configFrame();
	}

	public void configFrame() {
		this.setSize(500, 300);
		this.setTitle("Semana 4 - Exercício 1");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(Color.green);
		this.add(panel);
		placeComponents(panel);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		FormCalcular f = new FormCalcular();
	}

	private static void placeComponents(JPanel panel) {
		panel.setLayout(null);

		JLabel ALabel = new JLabel("A:");

		ALabel.setBounds(10, 20, 80, 25);
		panel.add(ALabel);

		JTextField AText = new JTextField(20);
		AText.setBounds(150, 20, 320, 25);
		panel.add(AText);

		JLabel BLabel = new JLabel("B:");

		BLabel.setBounds(10, 50, 80, 25);
		panel.add(BLabel);

		JTextField BText = new JTextField(20);
		BText.setBounds(150, 50, 320, 25);
		panel.add(BText);

		JLabel somaLabel = new JLabel("Soma:");

		somaLabel.setBounds(10, 80, 80, 25);
		panel.add(somaLabel);

		JTextField somaText = new JTextField(20);
		somaText.setBounds(150, 80, 320, 25);
		panel.add(somaText);

		JLabel subtLabel = new JLabel("Subtração:");

		subtLabel.setBounds(10, 110, 80, 25);
		panel.add(subtLabel);

		JTextField subtText = new JTextField(20);
		subtText.setBounds(150, 110, 320, 25);
		panel.add(subtText);

		JLabel multLabel = new JLabel("Multiplicação:");

		multLabel.setBounds(10, 140, 80, 25);
		panel.add(multLabel);

		JTextField multText = new JTextField(20);
		multText.setBounds(150, 140, 320, 25);
		panel.add(multText);

		JLabel divLabel = new JLabel("Divisão:");

		divLabel.setBounds(10, 170, 80, 25);
		panel.add(divLabel);

		JTextField divText = new JTextField(20);
		divText.setBounds(150, 170, 320, 25);
		panel.add(divText);

		JButton limparButton = new JButton("Limpar");
		limparButton.setBounds(10, 220, 140, 25);
		panel.add(limparButton);
		limparButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AText.setText("");
				BText.setText("");
				somaText.setText("");
				subtText.setText("");
				multText.setText("");
				divText.setText("");
			}
		});

		JButton calcButton = new JButton("Calcular");
		calcButton.setBounds(170, 220, 140, 25);
		panel.add(calcButton);
		calcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					float val1 = Float.parseFloat(AText.getText());
					float val2 = Float.parseFloat(BText.getText());
					String soma = String.valueOf(val1 + val2);
					String sub = String.valueOf(val1 - val2);
					String mult = String.valueOf(val1 * val2);
					String div = String.valueOf(val1 / val2);
					somaText.setText(soma);
					subtText.setText(sub);
					multText.setText(mult);
					divText.setText(div);

				} catch (Exception e1) {
					if(AText.getText().isBlank() || BText.getText().isBlank()) {
						JOptionPane.showMessageDialog(calcButton, "Preencha todos os campos!");
					} else {
						JOptionPane.showMessageDialog(calcButton, "Insira somente números!");
					}
				}
			}
		});

		JButton sairButton = new JButton("Sair");
		sairButton.setBounds(330, 220, 140, 25);
		panel.add(sairButton);
		sairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

}
