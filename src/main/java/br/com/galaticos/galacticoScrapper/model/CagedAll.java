package br.com.galaticos.galacticoScrapper.model;

public class CagedAll {
	private Caged caged;
	private CagedEmpresa cagedEmpresa;
	private CagedTrabalhador cagedTrabalhador;
	
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
