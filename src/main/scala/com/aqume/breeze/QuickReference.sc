package com.aqume.breeze

import breeze.linalg._
import breeze.numerics._

object QuickReference {
	val n = 3                                 //> n  : Int = 3
	val m = 5                                 //> m  : Int = 5
	
  // Zeroed matrix
  val zm1 = DenseMatrix.zeros[Double](n,m)        //> zm1  : breeze.linalg.DenseMatrix[Double] = 0.0  0.0  0.0  0.0  0.0  
                                                  //| 0.0  0.0  0.0  0.0  0.0  
                                                  //| 0.0  0.0  0.0  0.0  0.0  
  println("\nzm1:\n" + zm1)                       //> 
                                                  //| zm1:
                                                  //| 0.0  0.0  0.0  0.0  0.0  
                                                  //| 0.0  0.0  0.0  0.0  0.0  
                                                  //| 0.0  0.0  0.0  0.0  0.0  
  // Zeroed vector (Breeze Vectors are column vectors)
  val zv1 = DenseVector.zeros[Double](m)          //> zv1  : breeze.linalg.DenseVector[Double] = DenseVector(0.0, 0.0, 0.0, 0.0, 0
                                                  //| .0)
  println("\nzv1:\n" + zv1)                       //> 
                                                  //| zv1:
                                                  //| DenseVector(0.0, 0.0, 0.0, 0.0, 0.0)
  println("\nzv1:\n" + zv1.t)                     //> 
                                                  //| zv1:
                                                  //| Transpose(DenseVector(0.0, 0.0, 0.0, 0.0, 0.0))
  // Row vector - really a Matrix
  val rowVect1 = DenseMatrix.zeros[Double](1,5)   //> rowVect1  : breeze.linalg.DenseMatrix[Double] = 0.0  0.0  0.0  0.0  0.0  
  println("\nrowVect1:\n" + rowVect1)             //> 
                                                  //| rowVect1:
                                                  //| 0.0  0.0  0.0  0.0  0.0  
  // Row vector transposed - still a Matrix
  println("\nrowVect1 transposed:\n" + rowVect1.t)//> 
                                                  //| rowVect1 transposed:
                                                  //| 0.0  
                                                  //| 0.0  
                                                  //| 0.0  
                                                  //| 0.0  
                                                  //| 0.0  
  // Row vector transponsed: Now a column vector
  println("\nrowVect1 - now col vect:\n" + rowVect1.t(::,0))
                                                  //> 
                                                  //| rowVect1 - now col vect:
                                                  //| DenseVector(0.0, 0.0, 0.0, 0.0, 0.0)
  // Vector of ones
  println(DenseVector.ones[Double](m))            //> DenseVector(1.0, 1.0, 1.0, 1.0, 1.0)
  // Vector of particular number
  println(DenseVector.fill(5, 4))                 //> DenseVector(4, 4, 4, 4, 4)
  println(DenseVector.fill(5, 4.0))               //> DenseVector(4.0, 4.0, 4.0, 4.0, 4.0)
  // Identity Matrix
  println("\n" +DenseMatrix.eye[Double](5) + "\n")//> 
                                                  //| 1.0  0.0  0.0  0.0  0.0  
                                                  //| 0.0  1.0  0.0  0.0  0.0  
                                                  //| 0.0  0.0  1.0  0.0  0.0  
                                                  //| 0.0  0.0  0.0  1.0  0.0  
                                                  //| 0.0  0.0  0.0  0.0  1.0  
                                                  //| 
  // Diagonal matrix
  println(diag(DenseVector(1.0, 2.0, 3.0)))       //> 1.0  0.0  0.0  
                                                  //| 0.0  2.0  0.0  
                                                  //| 0.0  0.0  3.0  
  // Matrix inline creation
  val dmil = DenseMatrix((1.0, 2.0), (3.0, 4.0))  //> dmil  : breeze.linalg.DenseMatrix[Double] = 1.0  2.0  
                                                  //| 3.0  4.0  
  println("\nInline Matrix:\n" + dmil)            //> 
                                                  //| Inline Matrix:
                                                  //| 1.0  2.0  
                                                  //| 3.0  4.0  
  // Column vector inline creation
  val cvil = DenseVector(1,2,3,4)                 //> cvil  : breeze.linalg.DenseVector[Int] = DenseVector(1, 2, 3, 4)
  
  // Row vector inline creation
}