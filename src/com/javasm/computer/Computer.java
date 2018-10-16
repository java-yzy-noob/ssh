package com.javasm.computer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Computer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="computer"
    ,catalog="student"
)

public class Computer  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;


    // Constructors

    /** default constructor */
    public Computer() {
    }

    
    /** full constructor */
    public Computer(String name) {
        this.name = name;
    }

   
    // Property accessors
    @Id @GeneratedValue
    
    @Column(name="id", unique=true, nullable=false)

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="name", length=25)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }


	@Override
	public String toString() {
		return "Computer [id=" + id + ", name=" + name + "]";
	}
   








}