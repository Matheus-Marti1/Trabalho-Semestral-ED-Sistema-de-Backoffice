package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Produto;

public class ProdutoController implements ActionListener {

	private JTextField tfProdutoCadastroNome;
	private JTextField tfProdutoCadastroValor;
	private JTextArea taProdutosCadastroDescricao;
	private JComboBox<Object> cbProdutosCadastroTipo;
	private JSpinner spProdutosCadastroQtd;
	private JTextField tfProdutoCodigo;
	private JComboBox<Object> cbProdutosConsultaTipo;
	private JList<Object> listaProdutosConsulta;

	public ProdutoController(JTextField tfCadastroProdutosNome, JTextField tfCadastroProdutosValor,
			JTextArea taProdutosCadastroDescricao1, JComboBox<Object> cbProdutosCadastroTipo,
			JSpinner spProdutosCadastroQtd, JTextField tfProdutosCadastroCodigo,
			JComboBox<Object> cbProdutosConsultaTipo, JList<Object> listaProdutosConsulta) {
		this.tfProdutoCadastroNome = tfCadastroProdutosNome;
		this.tfProdutoCadastroValor = tfCadastroProdutosValor;
		this.taProdutosCadastroDescricao = taProdutosCadastroDescricao1;
		this.cbProdutosCadastroTipo = cbProdutosCadastroTipo;
		this.spProdutosCadastroQtd = spProdutosCadastroQtd;
		this.tfProdutoCodigo = tfProdutosCadastroCodigo;
		this.cbProdutosConsultaTipo = cbProdutosConsultaTipo;
		this.listaProdutosConsulta = listaProdutosConsulta;

		try {
			carregarComboBoxConsulta();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Cadastrar produto")) {
			try {
				cadastro();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (cmd.equals("Consultar produtos")) {
			try {
				consulta();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		if (cmd.equals("Excluir produto selecionado")) {
			try {
				excluir();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (cmd.equals("Recarregar")) {
			try {
				carregarComboBox();
				carregarComboBoxConsulta();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

	public void cadastro() throws IOException {
		Produto prod = new Produto();
		prod.setNome(tfProdutoCadastroNome.getText());
		prod.setDescricao(taProdutosCadastroDescricao.getText());
		prod.setValor(Double.parseDouble(tfProdutoCadastroValor.getText()));
		prod.setQuantidadeEstoque((Integer) spProdutosCadastroQtd.getValue());

		String codIdent = tfProdutoCodigo.getText();
		String codIdentTipo = buscaIdTipo((String) cbProdutosCadastroTipo.getSelectedItem());
		String uniao = codIdentTipo + codIdent;
		int codIdentificador = Integer.parseInt(uniao);
		if (codigoExiste(codIdentificador)) {
			JOptionPane.showMessageDialog(null, "Código de Identificador já Cadastrado");
			return;
		}

		prod.setCodigo(codIdentificador);
		prod.setTipoProduto(Integer.parseInt(codIdentTipo));
		cadastraProduto(prod.toString());
		tfProdutoCadastroNome.setText("");
		tfProdutoCadastroValor.setText("");
		tfProdutoCodigo.setText("");
		taProdutosCadastroDescricao.setText("");
		spProdutosCadastroQtd.setValue(0);
		JOptionPane.showMessageDialog(null, "Produto " + prod.getNome() + " cadastrado com sucesso!");
	}

	private void carregarComboBox() throws IOException {
		String currentDirectory = new File(".").getCanonicalPath();
		String path = currentDirectory + File.separator + "SistemaBackoffice";
		File arq = new File(path, "tipoProduto.csv");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			cbProdutosCadastroTipo.removeAllItems();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				cbProdutosCadastroTipo.addItem(vetLinha[1]);
				linha = buffer.readLine();
			}
			buffer.close();
		}
	}

	private String buscaIdTipo(String cbProdutos) throws IOException {
		String cbValor = cbProdutos;
		// Obtém o caminho do diretório atual
		String currentDirectory = new File(".").getCanonicalPath();
		String path = currentDirectory + File.separator + "SistemaBackoffice";
		File arq = new File(path, "tipoProduto.csv");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				if (vetLinha[1].equals(cbValor)) {
					return vetLinha[0];
				}
				linha = buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
		}
		return null;
	}

	private boolean codigoExiste(int codIdentificador) throws IOException {
		String currentDirectory = new File(".").getCanonicalPath();
		String path = currentDirectory + File.separator + "SistemaBackoffice" + File.separator + "produto.csv";
		File arq = new File(path);
		if (!arq.exists()) {
			return false;
		}

		BufferedReader buffer = new BufferedReader(new FileReader(arq));
		String line;
		while ((line = buffer.readLine()) != null) {
			String[] parts = line.split(";");
			if (Integer.parseInt(parts[0]) == codIdentificador) {
				buffer.close();
				return true;
			}
		}
		buffer.close();
		return false;
	}

	private void cadastraProduto(String csvProduto) throws IOException {
		// Obtém o caminho do diretório atual
		String currentDirectory = new File(".").getCanonicalPath();
		String path = currentDirectory + File.separator + "SistemaBackoffice";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		File arq = new File(path, "produto.csv");
		boolean existe = false;
		if (arq.exists()) {
			existe = true;
		}
		FileWriter fw = new FileWriter(arq, existe);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(csvProduto + "\r\n");
		pw.flush();
		pw.close();
		fw.close();
	}

	private void carregarComboBoxConsulta() throws FileNotFoundException, IOException {
		String currentDirectory = new File(".").getCanonicalPath();
		String path = currentDirectory + File.separator + "SistemaBackoffice";
		File arq = new File(path, "tipoProduto.csv");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			cbProdutosConsultaTipo.removeAllItems();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				cbProdutosConsultaTipo.addItem(vetLinha[1]);
				linha = buffer.readLine();
			}
			buffer.close();
		}
	}

	private void consulta() throws IOException {
		String currentDirectory = new File(".").getCanonicalPath();
		String path = currentDirectory + File.separator + "SistemaBackoffice";
		File arq = new File(path, "produto.csv");
		String tipoProduto = buscaIdTipo((String) cbProdutosConsultaTipo.getSelectedItem());
		if (arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			DefaultListModel<Object> prodConsListModel = new DefaultListModel<>();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				if (vetLinha[5].equals(tipoProduto)) {
					prodConsListModel.addElement("Id: " + vetLinha[0] + "; Produto: " + vetLinha[1] + "; Valor: R$"
							+ vetLinha[2] + "; Descrição: " + vetLinha[3] + "; Quantidade em estoque: " + vetLinha[4]);
				}
				linha = buffer.readLine();
			}
			listaProdutosConsulta.setModel(prodConsListModel);
			buffer.close();
			isr.close();
			fis.close();
		}
	}

	private void excluir() throws IOException {
		String currentDirectory = new File(".").getCanonicalPath();
		String path = currentDirectory + File.separator + "SistemaBackoffice" + File.separator + "produto.csv";
		File arq = new File(path);
		if (arq.exists() && arq.isFile()) {
			ArrayList<String> produtosMantidos = new ArrayList<>();
			BufferedReader buffer = new BufferedReader(new FileReader(arq));
			String linha;
			String produtoAExcluir = (String) listaProdutosConsulta.getSelectedValue();
			String[] idProdutoAExcluir = produtoAExcluir.split("[:;]");
			for (int i = 0; i < idProdutoAExcluir.length; i++) {
				idProdutoAExcluir[i] = idProdutoAExcluir[i].trim();
			}
			// Lê cada linha do arquivo
			while ((linha = buffer.readLine()) != null) {
				String[] linhaProduto = linha.split(";");
				// Se o tipo do produto não corresponder ao tipo a ser excluído, adiciona à
				// lista de linhas mantidas
				if (!linhaProduto[0].equals(idProdutoAExcluir[1])) {
					produtosMantidos.add(linha);
				}

			}
			buffer.close();
			// Escreve as linhas mantidas de volta ao arquivo
			FileWriter fw = new FileWriter(arq);
			PrintWriter pw = new PrintWriter(fw);
			for (String linhaMantida : produtosMantidos) {
				pw.println(linhaMantida);
			}
			pw.close();
			fw.close();
			consulta();
		}
	}
}
