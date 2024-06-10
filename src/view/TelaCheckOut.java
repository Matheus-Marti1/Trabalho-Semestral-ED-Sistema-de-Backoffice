package view;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import model.ProdutoCarrinho;
import java.awt.Font;
import java.util.List;

import controller.CheckOutController;

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
        listCheckoutRegistro.setBounds(601, 68, 400, 400);
        listCheckoutRegistro.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        tabCheckOut.add(listCheckoutRegistro);

        JLabel lblCheckoutCarrinho = new JLabel("Carrinho");
        lblCheckoutCarrinho.setBounds(177, 34, 63, 26);
        lblCheckoutCarrinho.setFont(new Font("Segoe UI", Font.BOLD, 14));
        tabCheckOut.add(lblCheckoutCarrinho);

        DefaultListModel<String> carrinhoModel = new DefaultListModel<>();
        JList<String> listCheckoutCarrinho = new JList<>(carrinhoModel);
        listCheckoutCarrinho.setBounds(10, 68, 400, 400);
        listCheckoutCarrinho.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        tabCheckOut.add(listCheckoutCarrinho);

        for (ProdutoCarrinho produto : listaCarrinho) {
            carrinhoModel.addElement(produto.toString());
        }

        JLabel lblCheckoutRegistro = new JLabel("Registro de compra");
        lblCheckoutRegistro.setBounds(742, 26, 139, 42);
        lblCheckoutRegistro.setFont(new Font("Segoe UI", Font.BOLD, 14));
        tabCheckOut.add(lblCheckoutRegistro);

        JLabel lblcheckout = new JLabel("ID da Compra");
        lblcheckout.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblcheckout.setBounds(458, 190, 105, 26);
        tabCheckOut.add(lblcheckout);

        JTextPane textPaneCheckoutID = new JTextPane();
        textPaneCheckoutID.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textPaneCheckoutID.setBounds(470, 227, 71, 20);
        tabCheckOut.add(textPaneCheckoutID);
        
        lblValorTotal = new JLabel(String.format("Valor Total: R$ %.2f", calcularValorTotal(listaCarrinho)));
        lblValorTotal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblValorTotal.setBounds(441, 278, 128, 35);
        tabCheckOut.add(lblValorTotal);

        JButton btnCheckoutFinaliza = new JButton("Finalizar");
        btnCheckoutFinaliza.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnCheckoutFinaliza.setBounds(420, 414, 173, 42);
        tabCheckOut.add(btnCheckoutFinaliza);

        CheckOutController checkOutCont = new CheckOutController(listaCarrinho, textPaneCheckoutID, listCheckoutRegistro, this, null, null);
        btnCheckoutFinaliza.addActionListener(checkOutCont);
    }

    private double calcularValorTotal(List<ProdutoCarrinho> listaCarrinho) {
        double total = 0;
        for (ProdutoCarrinho produto : listaCarrinho) {
            total += produto.getValor() * produto.getQuantidade();
        }
        return total;
    }
}
