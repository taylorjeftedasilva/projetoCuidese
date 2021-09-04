package br.com.eniac.eniac.userCase;
import java.util.Date;

public class Lancamentos {
    private Date data;
    private int dado;
    private boolean jejum;

    public Lancamentos(int dado, boolean jejum) {
        this.data = new Date();
        this.dado = dado;
        this.jejum = jejum;
    }

    public Date getData() {
        return data;
    }
    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public boolean getJejum() {
        return jejum;
    }

    public void setJejum(boolean jejum) {
        this.jejum = jejum;
    }

    @Override
    public String toString(){
        return "Data: " + this.data + "\nDado: " + this.dado + "\nJejum: "+ this.jejum;
    }
}
