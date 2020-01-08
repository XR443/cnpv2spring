/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localhost.cnp.cnpv2spring.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import localhost.cnp.cnpv2spring.calculation.PropertyType;

/**
 *
 * @author HardLOLMaster
 */
@Entity
@Table(name = "ADDRESSES")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*@OneToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;*/
    
    @Column(name = "building_year")
    private Integer buildingYear;
    
    @Column(name = "index")
    private String index;

    @Column(name = "country",
            nullable = false)
    private String country;

    @Column(name = "district")
    private String district;

    @Column(name = "region",
            nullable = false)
    private String region;

    @Column(name = "city",
            nullable = false)
    private String city;

    @Column(name = "street",
            nullable = false)
    private String street;

    @Column(name = "building")
    private Integer building;

    @Column(name = "corpus")
    private String corpus;
    //строение
    @Column(name = "building_case")
    private String buildingCase;

    @Column(name = "apartament",
            nullable = false)
    private Integer apartament;

    @Column(name = "type",
            nullable = false)
    private PropertyType type;
    public Address() {

    }

    public Address(Integer buildingYear, String index, String country, String district, String region, String city, String street, Integer building, String corpus, String buildingCase, Integer apartament, PropertyType type) {
        this.buildingYear = buildingYear;
        this.index = index;
        this.country = country;
        this.district = district;
        this.region = region;
        this.city = city;
        this.street = street;
        this.building = building;
        this.corpus = corpus;
        this.buildingCase = buildingCase;
        this.apartament = apartament;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }*/

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getBuilding() {
        return building;
    }

    public void setBuilding(Integer building) {
        this.building = building;
    }

    public String getCorpus() {
        return corpus;
    }

    public void setCorpus(String corpus) {
        this.corpus = corpus;
    }

    public String getBuildingCase() {
        return buildingCase;
    }

    public void setBuildingCase(String buildingCase) {
        this.buildingCase = buildingCase;
    }

    public Integer getApartament() {
        return apartament;
    }

    public void setApartament(Integer apartament) {
        this.apartament = apartament;
    }

    public PropertyType getType() {
        return type;
    }

    public void setType(PropertyType type) {
        this.type = type;
    }

    public Integer getBuildingYear() {
        return buildingYear;
    }

    public void setBuildingYear(Integer buildingYear) {
        this.buildingYear = buildingYear;
    }
    
}
