package view;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import model.ProdutoCarrinho;
import java.awt.Font;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class TelaCheckOut extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblValorTotal;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaCheckOut frame = new TelaCheckOut(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TelaCheckOut(List<ProdutoCarrinho> listaCarrinho) {
        setTitle("CheckOut");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1050, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 11, 1014, 550);
        contentPane.add(tabbedPane);

        JPanel tabCheckOut = new JPanel();
        tabbedPane.addTab("Finalizar compra", null, tabCheckOut, null);
        tabCheckOut.setLayout(null);

        JList<String> listCheckoutRegistro = new JList<>();
        listCheckoutRegistro.setBounds(669, 68, 280, 400);
        listCheckoutRegistro.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tabCheckOut.add(listCheckoutRegistro);

        JLabel lblCheckoutCarrinho = new JLabel("Carrinho");
        lblCheckoutCarrinho.setBounds(155, 31, 63, 26);
        lblCheckoutCarrinho.setFont(new Font("Segoe UI", Font.BOLD, 14));
        tabCheckOut.add(lblCheckoutCarrinho);

        DefaultListModel<String> carrinhoModel = new DefaultListModel<>();
        JList<String> listCheckoutCarrinho = new JList<>(carrinhoModel);
        listCheckoutCarrinho.setBounds(45, 68, 280, 400);
        listCheckoutCarrinho.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tabCheckOut.add(listCheckoutCarrinho);

        for (ProdutoCarrinho produto : listaCarrinho) {
            carrinhoModel.addElement(produto.toString());
        }

        JLabel lblCheckoutRegistro = new JLabel("Registro de compra");
        lblCheckoutRegistro.setBounds(741, 11, 139, 42);
        lblCheckoutRegistro.setFont(new Font("Segoe UI", Font.BOLD, 14));
        tabCheckOut.add(lblCheckoutRegistro);

        JLabel lblcheckout = new JLabel("ID da Compra");
        lblcheckout.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblcheckout.setBounds(448, 209, 98, 26);
        tabCheckOut.add(lblcheckout);

        JTextPane textPaneCheckoutID = new JTextPane();
        textPaneCheckoutID.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textPaneCheckoutID.setBounds(392, 245, 208, 20);
        tabCheckOut.add(textPaneCheckoutID);
        
        lblValorTotal = new JLabel(String.format("Valor Total: R$ %.2f", calcularValorTotal(listaCarrinho)));
        lblValorTotal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblValorTotal.setBounds(425, 292, 128, 35);
        tabCheckOut.add(lblValorTotal);

        JButton btnCheckoutFinaliza = new JButton("Finalizar");
        btnCheckoutFinaliza.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnCheckoutFinaliza.setBounds(403, 415, 173, 42);
        tabCheckOut.add(btnCheckoutFinaliza);

        btnCheckoutFinaliza.addActionListener(e -> {
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

            try (FileWriter writer = new FileWriter(compraID + ".csv")) {
                writer.write("ID,Nome,Valor,Descrição,Quantidade\n");
                for (ProdutoCarrinho produto : listaCarrinho) {
                    writer.write(String.format("%d,%s,%.2f,%s,%d\n",
                            produto.getId(), produto.getNome(), produto.getValor(),
                            produto.getDescricao(), produto.getQuantidade()));
                }
                writer.write(String.format("Total, ,%.2f, ,\n", totalCompra));
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao salvar a compra em um arquivo CSV.");
            }

            JOptionPane.showMessageDialog(this, "Compra finalizada com sucesso! ID da Compra: " + compraID);
            dispose(); 
        });
    }
    private double calcularValorTotal(List<ProdutoCarrinho> listaCarrinho) {
        double total = 0;
        for (ProdutoCarrinho produto : listaCarrinho) {
            total += produto.getValor() * produto.getQuantidade();
        }
        return total;
    }
}