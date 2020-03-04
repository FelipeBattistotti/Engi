package br.com.engi.negocio;

import java.util.Date;
import java.util.List;

import br.com.engi.dao.LancamentoDAO;
import br.com.engi.model.Conta;
import br.com.engi.model.Lancamento;
import br.com.engi.util.DAOException;
import br.com.engi.util.RNException;

public class LancamentoRN extends RN<Lancamento> {
	
	public LancamentoRN() {
		super(new LancamentoDAO());
	}

	@Override
	public void salvar(Lancamento model) throws RNException {
		try {
			dao.salvar(model);
		} catch (DAOException e) {
			throw new RNException(e);
		}
	}

	@Override
	public void excluir(Lancamento lancamento) throws RNException {
		try {
			// CASO TENHA UM CHEQUE RELACIONADO AO MESMO
			// IRÁ DESVINCULAR ESTE CHEQUE....
			if(lancamento.getCheque() != null){
				ChequeRN crn = new ChequeRN();
				crn.desvinculaLancamento(lancamento.getConta(), 
										 lancamento.getCheque().getChequeId().getCheque()
										 );
			}
			dao.excluir(lancamento);
		} catch (DAOException e) {
			throw new RNException(e);
		}
	}

	@Override
	public Lancamento obterPorId(Lancamento filtro) throws RNException {
		try {
			return dao.obterPorId(filtro);
		} catch (DAOException e) {
			throw new RNException(e);
		}
	}

	@Override
	public List<Lancamento> pesquisar(Lancamento filtros) throws RNException {
		try {
			return dao.pesquisar(filtros);
		} catch (DAOException e) {
			throw new RNException(e);
		}
	}
	
	public List<Lancamento> pesquisar(Conta c, Date dtInicio, Date dtFim) throws RNException {
		
//		LancamentoDAO ldao = (LancamentoDAO) dao;
//		ldao.pesquisar(c, dtInicio, dtFim);
		
		try {
			return ((LancamentoDAO)dao).pesquisar(c, dtInicio, dtFim);
		} catch (DAOException e) {
			throw new RNException(e);
		}
	}

	public float saldo(Conta conta, Date data) {
		float saldoInicial = conta.getSaldoInicial();
		float saldoNaData = ((LancamentoDAO) dao).saldo(conta, data);
		return saldoInicial + saldoNaData;
	}

}



















