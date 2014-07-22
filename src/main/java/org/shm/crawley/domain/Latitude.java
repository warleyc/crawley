package org.shm.crawley.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * implements  Serializable for memcache
 */
@Entity
@Table(name = "Latitude")
public class Latitude implements Serializable {


    /**
     * serial　id for memcache
     */
    private static final long serialVersionUID = 1234567L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //id profile du compte google

    String reverseGeocode;
    Long timeStamp;

    String location;
    String photoUrl;
    String xpos;
    String ypos;
    @Transient
    String since;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReverseGeocode() {
        return reverseGeocode;
    }

    public void setReverseGeocode(String reverseGeocode) {
        this.reverseGeocode = reverseGeocode;
    }

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getXpos() {
        return xpos;
    }

    public void setXpos(String xpos) {
        this.xpos = xpos;
    }

    public String getYpos() {
        return ypos;
    }

    public void setYpos(String ypos) {
        this.ypos = ypos;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Latitude{" +
                "id=" + id +
                ", reverseGeocode='" + reverseGeocode + '\'' +
                ", timeStamp=" + timeStamp +
                ", location='" + location + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", xpos='" + xpos + '\'' +
                ", ypos='" + ypos + '\'' +
                ", since='" + since + '\'' +
                '}';
    }
}
