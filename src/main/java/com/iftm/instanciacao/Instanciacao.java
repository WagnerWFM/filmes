package com.iftm.instanciacao;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iftm.dominio.Artista;
import com.iftm.dominio.Filme;
import com.iftm.dominio.Participacao;

import servico.ArtistaServico;
import servico.FilmeServico;
import servico.ParticipacaoServico;

@WebServlet("/Instanciacao")
public class Instanciacao extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Filme f1 = new Filme(null, "O aviador", 170, 2005 );
			Filme f2 = new Filme(null, "Titanic", 195, 	1997);
			
			Artista a1 = new Artista(null, "Leonaro Di Caprio", "EUA", new BigDecimal("10000000.00"), sdf.parse("11/11/1974"));
			Artista a2 = new Artista(null, "Cate Blanchett", "Austr�lia", new BigDecimal("5000000.00"), sdf.parse("14/05/1989"));
			Artista a3 = new Artista(null, "Kate Winslet", "UK", new BigDecimal("8000000.00"), sdf.parse("05/10/1975"));
			
			
			Participacao p1 = new Participacao(null, "Jack Dawson", new BigDecimal("2000000.00"), f2, a1);
			Participacao p2 = new Participacao(null, "Howard Hughes", new BigDecimal("1000000.00"), f1, a1);
			Participacao p3 = new Participacao(null, "Rose Bukater", new BigDecimal("1000000.00"), f2, a3);
			Participacao p4 = new Participacao(null, "Katharine Hepbum", new BigDecimal("500000.00"), f1, a2 );
			
			//aplica��o comunica com a camada de servi�o, que comunica com a dao.
			
			ArtistaServico as = new ArtistaServico();
			FilmeServico fs = new FilmeServico();
			ParticipacaoServico ps = new ParticipacaoServico();
			
			fs.inserirAtualizar(f1);
			fs.inserirAtualizar(f2);
			
			as.inserirAtualizar(a1);
			as.inserirAtualizar(a2);
			as.inserirAtualizar(a3);

			ps.inserirAtualizar(p1);
			ps.inserirAtualizar(p2);
			ps.inserirAtualizar(p3);
			ps.inserirAtualizar(p4);
			
			response.getWriter().append("Pronto! ");
		} catch (ParseException e) {
			response.getWriter().append("Erro ao instanciar data. Instancia n�o criada.");
		}
		
	}

}
