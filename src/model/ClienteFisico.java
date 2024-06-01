package model;

public class ClienteFisico extends Cliente {
	private String cpf;
	private String celular;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	@Override
	public String toString() {
		return getCpf() + ";" + getNome() + ";" + getEndereco() + ";" + getNumero() + ";" + getComplemento() + ";" + getCep() + ";" + getCelular();
	}
		
}
