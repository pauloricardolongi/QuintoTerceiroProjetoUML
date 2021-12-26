package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Contrato;
import entidades.Prestacao;
import servico.ContratoServico;
import servico.PagamentoServico;

public class Programa {

	public static void main(String[] args)throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com dados do contrato");
		System.out.print(" número: ");
		Integer numero = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date data = sdf.parse(sc.next());
		System.out.print("Valor do contrato");
		Double valorTotal= sc.nextDouble();
		
		Contrato contrato= new Contrato(numero, data, valorTotal);
		
		System.out.print("Entre com o número de prestações");
		int N = sc.nextInt();		
		ContratoServico cs = new ContratoServico(new PagamentoServico());
		cs.processarContrato(contrato, N);
		
		System.out.println("PRESTAÇÕES: ");
		for(Prestacao it : contrato.getPrestacoes()) {
			System.out.println(it);
		}
		
		
		sc.close();

	}

}
