package br.com.pdi.servico;

import br.com.pdi.visao.ImagemGUI;

/**
 *
 * @author brhol
 */
public class HistogramaServico {
    
    public static int[][] gerarVetores(ImagemGUI imagem){
        return gerarVetores(imagem, 0, imagem.getLargura(), 0, imagem.getAltura());
    }
    
    public static int[][] gerarVetores(ImagemGUI imagem, int x1, int x2, int y1, int y2){
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
    
    public static int[] gerarVetor(ImagemGUI imagem){
        return gerarVetor(imagem, 0, imagem.getLargura(), 0, imagem.getAltura());
    }
    
    public static int[] gerarVetor(ImagemGUI imagem, int x1, int x2, int y1, int y2) {
        int[] vetorHistograma = new int[256];
        for (int x = x1; x < x2; x++) {
            for (int y = y1; y < y2; y++) {
                vetorHistograma[imagem.getR(x, y)] += 1;
            }
        }
        return vetorHistograma;
    }
    
    public static int encontrarMaiorValor(int[] vetor){
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
    
    public static float[][] gerarVetoresRelativos(ImagemGUI imagem) {
        return gerarVetoresRelativos(imagem, 0, imagem.getLargura(), 0, imagem.getAltura());
    }

    public static float[][] gerarVetoresRelativos(ImagemGUI imagem, int x1, int x2, int y1, int y2) {
        int[][] vetoresHistograma = gerarVetores(imagem, x1, x2, y1, y2);
        int quantidadePixel = (x2 - x1) * (y2 - y1);
        float[][] vetoresRelativos = new float[3][256];
        for (int i = 0; i < vetoresRelativos[0].length; i++) {
            vetoresRelativos[0][i] = (float) vetoresHistograma[0][i] / quantidadePixel;
            vetoresRelativos[1][i] = (float) vetoresHistograma[1][i] / quantidadePixel;
            vetoresRelativos[2][i] = (float) vetoresHistograma[2][i] / quantidadePixel;
        }
        return vetoresRelativos;
    }
    
    public static float[] gerarVetorRelativo(ImagemGUI imagem) {
        return gerarVetorRelativo(imagem, 0, imagem.getLargura(), 0, imagem.getAltura());
    }
    
    public static float[] gerarVetorRelativo(ImagemGUI imagem, int x1, int x2, int y1, int y2) {
        int[] vetorHistograma = gerarVetor(imagem, x1, x2, y1, y2);
        int quantidadePixel = (x2 - x1) * (y2 - y1);
        float[] vetorRelativo = new float[256];
        for (int i = 0; i < vetorRelativo.length; i++) {
            vetorRelativo[i] = (float) vetorHistograma[i] / quantidadePixel;
        }
        return vetorRelativo;
    }

}
