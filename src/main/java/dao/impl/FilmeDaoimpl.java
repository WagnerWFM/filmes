package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.iftm.dominio.Filme;

import dao.FilmeDao;

public class FilmeDaoimpl implements FilmeDao {

	private EntityManager em;
	
	public FilmeDaoimpl() {
		this.em = EM.getLocalEm();	//entrega uma instancia do EM única por cada Thread.
	}
	
	@Override
	public void inserirAtualizar(Filme x) {
		if (x.getCodFilme() != null) {
			x = em.merge(x);	// verificar se os dados em cache são os mesmos do BD no atual momento da operação.
		}
		em.persist(x);
	}

	@Override
	public void excluir(Filme x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Filme buscar(int cod) {
		return em.find(Filme.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Filme> buscarTodos() {
		String jpql = "SELECT x from Filme x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

}
