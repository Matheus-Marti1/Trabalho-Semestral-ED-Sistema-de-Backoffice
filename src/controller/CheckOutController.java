package controller;

import javax.swing.*;
import model.ProdutoCarrinho;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

public class CheckOutController implements ActionListener {
    private List<ProdutoCarrinho> listaCarrinho;
    private JTextPane textPaneCheckoutID;
    private JList<String> listCheckoutRegistro;
    private JFrame frame;

    public CheckOutController(List<ProdutoCarrinho> listaCarrinho, JTextPane textPaneCheckoutID, JList<String> listCheckoutRegistro, JFrame frame) {
        this.listaCarrinho = listaCarrinho;
        this.textPaneCheckoutID = textPaneCheckoutID;
        this.listCheckoutRegistro = listCheckoutRegistro;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
}