package controller;

import javax.swing.*;
import model.ProdutoCarrinho;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

public class CheckOutController implements ActionListener {
    private List<ProdutoCarrinho> listaCarrinho;
    private JTextPane textPaneCheckoutID;
    private JList<String> listCheckoutRegistro;
    private JFrame frame;
	private JTextField textFieldIdCompra;
	private JList<Object> listaVendasCliente;

    public CheckOutController(List<ProdutoCarrinho> listaCarrinho, JTextPane textPaneCheckoutID, JList<String> listCheckoutRegistro,
    		JFrame frame, JTextField textFieldIdCompra, JList<Object> listaVendasCliente) {
        this.listaCarrinho = listaCarrinho;
        this.textPaneCheckoutID = textPaneCheckoutID;
        this.listCheckoutRegistro = listCheckoutRegistro;
        this.frame = frame;
        this.textFieldIdCompra = textFieldIdCompra;
        this.listaVendasCliente = listaVendasCliente;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	 String cmd = e.getActionCommand();
    	 if (cmd.equals("Finalizar")) {
    		 try {
    			 gravarDadosCompra();
    		 } catch (IOException ex) {
    		     ex.printStackTrace();
    		 }
    	 }
    	 if (cmd.equals("Consultar")) {
    		 try {
    			 consultarDadosCompra();
    	     } catch (IOException ex) {
    	    	 ex.printStackTrace();
    	     }    	        
    	}
    }
    	  
    public void gravarDadosCompra() throws IOException {
        Random rand = new Random();
        int compraID = rand.nextInt(90000) + 10000;
        textPaneCheckoutID.setText(String.valueOf(compraID));

        DefaultListModel<String> registroModel = new DefaultListModel<>();
        double totalCompra = 0;
        for (ProdutoCarrinho produto : listaCarrinho) {
            registroModel.addElement(produto.toString());
            totalCompra += produto.getValor() * produto.getQuantidade();
        }
        listCheckoutRegistro.setModel(registroModel);

        try {
            String currentDirectory = new File(".").getCanonicalPath();
            String path = currentDirectory + File.separator + "SistemaBackoffice";
            try (FileWriter writer = new FileWriter(new File(path, compraID + ".csv"))) {
                writer.write("ID,Nome,Valor,Descrição,Quantidade\n");
                for (ProdutoCarrinho produto : listaCarrinho) {
                    writer.write(String.format("%d,%s,%.2f,%s,%d\n",
                            produto.getId(), produto.getNome(), produto.getValor(),
                            produto.getDescricao(), produto.getQuantidade()));
                }
                writer.write(String.format("Total, ,%.2f, ,\n", totalCompra));
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Erro ao salvar a compra em um arquivo CSV.");
            }

            JOptionPane.showMessageDialog(frame, "Compra finalizada com sucesso! ID da Compra: " + compraID);
            frame.dispose();
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Erro ao determinar o diretório atual.");
        }
    }
    
    private void consultarDadosCompra() throws IOException {
        String currentDirectory = new File(".").getCanonicalPath();
        String path = currentDirectory + File.separator + "SistemaBackoffice";
        String textoIdCompra = textFieldIdCompra.getText();
        File arq = new File(path, textoIdCompra + ".csv");
        if (arq.exists() && arq.isFile()) {
            FileInputStream fis = new FileInputStream(arq);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader buffer = new BufferedReader(isr);
            String linha = buffer.readLine();
            DefaultListModel<Object> prodConsListModel = new DefaultListModel<>();
            boolean primeiraLinha = true; 
            while (linha != null) {
                if (primeiraLinha) {
                    primeiraLinha = false; // Ignorar a primeira linha
                } else {
                    String[] vetLinha = linha.split(",");
                    // Adicionando cada linha de produto
                    prodConsListModel.addElement(vetLinha[0] + " --- " + vetLinha[1] + " --- " + vetLinha[2] + " --- " + vetLinha[3] + " --- " + vetLinha[4]);
                }
                linha = buffer.readLine();
            }
            // Adicionando a última linha de forma diferente porque é o total
            if (!prodConsListModel.isEmpty()) {
                String ultimaLinha = (String) prodConsListModel.get(prodConsListModel.size() - 1);
                String[] ultimaLinhaSplit = ultimaLinha.split(" --- ");
                prodConsListModel.removeElementAt(prodConsListModel.size() - 1); // Remover a última linha da lista
                prodConsListModel.addElement("Total da Compra: R$" + ultimaLinhaSplit[2]); // Adicionar a última linha formatada como "Total da Compra: R$[valor total]"
            }
            listaVendasCliente.setModel(prodConsListModel);
            buffer.close();
            isr.close();
            fis.close();
        }
    }

}