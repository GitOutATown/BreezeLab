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
  val m3 = new DenseMatrix(5, 5, (1 to 25).toArray)
                                                  //> m3  : breeze.linalg.DenseMatrix[Int] = 1  6   11  16  21  
                                                  //| 2  7   12  17  22  
                                                  //| 3  8   13  18  23  
                                                  //| 4  9   14  19  24  
                                                  //| 5  10  15  20  25  
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
  println("\nm3:\n" + m3 + "\n")                  //> 
                                                  //| m3:
                                                  //| 1  6   11  16  21  
                                                  //| 2  7   12  17  22  
                                                  //| 3  8   13  18  23  
                                                  //| 4  9   14  19  24  
                                                  //| 5  10  15  20  25  
                                                  //| 
  
  //------- Sum operations ------------------------------------//
  
  // Elementwise sum
  sum(v1)                                         //> res0: Int = 55
  sum(v2)                                         //> res1: Int = 155
  
  sum(m1)                                         //> res2: Int = 55
  sum(m2)                                         //> res3: Int = 155
  
  // Sum each column (giving a row vector)
  sum(m1(::, *))                                  //> res4: breeze.linalg.DenseMatrix[Int] = 15  40  
  sum(m2.t(::, *))                                //> res5: breeze.linalg.DenseMatrix[Int] = 27  29  31  33  35  
  
  // Sum across each row (giving a column vector)
  sum(m1(*,::))                                   //> res6: breeze.linalg.DenseVector[Int] = DenseVector(7, 9, 11, 13, 15)
  sum(m1.t(*,::))                                 //> res7: breeze.linalg.DenseVector[Int] = DenseVector(15, 40)
  
  // trace (sum of diagonal elements)
  trace(m3)                                       //> res8: Int = 65
  
  // Cumulative sum (vector only)
  accumulate(v1)                                  //> res9: breeze.linalg.DenseVector[Int] = DenseVector(1, 3, 6, 10, 15, 21, 28, 
                                                  //| 36, 45, 55)
}