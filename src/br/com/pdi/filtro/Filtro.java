/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdi.filtro;

import br.com.pdi.dominio.Imagem;

/**
 *
 * @author brhol
 */
public interface Filtro {
    
    public int[] filtrar(Imagem imagem, int[][] kernel, int primeiroY, int ultimoY, int primeiroX, int ultimoX);
    
}
