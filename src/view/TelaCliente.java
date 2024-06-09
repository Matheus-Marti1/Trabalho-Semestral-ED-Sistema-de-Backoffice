package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import controller.ProdutoController;
import controller.CarrinhoController;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class TelaCliente extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public TelaCliente(JFrame parentFrame, String nomeCliente) {
        setMinimumSize(new Dimension(1050, 600));
        setTitle("Loja");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1050, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                parentFrame.setVisible(true);
                dispose();
            }
        });

        setContentPane(contentPane);

        JLabel lblExibirNomeCliente = new JLabel("Bem vindo, " + nomeCliente + "!");
        lblExibirNomeCliente.setForeground(new Color(255, 255, 255));

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

        JPanel tabProdutos = new JPanel();
        tabbedPane.addTab("Produtos", null, tabProdutos, null);

        JLabel lblNewLabel = new JLabel("Categoria");
        lblNewLabel.setBounds(10, 16, 59, 20);
        lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        JComboBox<Object> cbCategoriaProdutosCliente = new JComboBox<Object>();
        cbCategoriaProdutosCliente.setBounds(73, 11, 470, 31);
        cbCategoriaProdutosCliente.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JButton btnCarregarProdutos = new JButton("Carregar produtos");
        btnCarregarProdutos.setBounds(549, 11, 177, 31);
        btnCarregarProdutos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnCarregarProdutos.setActionCommand("Carregar produtos");

        JButton btnAdicionarCarrinho = new JButton("Adicionar ao carrinho");
        btnAdicionarCarrinho.setBounds(810, 51, 177, 29);
        btnAdicionarCarrinho.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnAdicionarCarrinho.setActionCommand("Adicionar ao carrinho");
        
        JButton btnExcluirProdutoCarrinho = new JButton("Excluir produto");
        btnExcluirProdutoCarrinho.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnExcluirProdutoCarrinho.setActionCommand("Excluir produto");
        
        JButton btnLimparCarrinho = new JButton("Limpar carrinho");
        btnLimparCarrinho.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnLimparCarrinho.setActionCommand("Limpar carrinho");

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(919, 11, 2, 2);

        JList<Object> listaProdutosCliente = new JList<Object>();
        listaProdutosCliente.setBounds(10, 52, 774, 431);
        ProdutoController prodCont = new ProdutoController(null, null, null, null, null, null, cbCategoriaProdutosCliente, listaProdutosCliente);
        btnCarregarProdutos.addActionListener(prodCont);
        
        JList<Object> listaCarrinhoCompras = new JList<Object>();
        JLabel lblValorTotal = new JLabel("Valor Total: R$ 0.00");
        lblValorTotal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        CarrinhoController ClienteCarrinhoController = new CarrinhoController(listaProdutosCliente, listaCarrinhoCompras, lblValorTotal);       
        btnAdicionarCarrinho.addActionListener(ClienteCarrinhoController);    
        btnExcluirProdutoCarrinho.addActionListener(ClienteCarrinhoController);
        btnLimparCarrinho.addActionListener(ClienteCarrinhoController);
        tabProdutos.setLayout(null);
        tabProdutos.add(lblNewLabel);
        tabProdutos.add(cbCategoriaProdutosCliente);
        tabProdutos.add(btnCarregarProdutos);
        tabProdutos.add(listaProdutosCliente);
        tabProdutos.add(scrollPane);
        tabProdutos.add(btnAdicionarCarrinho);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup().addGap(10)
                        .addComponent(lblExibirNomeCliente, GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE).addGap(153))
                .addComponent(tabbedPane));
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup()
                        .addGap(10).addComponent(lblExibirNomeCliente).addGap(14).addComponent(tabbedPane)));

        JPanel tabCarrinho = new JPanel();
        tabbedPane.addTab("Carrinho", null, tabCarrinho, null);

        JScrollPane scrollPane_1 = new JScrollPane();

        JButton btnCarrinhoCheckout = new JButton("Checkout");
        btnCarrinhoCheckout.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        GroupLayout gl_tabCarrinho = new GroupLayout(tabCarrinho);
        gl_tabCarrinho.setHorizontalGroup(
        	gl_tabCarrinho.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_tabCarrinho.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_tabCarrinho.createParallelGroup(Alignment.LEADING)
        				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 1102, Short.MAX_VALUE)
        				.addGroup(gl_tabCarrinho.createSequentialGroup()
        					.addGap(145)
        					.addComponent(btnExcluirProdutoCarrinho)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnLimparCarrinho)
        					.addGap(18)
        					.addComponent(lblValorTotal)
        					.addPreferredGap(ComponentPlacement.RELATED, 501, Short.MAX_VALUE)
        					.addComponent(btnCarrinhoCheckout)))
        			.addContainerGap())
        );
        gl_tabCarrinho.setVerticalGroup(
        	gl_tabCarrinho.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_tabCarrinho.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_tabCarrinho.createParallelGroup(Alignment.TRAILING)
        				.addGroup(gl_tabCarrinho.createParallelGroup(Alignment.BASELINE)
        					.addComponent(btnExcluirProdutoCarrinho)
        					.addComponent(btnLimparCarrinho)
        					.addComponent(lblValorTotal))
        				.addComponent(btnCarrinhoCheckout))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
        			.addContainerGap())
        );

        scrollPane_1.setViewportView(listaCarrinhoCompras);
        tabCarrinho.setLayout(gl_tabCarrinho);
        contentPane.setLayout(gl_contentPane);
    }
}
