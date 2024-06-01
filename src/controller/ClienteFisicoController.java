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

import model.ClienteFisico;

public class ClienteFisicoController implements ActionListener {

	private JTextField tfClienteFisicoNome;
	private JTextField tfClienteFisicoCpf;
	private JTextField tfClienteFisicoEndereco;
	private JTextField tfClienteFisicoNumero;
	private JTextField tfClienteFisicoComplemento;
	private JTextField tfClienteFisicoCep;
	private JTextField tfClienteFisicoCelular;
	private JTextArea taClienteFisico;

	public ClienteFisicoController(JTextField tfClienteFisicoNome, JTextField tfClienteFisicoCpf,
			JTextField tfClienteFisicoEndereco, JTextField tfClienteFisicoNumero, JTextField tfClienteFisicoComplemento,
			JTextField tfClienteFisicoCep, JTextField tfClienteFisicoCelular, JTextArea taClienteFisico) {
		this.tfClienteFisicoNome = tfClienteFisicoNome;
		this.tfClienteFisicoCpf = tfClienteFisicoCpf;
		this.tfClienteFisicoEndereco = tfClienteFisicoEndereco;
		this.tfClienteFisicoNumero = tfClienteFisicoNumero;
		this.tfClienteFisicoComplemento = tfClienteFisicoComplemento;
		this.tfClienteFisicoCep = tfClienteFisicoCep;
		this.tfClienteFisicoCelular = tfClienteFisicoCelular;
		this.taClienteFisico = taClienteFisico;
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
		ClienteFisico clienteF = new ClienteFisico();
		clienteF.setNome(tfClienteFisicoNome.getText());
		clienteF.setCpf(tfClienteFisicoCpf.getText());
		clienteF.setEndereco(tfClienteFisicoEndereco.getText());
		clienteF.setNumero(tfClienteFisicoNumero.getText());
		clienteF.setComplemento(tfClienteFisicoComplemento.getText());
		clienteF.setCep(tfClienteFisicoCep.getText());
		clienteF.setCelular(tfClienteFisicoCelular.getText());

		cadastraClienteFisico(clienteF.toString());
		tfClienteFisicoNome.setText("");
		tfClienteFisicoCpf.setText("");
		tfClienteFisicoEndereco.setText("");
		tfClienteFisicoNumero.setText("");
		tfClienteFisicoComplemento.setText("");
		tfClienteFisicoCep.setText("");
		tfClienteFisicoCelular.setText("");
		taClienteFisico.setText("Cliente " + clienteF.getNome() + " cadastrado com sucesso!");

	}

	private void cadastraClienteFisico(String csvClienteFisico) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "SistemaBackoffice";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		File arq = new File(path, "clienteFisico.csv");
		boolean existe = false;
		if (arq.exists()) {
			existe = true;
		}
		FileWriter fw = new FileWriter(arq, existe);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(csvClienteFisico + "\r\n");
		pw.flush();
		pw.close();
		fw.close();

	}

	private void consulta() throws IOException {
		ClienteFisico clienteF = new ClienteFisico();
		clienteF.setCpf(tfClienteFisicoCpf.getText());

		clienteF = buscaCliente(clienteF);
		if (clienteF.getNome() != null) {
			taClienteFisico.setText(" - Nome: " + clienteF.getNome() + "\r\n" + " - CPF: " + clienteF.getCpf() + "\r\n"
					+ " - Endereco: " + clienteF.getEndereco() + "\r\n" + " - Numero: " + clienteF.getNumero() + "\r\n"
					+ " - Complemento: " + clienteF.getComplemento() + "\r\n" + " - CEP: " + clienteF.getCep() + "\r\n"
					+ " - Celular: " + clienteF.getCelular());
		} else {
			taClienteFisico.setText("Cliente não encontrado");
		}
	}

	private ClienteFisico buscaCliente(ClienteFisico clienteF) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "SistemaBackoffice";
		File arq = new File(path, "clienteFisico.csv");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				if (vetLinha[0].equals(clienteF.getCpf())) {
					clienteF.setNome(vetLinha[1]);
					clienteF.setEndereco(vetLinha[2]);
					clienteF.setNumero(vetLinha[3]);
					clienteF.setComplemento(vetLinha[4]);
					clienteF.setCep(vetLinha[5]);
					clienteF.setCelular(vetLinha[6]);
					break;
				}
				linha = buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
		}
		return clienteF;
	}

	private void excluir() throws IOException {
		String path = System.getProperty("user.home") + File.separator + "SistemaBackoffice";
		File arq = new File(path, "clienteFisico.csv");
		File temp = new File(path, "clienteFisicoTemp.csv");
		BufferedReader buffer = new BufferedReader(new FileReader(arq));
		PrintWriter pw = new PrintWriter(new FileWriter(temp));
		String clienteAExcluir = tfClienteFisicoCpf.getText();
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
			taClienteFisico.setText("Cliente excluido com sucesso");
		} else {
			taClienteFisico.setText("Cliente não encontrado");
		}
		
	}
}
