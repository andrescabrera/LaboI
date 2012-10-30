/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package desktopapplication2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author acabrera
 */
@Entity
@Table(name = "facturas", catalog = "basededatows", schema = "")
@NamedQueries({
    @NamedQuery(name = "Facturas.findAll", query = "SELECT f FROM Facturas f"),
    @NamedQuery(name = "Facturas.findByNroFact", query = "SELECT f FROM Facturas f WHERE f.nroFact = :nroFact"),
    @NamedQuery(name = "Facturas.findByTotal", query = "SELECT f FROM Facturas f WHERE f.total = :total"),
    @NamedQuery(name = "Facturas.findByFecha", query = "SELECT f FROM Facturas f WHERE f.fecha = :fecha"),
    @NamedQuery(name = "Facturas.findByNrocliCLIENTES", query = "SELECT f FROM Facturas f WHERE f.nrocliCLIENTES = :nrocliCLIENTES")})
public class Facturas implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nro_fact")
    private Integer nroFact;
    @Column(name = "total")
    private Double total;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "nro_cli_CLIENTES")
    private Integer nrocliCLIENTES;

    public Facturas() {
    }

    public Facturas(Integer nroFact) {
        this.nroFact = nroFact;
    }

    public Integer getNroFact() {
        return nroFact;
    }

    public void setNroFact(Integer nroFact) {
        Integer oldNroFact = this.nroFact;
        this.nroFact = nroFact;
        changeSupport.firePropertyChange("nroFact", oldNroFact, nroFact);
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        Double oldTotal = this.total;
        this.total = total;
        changeSupport.firePropertyChange("total", oldTotal, total);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        Date oldFecha = this.fecha;
        this.fecha = fecha;
        changeSupport.firePropertyChange("fecha", oldFecha, fecha);
    }

    public Integer getNrocliCLIENTES() {
        return nrocliCLIENTES;
    }

    public void setNrocliCLIENTES(Integer nrocliCLIENTES) {
        Integer oldNrocliCLIENTES = this.nrocliCLIENTES;
        this.nrocliCLIENTES = nrocliCLIENTES;
        changeSupport.firePropertyChange("nrocliCLIENTES", oldNrocliCLIENTES, nrocliCLIENTES);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroFact != null ? nroFact.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturas)) {
            return false;
        }
        Facturas other = (Facturas) object;
        if ((this.nroFact == null && other.nroFact != null) || (this.nroFact != null && !this.nroFact.equals(other.nroFact))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "desktopapplication2.Facturas[nroFact=" + nroFact + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
