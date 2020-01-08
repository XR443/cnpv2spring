/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localhost.cnp.cnpv2spring.calculation;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author HardLOLMaster
 */
@XmlType(name="coefficient")
@XmlRootElement
public class Coefficient {
    
    private Float apartament;
    private Float house;
    private Float room;

    private Float coefLowYears;
    private Float coefMiddleYears;
    private Float coefMaxYears;
    
    private Float coefLowArea;
    private Float coefMiddleArea;
    private Float coefMaxArea;

    private Integer minYear;
    private Integer maxYear;
    
    private Integer minArea;
    private Integer maxArea;
    
    Coefficient(){
        
    }

    public Float getCoefLowArea() {
        return coefLowArea;
    }

    public void setCoefLowArea(Float coefLowArea) {
        this.coefLowArea = coefLowArea;
    }

    public Float getCoefMiddleArea() {
        return coefMiddleArea;
    }

    public void setCoefMiddleArea(Float coefMiddleArea) {
        this.coefMiddleArea = coefMiddleArea;
    }

    public Float getCoefMaxArea() {
        return coefMaxArea;
    }

    public void setCoefMaxArea(Float coefMaxArea) {
        this.coefMaxArea = coefMaxArea;
    }

    public Integer getMinArea() {
        return minArea;
    }

    public void setMinArea(Integer minArea) {
        this.minArea = minArea;
    }

    public Integer getMaxArea() {
        return maxArea;
    }

    public void setMaxArea(Integer maxArea) {
        this.maxArea = maxArea;
    }

    public void setApartament(Float apartament) {
        this.apartament = apartament;
    }

    public void setHouse(Float house) {
        this.house = house;
    }

    public void setRoom(Float room) {
        this.room = room;
    }

    public void setCoefMiddleYears(Float coefMiddleYears) {
        this.coefMiddleYears = coefMiddleYears;
    }

    public void setCoefMaxYears(Float coefMaxYears) {
        this.coefMaxYears = coefMaxYears;
    }

    public Float getCoefLowYears() {
        return coefLowYears;
    }

    public void setCoefLowYears(Float coefLowYears) {
        this.coefLowYears = coefLowYears;
    }

    public Integer getMinYear() {
        return minYear;
    }

    public void setMinYear(Integer minYear) {
        this.minYear = minYear;
    }
    
    public Integer getMaxYear() {
        return maxYear;
    }

    public void setMaxYear(Integer maxYear) {
        this.maxYear = maxYear;
    }

    public Float getApartament() {
        return apartament;
    }

    public Float getHouse() {
        return house;
    }

    public Float getRoom() {
        return room;
    }

    public Float getCoefMiddleYears() {
        return coefMiddleYears;
    }

    public Float getCoefMaxYears() {
        return coefMaxYears;
    }
}
