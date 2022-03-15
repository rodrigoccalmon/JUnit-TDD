package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Usuario;

public class AssertTest {
	@Test
	public void test() {
		Assert.assertTrue(true); // testar se a expressão é true, recomenda usar o mín de ! (negações)
		Assert.assertFalse(false); // testa se a expressão é false

		Assert.assertEquals(1, 1); // intuitivo.

		Assert.assertEquals(0.51, 0.51, 0.01);
		// precisa colocar o delta no fim 0.01 - é uma margem de erro de comparação

		Assert.assertEquals(Math.PI, 3.14, 0.01);

		int i = 5; // tipo primitivo
		Integer i2 = 5; // objeto
		// Assert.assertEquals(i, i2); //java nao deixa

		Assert.assertEquals(Integer.valueOf(i), i2);

		// strings são comparadas através do metodo equals também

		Assert.assertEquals("bola", "bola");
		// Assert.assertEquals("bola", "Bola"); // vai dar erro
		Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
		Assert.assertTrue("bola".startsWith("bo"));

		// igualdade dos obj tbm vai ser verificada atraves do metodo equals do proprio
		// obj,
		// ngm melhor que o proprio obj pra dizer se ele é igual ou não ao outro.

		Usuario u1 = new Usuario("Usuario 1");
		Usuario u2 = new Usuario("Usuario 1");

		Assert.assertEquals(u1, u2); // deu erro pq não considerou os 2 obj iguals
		// o proprio obj que diz se um é igual ao outro.
		// asert equals vai procurar o metodo equals do obj.
		// no usuario ainda não tem o metodo equals implementado
		// ambos sao do tipo usuario e o nome igual, como retornar true?
		// precisa implementar o equals do obj na classe da entidade
		// dps de implementado, o teste passa, os obj são iguais.

		// para garantir que os 2 obj são da mesma instância
		Assert.assertSame(u1, u2);
		// vai dar erro, vai considerar que são diferentes, só da pra comparar
		// por ex u2 com u2, u1 com u1
		
		
	}
}
