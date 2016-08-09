package modelCrud.dto;

public class Zivotinja {
	private int id;
	private String vrsta;
	private String kratakOpis;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVrsta() {
		return vrsta;
	}

	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}

	public String getKratakOpis() {
		return kratakOpis;
	}

	public void setKratakOpis(String kratakOpis) {
		this.kratakOpis = kratakOpis;
	}

	@Override
	public String toString() {
		return "Zivotinja [id=" + id + ", vrsta=" + vrsta + ", kratakOpis=" + kratakOpis + "]";
	}
	
	

}
