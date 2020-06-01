package modelo;

public class Paciente {
	private String folioPaciente;
	private String nomPaciente;
	private String primApPa;
	private String SegApPa;
	private String domicilio;
	private String numeroCel;
	
	public Paciente() {}

	public Paciente(String folioPaciente, String nomPaciente, String primApPa, String segApPa, String domicilio,
			String numeroCel) {
		super();
		this.folioPaciente = folioPaciente;
		this.nomPaciente = nomPaciente;
		this.primApPa = primApPa;
		SegApPa = segApPa;
		this.domicilio = domicilio;
		this.numeroCel = numeroCel;
	}

	public String getFolioPaciente() {
		return folioPaciente;
	}

	public void setFolioPaciente(String folioPaciente) {
		this.folioPaciente = folioPaciente;
	}

	public String getNomPaciente() {
		return nomPaciente;
	}

	public void setNomPaciente(String nomPaciente) {
		this.nomPaciente = nomPaciente;
	}

	public String getPrimApPa() {
		return primApPa;
	}

	public void setPrimApPa(String primApPa) {
		this.primApPa = primApPa;
	}

	public String getSegApPa() {
		return SegApPa;
	}

	public void setSegApPa(String segApPa) {
		SegApPa = segApPa;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getNumeroCel() {
		return numeroCel;
	}

	public void setNumeroCel(String numeroCel) {
		this.numeroCel = numeroCel;
	}

	@Override
	public String toString() {
		return "Paciente [folioPaciente=" + folioPaciente + ", nomPaciente=" + nomPaciente + ", primApPa=" + primApPa
				+ ", SegApPa=" + SegApPa + ", domicilio=" + domicilio + ", numeroCel=" + numeroCel + "]";
	}

	
	
	

}
