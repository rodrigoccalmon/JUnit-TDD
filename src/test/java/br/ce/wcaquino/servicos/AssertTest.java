package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Usuario;

public class AssertTest {
	@Test
	public void test() {
		Assert.assertTrue(true); // testar se a express�o � true, recomenda usar o m�n de ! (nega��es)
		Assert.assertFalse(false); // testa se a express�o � false

		Assert.assertEquals(1, 1); // intuitivo.

		Assert.assertEquals(0.51, 0.51, 0.01);
		// precisa colocar o delta no fim 0.01 - � uma margem de erro de compara��o

		Assert.assertEquals(Math.PI, 3.14, 0.01);

		int i = 5; // tipo primitivo
		Integer i2 = 5; // objeto
		// Assert.assertEquals(i, i2); //java nao deixa

		Assert.assertEquals(Integer.valueOf(i), i2);

		// strings s�o comparadas atrav�s do metodo equals tamb�m

		Assert.assertEquals("bola", "bola");
		// Assert.assertEquals("bola", "Bola"); // vai dar erro
		Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
		Assert.assertTrue("bola".startsWith("bo"));

		// igualdade dos obj tbm vai ser verificada atraves do metodo equals do proprio
		// obj,
		// ngm melhor que o proprio obj pra dizer se ele � igual ou n�o ao outro.

		Usuario u1 = new Usuario("Usuario 1");
		Usuario u2 = new Usuario("Usuario 1");

		Assert.assertEquals(u1, u2); // deu erro pq n�o considerou os 2 obj iguals
		// o proprio obj que diz se um � igual ao outro.
		// asert equals vai procurar o metodo equals do obj.
		// no usuario ainda n�o tem o metodo equals implementado
		// ambos sao do tipo usuario e o nome igual, como retornar true?
		// precisa implementar o equals do obj na classe da entidade
		// dps de implementado, o teste passa, os obj s�o iguais.

		// para garantir que os 2 obj s�o da mesma inst�ncia
		Assert.assertSame(u1, u2);
		// vai dar erro, vai considerar que s�o diferentes, s� da pra comparar
		// por ex u2 com u2, u1 com u1
		
		
	}
}
