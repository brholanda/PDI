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
public class FiltroMedia implements Filtro {

    @Override
    public int[] filtrar(Imagem imagem, int[][] kernel, int primeiroY, int ultimoY, int primeiroX, int ultimoX) {
        int r, g, b;
        r = g = b = 0;
        int tamanhoKernel = ((ultimoX +1) - primeiroX)*((ultimoY + 1) - primeiroY);
        for ( int i = primeiroY; i <= ultimoY; i++){
            for ( int j = primeiroX; j <= ultimoX; j++){
                r += imagem.getR(j, i);
                g += imagem.getG(j, i);
                b += imagem.getB(j, i);
            }
        }
        r /= tamanhoKernel;
        g /= tamanhoKernel;
        b /= tamanhoKernel;
        return new int[] {r , g, b};
    }
    
}
