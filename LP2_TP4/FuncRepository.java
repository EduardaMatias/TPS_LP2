import java.sql.*;
import java.util.ArrayList;

public class FuncRepository {
	public ArrayList<Funcionario> getFuncionarios(String nome) throws ClassNotFoundException, SQLException {
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

		String url = "jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=func;encrypt=true;trustServerCertificate=true;integratedSecurity=true";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(url);

		Statement st = con.createStatement();
		ResultSet result;

		if (nome == "") {
			result = st
					.executeQuery("SELECT * FROM tbfuncionario AS f JOIN tbcargo AS C ON f.CARGO_ID = c.COD_CARGO");
		} else {
			result = st.executeQuery("SELECT * FROM tbfuncionario AS f JOIN tbcargo AS C ON f.CARGO_ID = c.COD_CARGO WHERE f.NOME_FUNC LIKE '%" + nome + "%'");
		} while (result.next()) {
			funcionarios.add(initialFuncionario(result));
		}

		con.close();
		
		return funcionarios;
	}
	
	private Funcionario initialFuncionario(ResultSet result) throws SQLException {
		Funcionario func = new Funcionario(0, null, 0, null);
		Cargo cargo = new Cargo(0, null);
		
		cargo.setCod(Integer.parseInt(result.getString(1)));
		cargo.setCargo(result.getString(6));
		
		func.setCod(Integer.parseInt(result.getString(1)));
		func.setNome(result.getString(2));
		func.setSal(Double.parseDouble(result.getString(3)));
		func.setCargo(cargo.getCargo());
		
		return func;
	}
}
