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
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import javax.swing.JTextField;

import model.TipoProduto;

public class TipoProdutoController implements ActionListener {

    private JTextField tfTipoProdutoCodIdentificador;
    private JTextField tfTipoProdutoNome;
    private JTextArea taTipoProdutoDescricao;

    public TipoProdutoController(JTextField tfTipoProdutoCodIdentificador, JTextField tfTipoProdutoNome, JTextArea taTipoProdutoDescricao) {
        super();
        this.tfTipoProdutoCodIdentificador = tfTipoProdutoCodIdentificador;
        this.tfTipoProdutoNome = tfTipoProdutoNome;
        this.taTipoProdutoDescricao = taTipoProdutoDescricao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Cadastrar Tipo")) {
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
        int codIdentificador = Integer.parseInt(tfTipoProdutoCodIdentificador.getText());
        if (codigoExiste(codIdentificador)) {
            JOptionPane.showMessageDialog(null, "Código de Identificador já Cadastrado");
            return;
        }

        TipoProduto tipoProd = new TipoProduto();
        tipoProd.setCodIdentificador(Integer.parseInt(tfTipoProdutoCodIdentificador.getText()));
        tipoProd.setNome(tfTipoProdutoNome.getText());
        tipoProd.setDescricao(taTipoProdutoDescricao.getText());

        cadastraTipoProduto(tipoProd.toString());
        tfTipoProdutoCodIdentificador.setText("");
        tfTipoProdutoNome.setText("");
        taTipoProdutoDescricao.setText("");
        JOptionPane.showMessageDialog(null, "Tipo de Produto " + tipoProd.getNome() + " cadastrado com sucesso!");

    }

    private boolean codigoExiste(int codIdentificador) throws IOException {
        String currentDirectory = new File(".").getCanonicalPath();
        String path = currentDirectory + File.separator + "SistemaBackoffice" + File.separator + "tipoProduto.csv";
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

    private void cadastraTipoProduto(String csvTipoProduto) throws IOException {
        // Obtém o caminho do diretório atual
        String currentDirectory = new File(".").getCanonicalPath();
        String path = currentDirectory + File.separator + "SistemaBackoffice";
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
        File arq = new File(path, "tipoProduto.csv");
        boolean existe = false;
        if (arq.exists()) {
            existe = true;
        }
        FileWriter fw = new FileWriter(arq, existe);
        PrintWriter pw = new PrintWriter(fw);
        pw.write(csvTipoProduto + "\r\n");
        pw.flush();
        pw.close();
        fw.close();
    }

    private void consulta() throws IOException {
       
    }

    private TipoProduto buscaTipoProduto(TipoProduto tipoProd) throws IOException {
        return null;
    }

    private void excluir() throws IOException {
        
    }

}
