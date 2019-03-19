package br.com.pdi.monocromatizador;

import br.com.pdi.visao.ImagemGUI;

/**
 *
 * @author brhol
 */
public class MonocromatizadorBrilho implements Monocromatizador {

    @Override
    public int aplicar(ImagemGUI imagem, int y, int x) {
        int maior, menor;
        menor = maior = imagem.getR(x, y);
        menor = Integer.min(menor, imagem.getG(x, y));
        maior = Integer.max(maior, imagem.getG(x, y));
        menor = Integer.min(menor, imagem.getB(x, y));
        maior = Integer.max(maior, imagem.getB(x, y));
        return (menor + maior) / 2;
    }
    
}
