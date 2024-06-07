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
        if (cmd.equals("Cadastrar produto")) {
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
        Produto prod = new Produto();
        prod.setNome(tfProdutoCadastroNome.getText());
        prod.setDescricao(taProdutosCadastroDescricao.getText());
        prod.setValor(Double.parseDouble(tfProdutoCadastroValor.getText()));
        prod.setQuantidadeEstoque((Integer) spProdutosCadastroQtd.getValue());
        
        String codIdent = tfProdutoCodigo.getText();
        String codIdentTipo = buscaIdTipo();
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
    
    private String buscaIdTipo() throws IOException {
        String cbValor = cbProdutosCadastroTipo.getSelectedItem().toString();
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

    private void consulta() throws IOException {

    }

    private Produto buscaProduto(Produto prod) throws IOException {
        return null;
    }

    private void excluir() throws IOException {

    }

    

}
