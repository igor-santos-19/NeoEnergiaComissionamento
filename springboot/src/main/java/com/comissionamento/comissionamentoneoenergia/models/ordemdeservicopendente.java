package com.comissionamento.comissionamentoneoenergia.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ordemdeservicopendente")
public class ordemdeservicopendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String cliente;

    @Column(length = 255)
    private String empresa;

    @Column(length = 100)
    private String uteperesponsavel;

    @Column(length = 80)
    private String motivo;

    @Column(length = 20)
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

    // Getters e Setters

    @Override
    public String toString() {
        return "OrdemDeServicoPendente{" +
                "id=" + id +
                ", cliente='" + cliente + '\'' +
                ", empresa='" + empresa + '\'' +
                ", uteperesponsavel='" + uteperesponsavel + '\'' +
                ", motivo='" + motivo + '\'' +
                ", orgaoexecutor='" + orgaoexecutor + '\'' +
                ", localose='" + localose + '\'' +
                ", dataabertura=" + dataabertura +
                ", datalimite=" + datalimite +
                '}';
    }

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
}
