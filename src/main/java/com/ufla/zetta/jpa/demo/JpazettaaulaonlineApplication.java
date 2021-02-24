package com.ufla.zetta.jpa.demo;

import com.ufla.zetta.jpa.demo.model.*;
import com.ufla.zetta.jpa.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class JpazettaaulaonlineApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JpazettaaulaonlineApplication.class, args);
    }

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;



    @Override
    public void run(String... args) throws Exception {

        Produto produto1 = Produto.builder()
                .nome("computador")
                .preco(2000.0)
                .build();

        Produto produto2 = Produto.builder()
                .nome("Mouse")
                .preco(200.0)
                .build();

        Categoria categoria1 = Categoria.builder()
                .nome("Escritório")
                .build();

        categoria1.setProdutos(Arrays.asList(produto1, produto2));

        Categoria categoria2 = Categoria.builder()
                .nome("Papelaria")
                .build();

        produto1.setCategorias(Arrays.asList(categoria1, categoria2));

        categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
        produtoRepository.saveAll(Arrays.asList(produto1, produto2));


        Cidade campinas = Cidade.builder()
                .nome("Campinas")
                .build();

        Cidade marilia = Cidade.builder()
                .nome("Marilia")
                .build();

        Estado saoPaulo = Estado.builder()
                .nome("São Paulo")
                .build();

        saoPaulo.setCidades(Arrays.asList(campinas, marilia));
        marilia.setEstado(saoPaulo);
        campinas.setEstado(saoPaulo);

        Cidade lavras = Cidade.builder()
                .nome("Lavras")
                .build();

        Cidade beloHorizonte = Cidade.builder()
                .nome("Belo Horizonte")
                .build();

        Estado minasGerais = Estado.builder()
                .nome("Minas Gerais")
                .build();

        minasGerais.setCidades(Arrays.asList(lavras, beloHorizonte));
        lavras.setEstado(minasGerais);
        beloHorizonte.setEstado(minasGerais);
        this.estadoRepository
                .saveAll(Arrays.asList(saoPaulo, minasGerais));
        this.cidadeRepository
                .saveAll(Arrays.asList(campinas, marilia, lavras, beloHorizonte));

        Telefone telefone = Telefone.builder()
                .ddd("35")
                .telefone("99999999")
                .build();

        Endereco endereco = Endereco.builder()
                .bairro("Centro")
                .cep("37200-000")
                .cidade(lavras)
                .complemento("Apt 35")
                .numero("57")
                .logradouro("Av Vaz Monteiro")
                .build();

        Cliente cliente = Cliente.builder()
                .nome("Rafael Durelli")
                .cpfOuCnpj("000.000.000-00")
                .email("rafael.durelli@ufla.br")
                .tipoCliente(TipoCliente.PESSOAFISICA)
                .telefones(Arrays.asList(telefone))
                .enderecos(Arrays.asList(endereco))
                .build();

        telefone.setCliente(cliente);
        endereco.setCliente(cliente);

        this.clienteRepository.save(cliente);
        this.enderecoRepository.save(endereco);
        this.telefoneRepository.save(telefone);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Pedido pedido1 = Pedido.builder()
                .instante(simpleDateFormat.parse("30/10/2012 10:32"))
                .cliente(cliente)
                .enderecoDeEntrega(endereco)
                .build();

        Pagamento pagamento = PagamentoComCartao.builder()
                .estadoPagamento(EstadoPagamento.QUITADO)
                .pedido(pedido1)
                .build();

        pedido1.setPagamento(pagamento);

        cliente.setPedidos(Arrays.asList(pedido1));

        this.pedidoRepository.save(pedido1);
        this.pagamentoRepository.save(pagamento);

        ItemPedido itemPedido =
                new ItemPedido(pedido1, produto1, 30.0, 1, 2000.0);


        HashSet<ItemPedido> itemPedidos = new HashSet<>();
        itemPedidos.add(itemPedido);

//        pedido1.setItens(Arrays.asList(itemPedido));
        produto1.setItens(itemPedidos);

        this.itemPedidoRepository.save(itemPedido);
    }
}
