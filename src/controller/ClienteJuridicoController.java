package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.ClienteJuridico;

public class ClienteJuridicoController implements ActionListener {
	private JTextField tfClienteJuridicoNome;
	private JTextField tfClienteJuridicoCnpj;
	private JTextField tfClienteJuridicoEndereco;
	private JTextField tfClienteJuridicoNumero;
	private JTextField tfClienteJuridicoComplemento;
	private JTextField tfClienteJuridicoCep;
	private JTextField tfClienteJuridicoTelefone;
	private JTextField tfClienteJuridicoEmail;
	private JTextArea taClienteJuridico;
	
	

	public ClienteJuridicoController(JTextField tfClienteJuridicoNome, JTextField tfClienteJuridicoCnpj,
			JTextField tfClienteJuridicoEndereco, JTextField tfClienteJuridicoNumero,
			JTextField tfClienteJuridicoComplemento, JTextField tfClienteJuridicoCep,
			JTextField tfClienteJuridicoTelefone, JTextField tfClienteJuridicoEmail, JTextArea taClienteJuridico) {
		super();
		this.tfClienteJuridicoNome = tfClienteJuridicoNome;
		this.tfClienteJuridicoCnpj = tfClienteJuridicoCnpj;
		this.tfClienteJuridicoEndereco = tfClienteJuridicoEndereco;
		this.tfClienteJuridicoNumero = tfClienteJuridicoNumero;
		this.tfClienteJuridicoComplemento = tfClienteJuridicoComplemento;
		this.tfClienteJuridicoCep = tfClienteJuridicoCep;
		this.tfClienteJuridicoTelefone = tfClienteJuridicoTelefone;
		this.tfClienteJuridicoEmail = tfClienteJuridicoEmail;
		this.taClienteJuridico = taClienteJuridico;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Cadastrar")) {
			try {
				cadastro();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (cmd.equals("Consultar")) {
			try {
				consulta();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (cmd.equals("Excluir")) {
			try {
				excluir();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

	private void cadastro() throws IOException {
		ClienteJuridico clienteJ = new ClienteJuridico();
		clienteJ.setNome(tfClienteJuridicoNome.getText());
		clienteJ.setCnpj(tfClienteJuridicoCnpj.getText());
		clienteJ.setEndereco(tfClienteJuridicoEndereco.getText());
		clienteJ.setNumero(tfClienteJuridicoNumero.getText());
		clienteJ.setComplemento(tfClienteJuridicoComplemento.getText());
		clienteJ.setCep(tfClienteJuridicoCep.getText());
		clienteJ.setTelefone(tfClienteJuridicoTelefone.getText());
		clienteJ.setEmail(tfClienteJuridicoEmail.getText());

		cadastraClienteJuridico(clienteJ.toString());
		tfClienteJuridicoNome.setText("");
		tfClienteJuridicoCnpj.setText("");
		tfClienteJuridicoEndereco.setText("");
		tfClienteJuridicoNumero.setText("");
		tfClienteJuridicoComplemento.setText("");
		tfClienteJuridicoCep.setText("");
		tfClienteJuridicoTelefone.setText("");
		tfClienteJuridicoEmail.setText("");
		taClienteJuridico.setText("Cliente " + clienteJ.getNome() + " cadastrado com sucesso!");

	}

	private void cadastraClienteJuridico(String csvClienteJuridico) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "SistemaBackoffice";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		File arq = new File(path, "clienteJuridico.csv");
		boolean existe = false;
		if (arq.exists()) {
			existe = true;
		}
		FileWriter fw = new FileWriter(arq, existe);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(csvClienteJuridico + "\r\n");
		pw.flush();
		pw.close();
		fw.close();

	}

	private void consulta() throws IOException {
		ClienteJuridico clienteJ = new ClienteJuridico();
		clienteJ.setCnpj(tfClienteJuridicoCnpj.getText());

		clienteJ = buscaCliente(clienteJ);
		if (clienteJ.getNome() != null) {
			taClienteJuridico.setText(" - Nome: " + clienteJ.getNome() + "\r\n" + " - CNPJ: " + clienteJ.getCnpj()
					+ "\r\n" + " - Endereco: " + clienteJ.getEndereco() + "\r\n" + " - Numero: " + clienteJ.getNumero()
					+ "\r\n" + " - Complemento: " + clienteJ.getComplemento() + "\r\n" + " - CEP: " + clienteJ.getCep()
					+ "\r\n" + " - Telefone: " + clienteJ.getTelefone() + "\r\n" + " - E-mail: " + clienteJ.getEmail());
		} else {
			taClienteJuridico.setText("Cliente não encontrado");
		}
	}

	private ClienteJuridico buscaCliente(ClienteJuridico clienteJ) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "SistemaBackoffice";
		File arq = new File(path, "clienteJuridico.csv");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				if (vetLinha[0].equals(clienteJ.getCnpj())) {
					clienteJ.setNome(vetLinha[1]);
					clienteJ.setEndereco(vetLinha[2]);
					clienteJ.setNumero(vetLinha[3]);
					clienteJ.setComplemento(vetLinha[4]);
					clienteJ.setCep(vetLinha[5]);
					clienteJ.setTelefone(vetLinha[6]);
					clienteJ.setEmail(vetLinha[7]);
					break;
				}
				linha = buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
		}
		return clienteJ;
	}

	private void excluir() throws IOException {
		String path = System.getProperty("user.home") + File.separator + "SistemaBackoffice";
		File arq = new File(path, "clienteJuridico.csv");
		File temp = new File(path, "clienteJuridicoTemp.csv");
		BufferedReader buffer = new BufferedReader(new FileReader(arq));
		PrintWriter pw = new PrintWriter(new FileWriter(temp));
		String clienteAExcluir = tfClienteJuridicoCnpj.getText();
		String linha = buffer.readLine();
		boolean clienteExiste = false;
		while (linha != null) {
			String[] vetLinha = linha.split(";");
			if (!vetLinha[0].equals(clienteAExcluir)) {
				pw.println(linha);
			} else {
				clienteExiste = true;
			}
			linha = buffer.readLine();
		}
		pw.flush();
		pw.close();
		buffer.close();
		arq.delete();
		temp.renameTo(arq);
		if (clienteExiste) {
			taClienteJuridico.setText("Cliente excluido com sucesso");
		} else {
			taClienteJuridico.setText("Cliente não encontrado");
		}

	}
}
