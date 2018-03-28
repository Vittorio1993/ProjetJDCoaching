/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package METIER;

/**
 *
 * @author zhanghuakai
 */
public class utilisateur {
    private Integer codeu;
    private String nomu;
    private String prenomu;
    private String datenaissanceu;
    private String emailu;
    private String telu;
    private String statuts;
    private String password;
    private String type;

    public utilisateur(Integer codeu, String nomu, String prenomu, String datenaissanceu, String emailu, String telu, String statuts, String password, String type) {
        this.codeu = codeu;
        this.nomu = nomu;
        this.prenomu = prenomu;
        this.datenaissanceu = datenaissanceu;
        this.emailu = emailu;
        this.telu = telu;
        this.statuts = statuts;
        this.password = password;
        this.type = type;
    }

    public Integer getCodeu() {
        return codeu;
    }

    public String getNomu() {
        return nomu;
    }

    public String getPrenomu() {
        return prenomu;
    }

    public String getDatenaissanceu() {
        return datenaissanceu;
    }

    public String getEmailu() {
        return emailu;
    }

    public String getTelu() {
        return telu;
    }

    public String getStatuts() {
        return statuts;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public void setCodeu(Integer codeu) {
        this.codeu = codeu;
    }

    public void setNomu(String nomu) {
        this.nomu = nomu;
    }

    public void setPrenomu(String prenomu) {
        this.prenomu = prenomu;
    }

    public void setDatenaissanceu(String datenaissanceu) {
        this.datenaissanceu = datenaissanceu;
    }

    public void setEmailu(String emailu) {
        this.emailu = emailu;
    }

    public void setTelu(String telu) {
        this.telu = telu;
    }

    public void setStatuts(String statuts) {
        this.statuts = statuts;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
}
