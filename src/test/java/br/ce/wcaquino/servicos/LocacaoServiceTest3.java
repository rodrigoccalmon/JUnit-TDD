package br.ce.wcaquino.servicos;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

public class LocacaoServiceTest3 {

	private LocacaoService service;

	// definir um contador e imprimir na tela, exercicio

	private static int contador = 0;

	@Before
	public void setup() {
		System.out.println("Before");
		contador++;
		System.out.println(contador);
	}

	@After
	public void tearDown() {
		System.out.println("After");
	}

}
