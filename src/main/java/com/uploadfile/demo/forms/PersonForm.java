package com.uploadfile.demo.forms;

import org.springframework.web.multipart.MultipartFile;

/**
 * The type Person form.
 */
public class PersonForm {
    private String nom;

    private String prenoms;

    private MultipartFile image;

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
     * Gets image.
     *
     * @return the image
     */
    public MultipartFile getImage() {
        return image;
    }

    /**
     * Sets image.
     *
     * @param image the image
     */
    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
