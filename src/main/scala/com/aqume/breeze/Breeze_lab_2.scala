package com.aqume.breeze

import breeze.linalg._

object Breeze_lab_2 extends App {
    
    println("====== Vectors =======")
    
	val v1 = DenseVector.zeros[Double](97)
	println("v1: " + v1 + "\n")
	
	val v2 = DenseVector.ones[Double](97)
	println("v2: " + v2 + "\n")
	
	val v3 = v1 + v2
	println("v3: " + v3 + "\n")
	
	//val v4 = v2 * v3 // error
	
	val v4 = v2 :* v3
	println("v2 :* v3: " + v4 + "\n")
    
    val v5 = v2 :*= 4.0
    println("v5: " + v5 + "\n")
	
	println("\n====== Matrices =======\n")
	
	val m1 = DenseMatrix((1,2,3), (4,5,6))
	println("m1:\n" + m1 + "\n")
	
	val m2 = DenseMatrix.ones[Int](2,3)
	println("m2:\n" + m2 + "\n")
	
	val m3 = m1 + m2
	println("m3:\n" + m3 + "\n")
    
    val m4 = m1 :+= 1
    println("m4:\n" + m4 + "\n")
    
    //val m5 = m1 * m4 // error
    
    println("m4.activeSize: " + m4.activeSize)
    println("m4.size: " + m4.size)
    println("m4 dim: " + (m4.rows, m4.cols))
    println("m1 dim: " + (m1.rows, m1.cols))
    
    val m5 = m1 * m4.t
    println("\nm5:\n" + m5)
    
    val m6 = m1.t * m4
    println("\nm6:\n" + m6)
    
}






