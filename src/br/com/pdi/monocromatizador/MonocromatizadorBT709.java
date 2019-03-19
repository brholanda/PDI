package br.com.pdi.monocromatizador;

import br.com.pdi.visao.ImagemGUI;

/**
 *
 * @author brhol
 */
public class MonocromatizadorBT709 implements Monocromatizador{

    @Override
    public int aplicar(ImagemGUI imagem, int y, int x) {
        int r, g, b;
        r = imagem.getR(x, y);
        g = imagem.getG(x, y);
        b = imagem.getB(x, y);
        return (int) (0.2125 * r + 0.7154 * g + 0.0721 * b);
    }
    
}
