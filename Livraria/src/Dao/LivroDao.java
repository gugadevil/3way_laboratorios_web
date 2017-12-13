package Dao;

import java.sql.*;
import java.util.concurrent.locks.Lock;

import Data.FabricaConexao;

public class LivroDao<LOG> {

	Logger LOG =  Logger.getGlobal();

private static final String OBTER_POR_ID_SQL = "SELECT AUTOR, TITULO, COD_LIVRO, IMAGEM,"
	+ "PRECO, DESCRICAO FROM ESTOQUE WHERE COD_LIVRO =?";

private static final String CONSULTAR_SQL = "SELECT COD_LIVRO, TITULO, AUTOR, PRECO"
	+ "IMAGEM, DESCRICAO FROM ESTOQUE WHERE TITULO LIKE ?";

	public List<livro> consultar(String titulo){
		Livro livro = null;
		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(OBTER_POR_ID_SQL);) {
			consulta.setInt(1, codigo);
		ResultSet resultado = consulta.executeQuery();
		
		if(resultado.next()) {
			livro = new Livro();
			livro.setAutor(resultado.getString("AUTOR"));
			livro.setCodigo(resultado.getInt("COD_LIVRO"));
			livro.setImagem(resultado.getString("IMAGEM"));
			livro.setPreco(resultado.getDouble("PRECO"));
			livro.setTitulo(resultado.getString("TITULO"));
			livro.setDescricao(resultado.getString("DESCRICAO"));
		}
		
			resultado.close();
			
		} catch (SQLException e) {
			LOG.servere(e.toString());
	}
		return livro;
}
}
