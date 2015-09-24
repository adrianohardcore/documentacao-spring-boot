/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adrianohardcore.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Adriano
 */
@Entity
@Table(name = "FORNECEDOR")
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f")})
public class Fornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDFORNECEDOR")
    private Integer idfornecedor;
    @Size(max = 60)
    @Column(name = "NOMEFORNECEDOR")
    private String nomefornecedor;
    @Size(max = 60)
    @Column(name = "NOMEFANTASIA")
    private String nomefantasia;
    @Size(max = 60)
    @Column(name = "ENDERECO")
    private String endereco;
    @Column(name = "NUMERO")
    private Integer numero;
    @Size(max = 10)
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @Size(max = 25)
    @Column(name = "BAIRRO")
    private String bairro;
    @Size(max = 25)
    @Column(name = "CIDADE")
    private String cidade;
    @Size(max = 9)
    @Column(name = "CEP")
    private String cep;
    @Size(max = 50)
    @Column(name = "TELEFONES")
    private String telefones;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 18)
    @Column(name = "CGC")
    private String cgc;
    @Size(max = 18)
    @Column(name = "INSCRESTADUAL")
    private String inscrestadual;
    @Size(max = 30)
    @Column(name = "CONTATO")
    private String contato;
    @Size(max = 200)
    @Column(name = "OBSCONTATO")
    private String obscontato;
    @Size(max = 200)
    @Column(name = "DADOSBANCARIOS")
    private String dadosbancarios;
    @Column(name = "ATIVO")
    private Character ativo;
    @Column(name = "ATU")
    private Character atu;
    @Size(max = 3)
    @Column(name = "FATU")
    private String fatu;
    @Size(max = 50)
    @Column(name = "PRINCIPALPRODUTO")
    private String principalproduto;
    @Size(max = 400)
    @Column(name = "OBSERVACAO")
    private String observacao;
    @Size(max = 2)
    @Column(name = "UF")
    private String uf;
    @Size(max = 50)
    @Column(name = "DIRETOR")
    private String diretor;
    @Size(max = 15)
    @Column(name = "TELEFONE")
    private String telefone;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Formato de telefone/fax inválido, deve ser xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 15)
    @Column(name = "FAX")
    private String fax;
    @Size(max = 40)
    @Column(name = "GERENTEREGIONAL")
    private String gerenteregional;
    @Size(max = 40)
    @Column(name = "VENDEDOR")
    private String vendedor;
    @Size(max = 15)
    @Column(name = "TELEFONEVENDEDOR")
    private String telefonevendedor;
    @Column(name = "TIPOFRETE")
    private Character tipofrete;
    @Size(max = 35)
    @Column(name = "TRANSPORTADORA")
    private String transportadora;
    @Size(max = 15)
    @Column(name = "FREQUENCIAVISITA")
    private String frequenciavisita;
    @Column(name = "IDCONDPGVENDA")
    private Integer idcondpgvenda;
    @Size(max = 10)
    @Column(name = "PRAZOENTREGA")
    private String prazoentrega;
    @Size(max = 10)
    @Column(name = "ATRASOENTREGA")
    private String atrasoentrega;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PEDIDOMINIMO")
    private Double pedidominimo;
    @Column(name = "COBRANCADEVOLUCAO")
    private Character cobrancadevolucao;
    @Size(max = 35)
    @Column(name = "PRACAPAGAMENTO")
    private String pracapagamento;
    @Column(name = "TROCAPRODUTO")
    private Character trocaproduto;
    @Column(name = "TIPOTABELAPRECO")
    private Character tipotabelapreco;
    @Column(name = "TIPOCOBRANCA")
    private Character tipocobranca;
    @Size(max = 10)
    @Column(name = "BANCO")
    private String banco;
    @Size(max = 10)
    @Column(name = "AGENCIA")
    private String agencia;
    @Size(max = 10)
    @Column(name = "CONTA")
    private String conta;
    @Column(name = "VERBACRESCIMENTO")
    private Double verbacrescimento;
    @Column(name = "VERBAREFORMA")
    private Double verbareforma;
    @Column(name = "VERBANOVAFILIAL")
    private Double verbanovafilial;
    @Column(name = "VERBATROCABANDEIRA")
    private Double verbatrocabandeira;
    @Column(name = "VERBACAMPANHA")
    private Double verbacampanha;
    @Size(max = 20)
    @Column(name = "INSCRICAOMUNICIPAL")
    private String inscricaomunicipal;
    @Size(max = 600)
    @Column(name = "PONTOREFERENCIAENTREGA")
    private String pontoreferenciaentrega;
    @Column(name = "DATACADASTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datacadastro;
    @Column(name = "CREDITO")
    private Double credito;
    @Size(max = 10)
    @Column(name = "IDCONTAPADRAO")
    private String idcontapadrao;

    public Fornecedor() {
    }

    public Fornecedor(Integer idfornecedor) {
        this.idfornecedor = idfornecedor;
    }

    public Integer getIdfornecedor() {
        return idfornecedor;
    }

    public void setIdfornecedor(Integer idfornecedor) {
        this.idfornecedor = idfornecedor;
    }

    public String getNomefornecedor() {
        return nomefornecedor;
    }

    public void setNomefornecedor(String nomefornecedor) {
        this.nomefornecedor = nomefornecedor;
    }

    public String getNomefantasia() {
        return nomefantasia;
    }

    public void setNomefantasia(String nomefantasia) {
        this.nomefantasia = nomefantasia;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefones() {
        return telefones;
    }

    public void setTelefones(String telefones) {
        this.telefones = telefones;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCgc() {
        return cgc;
    }

    public void setCgc(String cgc) {
        this.cgc = cgc;
    }

    public String getInscrestadual() {
        return inscrestadual;
    }

    public void setInscrestadual(String inscrestadual) {
        this.inscrestadual = inscrestadual;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getObscontato() {
        return obscontato;
    }

    public void setObscontato(String obscontato) {
        this.obscontato = obscontato;
    }

    public String getDadosbancarios() {
        return dadosbancarios;
    }

    public void setDadosbancarios(String dadosbancarios) {
        this.dadosbancarios = dadosbancarios;
    }

    public Character getAtivo() {
        return ativo;
    }

    public void setAtivo(Character ativo) {
        this.ativo = ativo;
    }

    public Character getAtu() {
        return atu;
    }

    public void setAtu(Character atu) {
        this.atu = atu;
    }

    public String getFatu() {
        return fatu;
    }

    public void setFatu(String fatu) {
        this.fatu = fatu;
    }

    public String getPrincipalproduto() {
        return principalproduto;
    }

    public void setPrincipalproduto(String principalproduto) {
        this.principalproduto = principalproduto;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getGerenteregional() {
        return gerenteregional;
    }

    public void setGerenteregional(String gerenteregional) {
        this.gerenteregional = gerenteregional;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getTelefonevendedor() {
        return telefonevendedor;
    }

    public void setTelefonevendedor(String telefonevendedor) {
        this.telefonevendedor = telefonevendedor;
    }

    public Character getTipofrete() {
        return tipofrete;
    }

    public void setTipofrete(Character tipofrete) {
        this.tipofrete = tipofrete;
    }

    public String getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(String transportadora) {
        this.transportadora = transportadora;
    }

    public String getFrequenciavisita() {
        return frequenciavisita;
    }

    public void setFrequenciavisita(String frequenciavisita) {
        this.frequenciavisita = frequenciavisita;
    }

    public Integer getIdcondpgvenda() {
        return idcondpgvenda;
    }

    public void setIdcondpgvenda(Integer idcondpgvenda) {
        this.idcondpgvenda = idcondpgvenda;
    }

    public String getPrazoentrega() {
        return prazoentrega;
    }

    public void setPrazoentrega(String prazoentrega) {
        this.prazoentrega = prazoentrega;
    }

    public String getAtrasoentrega() {
        return atrasoentrega;
    }

    public void setAtrasoentrega(String atrasoentrega) {
        this.atrasoentrega = atrasoentrega;
    }

    public Double getPedidominimo() {
        return pedidominimo;
    }

    public void setPedidominimo(Double pedidominimo) {
        this.pedidominimo = pedidominimo;
    }

    public Character getCobrancadevolucao() {
        return cobrancadevolucao;
    }

    public void setCobrancadevolucao(Character cobrancadevolucao) {
        this.cobrancadevolucao = cobrancadevolucao;
    }

    public String getPracapagamento() {
        return pracapagamento;
    }

    public void setPracapagamento(String pracapagamento) {
        this.pracapagamento = pracapagamento;
    }

    public Character getTrocaproduto() {
        return trocaproduto;
    }

    public void setTrocaproduto(Character trocaproduto) {
        this.trocaproduto = trocaproduto;
    }

    public Character getTipotabelapreco() {
        return tipotabelapreco;
    }

    public void setTipotabelapreco(Character tipotabelapreco) {
        this.tipotabelapreco = tipotabelapreco;
    }

    public Character getTipocobranca() {
        return tipocobranca;
    }

    public void setTipocobranca(Character tipocobranca) {
        this.tipocobranca = tipocobranca;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public Double getVerbacrescimento() {
        return verbacrescimento;
    }

    public void setVerbacrescimento(Double verbacrescimento) {
        this.verbacrescimento = verbacrescimento;
    }

    public Double getVerbareforma() {
        return verbareforma;
    }

    public void setVerbareforma(Double verbareforma) {
        this.verbareforma = verbareforma;
    }

    public Double getVerbanovafilial() {
        return verbanovafilial;
    }

    public void setVerbanovafilial(Double verbanovafilial) {
        this.verbanovafilial = verbanovafilial;
    }

    public Double getVerbatrocabandeira() {
        return verbatrocabandeira;
    }

    public void setVerbatrocabandeira(Double verbatrocabandeira) {
        this.verbatrocabandeira = verbatrocabandeira;
    }

    public Double getVerbacampanha() {
        return verbacampanha;
    }

    public void setVerbacampanha(Double verbacampanha) {
        this.verbacampanha = verbacampanha;
    }

    public String getInscricaomunicipal() {
        return inscricaomunicipal;
    }

    public void setInscricaomunicipal(String inscricaomunicipal) {
        this.inscricaomunicipal = inscricaomunicipal;
    }

    public String getPontoreferenciaentrega() {
        return pontoreferenciaentrega;
    }

    public void setPontoreferenciaentrega(String pontoreferenciaentrega) {
        this.pontoreferenciaentrega = pontoreferenciaentrega;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    public Double getCredito() {
        return credito;
    }

    public void setCredito(Double credito) {
        this.credito = credito;
    }

    public String getIdcontapadrao() {
        return idcontapadrao;
    }

    public void setIdcontapadrao(String idcontapadrao) {
        this.idcontapadrao = idcontapadrao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfornecedor != null ? idfornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        return !((this.idfornecedor == null && other.idfornecedor != null) || (this.idfornecedor != null && !this.idfornecedor.equals(other.idfornecedor)));
    }

    @Override
    public String toString() {
        return "br.com.adrianohardcore.model.Fornecedor[ idfornecedor=" + idfornecedor + " ]";
    }
    
}
