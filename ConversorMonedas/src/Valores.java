
public class Valores {
    private String letraDivisa1;
    private String letradivisa2;
    private float resultado;


    public Valores(Divisas divisas) {
        this.letraDivisa1 = divisas.base_code();
        this.letradivisa2 = String.valueOf(Integer.valueOf(divisas.target_code()));
        this.resultado = Float.parseFloat(divisas.conversion_result());
    }

    public String getLetradivisa2() {
        return letradivisa2;
    }

    public void setLetradivisa2(Integer letradivisa2) {
        this.letradivisa2 = String.valueOf(letradivisa2);
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = (int) resultado;
    }

    public String getLetraDivisa1() {
        return letraDivisa1;
    }

    public void setLetraDivisa1(String letraDivisa1) {
        this.letraDivisa1 = letraDivisa1;
    }
    }
