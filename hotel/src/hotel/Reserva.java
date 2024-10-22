package hotel;

public class Reserva {
    private String hospede;
    private String dataCheckIn;
    private String dataCheckOut;
    private Quarto quarto;

    public Reserva(String hospede, String dataCheckIn, String dataCheckOut, Quarto quarto) {
        this.hospede = hospede;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.quarto = quarto;
    }

    public String getHospede() {
        return hospede;
    }

    public String getDataCheckIn() {
        return dataCheckIn;
    }

    public String getDataCheckOut() {
        return dataCheckOut;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    @Override
    public String toString() {
        return "Reserva para " + hospede + " - Check-in: " + dataCheckIn + ", Check-out: " + dataCheckOut + ", Quarto: " + quarto.getNumero();
    }
}
