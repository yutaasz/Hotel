package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Quarto> quartos;
    private List<Reserva> reservas;

    public Hotel() {
        this.quartos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void cadastrarQuarto(int numero, String tipo, double precoDiario) {
        Quarto quarto = new Quarto(numero, tipo, precoDiario);
        quartos.add(quarto);
    }

    public void cadastrarReserva(String hospede, String dataCheckIn, String dataCheckOut, int numeroQuarto) {
        Quarto quarto = encontrarQuarto(numeroQuarto);
        if (quarto != null && quarto.isDisponivel()) {
            Reserva reserva = new Reserva(hospede, dataCheckIn, dataCheckOut, quarto);
            reservas.add(reserva);
            quarto.setDisponivel(false);
            System.out.println("Reserva realizada com sucesso.");
        } else {
            System.out.println("Quarto não disponível.");
        }
    }

    public void realizarCheckIn(int numeroQuarto) {
        Quarto quarto = encontrarQuarto(numeroQuarto);
        if (quarto != null && quarto.isDisponivel()) {
            quarto.setDisponivel(false);
            System.out.println("Check-in realizado com sucesso.");
        } else {
            System.out.println("Quarto já ocupado ou inexistente.");
        }
    }

    public void realizarCheckOut(int numeroQuarto) {
        Quarto quarto = encontrarQuarto(numeroQuarto);
        if (quarto != null && !quarto.isDisponivel()) {
            quarto.setDisponivel(true);
            System.out.println("Check-out realizado com sucesso.");
        } else {
            System.out.println("Quarto já está disponível ou inexistente.");
        }
    }

    public void gerarRelatorioOcupacao() {
        System.out.println("Relatório de Ocupação:");
        for (Quarto quarto : quartos) {
            System.out.println(quarto);
        }
    }

    public void gerarHistoricoReservas() {
        System.out.println("Histórico de Reservas:");
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }
    
    public void exibirQuartosDisponiveis() {
        for (Quarto quarto : quartos) {
            if (quarto.isDisponivel()) {
                System.out.println("Quarto " + quarto.getNumero() + " - Tipo: " + quarto.getTipo() + " - Preço Diário: " + quarto.getPrecoDiario());
            }
        }
    }


    private Quarto encontrarQuarto(int numero) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numero) {
                return quarto;
            }
        }
        return null;
    }
}
