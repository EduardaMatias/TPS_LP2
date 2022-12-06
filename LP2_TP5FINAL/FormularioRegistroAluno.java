package LP2_TPFINAL;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

public class FormularioRegistroAluno extends JFrame implements ActionListener {

	private JLabel lblNome, lblIdade, lblPeso, lblAltura, lblObjetivo;
	private JTextField txtNome, txtIdade, txtPeso, txtAltura, txtObjetivo;
	private JPanel panel;
	private JButton btnIncluir, btnLimpar, btnApresentar, btnSair;

	
	private ArrayList<Aluno> alunos;
	private AlunoRepository alunoRepository;

	private int i;
	
	private boolean ok = false;

	public FormularioRegistroAluno() throws ClassNotFoundException, SQLException {
		super();

		this.configFormulario();

		alunos = new ArrayList<Aluno>();
		alunoRepository = new AlunoRepository();

		i = 0;

	}

	private void configFormulario() {
		this.setSize(400, 300);
		this.setTitle("CADASTRO ALUNO");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		this.add(panel);
		initCampos(panel);
		addEvents();
		this.setVisible(true);
	}

	private void initCampos(JPanel panel) {
		panel.setLayout(null);

		lblNome = new JLabel("Nome:");
		txtNome = new JTextField(20);

		lblNome.setBounds(10, 20, 80, 25);
		panel.add(lblNome);

		txtNome.setBounds(80, 20, 280, 25);
		panel.add(txtNome);

		lblIdade = new JLabel("Idade:");
		txtIdade = new JTextField(20);

		lblIdade.setBounds(10, 50, 80, 25);
		panel.add(lblIdade);

		txtIdade.setBounds(80, 50, 280, 25);
		panel.add(txtIdade);

		lblPeso = new JLabel("Peso:");
		txtPeso = new JTextField(10);

		lblPeso.setBounds(10, 80, 80, 25);
		panel.add(lblPeso);

		txtPeso.setBounds(80, 80, 280, 25);
		panel.add(txtPeso);

		lblAltura = new JLabel("Altura:");
		txtAltura = new JTextField(10);

		lblAltura.setBounds(10, 110, 80, 25);
		panel.add(lblAltura);

		txtAltura.setBounds(80, 110, 280, 25);
		panel.add(txtAltura);

		lblObjetivo = new JLabel("Objetivo:");
		txtObjetivo = new JTextField(10);

		lblObjetivo.setBounds(10, 140, 80, 25);
		panel.add(lblObjetivo);

		txtObjetivo.setBounds(80, 140, 280, 25);
		panel.add(txtObjetivo);

		btnLimpar = new JButton("Limpar");

		btnLimpar.setBounds(10, 180, 95, 25);
		panel.add(btnLimpar);

		btnApresentar = new JButton("Apresentar dados");

		btnApresentar.setBounds(10, 220, 350, 25);
		panel.add(btnApresentar);

		btnIncluir = new JButton("Incluir");

		btnIncluir.setBounds(140, 180, 95, 25);
		panel.add(btnIncluir);

		btnSair = new JButton("Sair");

		btnSair.setBounds(265, 180, 95, 25);
		panel.add(btnSair);
	}

	private void addEvents() {
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});

		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validation();		
			}
		});
		
		btnApresentar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					alunoRepository.apresentarDados();
				} catch (SQLException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	private void validation() {
		if (txtNome.getText().isBlank() || txtObjetivo.getText().isBlank()) {
			error();
		} else {
			try {
				Float peso = Float.parseFloat(txtPeso.getText());
				Float altura = Float.parseFloat(txtAltura.getText());
				Integer idade = Integer.parseInt(txtIdade.getText()); 
				ok = true;
				alunoRepository.inserirAluno(txtNome.getText(), idade, peso, altura, txtObjetivo.getText());
				success();
			} catch (Exception e) {
				error();
			}
		}
	}

	private void error() {
		JOptionPane.showMessageDialog(this, "Preencha os campos corretamente.");
	}
	
	private void success() {
		JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso.");
		clear();
	}
	
	private void clear() {
		txtNome.setText("");
		txtIdade.setText("");
		txtPeso.setText("");
		txtAltura.setText("");
		txtObjetivo.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		FormularioRegistroAluno formulario = new FormularioRegistroAluno();
	}
}
