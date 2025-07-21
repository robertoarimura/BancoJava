import java.util.Scanner;
import java.util.Locale;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        sc.useLocale(Locale.US);
        
        double saldo = 0;
        int op;
        boolean isRunning = true;

        while (isRunning){
            System.out.println("----------");
            System.out.println("Banco Java");
            System.out.println("----------");
            System.out.println("1. Mostrar saldo");
            System.out.println("2. Depósito");
            System.out.println("3. Saque");
            System.out.println("4. Sair");
            System.out.println("----------");

            System.out.print("Informe a opção desejada (1-4): ");
            op = sc.nextInt();

            switch (op){
                case 1 -> mostrarSaldo(saldo);
                case 2 -> saldo += deposito();
                case 3 -> saldo -= saque(saldo);
                case 4 -> isRunning = false;
                default -> System.out.println("Opção Inválida!");
            }
        }

        System.out.println("---------------------------");
        System.out.println("Obrigado! Tenha um bom dia!");
        System.out.println("---------------------------");

        sc.close();
    }

    static void mostrarSaldo(double saldo){
        System.out.println("---------------");
        System.out.printf("R$%.2f\n", saldo);
    }

    static double deposito(){
        double valor;

        System.out.print("Informe o valor que deseja depositar: ");
        valor = sc.nextDouble();

        if (valor < 0 ){
            System.out.println("O valor não pode ser negativo!");
            return 0;
        }else{
            return valor;
        }
    }

    static double saque(double saldo){
        double valor;

        System.out.print("Informe o valor a ser sacado: ");
        valor = sc.nextDouble();

        if (valor > saldo){
            System.out.println("Saldo insuficiente!");
            return 0;
        }else if(valor < 0){
            System.out.println("O valor não pode ser negativo!");
            return 0;
        }else{
            return valor;
        }
    }
}
