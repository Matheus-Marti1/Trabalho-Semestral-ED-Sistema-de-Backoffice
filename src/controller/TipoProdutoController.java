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

import model.TipoProduto;

public class TipoProdutoController implements ActionListener {

    private JTextField tfTipoProdutoCodIdentificador;
    private JTextField tfTipoProdutoNome;
    private JTextField tfTipoProdutoDescricao;
    private JTextArea taTipoProduto;

    public TipoProdutoController(JTextField tfTipoProdutoCodIdentificador, JTextField tfTipoProdutoNome, JTextField tfTipoProdutoDescricao, JTextArea taTipoProduto) {
        super();
        this.tfTipoProdutoCodIdentificador = tfTipoProdutoCodIdentificador;
        this.tfTipoProdutoNome = tfTipoProdutoNome;
        this.tfTipoProdutoDescricao = tfTipoProdutoDescricao;
        this.taTipoProduto = taTipoProduto;
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
        int codIdentificador = Integer.parseInt(tfTipoProdutoCodIdentificador.getText());
        if (codigoExiste(codIdentificador)) {
            taTipoProduto.setText("Erro: Código de identificador já existe.");
            return;
        }

        TipoProduto tipoProd = new TipoProduto();
        tipoProd.setCodIdentificador(Integer.parseInt(tfTipoProdutoCodIdentificador.getText()));
        tipoProd.setNome(tfTipoProdutoNome.getText());
        tipoProd.setdescricao(tfTipoProdutoDescricao.getText());

        cadastraTipoProduto(tipoProd.toString());
        tfTipoProdutoCodIdentificador.setText("");
        tfTipoProdutoNome.setText("");
        tfTipoProdutoDescricao.setText("");
        taTipoProduto.setText("Tipo de Produto " + tipoProd.getNome() + " cadastrado com sucesso!");

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
        TipoProduto tipoProd = new TipoProduto();
        tipoProd.setCodIdentificador(Integer.parseInt(tfTipoProdutoCodIdentificador.getText()));

        tipoProd = buscaTipoProduto(tipoProd);
        if (tipoProd.getNome() != null) {
            taTipoProduto.setText(" - Código: " + tipoProd.getCodIdentificador() + "\r\n" + " - Nome: " + tipoProd.getNome() + "\r\n" + " - Descricao: " + tipoProd.getDescricao());
        } else {
            taTipoProduto.setText("Tipo de Produto não encontrado");
        }
    }

    private TipoProduto buscaTipoProduto(TipoProduto tipoProd) throws IOException {
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
                if (vetLinha[0].equals(tipoProd.getCodIdentificador())) {
                    tipoProd.setNome(vetLinha[1]);
                    tipoProd.setdescricao(vetLinha[2]);
                    break;
                }
                linha = buffer.readLine();
            }
            buffer.close();
            isr.close();
            fis.close();
        }
        return tipoProd;
    }

    private void excluir() throws IOException {
        // Obtém o caminho do diretório atual
        String currentDirectory = new File(".").getCanonicalPath();
        String path = currentDirectory + File.separator + "SistemaBackoffice";
        File arq = new File(path, "tipoProduto.csv");
        File temp = new File(path, "tipoProdutoTemp.csv");
        BufferedReader buffer = new BufferedReader(new FileReader(arq));
        PrintWriter pw = new PrintWriter(new FileWriter(temp));
        String tipoProdAExcluir = tfTipoProdutoCodIdentificador.getText();
        String linha = buffer.readLine();
        boolean tipoExiste = false;
        while (linha != null) {
            String[] vetLinha = linha.split(";");
            if (!vetLinha[0].equals(tipoProdAExcluir)) {
                pw.println(linha);
            } else {
                tipoExiste = true;
            }
            linha = buffer.readLine();
        }
        pw.flush();
        pw.close();
        buffer.close();
        arq.delete();
        temp.renameTo(arq);
        if (tipoExiste) {
            taTipoProduto.setText("Tipo excluido com sucesso");
        } else {
            taTipoProduto.setText("Tipo não encontrado");
        }

    }

}
