package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.iftm.dominio.Participacao;

import dao.ParticipacaoDao;

public class ParticipacaoDaoimpl implements ParticipacaoDao {

	private EntityManager em;
	
	public ParticipacaoDaoimpl() {
		this.em = EM.getLocalEm();	//entrega uma instancia do EM única por cada Thread.
	}
	
	@Override
	public void inserirAtualizar(Participacao x) {
		if (x.getCodParticipacao() != null) {
			x = em.merge(x);	// verificar se os dados em cache são os mesmos do BD no atual momento da operação.
		}
		em.persist(x);
	}

	@Override
	public void excluir(Participacao x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Participacao buscar(int cod) {
		return em.find(Participacao.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Participacao> buscarTodos() {
		String jpql = "SELECT x from Participacao x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

}
