/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 *
 * @author El Bryan
 */
public class Juego {
    private NumeroSecreto numeroSecreto;
    private int limiteInferior;
    private int limiteSuperior;
    private int numeroDeIntentos;
    private int intentosRealizados;
    
    private static final int LIM_INF_PREDET = 1;
    private static final int LIM_SUP_PREDET = 100;
    
    /**
     *
     * @param limiteInferior
     * @param limiteSuperior
     * @param intentos
     */
    public Juego(int limiteInferior, int limiteSuperior, int intentos) {
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
        this.numeroDeIntentos = intentos;
        this.numeroSecreto = new NumeroSecreto
        (this.limiteInferior, this.limiteSuperior);
        this.intentosRealizados = 0;
    }    

    /**
     *
     * @param limiteInferior
     * @param limiteSuperior
     */
    public void setRangoDelNumeroSecreto
        (int limiteInferior, int limiteSuperior) {
            this.limiteInferior = limiteInferior;
            this.limiteSuperior = limiteSuperior;
            numeroSecreto.setRango(this.limiteInferior, this.limiteSuperior);
    }
    
    /**
     *
     * @param intentos
     */
    public void setNumeroDeIntentos(int intentos) {
        this.numeroDeIntentos = intentos;
    }
    
    /**
     *
     * @return
     */
    public int getNumeroSecreto(){
        return numeroSecreto.getNumeroSecreto();
    }
    
    /**
     *
     * @param numero
     * @return
     */
    public boolean esElNumeroSecreto(int numero) {
        this.intentosRealizados++;
        return numeroSecreto.esIgual(numero);
    }

    /**
     *
     * @return
     */
    public boolean puedeIntentarDeNuevo() {
        boolean hayMasOportunidades = this.intentosRestantes() > 0;
        return hayMasOportunidades;
    }

    /**
     *
     * @return
     */
    public int intentosRestantes() {
        int numeroDeIntentosRestantes = this.numeroDeIntentos - this.intentosRealizados;
        return (numeroDeIntentosRestantes);
    }

    /**
     *
     * @param numero
     * @return
     */
    public String getTextoDeAyuda(int numero) {
        String texto = null;
        if (this.numeroSecreto.esMayor(numero) == true) {
        texto = "mayor";
        }
        else if (this.numeroSecreto.esMenor(numero) == true) {
        texto = "menor";
        }
        return texto;
    }
}

