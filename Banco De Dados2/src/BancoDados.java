import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoDados {

	Connection conexao;

	public String conectar(String URL, String Driver) {
		try {
			Class.forName(Driver);
			conexao = (Connection) DriverManager.getConnection(URL);
			return "Conectado";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return "Não foi possivel conectar";
		}
	}

	public ResultSet consultar(String query) {
		Statement st;
		ResultSet resultado = null;
		try {
			st = conexao.createStatement();
			resultado = st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	public int inserirAlterarExcluir(String query) {
		int linhas = 0;
		try {
			Statement st = conexao.createStatement();
			linhas = st.executeUpdate(query);
			System.out.println("Operação Efetudada com Sucesso");
			return linhas;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Operação Não Efetuada");
		}
		return linhas;

	}
	
	
}
