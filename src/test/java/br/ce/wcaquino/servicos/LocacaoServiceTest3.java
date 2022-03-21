package br.ce.wcaquino.servicos;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

public class LocacaoServiceTest3 {

	@Rule
	public ErrorCollector error = new ErrorCollector();
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void setup() {
		System.out.println("Before");
	}

	@After
	public void tearDown() {
		System.out.println("After");
	}
	
	
}
