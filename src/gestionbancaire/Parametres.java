/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbancaire;

/**
 *
 * @author Hp
 */
public class Parametres {

    private String depotParam;
    private String retraitParam;
    private String monnaieParam;
    private String prctageParam;
    private int nbreDigitParam;
    
     
    public Parametres() {
        this.depotParam="déposer";
        this.retraitParam="retirer";
        this.monnaieParam="Euro(s)";
        this.prctageParam="%";
        this.nbreDigitParam=3;
    }
    
    public String formaterNumCpte(int varLocale) {
        return String.format("%0"+nbreDigitParam+"d",varLocale);
    }
    
    /**
     * @return the depotParam
     */
    public String getDepotParam() {
        return depotParam;
    }
    /**
     * @return the nbreDigitParam
     */
    public int getNbreDigitParam() {
        return nbreDigitParam;
    }
     /**
     * @return the monnaieParam
     */
    public String getMonnaieParam() {
        return monnaieParam;
    }

    /**
     * @return the retraitParam
     */
    public String getRetraitParam() {
        return retraitParam;
    }

    /**
     * @param retraitParam the retraitParam to set
     */
    public void setRetraitParam(String retraitParam) {
        this.retraitParam = retraitParam;
    }

    /**
     * @param monnaieParam the monnaieParam to set
     */
    public void setMonnaieParam(String monnaieParam) {
        this.monnaieParam = monnaieParam;
    }
      /**
     * @param nbreDigitParam the nbreDigitParam to set
     */
    public void setNbreDigitParam(int nbreDigitParam) {
        this.nbreDigitParam = nbreDigitParam;
    }

    /**
     * @param depotParam the depotParam to set
     */
    
    /**
     * @return the prctageParam
     */
    public String getPrctageParam() {
        return prctageParam;
    }

    /**
     * @param prctageParam the prctageParam to set
     */
    public void setPrctageParam(String prctageParam) {
        this.prctageParam = prctageParam;
    }
    public void setDepotParam(String depotParam) {
        this.depotParam = depotParam;
    }
}
