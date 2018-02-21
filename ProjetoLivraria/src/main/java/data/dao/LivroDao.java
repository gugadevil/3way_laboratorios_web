package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.dao.conection.FabricaConexao;
import data.model.Livro;

public class LivroDao implements Dao {

	public List<Livro> listeLivro() {
		List<Livro> Livros = new ArrayList<Livro>();
		Connection conection = FabricaConexao.getConnection();
		try {
			PreparedStatement prepareStatement = conection.prepareStatement("select * from estoque");
			ResultSet resultSet = prepareStatement.executeQuery();

			while (resultSet.next()) {
				// id SERIAL NOT NULL,
				// COD_LIVRO varchar(50),
				// TITULO VARCHAR(30) NOT NULL,
				// AUTOR VARCHAR(20) NOT NULL,
				// PRECO NUMERIC NOT NULL,
				// IMAGEM VARCHAR(80) NOT NULL,
				// DESCRICAO VARCHAR(80),
				Livro livro = new Livro();
				livro.setId(resultSet.getLong("id"));
				livro.setCodLivro(resultSet.getString("COD_LIVRO"));
				livro.setTitulo(resultSet.getString("TITULO"));
				livro.setAutor(resultSet.getString("AUTOR"));
				livro.setPreco(resultSet.getDouble("PRECO"));
				livro.setImagem(resultSet.getString("IMAGEM"));
				livro.setDescricao(resultSet.getString("DESCRICAO"));

				Livros.add(livro);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Livros;
	}

}
