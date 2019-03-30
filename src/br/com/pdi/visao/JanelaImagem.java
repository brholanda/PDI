package br.com.pdi.visao;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

/**
 * Esta classe implementa janelas gráficas que contêm imagens.
 * Ela é utilizada na exibição de imagens na interface gráfica do software.
 * Cada janela gráfica (objeto desta classe) exibe apenas uma imagem.
 * 
 * INSTRUÇÕES PARA O ALUNO:
 * - Você precisa modificar esta classe?
 *    Não.
 * - Quando você precisará usá-la?
 *    Você nunca a utilizará diretamente.
 * 
 * @author Leandro Luque
 * @version 1.0
 * @since 1.0
 */
public class JanelaImagem extends JInternalFrame {
 
    // Atributos.
    
    /**
     * Imagem exibida na janela.
     */
    private ImagemGUI imagem;
    
    /**
     * Rótulo utilizado para exibir a imagem.
     */
    private JLabel rotuloImagem;
    
    // Construtores.
    
    /**
     * Cria uma nova janela para a imagem especificada.
     * @param imagem A imagem que será exibida dentro da janela.
     */
    public JanelaImagem(ImagemGUI imagem) {
        // Define o layout como sendo de borda.
        setLayout(new BorderLayout());
        // Habilita botões de fechamento.
        setClosable(true);        
        // Armazena a imagem recebida.
        this.imagem = imagem;
        // Altera o título da janela para o nome da imagem.
        setTitle(imagem.getNome());
        // Cria um rótulo com uma imagem interna e a exibe.
        rotuloImagem = new JLabel();
        imagem.setConteiner(rotuloImagem);
        imagem.setJanela(this);
        add(rotuloImagem, BorderLayout.CENTER);
        ImageIcon iconeImagem1 = new ImageIcon(imagem.getImagem());
        setBounds(0, 0, imagem.getLargura()+12, imagem.getAltura()+37);
        rotuloImagem.setIcon(iconeImagem1);
        rotuloImagem.validate();
    }

    // Métodos de acesso.
    public ImagemGUI getImagem() { return imagem; }

}
