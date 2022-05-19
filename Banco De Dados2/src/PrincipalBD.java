import java.sql.ResultSet;
import java.sql.SQLException;

public class PrincipalBD {

	public static void main(String[] args) throws SQLException {
		// Endereço para a conexão do BD
		String urlBD = "jdbc:mysql://localhost:3306/biblioteca?user=root&password=Verinha@29";

		// Driver utilizado para o acesso ao BD
		String driver = "com.mysql.cj.jdbc.Driver";

		// objeto tipo BancoDados criação da classe
		BancoDados bd = new BancoDados();

		// ResulSet "Tabela" com os valores retornados da Busca
		ResultSet resultado = null;

		// Conexão ao BD
		System.out.println(bd.conectar(urlBD, driver));

		resultado = bd.consultar("select * from categoria");
		// Verifica se o resultado retornado da pesquisa da pesquisa junto ao BD não é
		// vazio , senão for exibe no console
		if (resultado != null)
			while (resultado.next()) {
				System.out.println("id: " + resultado.getString("id") + " Tipo da Categoria: "
						+ resultado.getString("tipo_categoria"));
			}
		System.out.println("--------------------------------------");
		resultado = bd.consultar("select * from autor");
		if (resultado != null)
			while (resultado.next()) {
				System.out.println("id: " + resultado.getString("id") + " nome: " + resultado.getString("nome")
						+ " - nacionalidade: " + resultado.getString("nacionalidade"));
			}
		System.out.println("--------------------------------------");
		resultado = bd.consultar("select * from editora");
		if (resultado != null)
			while (resultado.next()) {
				System.out.println("id: " + resultado.getString("id") + " nome: " + resultado.getString("nome"));
			}

		System.out.println("--------------------------------------");
		resultado = bd.consultar("select * from livro");
		if (resultado != null)
			while (resultado.next()) {
				System.out.println("id: " + resultado.getString("isbn") + " nome: " + resultado.getString("titulo")
						+ " ano: " + resultado.getString("ano") + " fk_editora: " + resultado.getString("fk_editora")
						+ " fk_categoria: " + resultado.getString("fk_categoria"));
			}
		System.out.println("--------------------------------------");
		resultado = bd.consultar("select * from livroautor");
		if (resultado != null)
			while (resultado.next()) {
				System.out.println("id: " + resultado.getString("id") + " fk_autor:" + resultado.getString("fk_autor")
						+ " fk_livro: " + resultado.getString("fk_livro"));
			}
		System.out.println("--------------------------------------");
		System.out.println("--------------------------------------");
		System.out.println("COLOCANDO VALORES NAS TABELAS:");

		// inserindo a categoria
		// bd.inserirAlterarExcluir("INSERT INTO categoria(tipo_categoria) value
		// ('Terror')");

		// inserindo um novo autor
		// bd.inserirAlterarExcluir("INSERT INTO autor (nome, nacionalidade) value
		// ('Machado de Assis','Dom Casmurro')");

		// deletando
		System.out.println(bd.inserirAlterarExcluir("DELETE FROM autor WHERE id =8"));

		// inserindo uma nova editora
		// bd.inserirAlterarExcluir("INSERT INTO editora (nome) value ('FTD')");

		// inserindo um novo livro
		// bd.inserirAlterarExcluir("INSERT INTO livro
		// (isbn,titulo,ano,fk_editora,fk_categoria) values
		// ('977682402029','Sapiens','1973','4','2'");

		
	}

}
