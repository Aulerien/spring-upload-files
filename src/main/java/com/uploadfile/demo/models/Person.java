package com.uploadfile.demo.models;
import javax.persistence.*;

/**
 * The type Person.
 */
@Entity(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenoms")
    private String prenoms;

    @Column(name = "image_name")
    private String imageName;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets nom.
     *
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets nom.
     *
     * @param nom the nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Gets prenoms.
     *
     * @return the prenoms
     */
    public String getPrenoms() {
        return prenoms;
    }

    /**
     * Sets prenoms.
     *
     * @param prenoms the prenoms
     */
    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    /**
     * Gets image name.
     *
     * @return the image name
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * Sets image name.
     *
     * @param imageName the image name
     */
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
