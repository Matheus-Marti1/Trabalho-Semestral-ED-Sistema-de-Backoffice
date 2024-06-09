package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JList;
import javax.swing.DefaultListModel;

public class CarrinhoController implements ActionListener {
    private JList<Object> listaProdutosCliente;
    private JList<Object> listaCarrinhoCompras;
    private DefaultListModel<Object> carrinhoListModel;

    public CarrinhoController(JList<Object> listaProdutosCliente, JList<Object> listaCarrinhoCompras) {
        this.listaProdutosCliente = listaProdutosCliente;
        this.listaCarrinhoCompras = listaCarrinhoCompras;
        this.carrinhoListModel = new DefaultListModel<>(); 
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
    
    public void adicionarProdutoCarrinho() throws IOException {
    	if (!listaProdutosCliente.isSelectionEmpty()) {
    	int selectedIndex = listaProdutosCliente.getSelectedIndex();
    	DefaultListModel<Object> produtosListModel = (DefaultListModel<Object>) listaProdutosCliente.getModel();
    	Object selectedProduct = produtosListModel.getElementAt(selectedIndex);
    	this.listaCarrinhoCompras.setModel(this.carrinhoListModel);
        this.carrinhoListModel.addElement(selectedProduct);
    }
    }
    
    public void excluirProdutoCarrinho() throws IOException {
    	if (!listaCarrinhoCompras.isSelectionEmpty()) {
    	int selectedIndex = listaCarrinhoCompras.getSelectedIndex();
    	DefaultListModel<Object> cartListModel = (DefaultListModel<Object>) listaCarrinhoCompras.getModel();
    	Object selectedProduct = cartListModel.getElementAt(selectedIndex);
    	this.listaCarrinhoCompras.setModel(this.carrinhoListModel);
        this.carrinhoListModel.removeElement(selectedProduct);
    	}
    }
    
    public void limparCarrinho() throws IOException {
    	this.listaCarrinhoCompras.setModel(this.carrinhoListModel);
        this.carrinhoListModel.removeAllElements();
    }
}
    
