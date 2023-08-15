import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            float saldoAtual = cadastro(scanner);
            System.out.println("Você deseja realizar um saque ou um deposito");
            String resposta = scanner.next();
            if (resposta.equals("saque")) {
                saldoAtual = saque(scanner, saldoAtual);
            } else if (resposta.equals("deposito")) {
                saldoAtual = deposito(scanner, saldoAtual);
            } else {
                System.out.println("Digite uma função válida");
            };
            System.out.println("Seu saldo atualizado é de R$ "+saldoAtual);
        } finally {
            scanner.close();
        }
        
    }

    public static float cadastro(Scanner scanner) {
            System.out.println("Por favor, digite o número de sua Conta:");
            int numeroConta = scanner.nextInt();

            System.out.println("Por favor, digite o número da agencia seguido de código de verificação:");
            String agenciaDigito = scanner.next();

            System.out.println("Por favor, digite o seu nome:");
            String nomeCliente = scanner.next();

            System.out.println("Por favor, digite o saldo da sua conta:");
            float saldo = scanner.nextFloat();

            System.out.println("Olá "+nomeCliente+", obrigado por criar uma conta em nosso banco, sua agência é "+ agenciaDigito +", conta "+numeroConta+" e seu saldo R$ "+saldo+", já está disponível para saque.");
            return saldo;
    }

    public static float saque(Scanner scanner, Float saldoAtual) {
        System.out.println("Digite o valor que deseja sacar ou sair");
        float valor = scanner.nextFloat();
        if (saldoAtual >= valor) {
            float saldoAtualizado = saldoAtual - valor;
            System.out.println("Saque de R$ "+valor+" realizado com sucesso!");
            return saldoAtualizado;
        }
        System.out.println("O saque não foi realizado, tente novamente mais tarde.");
        return saldoAtual;

    }

    public static float deposito(Scanner scanner, Float saldoAtual) {
        System.out.println("Digite o valor que deseja depositar: ");
        float valor = scanner.nextFloat();
        if (valor > 0) {
            float saldoAtualizado = valor + saldoAtual;
            return saldoAtualizado;
        }
        System.out.println("Depósito não realizado, tente novamente mais tarde.");
        return saldoAtual;
    }
}
