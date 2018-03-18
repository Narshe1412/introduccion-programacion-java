package uniandes.cupi2.lineasTelefonicas.mundo;

public class LineaVozIP extends LineaTelefonica {

	/* Total de minutos realizados en llamadas a larga distancia */
	private int numeroMinutosLargaDistancia;
	/* Total de minutos realizados a traves de celular */
	private int numeroMinutosCelular;
	/* Total de saldo disponible para llamadas VozIP */
	private double saldoDisponible;

	/**
	 * Constructor que inicializa la línea telefónica de voz ip <br>
	 * <b>post: </b> La línea vozip inicializó sus valores en cero. El saldo
	 * disponible se inicio en 100000$ Se inicializaron los valores de la línea
	 * telefonica heredada en cero a través del llamado a su respectivo constructor.
	 */
	public LineaVozIP() {
		super();
		numeroMinutosLargaDistancia = 0;
		numeroMinutosCelular = 0;
		saldoDisponible = 100000;
	}

	/**
	 * Devuelve el número de minutos larga distancia consumidos
	 * 
	 * @return Número de minutos larga distancia consumidos
	 */
	public int darNumeroMinutosLargaDistancia() {
		return numeroMinutosLargaDistancia;
	}

	/**
	 * Devuelve el número de minutos celular consumidos
	 * 
	 * @return Número de minutos celular consumidos
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
	 * Agrega una llamada de larga distancia a la línea telefónica <br>
	 * <b>post: </b> Se incremento en 1 numeroDeLlamadas, se incremento
	 * numeroDeMinutos en minutos, costoLlamadas aumento en ( minutos * 380 )
	 * 
	 * @param minutos
	 *            Número de minutos de la llamada. minutos >0.
	 */
	public void agregarLlamadaCelular(int minutos) {
		super.agregarLlamadaCelular(minutos);
		numeroMinutosCelular += minutos;
		modificarCostoLlamada(darCostoLlamadas() - (minutos * (999 - 7)));
	}

	/**
	 * Agrega una llamada a celular a la línea telefónica <br>
	 * <b>post: </b> Se incremento en 1 numeroDeLlamadas, se incremento
	 * numeroDeMinutos en minutos, costoLlamadas aumento en ( minutos * 999 )
	 * 
	 * @param minutos
	 *            Número de minutos de la llamada. minutos >0.
	 */
	public void agregarLlamadaLargaDistancia(int minutos) {
		numeroLlamadas++;
		numeroMinutos += minutos;
		numeroMinutosLargaDistancia += minutos;
		modificarCostoLlamada(darCostoLlamadas() + (minutos * 80));
		saldoDisponible -= (minutos * 80);

	}

	/**
	 * Reinicia la línea telefónica, dejando todos sus valores en cero.
	 */
	public void reiniciar() {
		super.reiniciar();
		numeroMinutosLargaDistancia = 0;
	}

}
