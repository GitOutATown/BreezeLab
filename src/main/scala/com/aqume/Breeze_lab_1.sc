package com.aqume

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
  x                                               //> res2: breeze.linalg.DenseVector[Double] = DenseVector(0.0, 2.0, 0.0, 0.5, 0.
                                                  //| 5)
  x(0 to 1) := DenseVector(.1, .2)                //> Jun 24, 2014 11:03:51 PM com.github.fommil.netlib.BLAS <clinit>
                                                  //| WARNING: Failed to load implementation from: com.github.fommil.netlib.Native
                                                  //| SystemBLAS
                                                  //| Jun 24, 2014 11:03:51 PM com.github.fommil.netlib.BLAS <clinit>
                                                  //| WARNING: Failed to load implementation from: com.github.fommil.netlib.Native
                                                  //| RefBLAS
                                                  //| res3: breeze.linalg.DenseVector[Double] = DenseVector(0.1, 0.2)
  x                                               //> res4: breeze.linalg.DenseVector[Double] = DenseVector(0.1, 0.2, 0.0, 0.5, 0.
                                                  //| 5)
  
  val matx1 = DenseMatrix.zeros[Int](5,5)         //> matx1  : breeze.linalg.DenseMatrix[Int] = 0  0  0  0  0  
                                                  //| 0  0  0  0  0  
                                                  //| 0  0  0  0  0  
                                                  //| 0  0  0  0  0  
                                                  //| 0  0  0  0  0  
  (matx1.rows, matx1.cols)                        //> res5: (Int, Int) = (5,5)
  
  matx1(::,1)                                     //> res6: breeze.linalg.DenseVector[Int] = DenseVector(0, 0, 0, 0, 0)
  matx1(4,::) := DenseVector(1,2,3,4,5).t         //> res7: breeze.linalg.Transpose[breeze.linalg.DenseVector[Int]] = Transpose(De
                                                  //| nseVector(1, 2, 3, 4, 5))
  matx1                                           //> res8: breeze.linalg.DenseMatrix[Int] = 0  0  0  0  0  
                                                  //| 0  0  0  0  0  
                                                  //| 0  0  0  0  0  
                                                  //| 0  0  0  0  0  
                                                  //| 1  2  3  4  5  
}