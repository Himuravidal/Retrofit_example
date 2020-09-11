package com.example.retrofit.pojo

data class Recipe(val title: String,
                  val version: Double,
                  val href: String,
                  val results: List<Results> )