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
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;

import model.TipoProduto;

public class TipoProdutoController implements ActionListener {

    private JTextField tfTipoProdutoCodIdentificador;
    private JTextField tfTipoProdutoNome;
    private JTextArea taTipoProdutoDescricao;
    private JList<Object> listaTipoConsultaTipo;
    private JList<Object> listaTiposConsultaProdutos;
    private ArrayList<String>[] listTipo;

    public TipoProdutoController(JTextField tfTipoProdutoCodIdentificador, JTextField tfTipoProdutoNome, JTextArea taTipoProdutoDescricao, JList<Object> listaTiposConsultaTipos, JList<Object> listaTiposConsultaProdutos) {
        this.tfTipoProdutoCodIdentificador = tfTipoProdutoCodIdentificador;
        this.tfTipoProdutoNome = tfTipoProdutoNome;
        this.taTipoProdutoDescricao = taTipoProdutoDescricao;
        this.listaTipoConsultaTipo = listaTiposConsultaTipos;
        this.listaTiposConsultaProdutos = listaTiposConsultaProdutos;
        
        try {
            carregarTiposDeProdutos();
            montarTabelaDeEspalhamento();
        } catch (IOException e) {
            e.printStackTrace();
        }

        listaTiposConsultaTipos.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                try {
                    exibirProdutosDoTipoSelecionado();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
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
        if (cmd.equals("Recarregar lista")) {
            try {
                carregarTiposDeProdutos();
                montarTabelaDeEspalhamento();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        if (cmd.equals("Excluir tipo selecionado")) {
            try {
                excluir();
                carregarTiposDeProdutos();
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

    private void carregarTiposDeProdutos() throws IOException {
        //Caminho Atual dos Arquivos
        String currentDirectory = new File(".").getCanonicalPath();
        String path = currentDirectory + File.separator + "SistemaBackoffice" + File.separator + "tipoProduto.csv";
        File arq = new File(path);

        //Valida se o Arquivo Existe
        if (arq.exists() && arq.isFile()) {
            ArrayList<TipoProduto> tiposDeProdutos = new ArrayList<>();
            BufferedReader buffer = new BufferedReader(new FileReader(arq));
            String linha;

            //Inicia a Leitura do Arquivo, e cria um objeto TipoProduto
        while ((linha = buffer.readLine()) != null) {
                String[] parts = linha.split(";");
                TipoProduto tipoProduto = new TipoProduto();
                tipoProduto.setCodIdentificador(Integer.parseInt(parts[0]));
                tipoProduto.setNome(parts[1]);
                tipoProduto.setDescricao(parts[2]);
                tiposDeProdutos.add(tipoProduto);
            }
            buffer.close();
            listaTipoConsultaTipo.setListData(tiposDeProdutos.toArray());
        }
    }

    private void montarTabelaDeEspalhamento() throws IOException {
        String currentDirectory = new File(".").getCanonicalPath();
        String path = currentDirectory + File.separator + "SistemaBackoffice" + File.separator + "produto.csv";
        File arq = new File(path);

        if (arq.exists() && arq.isFile()) {
            ArrayList<ArrayList<String>> tabelaEspalhamento = new ArrayList<>();
            BufferedReader buffer = new BufferedReader(new FileReader(arq));
            String linha;

            while ((linha = buffer.readLine()) != null) {
                String[] parts = linha.split(";");
                int tipoCod = Integer.parseInt(parts[5]);  //o índice 5 é o código do tipo do produto
                int posicao = HashCode(tipoCod);

                while (tabelaEspalhamento.size() <= posicao) {
                    tabelaEspalhamento.add(new ArrayList<>());
                }

                tabelaEspalhamento.get(posicao).add(linha);
            }

            buffer.close();
            this.listTipo = tabelaEspalhamento.toArray(new ArrayList[0]);
        }
    }

    private int HashCode(int tipoSelecionado) throws IOException {
        int posicao = tipoSelecionado;
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
                String[] vetLinha = linha.split(";");
                if (posicao == Integer.parseInt(vetLinha[5])) {
                    posicao = Integer.parseInt(vetLinha[5]);
                }
                linha = buffer.readLine();
            }
            buffer.close();
            isr.close();
            fis.close();
        }
        return posicao;
    }

    private void exibirProdutosDoTipoSelecionado() throws IOException {
        TipoProduto tipoProdutoSelecionado = (TipoProduto) listaTipoConsultaTipo.getSelectedValue();

        if (tipoProdutoSelecionado != null) {
            int tipoCod = tipoProdutoSelecionado.getCodIdentificador();
            int posicao = HashCode(tipoCod);

            if (posicao < listTipo.length && listTipo[posicao] != null) {
                ArrayList<String> produtos = listTipo[posicao];

                DefaultListModel<Object> produtosListModel = new DefaultListModel<>();
                for (String produto : produtos) {
                    produtosListModel.addElement(produto);
                }
                listaTiposConsultaProdutos.setModel(produtosListModel);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um tipo de produto.");
        }
    }

    private void excluir() throws IOException {
        // Obtém o tipo selecionado na lista
        TipoProduto tipoProdutoSelecionado = (TipoProduto) listaTipoConsultaTipo.getSelectedValue();
        int selectedIndex = listaTipoConsultaTipo.getSelectedIndex();

        if (tipoProdutoSelecionado != null) {
            int tipoCod = tipoProdutoSelecionado.getCodIdentificador();
            // Remove o tipo da lista
            ListModel<Object> listModel = listaTipoConsultaTipo.getModel();
            DefaultListModel<Object> defaultListModel = new DefaultListModel<>();
            for (int i = 0; i < listModel.getSize(); i++) {
                if (i != selectedIndex) {
                    defaultListModel.addElement(listModel.getElementAt(i));
                }
            }
            listaTipoConsultaTipo.setModel(defaultListModel);

            // Remove o tipo do arquivo
            String currentDirectory = new File(".").getCanonicalPath();
            String path = currentDirectory + File.separator + "SistemaBackoffice" + File.separator + "tipoProduto.csv";
            File arq = new File(path);
            if (arq.exists() && arq.isFile()) {
                // Cria uma lista para armazenar as linhas a serem mantidas no arquivo
                ArrayList<String> linhasMantidas = new ArrayList<>();
                BufferedReader buffer = new BufferedReader(new FileReader(arq));
                String linha;

                // Lê cada linha do arquivo
                while ((linha = buffer.readLine()) != null) {
                    String[] parts = linha.split(";");
                    // Se a linha não corresponde ao tipo a ser excluído, adiciona à lista de linhas mantidas
                    if (Integer.parseInt(parts[0]) != tipoCod) {
                        linhasMantidas.add(linha);
                    }
                }
                buffer.close();

                // Escreve as linhas mantidas de volta ao arquivo
                FileWriter fw = new FileWriter(arq);
                PrintWriter pw = new PrintWriter(fw);
                for (String linhaMantida : linhasMantidas) {
                    pw.println(linhaMantida);
                }
                pw.close();
                fw.close();
            }

            // Remove os produtos associados ao tipo do arquivo de produtos
            removerProdutosDoTipo(tipoCod);
        }
    }

    private void removerProdutosDoTipo(int tipoCod) throws IOException {
        String currentDirectory = new File(".").getCanonicalPath();
        String path = currentDirectory + File.separator + "SistemaBackoffice" + File.separator + "produto.csv";
        File arq = new File(path);
        if (arq.exists() && arq.isFile()) {
            ArrayList<String> linhasMantidas = new ArrayList<>();
            BufferedReader buffer = new BufferedReader(new FileReader(arq));
            String linha;

            // Lê cada linha do arquivo
            while ((linha = buffer.readLine()) != null) {
                String[] parts = linha.split(";");
                // Se o tipo do produto não corresponder ao tipo a ser excluído, adiciona à lista de linhas mantidas
                if (Integer.parseInt(parts[5]) != tipoCod) {
                    linhasMantidas.add(linha);
                }
            }
            buffer.close();

            // Escreve as linhas mantidas de volta ao arquivo
            FileWriter fw = new FileWriter(arq);
            PrintWriter pw = new PrintWriter(fw);
            for (String linhaMantida : linhasMantidas) {
                pw.println(linhaMantida);
            }
            pw.close();
            fw.close();
        }
    }

}
