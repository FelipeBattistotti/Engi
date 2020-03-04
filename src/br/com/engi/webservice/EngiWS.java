package br.com.engi.webservice;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import br.com.engi.dao.DAO2;
import br.com.engi.model.FatoFaturaContrat;
import br.com.engi.model.FatoMovInsuPrestador;
import br.com.engi.model.FatoMoviprocPrestador;

@WebService
public class EngiWS {
	
	@WebMethod
	public List<FatoFaturaContrat> findFatoFaturaContrat(@WebParam(name="nomeContratante") String nomeContratante,
														 @WebParam(name="nrMes1") Integer nrMes1,
														 @WebParam(name="nrAno1") Integer nrAno1,
														 @WebParam(name="nrMes2") Integer nrMes2,
														 @WebParam(name="nrAno2") Integer nrAno2) {
		
		List<FatoFaturaContrat> fatoFaturaContratList1 = new ArrayList<FatoFaturaContrat>();
		List<FatoFaturaContrat> fatoFaturaContratList2 = new ArrayList<FatoFaturaContrat>();
		List<FatoFaturaContrat> fatoFaturaContratList  = new ArrayList<FatoFaturaContrat>();
		DAO2 dao2 = new DAO2();
		
		/** realiza consulta - chama classe DAO **/
		fatoFaturaContratList1 = dao2.consultaFaturamentoTotal(nomeContratante, nrMes1, nrAno1); // 01/2016
		fatoFaturaContratList2 = dao2.consultaFaturamentoTotal(nomeContratante, nrMes2, nrAno2); // 01/2017
		
		fatoFaturaContratList.addAll(fatoFaturaContratList1);
		fatoFaturaContratList.addAll(fatoFaturaContratList2);
		
		return fatoFaturaContratList;
	}
	
	@WebMethod
	public List<FatoMoviprocPrestador> findFatoMoviprocPrestador(@WebParam(name="nomePrestador") String nomePrestador,
																 @WebParam(name="nrMes1") Integer nrMes1,
																 @WebParam(name="nrAno1") Integer nrAno1,
																 @WebParam(name="nrMes2") Integer nrMes2,
																 @WebParam(name="nrAno2") Integer nrAno2) {
		
		List<FatoMoviprocPrestador> fatoMoviprocPrestadorList1 = new ArrayList<FatoMoviprocPrestador>();
		List<FatoMoviprocPrestador> fatoMoviprocPrestadorList2 = new ArrayList<FatoMoviprocPrestador>();
		List<FatoMoviprocPrestador> fatoMoviprocPrestadorList  = new ArrayList<FatoMoviprocPrestador>();
		DAO2 dao2 = new DAO2();
		
		/** realiza consulta - chama classe DAO **/
		fatoMoviprocPrestadorList1 = dao2.consultaTotalGlosaProc(nomePrestador, nrMes1, nrAno1); // 01/2016
	    fatoMoviprocPrestadorList2 = dao2.consultaTotalGlosaProc(nomePrestador, nrMes2, nrAno2); // 01/2017
		
	    fatoMoviprocPrestadorList.addAll(fatoMoviprocPrestadorList1);
	    fatoMoviprocPrestadorList.addAll(fatoMoviprocPrestadorList2);
		
		return fatoMoviprocPrestadorList;
	}
	
	@WebMethod
	public List<FatoMovInsuPrestador> findFatoMovinsuPrestador(@WebParam(name="nomePrestador") String nomePrestador,
															   @WebParam(name="nrMes1") Integer nrMes1,
															   @WebParam(name="nrAno1") Integer nrAno1,
															   @WebParam(name="nrMes2") Integer nrMes2,
															   @WebParam(name="nrAno2") Integer nrAno2) {
		
		List<FatoMovInsuPrestador> fatoMovInsuPrestadorList1 = new ArrayList<FatoMovInsuPrestador>();
		List<FatoMovInsuPrestador> fatoMovInsuPrestadorList2 = new ArrayList<FatoMovInsuPrestador>();
		List<FatoMovInsuPrestador> fatoMovInsuPrestadorList  = new ArrayList<FatoMovInsuPrestador>();
		DAO2 dao2 = new DAO2();
		
		/** realiza consulta - chama classe DAO **/
		fatoMovInsuPrestadorList1 = dao2.consultaTotalGlosaInsu(nomePrestador, nrMes1, nrAno1); // 01/2016
	    fatoMovInsuPrestadorList2 = dao2.consultaTotalGlosaInsu(nomePrestador, nrMes2, nrAno2); // 01/2017
		
	    fatoMovInsuPrestadorList.addAll(fatoMovInsuPrestadorList1);
	    fatoMovInsuPrestadorList.addAll(fatoMovInsuPrestadorList2);
		
		return fatoMovInsuPrestadorList;
	}
	
}