package br.ce.wcaquino.servicos;

import java.util.Date;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {

	@Rule
	public ErrorCollector error = new ErrorCollector();

	@SuppressWarnings("deprecation")
	@Test
	public void teste() {
		// cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario1");
		Filme filme = new Filme("Filme 1", 2, 5.0);

		// acao
		Locacao locacao;
		try {
			locacao = service.alugarFilme(usuario, filme);

			Assert.assertEquals(5.0, locacao.getValor(), 0.01);
			Assert.assertThat(locacao.getValor(), CoreMatchers.is(5.0));
			Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
			Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		// verificacao
		// org.junit.assert - assertTrue - para retornar true, se retornar algo falso, o
		// Assert.assertEquals(locacao.getValor(), 5.0, 0.01);

		// melhor usar desse jeito:
		// assertThat(DataUtils.isMesmaData(locacao.getDataLocacao(),
		// DataUtils.obterDataComDiferencaDias(1)), is(true));

		// com o errorcollector:
		// error.checkThat(locacao.getValor(), IsEqual<assertEquals(6.0, 0.01));
		// error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true))
		// error.checkThat(isMesmaData(locacao.getDataRetorno(),
		// obterDataComDiferencaDias(1)), is(false);
	}

}
