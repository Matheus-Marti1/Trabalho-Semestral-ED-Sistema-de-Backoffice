package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.ProdutoCarrinho;

public class CarrinhoController implements ActionListener {

    private JList<Object> listaProdutos;
    private JList<Object> listaCarrinho;
    private JLabel lblValorTotal;
    private DefaultListModel<Object> carrinhoListModel = new DefaultListModel<>();
    private List<ProdutoCarrinho> carrinho = new ArrayList<>();

    public CarrinhoController(JList<Object> listaProdutos, JList<Object> listaCarrinho, JLabel lblValorTotal) {
        this.listaProdutos = listaProdutos;
        this.listaCarrinho = listaCarrinho;
        this.lblValorTotal = lblValorTotal;
        this.listaCarrinho.setModel(carrinhoListModel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Adicionar ao carrinho")) {
	        try {
	        	adicionarProdutoCarrinho();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
        }
        if (cmd.equals("Excluir produto")) {
            try {
            	excluirProdutoCarrinho();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if (cmd.equals("Limpar carrinho")) {
            try {
            	limparCarrinho();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }    
    }

    private void adicionarProdutoCarrinho() throws IOException {
        Object selectedValue = listaProdutos.getSelectedValue();
        if (selectedValue == null) {
            JOptionPane.showMessageDialog(null, "Selecione um produto para adicionar ao carrinho.");
            return;
        }
        String produtoInfo = selectedValue.toString();
        String[] parts = produtoInfo.split("[:;]");
        int id = Integer.parseInt(parts[1].trim());
        String nome = parts[3].trim();
        double valor = Double.parseDouble(parts[5].trim().substring(2).replace(',', '.'));
        String descricao = parts[7].trim();
        int quantidade = 1;
        for (ProdutoCarrinho produtoCarrinho : carrinho) {
            if (produtoCarrinho.getId() == id) {
                produtoCarrinho.setQuantidade(produtoCarrinho.getQuantidade() + 1);
                atualizarCarrinho();
                return;
            }
        }
        ProdutoCarrinho novoProduto = new ProdutoCarrinho(id, nome, valor, descricao, quantidade);
        carrinho.add(novoProduto);
        atualizarCarrinho();
    }

    private void excluirProdutoCarrinho() throws IOException {
        Object selectedValue = listaCarrinho.getSelectedValue();
        if (selectedValue == null) {
            JOptionPane.showMessageDialog(null, "Selecione um produto para excluir do carrinho.");
            return;
        }
        String produtoInfo = selectedValue.toString();
        String[] parts = produtoInfo.split("[:;]");
        int id = Integer.parseInt(parts[1].trim());
        carrinho.removeIf(produtoCarrinho -> produtoCarrinho.getId() == id);
        atualizarCarrinho();
    }

    private void limparCarrinho() throws IOException {
        carrinho.clear();
        atualizarCarrinho();
    }

    private void atualizarCarrinho() {
        carrinhoListModel.clear();
        for (ProdutoCarrinho produtoCarrinho : carrinho) {
            carrinhoListModel.addElement(produtoCarrinho.toString());
        }
        atualizarValorTotal();
    }

    private void atualizarValorTotal() {
        double valorTotal = calcularValorTotal();
        lblValorTotal.setText(String.format("Valor Total: R$ %.2f", valorTotal));
    }

    private double calcularValorTotal() {
        double total = 0;
        for (ProdutoCarrinho produtoCarrinho : carrinho) {
            total += produtoCarrinho.getValor() * produtoCarrinho.getQuantidade();
        }
        return total;
    }
}
