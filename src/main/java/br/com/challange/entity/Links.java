package br.com.challange.entity;

import br.com.challange.domain.utils.UrlShortenerVariables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Links {

    @Id
    private String urlId;

    public String getUrlId() {
        return urlId;
    }

    public void setUrlId(String urlId) {
        this.urlId = urlId;
    }

    public String getUrlFullPath() {
        return urlFullPath;
    }

    public void setUrlFullPath(String urlFullPath) {
        this.urlFullPath = urlFullPath;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Column(unique = true)
    private String urlFullPath;
    private LocalDateTime creationDate;
    private LocalDateTime expirationDate;


    public Links() {
    }

    public Links(String urlId, String urlFullPath) {
        this.urlId = urlId;
        this.urlFullPath = urlFullPath;
        this.creationDate = LocalDateTime.now();
        this.expirationDate = creationDate.plusDays(UrlShortenerVariables.DAYS_TO_EXPIRE);
    }

    @Override
    public String toString() {
        return "Links{" +
                "urlId=" + urlId +
                ", urlFullPath='" + urlFullPath + '\'' +
                ", creationDate=" + creationDate +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
