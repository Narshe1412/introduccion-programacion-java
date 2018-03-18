package uniandes.cupi2.lineasTelefonicas.mundo;

public class LineaVozIP extends LineaTelefonica {

	/* Total de minutos realizados en llamadas a larga distancia */
	private int numeroMinutosLargaDistancia;
	/* Total de minutos realizados a traves de celular */
	private int numeroMinutosCelular;
	/* Total de saldo disponible para llamadas VozIP */
	private double saldoDisponible;

	/**
	 * Constructor que inicializa la l�nea telef�nica de voz ip <br>
	 * <b>post: </b> La l�nea vozip inicializ� sus valores en cero. El saldo
	 * disponible se inicio en 100000$ Se inicializaron los valores de la l�nea
	 * telefonica heredada en cero a trav�s del llamado a su respectivo constructor.
	 */
	public LineaVozIP() {
		super();
		numeroMinutosLargaDistancia = 0;
		numeroMinutosCelular = 0;
		saldoDisponible = 100000;
	}

	/**
	 * Devuelve el n�mero de minutos larga distancia consumidos
	 * 
	 * @return N�mero de minutos larga distancia consumidos
	 */
	public int darNumeroMinutosLargaDistancia() {
		return numeroMinutosLargaDistancia;
	}

	/**
	 * Devuelve el n�mero de minutos celular consumidos
	 * 
	 * @return N�mero de minutos celular consumidos
	 */
	public int darNumeroMinutosCelular() {
		return numeroMinutosCelular;
	}

	/**
	 * Devuelve el saldo disponible
	 * 
	 * @return Total de saldo disponible para voz ip
	 */
	public double darSaldoDisponible() {
		return saldoDisponible;
	}

	/**
	 * Agrega una llamada de larga distancia a la l�nea telef�nica <br>
	 * <b>post: </b> Se incremento en 1 numeroDeLlamadas, se incremento
	 * numeroDeMinutos en minutos, costoLlamadas aumento en ( minutos * 380 )
	 * 
	 * @param minutos
	 *            N�mero de minutos de la llamada. minutos >0.
	 */
	public void agregarLlamadaCelular(int minutos) {
		super.agregarLlamadaCelular(minutos);
		numeroMinutosCelular += minutos;
		modificarCostoLlamada(darCostoLlamadas() - (minutos * (999 - 7)));
	}

	/**
	 * Agrega una llamada a celular a la l�nea telef�nica <br>
	 * <b>post: </b> Se incremento en 1 numeroDeLlamadas, se incremento
	 * numeroDeMinutos en minutos, costoLlamadas aumento en ( minutos * 999 )
	 * 
	 * @param minutos
	 *            N�mero de minutos de la llamada. minutos >0.
	 */
	public void agregarLlamadaLargaDistancia(int minutos) {
		numeroLlamadas++;
		numeroMinutos += minutos;
		numeroMinutosLargaDistancia += minutos;
		modificarCostoLlamada(darCostoLlamadas() + (minutos * 80));
		saldoDisponible -= (minutos * 80);

	}

	/**
	 * Reinicia la l�nea telef�nica, dejando todos sus valores en cero.
	 */
	public void reiniciar() {
		super.reiniciar();
		numeroMinutosLargaDistancia = 0;
	}

}
