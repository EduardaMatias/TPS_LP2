package LP2_TP2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;
import java.util.List;

public class FormFrame extends JFrame implements ActionListener {

	List<Alunos> alunos = new ArrayList<Alunos>();

	Button buttonOk;
	Button buttonLimpar;
	Button buttonMostrar;
	Button buttonSair;

	TextField nomeInput;
	TextField idadeInput;
	TextField enderecoInput;

	Label nomeLabel;
	Label idadeLabel;
	Label enderecoLabel;


	public FormFrame() {
		super();
		this.configFrame();
		this.configInputs();
		this.configButtons();
	}

	public void configFrame() {
		this.setVisible(true);
		this.setTitle("Formulário de cadastro");
		this.setSize(400, 180);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
	}

	public void configInputs() {
		nomeLabel = new Label("Nome      ");
		add(nomeLabel);

		nomeInput = new TextField(30);
		add(nomeInput);

		idadeLabel = new Label("Idade       ");
		add(idadeLabel);

		idadeInput = new TextField(30);
		add(idadeInput);

		enderecoLabel = new Label("Endereço");
		add(enderecoLabel);

		enderecoInput = new TextField(30);
		add(enderecoInput);
	}

	public void configButtons() {
		buttonOk = new Button("   Ok   ");
		add(buttonOk);
		buttonOk.addActionListener(this);

		buttonLimpar = new Button("   Limpar   ");
		add(buttonLimpar);
		buttonLimpar.addActionListener(this);

		buttonMostrar = new Button("   Mostrar   ");
		add(buttonMostrar);
		buttonMostrar.addActionListener(this);

		buttonSair = new Button("   Sair   ");
		add(buttonSair);
		buttonSair.addActionListener(this);

		/*
		 * this.addWindowListener(new WindowAdapter() {
		 * 
		 * @Override public void windowClosing(WindowEvent e) { System.exit(0); } });
		 */
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonOk) {
			String nome = nomeInput.getText();
			String endereco = enderecoInput.getText();
			String idade = idadeInput.getText();
			UUID uuid = UUID.randomUUID();

			if (nome.isBlank() || endereco.isBlank() || idade.isBlank()) {
				JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
			} else {
				try {
					int formatIdade = Integer.parseInt(idade);
					if (formatIdade < 0 || formatIdade > 100) {
						JOptionPane.showMessageDialog(this, "Insira uma idade válida!");
						idadeInput.setText("");
					} else {
						alunos.add(new Alunos(nome, endereco, formatIdade, uuid));
						JOptionPane.showMessageDialog(this, "Sucesso. Aluno cadastrado!");
						nomeInput.setText("");
						idadeInput.setText("");
						enderecoInput.setText("");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(this, "Insira uma idade válida!");
					idadeInput.setText("");
				}
			}
		}

		if (e.getSource() == buttonLimpar) {
			nomeInput.setText("");
			idadeInput.setText("");
			enderecoInput.setText("");
		}

		if (e.getSource() == buttonMostrar) {
			if (alunos.size() == 0) {
				JOptionPane.showMessageDialog(this, "Nenhum aluno cadastrado");
			} else {
				JOptionPane.showMessageDialog(this, alunos);
			}
		}

		if (e.getSource() == buttonSair) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		FormFrame f = new FormFrame();
	}
}
