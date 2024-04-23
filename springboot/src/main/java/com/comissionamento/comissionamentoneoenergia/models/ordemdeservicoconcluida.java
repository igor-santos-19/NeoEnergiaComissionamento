package com.comissionamento.comissionamentoneoenergia.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

// Cria a tabela Ordem De Serviço Conluida no BD

@Entity 
@Table(name ="ordemdeservicoconcluida")
public class ordemdeservicoconcluida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "integer", length = 255)
    private Integer cliente;

    @Column(columnDefinition = "integer", length = 255)
    private Integer protocolo;

    @Column(length = 255)
    private String empresa;

    @Column(length = 100)
    private String uteperesponsavel;

    @Column(length = 80)
    private String motivo;

    @Column(length = 20)
    private String situacao;

    @Column(length = 10)
    private String orgaoexecutor;

    @Column(length = 30)
    private String localose; //Local Ordem De Serviço

    @Column(name = "dataabertura")
    @Temporal(TemporalType.DATE)
    private Date dataabertura;

    @Column(name = "datalimite")
    @Temporal(TemporalType.DATE)
    private Date datalimite;

    @Column(name = "dataconclusao")
    @Temporal(TemporalType.DATE)
    private Date dataconclusao;

    @Column(length = 3)
    private String foradoprazo;

    @Column(length = 255)
    private Integer diasatraso;

    @Column(length = 255)
    private String termos;

    @Column(name = "dataenvio")
    @Temporal(TemporalType.DATE)
    private Date dataenvio;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCliente() {
        return this.cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public Integer getProtocolo() {
        return this.protocolo;
    }

    public void setProtocolo(Integer protocolo) {
        this.protocolo = protocolo;
    }

    public String getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getUteperesponsavel() {
        return this.uteperesponsavel;
    }

    public void setUteperesponsavel(String uteperesponsavel) {
        this.uteperesponsavel = uteperesponsavel;
    }

    public String getMotivo() {
        return this.motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getSituacao() {
        return this.situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getOrgaoexecutor() {
        return this.orgaoexecutor;
    }

    public void setOrgaoexecutor(String orgaoexecutor) {
        this.orgaoexecutor = orgaoexecutor;
    }

    public String getLocalose() {
        return this.localose;
    }

    public void setLocalose(String localose) {
        this.localose = localose;
    }

    public Date getDataabertura() {
        return this.dataabertura;
    }

    public void setDataabertura(Date dataabertura) {
        this.dataabertura = dataabertura;
    }

    public Date getDatalimite() {
        return this.datalimite;
    }

    public void setDatalimite(Date datalimite) {
        this.datalimite = datalimite;
    }

    public Date getDataconclusao() {
        return this.dataconclusao;
    }

    public void setDataconclusao(Date dataconclusao) {
        this.dataconclusao = dataconclusao;
    }

    public String getForadoprazo() {
        return this.foradoprazo;
    }

    public void setForadoprazo(String foradoprazo) {
        this.foradoprazo = foradoprazo;
    }

    public Integer getDiasatraso() {
        return this.diasatraso;
    }

    public void setDiasatraso(Integer diasatraso) {
        this.diasatraso = diasatraso;
    }

    public String getTermos() {
        return this.termos;
    }

    public void setTermos(String termos) {
        this.termos = termos;
    }

    public Date getDataenvio() {
        return this.dataenvio;
    }

    public void setDataenvio(Date dataenvio) {
        this.dataenvio = dataenvio;
    }

}
