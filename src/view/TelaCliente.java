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

import controller.ClienteProdutosController;
import controller.CarrinhoController;

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
        lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JButton btnCarregarCategorias = new JButton("Carregar categorias");
        btnCarregarCategorias.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnCarregarCategorias.setBounds(850, 20, 400, 42);
        btnCarregarCategorias.setActionCommand("Carregar categorias");
        
        JComboBox<Object> cbCategoriaProdutosCliente = new JComboBox<Object>();
        cbCategoriaProdutosCliente.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JButton btnCarregarProdutos = new JButton("Carregar produtos");
        btnCarregarProdutos.setBounds(850, 20, 400, 42);
        btnCarregarProdutos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnCarregarProdutos.setActionCommand("Carregar produtos");

        JButton btnAdicionarCarrinho = new JButton("Adicionar ao carrinho");
        btnAdicionarCarrinho.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnAdicionarCarrinho.setActionCommand("Adicionar ao carrinho");
        
        JButton btnExcluirProdutoCarrinho = new JButton("Excluir produto");
        btnExcluirProdutoCarrinho.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnExcluirProdutoCarrinho.setActionCommand("Excluir produto");
        
        JButton btnLimparCarrinho = new JButton("Limpar carrinho");
        btnLimparCarrinho.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnLimparCarrinho.setActionCommand("Limpar carrinho");

        JScrollPane scrollPane = new JScrollPane();

        JList<Object> listaProdutosCliente = new JList<Object>();
        ClienteProdutosController clienteProdController = new ClienteProdutosController(cbCategoriaProdutosCliente, listaProdutosCliente);
        btnCarregarProdutos.addActionListener(clienteProdController);
        btnCarregarCategorias.addActionListener(clienteProdController);
        
        JList<Object> listaCarrinhoCompras = new JList<Object>();
        CarrinhoController ClienteCarrinhoController = new CarrinhoController(listaProdutosCliente, listaCarrinhoCompras);       
        btnAdicionarCarrinho.addActionListener(ClienteCarrinhoController);    
        btnExcluirProdutoCarrinho.addActionListener(ClienteCarrinhoController);
        btnLimparCarrinho.addActionListener(ClienteCarrinhoController);

        GroupLayout gl_tabProdutos = new GroupLayout(tabProdutos);
        gl_tabProdutos.setHorizontalGroup(
        	gl_tabProdutos.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_tabProdutos.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(cbCategoriaProdutosCliente, 0, 311, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnCarregarProdutos)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnCarregarCategorias, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
        			.addGap(444))
        		.addGroup(gl_tabProdutos.createSequentialGroup()
        			.addGroup(gl_tabProdutos.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_tabProdutos.createSequentialGroup()
        					.addContainerGap(923, Short.MAX_VALUE)
        					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED))
        				.addGroup(gl_tabProdutos.createSequentialGroup()
        					.addGap(149)
        					.addComponent(listaProdutosCliente, GroupLayout.PREFERRED_SIZE, 533, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)))
        			.addComponent(btnAdicionarCarrinho, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        gl_tabProdutos.setVerticalGroup(
        	gl_tabProdutos.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_tabProdutos.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_tabProdutos.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(cbCategoriaProdutosCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnCarregarProdutos)
        				.addComponent(btnCarregarCategorias))
        			.addGroup(gl_tabProdutos.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_tabProdutos.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(gl_tabProdutos.createParallelGroup(Alignment.LEADING)
        						.addComponent(btnAdicionarCarrinho, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
        						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(gl_tabProdutos.createSequentialGroup()
        					.addGap(32)
        					.addComponent(listaProdutosCliente, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
        			.addGap(294))
        );
        tabProdutos.setLayout(gl_tabProdutos);
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

        JLabel lblValorTotal = new JLabel("Valor total: R$");
        lblValorTotal.setFont(new Font("Segoe UI", Font.PLAIN, 14));

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
