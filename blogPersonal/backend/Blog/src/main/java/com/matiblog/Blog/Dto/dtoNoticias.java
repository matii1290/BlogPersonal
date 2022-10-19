/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matiblog.Blog.Dto;

import javax.validation.constraints.NotBlank;


public class dtoNoticias {
    @NotBlank
    private String nombreN;
    @NotBlank
    private String descripcionN;

//constructores

    public dtoNoticias() {
    }

    public dtoNoticias(String nombreN, String descripcionN) {
        this.nombreN = nombreN;
        this.descripcionN = descripcionN;
    }
    
    //getter and setters

    public String getNombreN() {
        return nombreN;
    }

    public void setNombreN(String nombreN) {
        this.nombreN = nombreN;
    }

    public String getDescripcionN() {
        return descripcionN;
    }

    public void setDescripcionN(String descripcionN) {
        this.descripcionN = descripcionN;
    }
    

}
