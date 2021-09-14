import java.util.ArrayList;
import java.util.Scanner;


public class BasicConsole {
    
    protected Scanner in = new Scanner(System.in);

    public void showLnMsg(String msg){
        System.out.println(msg);
    }

    public void showMsg(String msg){
        System.out.print(msg);
    }

    public int askInt(String msg){
        showMsg(msg);
        return in.nextInt();
    }
    public String askNext(String msg){
        showMsg(msg);
        return in.next();
    }
    public double askDouble(String msg){
        showMsg(msg);
        return in.nextDouble();
    }
    public void askVazio(){
        showMsg("Pressione enter para prosseguir...");
        in.nextLine();
        in.nextLine();
    }
    public void askVazio1(){
        showMsg("Pressione enter para prosseguir...");
        in.nextLine();
    }

    public void cheio(){
        showMsg("Não foi possível adicionar a última figura geométrica, pois o vetor está cheio!\n");
    }

    public int askInt(){
        return in.nextInt();
    }

    public boolean hasNextInt(){
        return in.hasNextInt();
    }

    public void listar(ArrayList array){
        for (Object object : array) {
            System.out.println(object);
        }
    }
}
