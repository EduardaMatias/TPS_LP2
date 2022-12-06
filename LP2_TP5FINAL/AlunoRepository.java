package LP2_TPFINAL;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import javax.swing.JOptionPane;

import java.awt.Component;
import java.math.BigDecimal;
import java.sql.*;

@SuppressWarnings("unused")
public class AlunoRepository {

	private FormularioRegistroAluno formulario;

	public ArrayList<Aluno> inserirAluno(String nome, int idade, float peso, float altura, String objetivo)
			throws SQLException, ClassNotFoundException {
		String url;
		Connection con;
		Statement st;
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		url = "jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=academia;encrypt=true;trustServerCertificate=true;integratedSecurity=true";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con = DriverManager.getConnection(url);
		st = con.createStatement();
		int result = st.executeUpdate("INSERT INTO tb_aluno VALUES('" + nome + "', " + peso + ", " + altura + ", '"
				+ objetivo + "', " + idade + ")");
		con.close();
		return alunos;
	}

	public ArrayList<Aluno> apresentarDados() throws SQLException, ClassNotFoundException {
		String url;
		Connection con;
		Statement st;
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		url = "jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=academia;encrypt=true;trustServerCertificate=true;integratedSecurity=true";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con = DriverManager.getConnection(url);
		st = con.createStatement();
		String resultadoJson;
		ResultSet result = st.executeQuery(
				"SELECT nome, peso = FORMAT(peso,'####.##'), altura = FORMAT(altura,'####.##'), objetivo, idade FROM tb_aluno FOR JSON PATH");
		while (result.next()) {
			resultadoJson = result.getString(1);
			JOptionPane.showMessageDialog(formulario, resultadoJson);
		}
		con.close();
		return alunos;
	}
}
