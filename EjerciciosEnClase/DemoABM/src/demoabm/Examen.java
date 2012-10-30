/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demoabm;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author acabrera
 */
@Entity
@Table(name = "examen", catalog = "examenes", schema = "")
@NamedQueries({
    @NamedQuery(name = "Examen.findAll", query = "SELECT e FROM Examen e"),
    @NamedQuery(name = "Examen.findById", query = "SELECT e FROM Examen e WHERE e.id = :id"),
    @NamedQuery(name = "Examen.findByNota", query = "SELECT e FROM Examen e WHERE e.nota = :nota"),
    @NamedQuery(name = "Examen.findByIdAlumno", query = "SELECT e FROM Examen e WHERE e.idAlumno = :idAlumno"),
    @NamedQuery(name = "Examen.findByIdModeloDeExamen", query = "SELECT e FROM Examen e WHERE e.idModeloDeExamen = :idModeloDeExamen"),
    @NamedQuery(name = "Examen.findByIdExaminador", query = "SELECT e FROM Examen e WHERE e.idExaminador = :idExaminador")})
public class Examen implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nota")
    private Long nota;
    @Column(name = "id_Alumno")
    private Integer idAlumno;
    @Column(name = "id_ModeloDeExamen")
    private Integer idModeloDeExamen;
    @Column(name = "id_Examinador")
    private Integer idExaminador;

    public Examen() {
    }

    public Examen(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Long getNota() {
        return nota;
    }

    public void setNota(Long nota) {
        Long oldNota = this.nota;
        this.nota = nota;
        changeSupport.firePropertyChange("nota", oldNota, nota);
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        Integer oldIdAlumno = this.idAlumno;
        this.idAlumno = idAlumno;
        changeSupport.firePropertyChange("idAlumno", oldIdAlumno, idAlumno);
    }

    public Integer getIdModeloDeExamen() {
        return idModeloDeExamen;
    }

    public void setIdModeloDeExamen(Integer idModeloDeExamen) {
        Integer oldIdModeloDeExamen = this.idModeloDeExamen;
        this.idModeloDeExamen = idModeloDeExamen;
        changeSupport.firePropertyChange("idModeloDeExamen", oldIdModeloDeExamen, idModeloDeExamen);
    }

    public Integer getIdExaminador() {
        return idExaminador;
    }

    public void setIdExaminador(Integer idExaminador) {
        Integer oldIdExaminador = this.idExaminador;
        this.idExaminador = idExaminador;
        changeSupport.firePropertyChange("idExaminador", oldIdExaminador, idExaminador);
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
        if (!(object instanceof Examen)) {
            return false;
        }
        Examen other = (Examen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demoabm.Examen[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
