package br.com.galaticos.galacticoScrapper.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cagedAll")
public class CagedAll {

	@Id
	private String id;
	private Caged caged;
	private CagedEmpresa cagedEmpresa;
	private CagedTrabalhador cagedTrabalhador;

	public CagedAll() {
		super();
	}

	public CagedAll(Caged caged, CagedTrabalhador cagedTrabalhador) {
		super();
		this.caged = caged;
		this.cagedTrabalhador = cagedTrabalhador;
	}

	public CagedAll(Caged caged, CagedEmpresa cagedEmpresa) {
		super();
		this.caged = caged;
		this.cagedEmpresa = cagedEmpresa;
	}

	public CagedAll(Caged caged, CagedEmpresa cagedEmpresa, CagedTrabalhador cagedTrabalhador) {
		super();
		this.caged = caged;
		this.cagedEmpresa = cagedEmpresa;
		this.cagedTrabalhador = cagedTrabalhador;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Caged getCaged() {
		return caged;
	}

	public void setCaged(Caged caged) {
		this.caged = caged;
	}

	public CagedEmpresa getCagedEmpresa() {
		return cagedEmpresa;
	}

	public void setCagedEmpresa(CagedEmpresa cagedEmpresa) {
		this.cagedEmpresa = cagedEmpresa;
	}

	public CagedTrabalhador getCagedTrabalhador() {
		return cagedTrabalhador;
	}

	public void setCagedTrabalhador(CagedTrabalhador cagedTrabalhador) {
		this.cagedTrabalhador = cagedTrabalhador;
	}

	@Override
	public String toString() {
		return "CagedAll [caged=" + caged + ", cagedEmpresa=" + cagedEmpresa + ", cagedTrabalhador=" + cagedTrabalhador
				+ "]";
	}

}
