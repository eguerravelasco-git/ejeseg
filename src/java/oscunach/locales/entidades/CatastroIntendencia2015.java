/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oscunach.locales.entidades;

/**
 *
 * @Edwin Maigua
 */
public class CatastroIntendencia2015 {

    private int codigo;
    private int orpaf;
    private String propietario;
    private String razon_social;
    private String direccion;
    private double valor;
    private String tipo_establecimiento;
    private String parroqui;
    private int categoria;

    public CatastroIntendencia2015() {
    }

    public CatastroIntendencia2015(int codigo, int orpaf, String propietario, String razon_social, String direccion, double valor, String tipo_establecimiento, String parroqui, int categoria) {
        this.codigo = codigo;
        this.orpaf = orpaf;
        this.propietario = propietario;
        this.razon_social = razon_social;
        this.direccion = direccion;
        this.valor = valor;
        this.tipo_establecimiento = tipo_establecimiento;
        this.parroqui = parroqui;
        this.categoria = categoria;
    }

    public String getParroqui() {
        return parroqui;
    }

    public void setParroqui(String parroqui) {
        this.parroqui = parroqui;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getOrpaf() {
        return orpaf;
    }

    public void setOrpaf(int orpaf) {
        this.orpaf = orpaf;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo_establecimiento() {
        return tipo_establecimiento;
    }

    public void setTipo_establecimiento(String tipo_establecimiento) {
        this.tipo_establecimiento = tipo_establecimiento;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

}
