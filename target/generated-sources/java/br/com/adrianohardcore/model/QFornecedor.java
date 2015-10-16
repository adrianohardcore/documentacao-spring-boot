package br.com.adrianohardcore.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QFornecedor is a Querydsl query type for Fornecedor
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QFornecedor extends EntityPathBase<Fornecedor> {

    private static final long serialVersionUID = -2088136591L;

    public static final QFornecedor fornecedor = new QFornecedor("fornecedor");

    public final StringPath agencia = createString("agencia");

    public final ComparablePath<Character> ativo = createComparable("ativo", Character.class);

    public final StringPath atrasoentrega = createString("atrasoentrega");

    public final ComparablePath<Character> atu = createComparable("atu", Character.class);

    public final StringPath bairro = createString("bairro");

    public final StringPath banco = createString("banco");

    public final StringPath cep = createString("cep");

    public final StringPath cgc = createString("cgc");

    public final StringPath cidade = createString("cidade");

    public final ComparablePath<Character> cobrancadevolucao = createComparable("cobrancadevolucao", Character.class);

    public final StringPath complemento = createString("complemento");

    public final StringPath conta = createString("conta");

    public final StringPath contato = createString("contato");

    public final NumberPath<Double> credito = createNumber("credito", Double.class);

    public final StringPath dadosbancarios = createString("dadosbancarios");

    public final DateTimePath<java.util.Date> datacadastro = createDateTime("datacadastro", java.util.Date.class);

    public final StringPath diretor = createString("diretor");

    public final StringPath email = createString("email");

    public final StringPath endereco = createString("endereco");

    public final StringPath fatu = createString("fatu");

    public final StringPath fax = createString("fax");

    public final StringPath frequenciavisita = createString("frequenciavisita");

    public final StringPath gerenteregional = createString("gerenteregional");

    public final NumberPath<Integer> idcondpgvenda = createNumber("idcondpgvenda", Integer.class);

    public final StringPath idcontapadrao = createString("idcontapadrao");

    public final NumberPath<Integer> idfornecedor = createNumber("idfornecedor", Integer.class);

    public final StringPath inscrestadual = createString("inscrestadual");

    public final StringPath inscricaomunicipal = createString("inscricaomunicipal");

    public final StringPath nomefantasia = createString("nomefantasia");

    public final StringPath nomefornecedor = createString("nomefornecedor");

    public final NumberPath<Integer> numero = createNumber("numero", Integer.class);

    public final StringPath obscontato = createString("obscontato");

    public final StringPath observacao = createString("observacao");

    public final NumberPath<Double> pedidominimo = createNumber("pedidominimo", Double.class);

    public final StringPath pontoreferenciaentrega = createString("pontoreferenciaentrega");

    public final StringPath pracapagamento = createString("pracapagamento");

    public final StringPath prazoentrega = createString("prazoentrega");

    public final StringPath principalproduto = createString("principalproduto");

    public final StringPath telefone = createString("telefone");

    public final StringPath telefones = createString("telefones");

    public final StringPath telefonevendedor = createString("telefonevendedor");

    public final ComparablePath<Character> tipocobranca = createComparable("tipocobranca", Character.class);

    public final ComparablePath<Character> tipofrete = createComparable("tipofrete", Character.class);

    public final ComparablePath<Character> tipotabelapreco = createComparable("tipotabelapreco", Character.class);

    public final StringPath transportadora = createString("transportadora");

    public final ComparablePath<Character> trocaproduto = createComparable("trocaproduto", Character.class);

    public final StringPath uf = createString("uf");

    public final StringPath vendedor = createString("vendedor");

    public final NumberPath<Double> verbacampanha = createNumber("verbacampanha", Double.class);

    public final NumberPath<Double> verbacrescimento = createNumber("verbacrescimento", Double.class);

    public final NumberPath<Double> verbanovafilial = createNumber("verbanovafilial", Double.class);

    public final NumberPath<Double> verbareforma = createNumber("verbareforma", Double.class);

    public final NumberPath<Double> verbatrocabandeira = createNumber("verbatrocabandeira", Double.class);

    public QFornecedor(String variable) {
        super(Fornecedor.class, forVariable(variable));
    }

    public QFornecedor(Path<? extends Fornecedor> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFornecedor(PathMetadata<?> metadata) {
        super(Fornecedor.class, metadata);
    }

}

