package com.belajar.rest_api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity

public class Hardware {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // untuk Menggenerate AutoIncrement
    private Long id;

        @Column(name = "tipe")
        private String tipe;

        @Column(name = "merk")
        private String merk;

        @Column(name = "harga")
        private Long harga;

        @Column(name = "jenis_garansi")
        private String jenisGaransi;
}
