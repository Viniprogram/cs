package com.kodq.cursomc.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.kodq.cursomc.domain.PagamentoComBoleto;

//Classe temporária para substituir web service responsável por gerar o boleto (Aula 53)
@Service
public class BoletoService {
	
	//Método programa data de vencimento do boleto para 7 dias após data atual (Aula 53)
	public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instanteDoPedido) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDataVencimento(cal.getTime());
	}

}
