package br.com.wamais.houseCare.service;

import br.com.wamais.houseCare.domain.Fatura;

public interface IFaturaService extends ICrudService<Fatura, Integer> {

	Fatura faturar(Integer idEmpresa, Integer idCliente, Fatura fatura);

}
