package dao;

import java.util.List;

import com.iftm.dominio.Artista;

/*
 *	Caso precise mudar o banco, muda somente a interface(Chamado de documento). 
 */

public interface ArtistaDao {

	public void inserirAtualizar(Artista x);

	public void excluir(Artista x);

	public Artista buscar(int cod);

	public List<Artista> buscarTodos();
}
