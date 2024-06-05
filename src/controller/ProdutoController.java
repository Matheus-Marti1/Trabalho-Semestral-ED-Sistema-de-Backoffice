package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

import javax.swing.JTextField;

import model.Produto;

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

        if (cmd.equals("Excluir tipo selecionado")) {
            try {
                excluir();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

    private void cadastro() throws IOException {

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
