package com.example.CrudSpring.entity;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length =60)
    private String producto;

    @Column(nullable = false, length =60)
    private String categoria;

    @Column(nullable = false, length =60)
    private String cliente;

    @Column(nullable = false)
    private float cantidad;

    public Product(Long id, String producto, String categoria, String cliente, float cantidad) {
        super();
        this.id = id;
        this.producto = producto;
        this.categoria = categoria;
        this.cliente = cliente;
        this.cantidad = cantidad;
    }

    public Product(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }
}
