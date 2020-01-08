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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import localhost.cnp.cnpv2spring.services.ContractService;


/**
 *
 * @author HardLOLMaster
 */
@Entity
@Table(name = "CONTRACTS")
public class Contract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contract_number",
            unique = true,
            length = 6,
            nullable = false)
    private Integer contractNumber;

    @Column(name = "conclusion_date",
            nullable = false)
    @Temporal(TemporalType.DATE)
    private Date conclusionDate;

    @Column(name = "calculation_date",
            nullable = false)
    @Temporal(TemporalType.DATE)
    private Date calculationDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "policyholder",
            nullable = false)
    private PolicyHolder policyholder;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address",
            nullable = false)
    private Address address;

    @Column(name = "area")
    private Float area;
    
    @Column(name = "prize",
            nullable = false)
    private Float prize;

    @Column(name = "sum",
            nullable = false)
    private Long sum;

    @Column(name = "date_from",
            nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateFrom;

    @Column(name = "date_to",
            nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateTo;

    @Column(name = "comment")
    private String comment;

    public Contract() {
        policyholder = new PolicyHolder();
        address = new Address();
    }

    public Contract(Integer contractNumber,
            Date conclusionDate,
            Date calculationDate,
            PolicyHolder policyholder,
            Address address,
            Float prize,
            Long sum,
            Date dateFrom,
            Date dateTo) {
        this.contractNumber = contractNumber;
        this.conclusionDate = conclusionDate;
        this.calculationDate = calculationDate;
        this.policyholder = policyholder;
        this.address = address;
        this.prize = prize;
        this.sum = sum;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public String formatFFromTo() {
        return formatFDateFrom()+'-'+formatFDateTo();
    }
    
    public String formatFDateFrom() {
        return ContractService.formatFDate(dateFrom);
    }
    
    public String formatFDateTo() {
        return ContractService.formatFDate(dateTo);
    }
    
    public String formatFConclusionDate() {
        return ContractService.formatFDate(conclusionDate);
    }
    
    public String formatFCalculationDate() {
        return ContractService.formatFDate(calculationDate);
    }

    public String formatFromTo() {
        return formatDateFrom()+'-'+formatDateTo();
    }
    
    public String formatDateFrom() {
        return ContractService.formatDate(dateFrom);
    }
    
    public String formatDateTo() {
        return ContractService.formatDate(dateTo);
    }
    
    public String formatConclusionDate() {
        return ContractService.formatDate(conclusionDate);
    }
    
    public String formatCalculationDate() {
        return ContractService.formatDate(calculationDate);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(Integer contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Date getConclusionDate() {
        return conclusionDate;
    }

    public void setConclusionDate(Date conclusionDate) {
        this.conclusionDate = conclusionDate;
    }

    public Date getCalculationDate() {
        return calculationDate;
    }

    public void setCalculationDate(Date calculationDate) {
        this.calculationDate = calculationDate;
    }

    public PolicyHolder getPolicyholder() {
        return policyholder;
    }

    public void setPolicyholder(PolicyHolder policyholder) {
        this.policyholder = policyholder;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Float getPrize() {
        return prize;
    }

    public void setPrize(Float prize) {
        this.prize = prize;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

}
