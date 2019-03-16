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
public class FiltroLaplaciano implements Filtro{

    @Override
    public int[] filtrar(Imagem imagem, int[][] kernel, int primeiroY, int ultimoY, int primeiroX, int ultimoX) {
        int r, g, b;
        r = g = b = 0;
        for ( int i = primeiroY; i <= ultimoY; i++){
            for ( int j = primeiroX; j <= ultimoX; j++){
                r += imagem.getR(j, i) * kernel[j - primeiroX][i - primeiroY];
                g += imagem.getG(j, i) * kernel[j - primeiroX][i - primeiroY];
                b += imagem.getB(j, i) * kernel[j - primeiroX][i - primeiroY];
            }
        }
        
        r = Math.min(255, Math.max(0, r));
        g = Math.min(255, Math.max(0, g));
        b = Math.min(255, Math.max(0, b));
        
        return new int[] {r , g, b};
    }
    
}
