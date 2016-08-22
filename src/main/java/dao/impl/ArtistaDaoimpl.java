package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.iftm.dominio.Artista;

import dao.ArtistaDao;

public class ArtistaDaoimpl implements ArtistaDao {

	private EntityManager em;
	
	public ArtistaDaoimpl() {
		this.em = EM.getLocalEm();	//entrega uma instancia do EM única por cada Thread.
	}
	
	@Override
	public void inserirAtualizar(Artista x) {
		if (x.getCodArtista() != null) {
			x = em.merge(x);	// verificar se os dados em cache são os mesmos do BD no atual momento da operação.
		}
		em.persist(x);
	}

	@Override
	public void excluir(Artista x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Artista buscar(int cod) {
		return em.find(Artista.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Artista> buscarTodos() {
		String jpql = "SELECT x from Artista x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

}
