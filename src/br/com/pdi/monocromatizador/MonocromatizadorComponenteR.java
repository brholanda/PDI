package br.com.pdi.monocromatizador;

import br.com.pdi.visao.ImagemGUI;

/**
 *
 * @author brhol
 */
public class MonocromatizadorComponenteR implements Monocromatizador {

    @Override
    public int aplicar(ImagemGUI imagem, int y, int x) {
        return imagem.getR(x, y);
    }
    
}
