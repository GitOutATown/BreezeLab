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
  DenseVector.rand(4000)                          //> res4: breeze.linalg.DenseVector[Double] = DenseVector(0.5146516203558829, 0
                                                  //| .2818361654911514, 0.9690475192211179, 0.6926210726666981, 0.64391798249175
                                                  //| 56, 0.11969168098057148, 0.31162394568974605, 0.6718126623257956, 0.2218127
                                                  //| 114579742, 0.661540415744073, 0.9127332719068582, 0.9988581119277862, 0.875
                                                  //| 6542019662206, 0.5506359700474162, 0.3568533042304156, 0.9796779057270213, 
                                                  //| 0.42879841534345453, 0.31559464564923667, 0.9730259846520304, 0.66892271365
                                                  //| 90017, 0.5433717094216259, 0.4405675753100884, 0.6496312028404545, 0.142631
                                                  //| 65972956138, 0.8076827745378732, 0.45850079688147827, 0.875770549692831, 0.
                                                  //| 4885034917057933, 0.7103436506080154, 0.665475382959519, 0.9370176367087122
                                                  //| , 0.29670216968950314, 0.5141905516817504, 0.6807063578378576, 0.5010528612
                                                  //| 273897, 0.3828282772691929, 0.13406795981369868, 0.4027288137180365, 0.9712
                                                  //| 588273108649, 0.7035584719759376, 0.4242005478661941, 0.8611778565497767, 0
                                                  //| .8980693626355594, 0.76
                                                  //| Output exceeds cutoff limit.
  // Matrix of random elements from 0 to 1
  println(DenseMatrix.rand(2,3))                  //> 0.917805609434176   0.33618348734995074  0.5636401993914171   
                                                  //| 0.5440485888572446  0.5198812419640708   0.24768569821542097  
}