package com.example.demo.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Movie(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Int = 0,
    var name:String = "",
    var rating:Double = 0.0
)
