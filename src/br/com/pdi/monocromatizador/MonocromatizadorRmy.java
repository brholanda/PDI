package br.com.pdi.monocromatizador;

import br.com.pdi.visao.ImagemGUI;

/**
 *
 * @author brhol
 */
public class MonocromatizadorRmy implements Monocromatizador{

    @Override
    public int aplicar(ImagemGUI imagem, int y, int x) {
        int r, g, b;
        r = imagem.getR(x, y);
        g = imagem.getG(x, y);
        b = imagem.getB(x, y);
        return (int) (0.5 * r + 0.419 * g + 0.081 * b);
    }
    
}
