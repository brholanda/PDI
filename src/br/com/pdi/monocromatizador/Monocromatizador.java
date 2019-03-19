package br.com.pdi.monocromatizador;

import br.com.pdi.visao.ImagemGUI;

/**
 *
 * @author brhol
 */
public interface Monocromatizador {
    
    public int aplicar(ImagemGUI imagem, int y, int x);
}
