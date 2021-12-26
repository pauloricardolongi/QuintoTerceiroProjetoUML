package servico;

import java.util.Calendar;
import java.util.Date;

import entidades.Contrato;
import entidades.Prestacao;

public class ContratoServico {
	
	private OnlineServicoPagamento onlineServicoPagamento;

	//injeção de dependência pelo construtor
	public ContratoServico(OnlineServicoPagamento onlineServicoPagamento) {		
		this.onlineServicoPagamento = onlineServicoPagamento;
	}
	
	//operação responsável por instanciar os objetos que serão as parcelas do contrato
	
	public void processarContrato(Contrato contrato, int meses) {		
		//parcela basia 600/3= 200
		double parcelaBasica = contrato.getValorTotal()/meses;
		//parcelaBasica = 200
		for (int i=1; i<= meses; i++) {
			/*i=1 ->  juro 1% de 200 =2 -> 202 -> 202 + 2% = 206,04
			 * i = 2 -> 200 x 1% + 2% */
			double taxaAtualizada = parcelaBasica + onlineServicoPagamento.juros(parcelaBasica, i);
			double fulQuota = taxaAtualizada + onlineServicoPagamento.taxaPagamento(taxaAtualizada);
			Date dataVencimento= addMeses(contrato.getData(), i);
			contrato.getPrestacoes().add(new Prestacao(dataVencimento, fulQuota));
		}
	}
	private Date addMeses(Date data, int N) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(Calendar.MONTH, N);
		return calendar.getTime();
	}
	
}
