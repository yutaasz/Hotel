package hotel;

import java.util.Scanner;

public class SistemaHotel {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("\n=== Sistema de Gerenciamento de Hotel ===");
            System.out.println("1. Cadastrar Quarto");
            System.out.println("2. Cadastrar Reserva");
            System.out.println("3. Realizar Check-in");
            System.out.println("4. Realizar Check-out");
            System.out.println("5. Gerar Relatório de Ocupação");
            System.out.println("6. Gerar Histórico de Reservas");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    System.out.print("Número do Quarto: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();  // Limpar o buffer
                    System.out.print("Tipo de Quarto (Solteiro, Casal, Suíte): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Preço Diário: ");
                    double precoDiario = scanner.nextDouble();
                    hotel.cadastrarQuarto(numero, tipo, precoDiario);
                    System.out.println("Quarto cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Nome do Hóspede: ");
                    String hospede = scanner.nextLine();

                    System.out.print("Data de Check-in (DD/MM/AAAA): ");
                    String checkIn = scanner.nextLine();

                    System.out.print("Data de Check-out (DD/MM/AAAA): ");
                    String checkOut = scanner.nextLine();

                    System.out.println("Quartos disponíveis para reserva:");
                    hotel.exibirQuartosDisponiveis(); 

                    System.out.print("Número do Quarto para Reservar: ");
                    int numQuarto = scanner.nextInt();
                    
                    hotel.cadastrarReserva(hospede, checkIn, checkOut, numQuarto);
                    break;


                case 3:
                    System.out.print("Número do Quarto para Check-in: ");
                    int checkInQuarto = scanner.nextInt();
                    hotel.realizarCheckIn(checkInQuarto);
                    break;

                case 4:
                    System.out.print("Número do Quarto para Check-out: ");
                    int checkOutQuarto = scanner.nextInt();
                    hotel.realizarCheckOut(checkOutQuarto);
                    break;

                case 5:
                    hotel.gerarRelatorioOcupacao();
                    break;

                case 6:
                    hotel.gerarHistoricoReservas();
                    break;

                case 7:
                    sair = true;
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}
