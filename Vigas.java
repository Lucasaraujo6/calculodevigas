


import java.util.ArrayList;

public class Vigas {
    private ArrayList<Double> medidas = new ArrayList<Double>();
    private ArrayList<Integer> quantidades = new ArrayList<Integer>();
    private ArrayList<String> saida = new ArrayList<String>();
    private BasicConsole tela = new BasicConsole();
    private int tamanhoMax;
    private int qntdMinima, contador = 0;
    private double margem, espelho;
    private String temp;


    public Vigas(){
        colectMaxSize();
        addPieces();
        removeExtrems();
        //tela.showLnMsg("\nAbaixo as medidas em ordem");
        //tela.showLnMsg("A seguir a quantidade de vetores do tamanho máximo");
        verificarDuplas();
        // verificarTrios();
        // verificarQuadras();
        tela.listar(saida);
    }

            //50 0 50 10 30 10 20 5 10 3 40 2

    public void verificarDuplas(){
      //  System.out.println(contador);
        int i = contador-1;
        int j = 0;
        while (medidas.get(i)>tamanhoMax/2){
            espelho = tamanhoMax-medidas.get(i);
            if(medidas.get(j)>espelho){
                i--;
            }else if (medidas.get(j)<espelho){
                j++;
            }else if (medidas.get(j)==espelho){
                qntdMinima = Math.min(quantidades.get(i), quantidades.get(j));
                quantidades.set(i,quantidades.get(i)-qntdMinima);
                quantidades.set(j,quantidades.get(j)-qntdMinima);
                temp = ""+medidas.get(i)+", "+medidas.get(j)+" => "+ qntdMinima +" par(es);";
                saida.add(temp);
                i--;
                
            }  
        }
    }

    public void removeExtrems(){
        if (medidas.get(contador-1)==tamanhoMax && quantidades.get(contador-1)>0){
            contador--;
            temp = ""+medidas.get(contador)+", 0 => "+quantidades.get(contador)+" pares;";
            saida.add(temp);
            medidas.remove(contador);
            quantidades.remove(contador);
        }
    }


    /** Adiciona novos valores e organiza em ordem crescrente automaticamente */
    public void addPieces(){
        while(contador<5){
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
        margem = tela.askDouble("Qual a margem? ");
    }
}
