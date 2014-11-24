package com.aqume.breeze

import breeze.linalg._
//import breeze.numerics._

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
  // Matrix inline creation - tuples are rows
  val dmil = DenseMatrix((1.0, 2.0, 3.0), (3.0, 4.0, 5.0))
                                                  //> dmil  : breeze.linalg.DenseMatrix[Double] = 1.0  2.0  3.0  
                                                  //| 3.0  4.0  5.0  
  println("\nInline Matrix:\n" + dmil)            //> 
                                                  //| Inline Matrix:
                                                  //| 1.0  2.0  3.0  
                                                  //| 3.0  4.0  5.0  
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
  DenseVector.rand(4000)                          //> res4: breeze.linalg.DenseVector[Double] = DenseVector(0.6697350978489744, 0
                                                  //| .46708179638659675, 0.705253046571807, 0.4792309504044785, 0.43912764296143
                                                  //| 525, 0.1803099582420311, 0.4034546127463843, 0.5395588543871925, 0.75378512
                                                  //| 7778646, 0.04903280515774977, 0.4437818177151738, 0.6540712657125713, 0.005
                                                  //| 895637486097005, 0.8253762845350188, 0.7902398369478043, 0.5693072121400213
                                                  //| , 0.8235684234649161, 0.2904930647234192, 0.34337101139465154, 0.2312960059
                                                  //| 7365774, 0.27471829870920095, 0.6282480161771631, 0.617554345791721, 0.2360
                                                  //| 6336023515784, 0.6533501284191507, 0.16044151618936242, 0.6935563529313864,
                                                  //|  0.8436814494310878, 0.47516684410388765, 0.32724630980550695, 0.6508219172
                                                  //| 223919, 0.44487195510510213, 0.9758324627259292, 0.7729739411115983, 0.0473
                                                  //| 4531804156483, 0.09490222431583883, 0.35188996085068003, 0.8240381666246135
                                                  //| , 0.19556641337378333, 0.7477049627986909, 0.6644382865906164, 0.9473389387
                                                  //| 320788, 0.0746788101597
                                                  //| Output exceeds cutoff limit.
  // Matrix of random elements from 0 to 1
  println(DenseMatrix.rand(2,3))                  //> 0.6810743370754493   0.8935390807195474  0.29264892759607486  
                                                  //| 0.07349257593800651  0.8682592617609017  0.21188729266010675  
}