package com.matheusgr.lunr;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimilaridadeTest extends BaseTest{

	@Test 
    void testSimilaridadeExistente() {
		this.similaridadeController.similaridade(TEXTO1_ID, TEXTO2_ID);
    }

    @Test 
    void testSimilaridadeNaoExistente() {
    	double similaridade = 0.0;
    	assertEquals(similaridade, this.similaridadeController.similaridade(TEXTO3_ID, TEXTO4_ID)); 
    }

    @Test 
    void testSimilaridadeNaoExistente2() {
    	double similaridade = 0.0;
    	assertEquals(similaridade, this.similaridadeController.similaridade(TEXTO3_ID, TEXTO4_ID));
    }
    
    @Test 
    void testSimilaridadeExistente2() {
    	double similaridade = 1.0;
    	double similaridadeNula = 0.0;
    	double valorEsperado =  this.similaridadeController.similaridade(TEXTO5_ID, TEXTO6_ID);
    	assertEquals(similaridade, valorEsperado);
    	assertNotEquals(similaridade, similaridadeNula);
    	assertEquals(similaridade, this.similaridadeController.similaridade(TEXTO5_ID, TEXTO6_ID)); 
    }

}
