package br.ce.wcaquino.servicos;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;

public class LocacaoServiceTest2 {

	@Rule
	public ErrorCollector error = new ErrorCollector();

	@Test
	public void testeLocacao() throws Exception {

		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("usuario 1");
		Filme filme = new Filme("filme 1", 2, 5.0);

		Locacao locacao = service.alugarFilme(usuario, filme);

	}

	@Test
	public void testLocacao_filmeSemEstoque() throws Exception {
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("usuario 1");
		Filme filme = new Filme("filme 1", 0, 5.0);

		service.alugarFilme(usuario, filme);
	}

}
