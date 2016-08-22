package servico;

import java.util.List;

import com.iftm.dominio.Participacao;

import dao.DaoFactory;
import dao.ParticipacaoDao;
import dao.impl.EM;

public class ParticipacaoServico {

	private ParticipacaoDao dao;

	public ParticipacaoServico() {
		dao = DaoFactory.criarParticipacaoDao();
	}

	public void inserirAtualizar(Participacao x) {
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}

	public void excluir(Participacao x) {
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}

	public Participacao buscar(int cod) {
		return dao.buscar(cod);
	}

	public List<Participacao> buscarTodos() {
		return dao.buscarTodos();
	}

}
