package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Prestacao {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date dataVencimento;
	private Double parcela;
	
	
	
	public Prestacao() {
		
	}

	public Prestacao(Date dataVencimento, Double parcela) {
		
		this.dataVencimento= dataVencimento;
		this.parcela = parcela;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getParcela() {
		return parcela;
	}

	public void setParcela(Double parcela) {
		this.parcela = parcela;
	}

	@Override
	public String toString() {
		return sdf.format(dataVencimento) + " - " + String.format("%.2f",parcela);
	}

	
}
