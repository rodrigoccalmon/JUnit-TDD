package br.ce.wcaquino.servicos;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exception.FilmeSemEstoqueException;
import br.ce.wcaquino.exception.LocadoraException;

public class LocacaoServiceTest2 {

	@Rule
	public ErrorCollector error = new ErrorCollector();

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testeLocacao() throws Exception {

		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("usuario 1");
		Filme filme = new Filme("filme 1", 2, 5.0);

		Locacao locacao = service.alugarFilme(usuario, filme);

	}

	@Test(expected = FilmeSemEstoqueException.class) // forma elegante
	// funciona bem quando apenas a exceção importa pra vc, nos casos que consegue
	// garantir o motivo pelo qual ela foi lançada

	public void testLocacao_filmeSemEstoque() throws Exception {
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("usuario 1");
		Filme filme = new Filme("filme 1", 0, 5.0);

		service.alugarFilme(usuario, filme);
	}

	@Test
	//forma robusca, professor recomenda essa, forma robusta
	public void testLocacaoUsuarioVazio() throws FilmeSemEstoqueException {
		LocacaoService service = new LocacaoService();
		Filme filme = new Filme("filme 1", 0, 5.0);

		try {
			service.alugarFilme(null, filme);
		} catch (LocadoraException e) {
			e.getMessage();
		}

	}

	@Test
	public void testLocacaoFilmeVazio() throws FilmeSemEstoqueException, LocadoraException {
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("usuario 1");

		exception.expect(LocadoraException.class);
		exception.expectMessage("Filme vazio");

		service.alugarFilme(usuario, null);

	}

//	@Test // vantagem pois captura a exceção e ainda verifica a msg da exception
//	public void testLocacao_filmeSemEstoque2() {
//		LocacaoService service = new LocacaoService();
//		Usuario usuario = new Usuario("usuario 1");
//		Filme filme = new Filme("filme 1", 0, 5.0);
//
//		try {
//			service.alugarFilme(usuario, filme);
//		} catch (Exception e) {
//			e.getMessage();
//		}
//	}

//	@Test
//	public void testLocacao_filmeSemEstoque3() throws Exception {
//		LocacaoService service = new LocacaoService();
//		Usuario usuario = new Usuario("usuario 1");
//		Filme filme = new Filme("filme 1", 1, 5.0);
//
//		service.alugarFilme(usuario, filme);
//
//		exception.expect(FilmeSemEstoqueException.class);// esperando uma exceção
//		exception.expectMessage("Filme sem estoque");
//	}

}
