


import java.util.ArrayList;

public class Vigas {
    private ArrayList<Double> medidas = new ArrayList<Double>();
    private ArrayList<Integer> quantidades = new ArrayList<Integer>();
    private ArrayList<String> saida = new ArrayList<String>();
    private BasicConsole tela = new BasicConsole();
    private int tamanhoMax;
    private int contador = 0;
    private int espelho = 0;


    public Vigas(){
        colectMaxSize();
        addPieces();
        removeExtrems();
        //tela.showLnMsg("\nAbaixo as medidas em ordem");
        //tela.showLnMsg("A seguir a quantidade de vetores do tamanho máximo");
        verificarDuplas();
        // verificarTrios();
        // verificarQuadras();
    }


    public void verificarDuplas(){
        System.out.println(contador);
    }

    public void removeExtrems(){
        if (medidas.get(contador-1)==tamanhoMax && quantidades.get(contador-1)>0){
            String temp = ""+medidas.get(contador-1)+quantidades.get(contador-1);
            saida.add(temp);
            medidas.remove(contador-1);
            quantidades.remove(contador-1);
        }
    }


    /** Adiciona novos valores e organiza em ordem crescrente automaticamente */
    public void addPieces(){
        while(contador<3){
            contador++;
            int j=contador;
            medidas.add(tela.askDouble("qual a medida "+contador+"? "));
            quantidades.add(tela.askInt("qual a quantidade "+contador+"?"));
            while(j>=2 && medidas.get(j-1)<medidas.get(j-2)){
                Double medidaTemp;
                medidaTemp = medidas.get(j-2);
                medidas.set(j-2,medidas.get(j-1));
                medidas.set(j-1,medidaTemp);
                int qntdTemp;
                qntdTemp = quantidades.get(j-2);
                quantidades.set(j-2,quantidades.get(j-1));
                quantidades.set(j-1,qntdTemp);
                j--;
            }
            if(j>=2 && medidas.get(j-1).equals(medidas.get(j-2))){  // mescla quantidades de medidas iguais e reordena o vetor
                int soma = quantidades.get(j-1)+quantidades.get(j-2);
                tela.showLnMsg("Valor da soma: "+soma);
                quantidades.set(j-2,soma);
                int i = j-1;
                while (i<contador-1){
                    medidas.set(i,medidas.get(i+1));
                    quantidades.set(i,quantidades.get(i+1));
                }contador--;
                medidas.remove(contador);
                quantidades.remove(contador);
            }
        }
    }

    public void colectMaxSize(){
        tamanhoMax=tela.askInt("Qual o tamanho máximo? ");
    }
}
