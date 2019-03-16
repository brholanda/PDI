/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdi.filtro;

import br.com.pdi.dominio.Imagem;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author brhol
 */
public class FiltroMediana implements Filtro {

    @Override
    public int[] filtrar(Imagem imagem, int[][] kernel, int primeiroY, int ultimoY, int primeiroX, int ultimoX) {
        int indiceMediana;
        Integer[] arrayRGB;
        arrayRGB = new Integer[((ultimoX +1) - primeiroX)*((ultimoY + 1) - primeiroY)];
        int indiceArray = 0;
        for ( int i = primeiroY; i <= ultimoY; i++){
            for ( int j = primeiroX; j <= ultimoX; j++, indiceArray++){
                arrayRGB[indiceArray] = imagem.getImagem().getRGB(j, i);
            }
        }
        List<Integer> lista = Arrays.asList(arrayRGB);
        Collections.sort(Arrays.asList(arrayRGB));
        //quickSort(arrayRGB, 0, arrayRGB.length - 1);

        indiceMediana = (lista.size() - 1) / 2;
        
        Color color = new Color(lista.get(indiceMediana));
        
        int r, g, b;
        
        r = color.getRed();
        g = color.getGreen();
        b = color.getBlue();
        
        return new int[] {r , g, b};
    }

    private void quickSort(int[] array, int esquerda, int direita) {
        int indice = esquerda + (direita - esquerda) / 2;
        int valor = array[indice];

        int i = esquerda, j = direita;

        while(i <= j) {

            while(array[i] < valor) {
                i++;
            }

            while(array[j] > valor) {
                j--;
            }

            if(i <= j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }

            if(esquerda < i) {
                quickSort(array, esquerda, j);
            }

            if(direita > i) {
                quickSort(array, i, direita);
            }

        }
    }
}
