package modelo;

public class Doctores {
	private String cedProf;
	private String nombreDoc;
	private String pApDoc;
	private String sApDoc;
	private String especialidad;
	
	public Doctores() {}

	public Doctores(String cedProf, String nombreDoc, String pApDoc, String sApDoc, String especialidad) {
		super();
		this.cedProf = cedProf;
		this.nombreDoc = nombreDoc;
		this.pApDoc = pApDoc;
		this.sApDoc = sApDoc;
		this.especialidad = especialidad;
	}

	public String getCedProf() {
		return cedProf;
	}

	public void setCedProf(String cedProf) {
		this.cedProf = cedProf;
	}

	public String getNombreDoc() {
		return nombreDoc;
	}

	public void setNombreDoc(String nombreDoc) {
		this.nombreDoc = nombreDoc;
	}

	public String getpApDoc() {
		return pApDoc;
	}

	public void setpApDoc(String pApDoc) {
		this.pApDoc = pApDoc;
	}

	public String getsApDoc() {
		return sApDoc;
	}

	public void setsApDoc(String sApDoc) {
		this.sApDoc = sApDoc;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return "Doctores [cedProf=" + cedProf + ", nombreDoc=" + nombreDoc + ", pApDoc=" + pApDoc + ", sApDoc=" + sApDoc
				+ ", especialidad=" + especialidad + "]";
	}
	
	

}
