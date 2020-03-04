package br.com.engi.negocio;

import java.util.Date;
import java.util.List;

import br.com.engi.dao.ChequeDAO;
import br.com.engi.domain.SituacaoCheque;
import br.com.engi.model.Cheque;
import br.com.engi.model.ChequeId;
import br.com.engi.model.Conta;
import br.com.engi.model.Lancamento;
import br.com.engi.util.DAOException;
import br.com.engi.util.RNException;


/**
 * Classe que efetuara as regras de negocio de cheque
 */
public class ChequeRN extends RN<Cheque> {
	
	public ChequeRN() {
		super(new ChequeDAO());
	}

	@Override
	public void salvar(Cheque cheque) throws RNException {
		
		try {
			dao.salvar(cheque);
		} catch (DAOException e) {
			throw new RNException(e);
		}
	}

	@Override
	public void excluir(Cheque cheque) throws RNException {
		// Só permite excluir cheques que estejam com a situação
		// Não emitido
		if (SituacaoCheque.N.equals(cheque.getSituacao())) {
			try {
				dao.excluir(cheque);
			} catch (DAOException e) {
				throw new RNException(e);
			}
		} else {
			throw new RNException("Não é possível excluir cheque, status não permitido para operação.");
		}
	}
	

	/**
	 * Método que salva uma sequencia de cheques (inicial e final)
	 */
	public int salvarSequencia(Conta conta, Integer chequeInicial, Integer chequeFinal) throws RNException {
		
		Cheque cheque = null;
		Cheque chequeVerifica = null;
		ChequeId chequeId = null;
		int contaTotal = 0;
		
		// Loop para salvar cheques de: chequeInicial até: chequeFinal
		for (int i = chequeInicial; i <= chequeFinal; i++) {
			chequeId = new ChequeId();
			chequeId.setCheque(i);
			chequeId.setConta(conta.getCodigo().intValue());
			
			/*
			 * Irá verificar se já não existe o cheque informado
			 * 
			 * Informa-se de 1 a 10, mas ja se tem os cheques 5 e 6 
			 */
//			Cheque chequeAux = new Cheque();
//			chequeAux.setChequeId(chequeId);
			try {
				chequeVerifica = obterPorId(new Cheque(chequeId));
			} catch (RNException e) {
				throw new RNException(e);
			}
			
			//Só insere caso o cheque não existe
			if (chequeVerifica == null) {
				cheque = new Cheque();
				cheque.setChequeId(chequeId);
				// Situação inicial: Não emitido
				cheque.setSituacao(SituacaoCheque.N);
				cheque.setDataCadastro(new Date(System.currentTimeMillis()));
				salvar(cheque);
				// Váriavel que vai informar ao final do processo
				// quantos cheques realmente foram inseridos,
				// eliminando-se os duplicados.
				contaTotal++;
			}
		}
		
		return contaTotal;
	}

	@Override
	public Cheque obterPorId(Cheque cheque) throws RNException {
		try {
			return dao.obterPorId(cheque);
		} catch (DAOException e) {
			throw new RNException(e);
		}
	}

	@Override
	public List<Cheque> pesquisar(Cheque filtros) throws RNException {
		try {
			return dao.pesquisar(filtros);
		} catch (DAOException e) {
			throw new RNException(e);
		}
	}
	
	public void cancelarCheque(Cheque cheque) throws RNException {
		
		// Só é possível cancelar cheques que não tenham sido emitidos
		if (SituacaoCheque.N.equals(cheque.getSituacao())) {
			cheque.setSituacao(SituacaoCheque.C);
			try {
				dao.salvar(cheque);
			} catch (DAOException e) {
				throw new RNException(e);
			}
		} else {
			throw new RNException("Não é possível cancelar cheque, status não permitido para operação.");
		}
	}
	
	/**
	 * Método chamado ao se UTILIZAR um cheque para um lançamento
	 */
	public void baixarCheque(ChequeId chequeId, Lancamento lancamento) throws RNException {
		Cheque chequeAux = new Cheque();
		chequeAux.setChequeId(chequeId);
		Cheque cheque = null;
		try {
			cheque = obterPorId(chequeAux);
		} catch (RNException e) {
			throw new RNException(e);
		}
		
		if (cheque != null) {
			// Baixar o cheque == alterar a situacao de Não Emitido para 
			// Baixado
			cheque.setSituacao(SituacaoCheque.B);
			cheque.setLancamento(lancamento);
			try {
				dao.salvar(cheque);
			} catch (DAOException e) {
				throw new RNException(e);
			}
		}
	}
	
	/**
	 * AO se alterar um lancamento e tirar o cheque
	 * deve-se passar o cheque para não emitido
	 */
	public void desvinculaLancamento(Conta conta, Integer numeroCheque) throws RNException {
		ChequeId chequeId = new ChequeId();
		chequeId.setCheque(numeroCheque);
		chequeId.setConta(conta.getCodigo().intValue());
		
		Cheque chequeAux = new Cheque();
		chequeAux.setChequeId(chequeId);
		Cheque cheque = null;
		try {
			cheque = obterPorId(chequeAux);
		} catch (RNException e) {
			throw new RNException(e);
		}
		
		if (SituacaoCheque.C.equals(cheque.getSituacao())) {
			throw new RNException("Não é possível usar cheque cancelado.");
		} else {
			cheque.setSituacao(SituacaoCheque.N);
			cheque.setLancamento(null);
			try {
				dao.salvar(cheque);
			} catch (DAOException e) {
				throw new RNException(e);
			}
		}
	}

}
