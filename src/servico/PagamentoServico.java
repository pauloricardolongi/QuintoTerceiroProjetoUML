package servico;

public class PagamentoServico implements OnlineServicoPagamento{

	private static final double TAXA_PAGAMENTO = 0.02;
	private static final double JURO_MENSAL = 0.01;
	@Override
	public double taxaPagamento(double quantia) {
		
		return quantia * TAXA_PAGAMENTO;
	}

	@Override
	public double juros(double quantia, int meses) {
		
		return quantia * meses * JURO_MENSAL;
	}
	

}
