package LP2_TP3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormLivro extends JFrame {

	static List<LivroDeBiblioteca> livros = new ArrayList<LivroDeBiblioteca>();

	public FormLivro() {
		super();
		this.configFrame();

		livros.add(new LivroDeBiblioteca("Introdução à POO usando Java2", "Prof. Rafael Santos", "Campus/SBC",
				(short) 2003, "g11p17", "Disponível"));
	}

	public void configFrame() {
		this.setSize(530, 300);
		this.setTitle("Semana 4 - Exercício 2");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(Color.green);
		this.add(panel);
		placeComponents(panel);
		this.setVisible(true);
	}

	private static void placeComponents(JPanel panel) {
		panel.setLayout(null);

		JLabel tituloLabel = new JLabel("Título:");

		tituloLabel.setBounds(10, 20, 80, 25);
		panel.add(tituloLabel);

		JTextField tituloText = new JTextField(20);
		tituloText.setBounds(150, 20, 355, 25);
		panel.add(tituloText);

		JLabel autorLabel = new JLabel("Autor:");

		autorLabel.setBounds(10, 50, 80, 25);
		panel.add(autorLabel);

		JTextField autorText = new JTextField(20);
		autorText.setBounds(150, 50, 355, 25);
		panel.add(autorText);

		JLabel editoraLabel = new JLabel("Editora:");

		editoraLabel.setBounds(10, 80, 80, 25);
		panel.add(editoraLabel);

		JTextField editoraText = new JTextField(20);
		editoraText.setBounds(150, 80, 355, 25);
		panel.add(editoraText);

		JLabel edicaoLabel = new JLabel("Ano edição:");

		edicaoLabel.setBounds(10, 110, 80, 25);
		panel.add(edicaoLabel);

		JTextField edicaoText = new JTextField(20);
		edicaoText.setBounds(150, 110, 355, 25);
		panel.add(edicaoText);

		JLabel localLabel = new JLabel("Localização:");

		localLabel.setBounds(10, 140, 80, 25);
		panel.add(localLabel);

		JTextField localText = new JTextField(20);
		localText.setBounds(150, 140, 355, 25);
		panel.add(localText);

		JLabel statusLabel = new JLabel("Status:");

		statusLabel.setBounds(10, 170, 80, 25);
		panel.add(statusLabel);

		JTextField statusText = new JTextField(20);
		statusText.setBounds(150, 170, 355, 25);
		panel.add(statusText);

		JButton okButton = new JButton("Ok");
		okButton.setBounds(10, 220, 95, 25);
		panel.add(okButton);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tituloText.getText().isBlank() || autorText.getText().isBlank() || editoraText.getText().isBlank()
						|| edicaoText.getText().isBlank() || localText.getText().isBlank()
						|| statusText.getText().isBlank()) {
					JOptionPane.showMessageDialog(okButton, "Preencha todos os campos.");
				} else {
					String titulo = tituloText.getText();
					String autor = autorText.getText();
					String editora = editoraText.getText();
					Short edicao = Short.valueOf(edicaoText.getText());
					String local = localText.getText();
					String status = statusText.getText();

					livros.add(new LivroDeBiblioteca(titulo, autor, editora, edicao, local, status));
				}

			}
		});

		JButton emprestarButton = new JButton("Emprestar");
		emprestarButton.setBounds(110, 220, 95, 25);
		panel.add(emprestarButton);
		emprestarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// verifica se o livro existe
				if (tituloText.getText().isBlank() || autorText.getText().isBlank() || editoraText.getText().isBlank()
						|| edicaoText.getText().isBlank() || localText.getText().isBlank()
						|| statusText.getText().isBlank()) {
					JOptionPane.showMessageDialog(emprestarButton, "Preencha todos os campos.");
				} else {
					boolean existe = pesquisar(tituloText.getText(), autorText.getText(), editoraText.getText(),
							Short.valueOf(edicaoText.getText()), localText.getText(), statusText.getText(), true,
							false);
					System.out.println(existe);
					if (existe == false) {
						JOptionPane.showMessageDialog(emprestarButton, "Esse livro não está disponível no momento.");
					}
				}
			}
		});

		JButton devolverButton = new JButton("Devolver");
		devolverButton.setBounds(210, 220, 95, 25);
		panel.add(devolverButton);
		devolverButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// verifica se o livro existe
				if (tituloText.getText().isBlank() || autorText.getText().isBlank() || editoraText.getText().isBlank()
						|| edicaoText.getText().isBlank() || localText.getText().isBlank()
						|| statusText.getText().isBlank()) {
					JOptionPane.showMessageDialog(devolverButton, "Preencha todos os campos.");
				} else {
					boolean existe = pesquisar(tituloText.getText(), autorText.getText(), editoraText.getText(),
							Short.valueOf(edicaoText.getText()), localText.getText(), statusText.getText(), false,
							true);
					if (existe == false) {
						JOptionPane.showMessageDialog(emprestarButton, "Esse livro não está disponível no momento.");
					}
				}
				
			}
		});

		JButton mostrarButton = new JButton("Mostrar");
		mostrarButton.setBounds(310, 220, 95, 25);
		panel.add(mostrarButton);
		mostrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// mostra sempre o último livro inserido

				int ultimoLivro = livros.size() - 1;

				String titulo = livros.get(ultimoLivro).getTitulo();
				tituloText.setText(titulo);

				String autor = livros.get(ultimoLivro).getAutor();
				autorText.setText(autor);

				String editora = livros.get(ultimoLivro).getEditora();
				editoraText.setText(editora);

				short edicao = livros.get(ultimoLivro).getAnoEdicao();
				edicaoText.setText(Short.toString(edicao));

				String local = livros.get(ultimoLivro).getLocalizacao();
				localText.setText(local);

				String status = livros.get(ultimoLivro).getStatus();
				statusText.setText(status);

			}
		});

		JButton sairButton = new JButton("Sair");
		sairButton.setBounds(410, 220, 95, 25);
		panel.add(sairButton);
		sairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	public static boolean pesquisar(String titulo, String autor, String editora, Short anoEdicao, String localizacao,
			String status, boolean empresta, boolean devolve) {
		int i;
		int qtd = livros.size();
		for (i = 0; i < qtd; i++) {
			if (titulo.equals(livros.get(i).getTitulo())) {
				if (autor.equals(livros.get(i).getAutor())) {
					if (editora.equals(livros.get(i).getEditora())) {
						if (anoEdicao.equals(livros.get(i).getAnoEdicao())) {
							if (localizacao.equals(livros.get(i).getLocalizacao())) {
								if (status.equals(livros.get(i).getStatus())) {
									if (empresta == true) {
										emprestaLivro(i);
									} else if (devolve == true) {
										devolveLivro(i);
									}
									return true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	public static void emprestaLivro(int i) {
		if (livros.get(i).getStatus() == "Emprestado") {
			JOptionPane.showMessageDialog(null, "Esse livro já foi emprestado.");
		} else {
			livros.get(i).Empresta();
			JOptionPane.showMessageDialog(null, "Esse livro foi emprestado com sucesso.");
		}
	}

	public static void devolveLivro(int i) {
		if (livros.get(i).getStatus() == "Disponível") {
			JOptionPane.showMessageDialog(null, "Esse livro já foi devolvido.");
		} else {
			livros.get(i).Devolve();
			JOptionPane.showMessageDialog(null, "Esse livro foi devolvido com sucesso.");
		}
	}

	public static void main(String[] args) {
		FormLivro f = new FormLivro();

	}
}
