package com.comissionamento.comissionamentoneoenergia.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity 
@Table(name ="ordemdeservicopendente")
public class ordemdeservicopendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(length = 255)
    private String cliente; // Alterado para String

    @Column(length = 255)
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
    private String localose;

    @Column(name = "dataabertura")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataabertura;

    @Column(name = "datalimite")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date datalimite;

    @Column(name = "dataconclusao")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataconclusao;

    @Column(length = 3)
    private String foradoprazo;

    @Column(length = 255)
    private Integer dias;

    // Getters e setters
    // ...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Integer getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(Integer protocolo) {
        this.protocolo = protocolo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getUteperesponsavel() {
        return uteperesponsavel;
    }

    public void setUteperesponsavel(String uteperesponsavel) {
        this.uteperesponsavel = uteperesponsavel;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getOrgaoexecutor() {
        return orgaoexecutor;
    }

    public void setOrgaoexecutor(String orgaoexecutor) {
        this.orgaoexecutor = orgaoexecutor;
    }

    public String getLocalose() {
        return localose;
    }

    public void setLocalose(String localose) {
        this.localose = localose;
    }

    public Date getDataabertura() {
        return dataabertura;
    }

    public void setDataabertura(Date dataabertura) {
        this.dataabertura = dataabertura;
    }

    public Date getDatalimite() {
        return datalimite;
    }

    public void setDatalimite(Date datalimite) {
        this.datalimite = datalimite;
    }

    public Date getDataconclusao() {
        return dataconclusao;
    }

    public void setDataconclusao(Date dataconclusao) {
        this.dataconclusao = dataconclusao;
    }

    public String getForadoprazo() {
        return foradoprazo;
    }

    public void setForadoprazo(String foradoprazo) {
        this.foradoprazo = foradoprazo;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }
}
