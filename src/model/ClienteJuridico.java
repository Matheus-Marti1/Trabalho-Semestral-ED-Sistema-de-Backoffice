package model;

public class ClienteJuridico extends Cliente {
	private String cnpj;
	private String telefone;
	private String email;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return getCnpj() + ";" + getNome() + ";" + getEndereco() + ";" + getNumero() + ";" + getComplemento() + ";"
				+ getCep() + ";" + getTelefone() + ";" + getEmail();
	}
}
