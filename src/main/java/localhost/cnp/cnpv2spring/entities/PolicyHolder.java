/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localhost.cnp.cnpv2spring.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import localhost.cnp.cnpv2spring.services.ContractService;

/**
 *
 * @author HardLOLMaster
 */
@Entity
@Table(name = "POLICYHOLDERS")
public class PolicyHolder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*@OneToMany(fetch = FetchType.EAGER, mappedBy = "policyholder")
    private List<Contract> contracts = new ArrayList<>();*/
    @Column(name = "last_name",
            nullable = false)
    private String lastName;

    @Column(name = "first_name",
            nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "birthday",
            nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name = "passport_series",
            length = 4)
    private Integer passportSeries;

    @Column(name = "passport_number",
            length = 6,
            unique = true)
    private Integer passportNumber;

    public PolicyHolder() {

    }

    public PolicyHolder(String lastName, String firstName, Date birthday, Integer passportSeries, Integer passportNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
    }

    public PolicyHolder(String lastName, String firstName,Date birthday) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
    }
    

    public String formatBirthday() {
        return ContractService.formatDate(birthday);
    }
    
    public String fio() {
        return String.format("%s %s %s",
                (lastName == null) ? "" : lastName,
                (firstName == null) ? "" : firstName, 
                (middleName == null) ? "" : middleName);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
    
    public void addContract(Contract contract){
        contracts.add(contract);
    }*/
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(Integer passportSeries) {
        this.passportSeries = passportSeries;
    }

    public Integer getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(Integer passportNumber) {
        this.passportNumber = passportNumber;
    }

}
