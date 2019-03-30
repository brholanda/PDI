package br.com.pdi.servico;

import br.com.pdi.visao.ImagemGUI;

/**
 *
 * @author brhol
 */
public class HistogramaServico {
    
    public static int[][] geraVetores(ImagemGUI imagem){
        int[][] vetoresHistograma = new int[3][256];
        int altura = imagem.getAltura();
        int largura = imagem.getLargura();
        for (int x = 0; x < largura; x++) {
            for (int y = 0; y < altura; y++) {
                vetoresHistograma[0][imagem.getR(x, y)] += 1;
                vetoresHistograma[1][imagem.getG(x, y)] += 1;
                vetoresHistograma[2][imagem.getB(x, y)] += 1;
            }
        }
        return vetoresHistograma;
    }
    
    public static int[][] geraVetores2(int[][][] imagem){
        int[][] vetoresHistograma = new int[3][256];
        int altura = imagem[0][0].length;
        int largura = imagem[0].length;
        for (int x = 0; x < largura; x++) {
            for (int y = 0; y < altura; y++) {
                vetoresHistograma[0][imagem[0][x][y]] += 1;
                vetoresHistograma[1][imagem[1][x][y]] += 1;
                vetoresHistograma[2][imagem[2][x][y]] += 1;
            }
        }
        return vetoresHistograma;
    }
    
    public static int[] geraVetor(int[][] imagem){
        int[] vetorHistograma = new int[256];
        int altura = imagem[0].length;
        int largura = imagem.length;
        for (int x = 0; x < largura; x++) {
            for (int y = 0; y < altura; y++) {
                vetorHistograma[imagem[x][y]] += 1;
            }
        }
        return vetorHistograma;
    }
    
    public static int[] geraVetor(ImagemGUI imagem, int x1, int x2, int y1, int y2) {
        int[] vetorHistograma = new int[256];
        for (int x = x1; x < x2; x++) {
            for (int y = y1; y < y2; y++) {
                vetorHistograma[imagem.getR(x, y)] += 1;
            }
        }
        return vetorHistograma;
    }
    
    public static int getMaiorValor(int[] vetor){
        int maior = 0;
        int aux;
        for (int i = 0; i < vetor.length; i++) {
            aux = vetor[i];
            if (aux > maior){
                maior = aux;
            }
        }
        return maior;
    }

    public static float[][] geraVetoresProbabilidade(ImagemGUI imagem, int[][] vetoresHistograma) {
        int quantidadePixel = imagem.getLargura() * imagem.getAltura();
        float[][] vetoresProblabilidade = new float[3][256];
        for (int i = 0; i < vetoresProblabilidade[0].length; i++) {
            vetoresProblabilidade[0][i] = (float) vetoresHistograma[0][i] / quantidadePixel;
            vetoresProblabilidade[1][i] = (float) vetoresHistograma[1][i] / quantidadePixel;
            vetoresProblabilidade[2][i] = (float) vetoresHistograma[2][i] / quantidadePixel;
        }
        return vetoresProblabilidade;
    }

}
