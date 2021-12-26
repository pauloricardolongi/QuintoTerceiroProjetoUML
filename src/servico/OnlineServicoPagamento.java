package servico;

public interface OnlineServicoPagamento {
	
	double taxaPagamento(double quantia);
	double juros(double quantia, int meses);
	
}
