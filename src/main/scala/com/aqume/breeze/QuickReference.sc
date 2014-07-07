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
  println("\n" + DenseMatrix.eye[Double](5) + "\n")
                                                  //> 
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
  DenseVector(1,2,3,4).t                          //> res0: breeze.linalg.Transpose[breeze.linalg.DenseVector[Int]] = Transpose(D
                                                  //| enseVector(1, 2, 3, 4))
  // Vector from function
  DenseVector.tabulate(3)(i => 2*i)               //> res1: breeze.linalg.DenseVector[Int] = DenseVector(0, 2, 4)
  DenseVector.tabulate(2 to 10 by 2)(i => i + 1)  //> res2: breeze.linalg.DenseVector[Int] = DenseVector(3, 5, 7, 9, 11)
  
  // Matrix from function
  println(
  	DenseMatrix.tabulate(3, 5){ case (i,j) => i*j }
  )                                               //> 0  0  0  0  0  
                                                  //| 0  1  2  3  4  
                                                  //| 0  2  4  6  8  
  // Vector creation from array
  DenseVector(Array(2,4,6,8))                     //> res3: breeze.linalg.DenseVector[Int] = DenseVector(2, 4, 6, 8)
  
  // Matrix creation from array
  val a = Array(11,21,12,22,13,23)                //> a  : Array[Int] = Array(11, 21, 12, 22, 13, 23)
  val dmfa = new DenseMatrix(2, 3, a)             //> dmfa  : breeze.linalg.DenseMatrix[Int] = 11  12  13  
                                                  //| 21  22  23  
  println("\n" + dmfa)                            //> 
                                                  //| 11  12  13  
                                                  //| 21  22  23  
  // Vector of random elements from 0 to 1
  DenseVector.rand(4)                             //> res4: breeze.linalg.DenseVector[Double] = DenseVector(0.199142202617983, 0.
                                                  //| 027230982515441537, 0.5159708397454372, 0.139847274831139)
  // Matrix of random elements from 0 to 1
  println(DenseMatrix.rand(2,3))                  //> 0.5422532207465687  0.03960673867156861  0.6708252550139144  
                                                  //| 0.7646345580020333  0.04396213158220319  0.1578409986263034  
}