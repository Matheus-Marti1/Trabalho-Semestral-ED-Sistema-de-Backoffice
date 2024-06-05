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
    private JComboBox cbProdutosCadastroTipo;
    private JSpinner spProdutosCadastroQtd;
    private JTextField tfProdutoCodigo;

    public ProdutoController(JTextField tfCadastroProdutosNome, JTextField tfCadastroProdutosValor, JTextArea taProdutosCadastroDescricao1, JComboBox cbProdutosCadastroTipo1, JSpinner spProdutosCadastroQtd1, JTextField tfProdutosCadastroCodigo) {
        this.tfProdutoCadastroNome = tfCadastroProdutosNome;
        this.tfProdutoCadastroValor = tfCadastroProdutosValor;
        this.taProdutosCadastroDescricao = taProdutosCadastroDescricao1;
        this.cbProdutosCadastroTipo = cbProdutosCadastroTipo1;
        this.spProdutosCadastroQtd = spProdutosCadastroQtd1;
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

    }

    private void cadastro() throws IOException {
        List<TipoProduto> listaTipos = new ArrayList<>();
        listaTipos = listarTipoProduto();
        
        //Remove todos os dados do comboboc
        cbProdutosCadastroTipo.removeAll();
        
        for(TipoProduto tP : listaTipos) {
            cbProdutosCadastroTipo.addItem(tP);
        }
        
    }

    private List<TipoProduto> listarTipoProduto() throws FileNotFoundException, IOException {
        //Criação da lista de objetos TipoProduto
        List<TipoProduto> listaTipos = new ArrayList<>();

        TipoProduto tipoProd = new TipoProduto();

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
                tipoProd.setCodIdentificador(Integer.parseInt(vetLinha[0]));
                tipoProd.setNome(vetLinha[1]);
                tipoProd.setDescricao(vetLinha[0]);
                linha = buffer.readLine();
                
                listaTipos.add(tipoProd);
            }
            buffer.close();
            isr.close();
            fis.close();
        }
        return listaTipos;
    }

    private boolean codigoExiste(int codIdentificador) throws IOException {
        return false;
    }

    private void cadastraProduto(String csvProduto) throws IOException {

    }

    private void consulta() throws IOException {

    }

    private Produto buscaProduto(Produto prod) throws IOException {
        return null;
    }

    private void excluir() throws IOException {

    }

}
