package com.aqume.breeze

// https://github.com/scalanlp/breeze/wiki/Quickstart

import breeze.linalg._

object Breeze_lab_1 {

	val x = DenseVector.zeros[Double](5)      //> x  : breeze.linalg.DenseVector[Double] = DenseVector(0.0, 0.0, 0.0, 0.0, 0.0
                                                  //| )
	val x2 = DenseVector(1,2,3)               //> x2  : breeze.linalg.DenseVector[Int] = DenseVector(1, 2, 3)
	val xSparse = SparseVector.zeros[Double](5)
                                                  //> xSparse  : breeze.linalg.SparseVector[Double] = SparseVector()
  x(0)                                            //> res0: Double = 0.0
  x(1) = 2
  x(3 to 4) := .5                                 //> res1: breeze.linalg.DenseVector[Double] = DenseVector(0.5, 0.5)
  println(x)                                      //> DenseVector(0.0, 2.0, 0.0, 0.5, 0.5)
  x(0 to 1) := DenseVector(.1, .2)                //> Jun 29, 2014 6:44:15 PM com.github.fommil.netlib.BLAS <clinit>
                                                  //| WARNING: Failed to load implementation from: com.github.fommil.netlib.Native
                                                  //| SystemBLAS
                                                  //| Jun 29, 2014 6:44:15 PM com.github.fommil.netlib.BLAS <clinit>
                                                  //| WARNING: Failed to load implementation from: com.github.fommil.netlib.Native
                                                  //| RefBLAS
                                                  //| res2: breeze.linalg.DenseVector[Double] = DenseVector(0.1, 0.2)
  x                                               //> res3: breeze.linalg.DenseVector[Double] = DenseVector(0.1, 0.2, 0.0, 0.5, 0.
                                                  //| 5)
                          
  
  val matx1 = DenseMatrix.zeros[Int](5,5)         //> matx1  : breeze.linalg.DenseMatrix[Int] = 0  0  0  0  0  
                                                  //| 0  0  0  0  0  
                                                  //| 0  0  0  0  0  
                                                  //| 0  0  0  0  0  
                                                  //| 0  0  0  0  0  
 
  (matx1.rows, matx1.cols)                        //> res4: (Int, Int) = (5,5)
  
  matx1(::,1)                                     //> res5: breeze.linalg.DenseVector[Int] = DenseVector(0, 0, 0, 0, 0)
  matx1(4,::) := DenseVector(1,2,3,4,5).t         //> res6: breeze.linalg.Transpose[breeze.linalg.DenseVector[Int]] = Transpose(De
                                                  //| nseVector(1, 2, 3, 4, 5))
  println(matx1)                                  //> 0  0  0  0  0  
                                                  //| 0  0  0  0  0  
                                                  //| 0  0  0  0  0  
                                                  //| 0  0  0  0  0  
                                                  //| 1  2  3  4  5  
  matx1.size                                      //> res7: Int = 25
  matx1(2,::) := DenseVector(4,4,4,4,4).t         //> res8: breeze.linalg.Transpose[breeze.linalg.DenseVector[Int]] = Transpose(De
                                                  //| nseVector(4, 4, 4, 4, 4))
  println(matx1)                                  //> 0  0  0  0  0  
                                                  //| 0  0  0  0  0  
                                                  //| 4  4  4  4  4  
                                                  //| 0  0  0  0  0  
                                                  //| 1  2  3  4  5  
  matx1(::,3)                                     //> res9: breeze.linalg.DenseVector[Int] = DenseVector(0, 0, 4, 0, 4)
  matx1(::,3) := DenseVector(3,3,3,3,3)           //> res10: breeze.linalg.DenseVector[Int] = DenseVector(3, 3, 3, 3, 3)
  println(matx1)                                  //> 0  0  0  3  0  
                                                  //| 0  0  0  3  0  
                                                  //| 4  4  4  3  4  
                                                  //| 0  0  0  3  0  
                                                  //| 1  2  3  3  5  
  
  matx1(0 to 1, 0 to 1) := DenseMatrix((3,1),(-1,-2))
                                                  //> res11: breeze.linalg.DenseMatrix[Int] = 3   1   
                                                  //| -1  -2  
  println(matx1.toString)                         //> 3   1   0  3  0  
                                                  //| -1  -2  0  3  0  
                                                  //| 4   4   4  3  4  
                                                  //| 0   0   0  3  0  
                                                  //| 1   2   3  3  5  
  
}