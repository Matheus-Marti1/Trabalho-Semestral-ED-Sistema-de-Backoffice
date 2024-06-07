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

		JComboBox<Object> cbTiposProdutosCompra = new JComboBox<Object>();
		cbTiposProdutosCompra.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		JButton btnNewButton = new JButton("Carregar produtos");
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		JButton btnNewButton_1 = new JButton("Adicionar ao carrinho");
		btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_tabProdutos = new GroupLayout(tabProdutos);
		gl_tabProdutos.setHorizontalGroup(gl_tabProdutos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabProdutos.createSequentialGroup().addContainerGap()
						.addGroup(gl_tabProdutos.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_tabProdutos.createSequentialGroup().addComponent(scrollPane)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(
												btnNewButton_1, GroupLayout.PREFERRED_SIZE, 177,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(gl_tabProdutos.createSequentialGroup()
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 59,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(cbTiposProdutosCompra, 0, 255, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNewButton)
										.addGap(549)))));
		gl_tabProdutos.setVerticalGroup(gl_tabProdutos.createParallelGroup(Alignment.TRAILING).addGroup(gl_tabProdutos
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_tabProdutos.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(cbTiposProdutosCompra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_tabProdutos.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane))
				.addContainerGap()));

		JList<Object> listaProdutosCompra = new JList<Object>();
		scrollPane.setViewportView(listaProdutosCompra);
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

		JButton btnCarregarCarrinho = new JButton("Carregar carrinho");
		btnCarregarCarrinho.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		JScrollPane scrollPane_1 = new JScrollPane();

		JButton btnExcluirProdutoCarrinho = new JButton("Excluir produto");
		btnExcluirProdutoCarrinho.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		JButton btnLimparCarrinho = new JButton("Limpar carrinho");
		btnLimparCarrinho.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		JLabel lblValorTotal = new JLabel("Valor total: R$");
		lblValorTotal.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		JButton btnCarrinhoCheckout = new JButton("Checkout");
		btnCarrinhoCheckout.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GroupLayout gl_tabCarrinho = new GroupLayout(tabCarrinho);
		gl_tabCarrinho.setHorizontalGroup(gl_tabCarrinho.createParallelGroup(Alignment.LEADING).addGroup(gl_tabCarrinho
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_tabCarrinho.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
						.addGroup(gl_tabCarrinho.createSequentialGroup().addComponent(btnCarregarCarrinho)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnExcluirProdutoCarrinho)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnLimparCarrinho).addGap(18)
								.addComponent(lblValorTotal)
								.addPreferredGap(ComponentPlacement.RELATED, 461, Short.MAX_VALUE)
								.addComponent(btnCarrinhoCheckout)))
				.addContainerGap()));
		gl_tabCarrinho.setVerticalGroup(gl_tabCarrinho.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabCarrinho.createSequentialGroup().addContainerGap()
						.addGroup(gl_tabCarrinho.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_tabCarrinho.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnCarregarCarrinho).addComponent(btnExcluirProdutoCarrinho)
										.addComponent(btnLimparCarrinho).addComponent(lblValorTotal))
								.addComponent(btnCarrinhoCheckout))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE).addContainerGap()));

		JList<Object> listaCarrinhoCompras = new JList<Object>();
		scrollPane_1.setViewportView(listaCarrinhoCompras);
		tabCarrinho.setLayout(gl_tabCarrinho);
		contentPane.setLayout(gl_contentPane);
	}
}
