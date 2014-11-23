/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.rigo.myrest;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.xml.bind.Element;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
//import com.fasterxml.jackson.annotate.JsonAnySetter;
//import com.fasterxml.jackson.annotate.JsonBackReference;
//import com.fasterxml.jackson.annotate.JsonIgnore;
//import com.fasterxml.jackson.annotate.JsonManagedReference;
//import com.fasterxml.jackson.annotate.JsonProperty;

/**
 *
 * @author mcree
 */
@Entity
@ApiModel("Test subentity")
public class MySubEntity implements Serializable,IdentEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JsonBackReference
    private MyEntity parent;

    private static final Logger LOG = Logger.getLogger(MySubEntity.class.getName());

    /**
     *
     * @param key
     * @param value
     */
    @JsonAnySetter
    public void jsonSetter(String key, String value) {
        LOG.log(Level.INFO, "jsonSetter({0},{1})", new Object[]{key, value});
    }

    @JsonProperty
    public Long getParentId() {
        if(parent!=null) {
            return parent.getId();
        }
        return null;
    }
    
    public MyEntity getParent() {
        return parent;
    }

    public void setParent(MyEntity parent) {
        this.parent = parent;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MySubEntity)) {
            return false;
        }
        MySubEntity other = (MySubEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.rigo.myrest.MySubEntity[ id=" + id + " ]";
    }

}
