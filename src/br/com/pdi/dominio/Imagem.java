package br.com.pdi.dominio;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

/**
 * Esta classe encapsula os dados e o comportamento comuns a
 * imagens coloridas (RGB) do software da disciplina "Tópicos 
 * Especiais em Informática" - Processamento Digital de Imagens.
 *
 * INSTRUÇÕES PARA O ALUNO:
 *  - Você não usará esta classe diretamente. No entanto, você usará uma
 *    subclasse desta (ImagemGUI) na manipulação de imagens.
 *  - Os métodos desta classe importantes para você são:
 *    > getR(int x, int y):
 *       Este método retorna o valor do componente R (vermelho) do pixel na
 *       posição (x,y).
 *    > getG(int x, int y):
 *       Este método retorna o valor do componente G (verde) do pixel na
 *       posição (x,y).
 *    > getB(int x, int y):
 *       Este método retorna o valor do componente B (azul) do pixel na
 *       posição (x,y).
 *    > setRGB(int x, int y, int R, int G, int B):
 *       Este método define a cor do pixel (x,y) por meio da especificação dos
 *       componentes R (vermelho), G (verde) e B (azul).
 *       O valor deve estar entre 0 e 255 (inclusive).
 *
 * @author Leandro Luque (Professor) - leandro.luque@gmail.com
 * @version 1.0
 */
public class Imagem {

    /**
     * Imagem.
     */
    private BufferedImage imagemBuffer;
       
    /**
     * Cria uma nova imagem para a imagem especificada por parâmetro.
     * Este método não faz cópias do BufferedImage, apenas o referencia.
     * @param imagem imagem.
     */
    public Imagem(BufferedImage imagem) {
        this.imagemBuffer = imagem;
    }    
    
    /**
     * Cria uma nova imagem baseada na especificada.
     * A imagem especificada é copiada. Portanto, os dados não são compartilhados
     * entre as duas. Em outras palavras, a alteração em uma não afetará a outra.
     * @param imagem imagem.
     */
    public Imagem(Imagem imagem) {
        // Cria uma cópia da imagem especificada.
        ColorModel modeloCores = imagem.getImagem().getColorModel();
        boolean temCanalAlfa = modeloCores.isAlphaPremultiplied();
        WritableRaster raster = imagem.getImagem().copyData(null);
        this.imagemBuffer = new BufferedImage(modeloCores, raster, temCanalAlfa, null);        
    }

    /**
     * Cria uma nova imagem com a largura e altura especificadas.
     * @param largura largura da imagem.
     * @param altura altura da imagem.
     */
    public Imagem(int largura, int altura) {
        this.imagemBuffer = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
    }        
    
    // Métodos de acesso.
    public BufferedImage getImagem() { return imagemBuffer; }
    public int getAltura() { return this.imagemBuffer.getHeight(); }
    public int getLargura() { return this.imagemBuffer.getWidth(); }
    public int getR(int x, int y) { return (new Color(Imagem.this.imagemBuffer.getRGB(x, y)).getRed()); }
    public void setR(int x, int y, int valor) { Imagem.this.imagemBuffer.setRGB(x, y, new Color(valor, getG(x, y), getB(x, y)).getRGB()); }
    public int getG(int x, int y) { return (new Color(Imagem.this.imagemBuffer.getRGB(x, y)).getGreen()); }
    public void setG(int x, int y, int valor) { Imagem.this.imagemBuffer.setRGB(x, y, new Color(getR(x,y), valor, getB(x, y)).getRGB()); }
    public int getB(int x, int y) { return (new Color(Imagem.this.imagemBuffer.getRGB(x, y)).getBlue()); }
    public void setB(int x, int y, int valor) { Imagem.this.imagemBuffer.setRGB(x, y, new Color(getR(x,y), getG(x,y), valor).getRGB()); }
    public void setRGB(int x, int y, int R, int G, int B) { Imagem.this.imagemBuffer.setRGB(x, y, new Color(R, G, B).getRGB()); }
    public int[][][] getMatrizesRGB() {
        int[][][] matrizes = new int[3][imagemBuffer.getWidth()][imagemBuffer.getHeight()];
        for ( int x = 0; x < imagemBuffer.getWidth(); x++ ){
            for ( int y = 0; y < imagemBuffer.getHeight(); y++ ){
                matrizes[0][x][y] = (new Color(Imagem.this.imagemBuffer.getRGB(x, y)).getRed());
                matrizes[1][x][y] = (new Color(Imagem.this.imagemBuffer.getRGB(x, y)).getGreen());
                matrizes[2][x][y] = (new Color(Imagem.this.imagemBuffer.getRGB(x, y)).getBlue());
            }
        }
        return matrizes;
    }
    
}
