package dao;

import dao.impl.ArtistaDaoimpl;
import dao.impl.FilmeDaoimpl;
import dao.impl.ParticipacaoDaoimpl;

public class DaoFactory {

		public static ArtistaDao criarArtistaDao() {
			return new ArtistaDaoimpl();
		}
		
		public static FilmeDao criarFilmeDao() {
			return new FilmeDaoimpl();
		}
		
		public static ParticipacaoDao criarParticipacaoDao() {
			return new ParticipacaoDaoimpl();
		}
}
