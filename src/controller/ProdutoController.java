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
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

import javax.swing.JTextField;

import model.Produto;
import model.TipoProduto;

public class ProdutoController implements ActionListener {

	private JTextField tfProdutoCadastroNome;
	private JTextField tfProdutoCadastroValor;
	private JTextArea taProdutosCadastroDescricao;
	private JComboBox<Object> cbProdutosCadastroTipo;
	private JSpinner spProdutosCadastroQtd;
	private JTextField tfProdutoCodigo;

	public ProdutoController(JTextField tfCadastroProdutosNome, JTextField tfCadastroProdutosValor,
			JTextArea taProdutosCadastroDescricao1, JComboBox<Object> cbProdutosCadastroTipo, JSpinner spProdutosCadastroQtd,
			JTextField tfProdutosCadastroCodigo) {
		this.tfProdutoCadastroNome = tfCadastroProdutosNome;
		this.tfProdutoCadastroValor = tfCadastroProdutosValor;
		this.taProdutosCadastroDescricao = taProdutosCadastroDescricao1;
		this.cbProdutosCadastroTipo = cbProdutosCadastroTipo;
		this.spProdutosCadastroQtd = spProdutosCadastroQtd;
		this.tfProdutoCodigo = tfProdutosCadastroCodigo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Cadastrar Produto")) {
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

		if (cmd.equals("Excluir tipo selecionado")) {
			try {
				excluir();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (cmd.equals("Recarregar")) {
			try {
				carregarComboBox();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

    public void cadastro() throws IOException {
        preencheComboBox();
        int codIdentificador = Integer.parseInt(tfProdutoCodigo.getText());
        if (codigoExiste(codIdentificador)) {
            JOptionPane.showMessageDialog(null, "Código de Identificador já Cadastrado");
            return;
        }

        Produto prod = new Produto();
        prod.setCodigo(codIdentificador);
        
        prod.setDescricao(taProdutosCadastroDescricao.getText());
        prod.setCodigo(1);
        prod.setNome("a");
        prod.setValor(1.0);
        prod.setQuantidadeEstoque(10);
        prod.setTipoProduto(0);
        

        cadastraProduto(prod.toString());
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

    private List<TipoProduto> listarTipoProduto() throws FileNotFoundException, IOException {
        //Criação da lista de objetos TipoProduto
        List<TipoProduto> listaTipos = new ArrayList<>();

        // Obtém o caminho do diretório atual
        String currentDirectory = new File(".").getCanonicalPath();
        String path = currentDirectory + File.separator + "SistemaBackoffice";
        File arq = new File(path, "produto.csv");
        if (arq.exists() && arq.isFile()) {
            FileInputStream fis = new FileInputStream(arq);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader buffer = new BufferedReader(isr);
            String linha = buffer.readLine();
            while (linha != null) {
                TipoProduto tipoProd = new TipoProduto();
                String[] vetLinha = linha.split(";");
                tipoProd.setNome(vetLinha[0]);
                tipoProd.setCodIdentificador(Integer.parseInt(vetLinha[1]));
                tipoProd.setDescricao(vetLinha[2]);
                listaTipos.add(tipoProd);
                linha = buffer.readLine();
            }
            buffer.close();
            isr.close();
            fis.close();
		}
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

	private void consulta() throws IOException {

	}

	private Produto buscaProduto(Produto prod) throws IOException {
		return null;
	}

	private void excluir() throws IOException {

	}

}
