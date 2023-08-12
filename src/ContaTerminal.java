import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        float saldo = 0.0f;
        try {
            System.out.println("Por favor, digite o número de sua Conta:");
            int numeroConta = scanner.nextInt();

            System.out.println("Por favor, digite o número da agencia seguido de código de verificação:");
            String agenciaDigito = scanner.next();

            System.out.println("Por favor, digite o seu nome:");
            String nomeCliente = scanner.next();

            System.out.println("Por favor, digite o saldo da sua conta:");
            saldo = scanner.nextFloat();

            System.out.println("Olá "+nomeCliente+", obrigado por criar uma conta em nosso banco, sua agência é "+ agenciaDigito +", conta "+numeroConta+" e seu saldo R$ "+saldo+", já está disponível para saque.");
        } finally {
            scanner.close();
        }
        
    }
}
