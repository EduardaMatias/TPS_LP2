import java.awt.*;
import java.util.*;
import java.util.List;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class FormPesquisa extends JFrame implements ActionListener {

	private JLabel lblNomeInput, lblNome, lblSalario, lblCargo;
	private JTextField txtNomeInput, txtNome, txtSalario, txtCargo;
	private JPanel pnlPesquisa, pnlPesquisaCampo, pnlCampos, pnlBotoes;
	private JButton btnPesquisar, btnAnterior, btnProximo;
	
	private ArrayList<Funcionario> funcionarios;
	private FuncRepository funcionarioRepository;
	
	private int i;

	public FormPesquisa() {
		super();

		configForm();
		instanciarCampos();
		disableInputs();
		registrarEventos();
		addItems();

		funcionarios = new ArrayList<Funcionario>();
		funcionarioRepository = new FuncRepository();
		i = 0;

	}

	private void configForm() {
		this.setSize(530, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("TRABALHO PRÁTICO 4");
		setLayout(new BorderLayout(10, 10));
	}

	private void instanciarCampos() {
		lblNomeInput = new JLabel("Nome:");
		txtNomeInput = new JTextField(20);

		lblNome = new JLabel("Nome:");
		txtNome = new JTextField(10);

		lblSalario = new JLabel("Salário:");
		txtSalario = new JTextField(10);

		lblCargo = new JLabel("Cargo:");
		txtCargo = new JTextField(10);

		btnPesquisar = new JButton("Pesquisar");
		btnAnterior = new JButton("Anterior");
		btnProximo = new JButton("Próximo");
	}

	private void disableInputs() {
		txtNome.setEditable(false);
		txtSalario.setEditable(false);
		txtCargo.setEditable(false);
	}

	private void registrarEventos() {
		btnPesquisar.addActionListener(this);
		btnAnterior.addActionListener(this);
		btnProximo.addActionListener(this);
	}

	private void addItems() {

		pnlPesquisaCampo = new JPanel();
		pnlPesquisaCampo.setLayout(new FlowLayout(FlowLayout.CENTER));

		pnlPesquisaCampo.add(lblNomeInput);
		pnlPesquisaCampo.add(txtNomeInput);

		pnlPesquisa = new JPanel();
		pnlPesquisa.setLayout(new GridLayout(2, 1));

		pnlPesquisa.add(pnlPesquisaCampo);
		pnlPesquisa.add(btnPesquisar);

		pnlCampos = new JPanel();
		pnlCampos.setLayout(new GridLayout(3, 2, 10, 10));

		pnlCampos.add(lblNome);
		pnlCampos.add(txtNome);

		pnlCampos.add(lblCargo);
		pnlCampos.add(txtCargo);

		pnlCampos.add(lblSalario);
		pnlCampos.add(txtSalario);

		pnlBotoes = new JPanel();
		pnlBotoes.setLayout(new GridLayout(1, 2, 0, 0));

		pnlBotoes.add(btnAnterior);
		pnlBotoes.add(btnProximo);

		add(pnlPesquisa, BorderLayout.NORTH);
		add(pnlCampos, BorderLayout.CENTER);
		add(pnlBotoes, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPesquisar) {
			try {
				pesquisar();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		if (e.getSource() == btnAnterior) {
			anterior();
		}

		if (e.getSource() == btnProximo) {
			proximo();
		}

	}

	private void pesquisar() throws ClassNotFoundException, SQLException {
		i = 0;
		funcionarios = funcionarioRepository.getFuncionarios(txtNomeInput.getText());

		if (funcionarios.size() <= 0) {
			JOptionPane.showMessageDialog(null, "Não foram encontrados funcionarios com esse nome");
			return;
		}

		txtNomeInput.setText("");
		setFuncionarioCampos();
	}

	private void anterior() {
		if (i - 1 < 0) {
			JOptionPane.showMessageDialog(null, "Não existem mais registros com esse nome");
			return;
		}

		i--;
		setFuncionarioCampos();
	}

	private void proximo() {
		if (i + 1 >= funcionarios.size()) {
			JOptionPane.showMessageDialog(null, "Não existem mais registros com esse nome");
			return;
		}

		i++;
		setFuncionarioCampos();
	}

	private void setFuncionarioCampos() {
		Funcionario funcionario = funcionarios.get(i);

		txtNome.setText(funcionario.getNome());
		txtSalario.setText(funcionario.getSal() + "");
		txtCargo.setText(funcionario.getCargo().toString());

	}

	public static void main(String[] args) {
		FormPesquisa f = new FormPesquisa();
		f.setVisible(true);
	}
}
