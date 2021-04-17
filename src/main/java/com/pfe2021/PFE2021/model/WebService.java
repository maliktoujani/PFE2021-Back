package com.pfe2021.PFE2021.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class WebService implements Serializable {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String url;
    private String format;
    private String methodeHttp;
    @JsonIgnoreProperties(value = {"webService"})
    @OneToMany( mappedBy = "webService", cascade = CascadeType.ALL )
    private List<InfoAcces> infoAcces;

    public WebService(String id, String url, String format, String methodeHttp) {
        this.id = id;
        this.url = url;
        this.format = format;
        this.methodeHttp = methodeHttp;
    }

    public WebService() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getMethodeHttp() {
        return methodeHttp;
    }

    public void setMethodeHttp(String methodeHttp) {
        this.methodeHttp = methodeHttp;
    }

    public List<InfoAcces> getInfoAcces() {
        return infoAcces;
    }

    public void setInfoAcces(List<InfoAcces> infoAcces) {
        this.infoAcces = infoAcces;
    }
}
