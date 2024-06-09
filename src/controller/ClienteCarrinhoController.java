package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;
import javax.swing.DefaultListModel;

public class ClienteCarrinhoController implements ActionListener {
    private JList<Object> listaCarrinhoCompras;
    private DefaultListModel<Object> carrinhoListModel;

    public ClienteCarrinhoController(JList<Object> listaCarrinhoCompras) {
        this.listaCarrinhoCompras = listaCarrinhoCompras;
        this.carrinhoListModel = new DefaultListModel<>(); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
//    if (cmd.equals("Carregar carrinho")) {
//            try {
//                testarTabelaProd();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
    }
    
    public void adicionarProduto(Object produto) {
    	this.listaCarrinhoCompras.setModel(this.carrinhoListModel);
        this.carrinhoListModel.addElement(produto);
    }
           
//    private void testarTabelaProd() {
//		DefaultListModel<Object> model = new DefaultListModel<>();
//		model.addElement("Produto 1: Teste 1, Valor: R$10.00");
//		model.addElement("Produto 2: Teste 2, Valor: R$20.00");
//		model.addElement("Produto 3: Teste 3, Valor: R$30.00");
//		listaCarrinhoCompras.setModel(model);
//	}
}
