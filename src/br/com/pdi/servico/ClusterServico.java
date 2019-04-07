package br.com.pdi.servico;

import br.com.pdi.visao.ImagemGUI;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author brhol
 */
public class ClusterServico {
    
    public static boolean verificaMudancaDosClusters(List<Color> listaClusters, List<Color> novosClusters){
        int rDiferenca, gDiferenca, bDiferenca,
                rCluster, gCluster, bCluster,
                rNovoCluster, gNovoCluster, bNovoCluster;
        for (int indice = 0; indice < listaClusters.size(); indice++) {
            rCluster = listaClusters.get(indice).getRed();
            gCluster = listaClusters.get(indice).getGreen();
            bCluster = listaClusters.get(indice).getBlue();
            rNovoCluster = novosClusters.get(indice).getRed();
            gNovoCluster = novosClusters.get(indice).getGreen();
            bNovoCluster = novosClusters.get(indice).getBlue();
            rDiferenca = rCluster - rNovoCluster > 0 ? rCluster - rNovoCluster : rNovoCluster - rCluster;
            gDiferenca = gCluster - gNovoCluster > 0 ? gCluster - gNovoCluster : gNovoCluster - gCluster;
            bDiferenca = bCluster - bNovoCluster > 0 ? bCluster - bNovoCluster : bNovoCluster - bCluster;
            if (rDiferenca > 1 && gDiferenca > 1 && bDiferenca > 1){
                return true;
            }
        }
        return false;
    }
    
    public static List<Color> encontraNovosClusters(List<Color> listaClusters, long[][] somatorioRGBPorCluster){
        long qtdPixelsDesteCluster;
        int rNovoCluster, gNovoCluster, bNovoCluster;
        List<Color> novosClusters = new ArrayList<>();
        Color novoCluster;
        for (int indice = 0; indice < listaClusters.size(); indice++) {
            qtdPixelsDesteCluster = somatorioRGBPorCluster[indice][3];
            if (qtdPixelsDesteCluster == 0){
                novosClusters.add(listaClusters.get(indice));
                continue;
            }
            rNovoCluster = new Long(somatorioRGBPorCluster[indice][0] / qtdPixelsDesteCluster).intValue();
            gNovoCluster = new Long(somatorioRGBPorCluster[indice][1] / qtdPixelsDesteCluster).intValue();
            bNovoCluster = new Long(somatorioRGBPorCluster[indice][2] / qtdPixelsDesteCluster).intValue();
            novoCluster = new Color(rNovoCluster, gNovoCluster, bNovoCluster);
            novosClusters.add(novoCluster);
        }
        return novosClusters;
    }
    
    public static int encontraClusterDoPixel(ImagemGUI imagem, int eixoX, int eixoY, List<Color> listaClusters){
        int indiceCluster = 0;
        int means;
        int meansAux = Integer.MAX_VALUE;
        int rImagem = imagem.getR(eixoX, eixoY);
        int gImagem = imagem.getG(eixoX, eixoY);
        int bImagem = imagem.getB(eixoX, eixoY);
        int rCluster, gCluster, bCluster;
        for (int indice = 0; indice < listaClusters.size(); indice++) {
            rCluster = listaClusters.get(indice).getRed();
            gCluster = listaClusters.get(indice).getGreen();
            bCluster = listaClusters.get(indice).getBlue();
            means = (int) Math.sqrt((Math.pow((rImagem - rCluster), 2)) 
                    + (Math.pow((gImagem - gCluster), 2)) 
                    + (Math.pow((bImagem - bCluster), 2)));
            // encontra a menor média e atribui o indice do cluster no mapa de clusters
            if (means < meansAux){
                meansAux = means;
                indiceCluster = indice;
            }
        }
        return indiceCluster;
    }
    
    public static ImagemGUI montaImagemClusterizada(ImagemGUI imagem, List<Color> listaClusters, int[][] mapaClusters){
        // variáveis auxiliares
        int altura = imagem.getAltura();
        int largura = imagem.getLargura();
        ImagemGUI imagemResultante = new ImagemGUI(largura, altura);
        int r, g, b;
        Color cluster;
        // pinta imagem resultante
        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                cluster = listaClusters.get(mapaClusters[x][y]);
                r = cluster.getRed();
                g = cluster.getGreen();
                b = cluster.getBlue();
                imagemResultante.setRGB(x, y, r, g, b);
            }
        }
        return imagemResultante;
    }
}
