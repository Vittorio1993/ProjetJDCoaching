/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author RHAW
 */
public class Utilisateur {

    /**
     * Code de l'Uilisateur.
     */
    private String codeu;

    /**
     * Nom de l'Utilisateur.
     */
    private String nomu;

    /**
     * Prénom de l'Utilisateur.
     */
    private String prenomu;

    /**
     * Date de naissance de l'Utilisateur.
     */
    private String datenaissanceu;

    /**
     * Adresse mail de l'Utilisateur.
     */
    private String emailu;

    /**
     * Numéro de téléphone de l'Utilisateur.
     */
    private String telu;

    /**
     * Status de l'Utilisateur.
     */
    private String status;

    /**
     * Mot de passe de l'Utilisateur.
     */
    private String password;

    /**
     * Type de l'Utilisateur.
     */
    private String type;

    /**
     * Objectif de l'Utilisateur.
     */
    private String objectif;
    /**
     * Class Constructor.
     * @param code code utilisateur
     * @param nom nom utilisateur
     * @param prenom prénom utilisateur
     * @param datenaissance date de naissance utilisateur
     * @param email mail utilisateur
     * @param tel numéro de téléphone utilisateur
     * @param statusu status utilisateur
     * @param passwordu mot de passe utilisateur
     * @param typeu type utilisateur
     * @param objectifu objectif utilisateur
     */
    public Utilisateur(final String code, final String nom,
            final String prenom, final String datenaissance,
                final String email, final String tel, final String statusu,
                final String passwordu, final String typeu, final String objectifu) {
        this.codeu = code;
        this.nomu = nom;
        this.prenomu = prenom;
        this.datenaissanceu = datenaissance;
        this.emailu = email;
        this.telu = tel;
        this.status = statusu;
        this.password = passwordu;
        this.type = typeu;
        this.objectif = objectifu;
    }

    /**
     * Getter Code Utilisateur.
     * @return codeu
     */
    public final String getCodeu() {
        return codeu;
    }

    /**
     * Getter Nom Utilisateur.
     * @return nomu
     */
    public final String getNomu() {
        return nomu;
    }

    /**
     * Getter Prenom Utilisateur.
     * @return prenomu
     */
    public final String getPrenomu() {
        return prenomu;
    }

    /**
     * Getter Date naissance Utilisateur.
     * @return datenaissanceu
     */
    public final String getDatenaissanceu() {
        return datenaissanceu;
    }

    /**
     * Getter Email Utilisateur.
     * @return emailu
     */
    public final String getEmailu() {
        return emailu;
    }

    /**
     * Getter Tel Utilisateur.
     * @return telu
     */
    public final String getTelu() {
        return telu;
    }

    /**
     * Getter Status Utilisateur.
     * @return status
     */
    public final String getStatus() {
        return status;
    }

    /**
     * Getter Password Utilisateur.
     * @return password
     */
    public final String getPassword() {
        return password;
    }

    /**
     * Getter Type Utilisateur.
     * @return type
     */
    public final String getType() {
        return type;
    }

    /**
     * Getter Objectif Utilisateur.
     * @return objectif
     */
    public final String getObjectif() {
        return objectif;
    }

    /**
     * Setter Code Utilisateur.
     * @param code code utilisateur
     */
    public final void setCodeu(final String code) {
        this.codeu = code;
    }

    /**
     * Setter Nom Utilisateur.
     * @param nom nom
     */
    public final void setNomu(final String nom) {
        this.nomu = nom;
    }

    /**
     * Setter Prenom Utilisateur.
     * @param prenom prénom
     */
    public final void setPrenomu(final String prenom) {
        this.prenomu = prenom;
    }

    /**
     * Setter Date Naissance Utilisateur.
     * @param datenaissance date de naissance
     */
    public final void setDatenaissanceu(final String datenaissance) {
        this.datenaissanceu = datenaissance;
    }

    /**
     * Setter Mail Utilisateur.
     * @param email mail
     */
    public final void setEmailu(final String email) {
        this.emailu = email;
    }

    /**
     * Setter Tel Utilisateur.
     * @param tel téléphone
     */
    public final void setTelu(final String tel) {
        this.telu = tel;
    }

    /**
     * Setter Status Utilisateur.
     * @param statusu status
     */
    public final void setStatus(final String statusu) {
        this.status = statusu;
    }

    /**
     * Setter Password Utilisateur.
     * @param passwordu password
     */
    public final void setPassword(final String passwordu) {
        this.password = passwordu;
    }

    /**
     * Setter Type Utilisateur.
     * @param typeu type
     */
    public final void setType(final String typeu) {
        this.type = typeu;
    }

    /**
     * Setter Type Utilisateur.
     * @param objectifu objectif
     */
    public final void setObjectif(final String objectifu) {
        this.objectif = objectifu;
    }
}
