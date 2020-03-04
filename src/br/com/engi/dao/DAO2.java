package br.com.engi.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import br.com.engi.util.HibernateUtil;
import br.com.engi.model.Chart;
import br.com.engi.model.FatoFaturaContrat;
import br.com.engi.model.FatoMovInsuPrestador;
import br.com.engi.model.FatoMoviprocPrestador;
import br.com.engi.model.FatoVlbenefFatura;
import br.com.engi.model.Usuario;

public class DAO2 {
	private Session session;
	
	public DAO2() {
		session = HibernateUtil.getSessionFactory().openSession();
	}
	
	public void commit(){
		session.getTransaction().commit();
	}
	
	public void begin(){
		session.getTransaction().begin();
	}
	
	public void finalizaTransacao(){
		session.close();
	}
	
	public void salvar(Usuario usuario) {
		this.session.save(usuario);
	}
	
	public void salvar(Chart chart) {
		Chart chartDel = new Chart();
		chartDel = this.buscarPorChart(1);
		
		this.begin();
		
		if (chartDel != null) {
			this.session.delete(chartDel);
		}
		
		this.session.save(chart);
		this.commit();
	}

	public void atualizar(Usuario usuario) {

		if (usuario.getPermissao() == null || usuario.getPermissao().size() == 0) {
			Usuario usuarioPermissao = this.carregar(usuario.getCodigo());
			usuario.setPermissao(usuarioPermissao.getPermissao());
			this.session.evict(usuarioPermissao);
		}
		
		this.session.update(usuario);
	}

	public Usuario carregar(Integer codigo) {
		return (Usuario) this.session.get(Usuario.class, codigo);
	}

	public Usuario buscarPorLogin(String login) {
		String hql = "select u from Usuario u where u.login = :login";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("login", login);

		return (Usuario) consulta.uniqueResult();
	}
	
	public Chart buscarPorChart(Integer codigo) {
		String hql = "select c from Chart c where c.codigo = :codigo";
		Query consulta = this.session.createQuery(hql);
		consulta.setInteger("codigo", codigo);

		return (Chart) consulta.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<FatoFaturaContrat> consultaFaturamentoTotal(String nmContratante, Integer nrMes, Integer nrAno) {
		
		String hql = "select fc from FatoFaturaContrat fc where fc.nmContratante LIKE '%"+nmContratante+"%'"
				                                         + "and MONTH(fc.dtEmissao) =  "+nrMes+""
		                                                 + "and YEAR(fc.dtEmissao)  =  "+nrAno+"";
		Query consulta = this.session.createQuery(hql);
		
		return (List<FatoFaturaContrat>) consulta.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<FatoMoviprocPrestador> consultaTotalGlosaProc(String nmPrestador, Integer nrMes, Integer nrAno) {
		
		String hql = "select fp from FatoMoviprocPrestador fp where fp.nmPrestador LIKE '%"+nmPrestador+"%'"
				                                             + "and MONTH(fp.dtRealizacao) = "+nrMes+""
		                                                     + "and YEAR(fp.dtRealizacao)  = "+nrAno+"";
		Query consulta = this.session.createQuery(hql);
		
		return (List<FatoMoviprocPrestador>) consulta.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<FatoMovInsuPrestador> consultaTotalGlosaInsu(String nmPrestador, Integer nrMes, Integer nrAno) {
		
		String hql = "select fi from FatoMovInsuPrestador fi where fi.nmPrestador LIKE '%"+nmPrestador+"%'"
				                                            + "and MONTH(fi.dtRealizacao) = "+nrMes+""
		                                                    + "and YEAR(fi.dtRealizacao)  = "+nrAno+"";
		Query consulta = this.session.createQuery(hql);
		
		return (List<FatoMovInsuPrestador>) consulta.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<FatoVlbenefFatura> consultaPremio(Integer nrMes, Integer nrAno) {
		
		String hql = "select ff from FatoVlbenefFatura ff where ff.mmReferencia = "+nrMes+""
		                                                 + "and ff.aaReferencia = "+nrAno+""
														 + "and ff.nrFatura <> 0";
		Query consulta = this.session.createQuery(hql);
		
		return (List<FatoVlbenefFatura>) consulta.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<FatoVlbenefFatura> consultaSinistro(Integer nrMes, Integer nrAno) {
		
		String hql = "select ff from FatoVlbenefFatura ff where ff.mmReferencia = "+nrMes+""
		                                                 + "and ff.aaReferencia = "+nrAno+""
														 + "and ff.nrFatura     = 0";
		Query consulta = this.session.createQuery(hql);
		
		return (List<FatoVlbenefFatura>) consulta.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<FatoVlbenefFatura> consultaSinistroFaixa(Integer nrMes, Integer nrAno, Integer nrFaixa) {
		
		String hql = "select ff from FatoVlbenefFatura ff where ff.mmReferencia  = "+nrMes+""
		                                                 + "and ff.aaReferencia  = "+nrAno+""
		                                                 + "and ff.nrFaixaEtaria = "+nrFaixa+""
														 + "and ff.nrFatura      = 0";
		Query consulta = this.session.createQuery(hql);
		
		return (List<FatoVlbenefFatura>) consulta.list();
	}
	
}
