package com.aqume.breeze

import breeze.linalg._

object QuickReference4 {
	//------- Data objects ------------------------------------//
  val v1 = DenseVector((1 to 10).toArray)         //> v1  : breeze.linalg.DenseVector[Int] = DenseVector(1, 2, 3, 4, 5, 6, 7, 8, 9
                                                  //| , 10)
  val v2 = DenseVector((11 to 20).toArray)        //> v2  : breeze.linalg.DenseVector[Int] = DenseVector(11, 12, 13, 14, 15, 16, 1
                                                  //| 7, 18, 19, 20)
  
  val m1 = new DenseMatrix(5, 2, (1 to 10).toArray)
                                                  //> m1  : breeze.linalg.DenseMatrix[Int] = 1  6   
                                                  //| 2  7   
                                                  //| 3  8   
                                                  //| 4  9   
                                                  //| 5  10  
  val m2 = new DenseMatrix(5, 2, (11 to 20).toArray)
                                                  //> m2  : breeze.linalg.DenseMatrix[Int] = 11  16  
                                                  //| 12  17  
                                                  //| 13  18  
                                                  //| 14  19  
                                                  //| 15  20  
  println("\nm1:\n" + m1 + "\n")                  //> 
                                                  //| m1:
                                                  //| 1  6   
                                                  //| 2  7   
                                                  //| 3  8   
                                                  //| 4  9   
                                                  //| 5  10  
                                                  //| 
  println("\nm2:\n" + m2 + "\n")                  //> 
                                                  //| m2:
                                                  //| 11  16  
                                                  //| 12  17  
                                                  //| 13  18  
                                                  //| 14  19  
                                                  //| 15  20  
                                                  //| 
  
  //------- Data objects ------------------------------------//
  
  // Elementwise sum
  sum(v1)                                         //> res0: Int = 55
  sum(v2)                                         //> res1: Int = 155
  
  sum(m1)                                         //> res2: Int = 55
  sum(m2)                                         //> res3: Int = 155
  
  // Sum each column (giving a row vector)
  sum(m1(::, *))                                  //> res4: breeze.linalg.DenseMatrix[Int] = 15  40  
  sum(m2.t(::, *))                                //> res5: breeze.linalg.DenseMatrix[Int] = 27  29  31  33  35  
}