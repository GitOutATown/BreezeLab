package com.aqume.breeze

import breeze.linalg._
import breeze.numerics._

object QuickReference3 {
  
  val v1 = DenseVector((1 to 10).toArray)         //> v1  : breeze.linalg.DenseVector[Int] = DenseVector(1, 2, 3, 4, 5, 6, 7, 8, 9
                                                  //| , 10)
  val v2 = DenseVector((11 to 20).toArray)        //> v2  : breeze.linalg.DenseVector[Int] = DenseVector(11, 12, 13, 14, 15, 16, 1
                                                  //| 7, 18, 19, 20)
  
  val v3 = DenseVector(1,1,3,3,3,5,7,9,14,15)     //> v3  : breeze.linalg.DenseVector[Int] = DenseVector(1, 1, 3, 3, 3, 5, 7, 9, 1
                                                  //| 4, 15)
  
  val m1 = new DenseMatrix(2, 5, (1 to 10).toArray)
                                                  //> m1  : breeze.linalg.DenseMatrix[Int] = 1  3  5  7  9   
                                                  //| 2  4  6  8  10  
  val m2 = new DenseMatrix(2, 5, (11 to 20).toArray)
                                                  //> m2  : breeze.linalg.DenseMatrix[Int] = 11  13  15  17  19  
                                                  //| 12  14  16  18  20  
  
  val m3 = new DenseMatrix(5, 2, (11 to 20).toArray)
                                                  //> m3  : breeze.linalg.DenseMatrix[Int] = 11  16  
                                                  //| 12  17  
                                                  //| 13  18  
                                                  //| 14  19  
                                                  //| 15  20  
  println("\nm1:\n" + m1)                         //> 
                                                  //| m1:
                                                  //| 1  3  5  7  9   
                                                  //| 2  4  6  8  10  
  println("\nm2:\n" + m2)                         //> 
                                                  //| m2:
                                                  //| 11  13  15  17  19  
                                                  //| 12  14  16  18  20  
  println("\nm3:\n" + m3)                         //> 
                                                  //| m3:
                                                  //| 11  16  
                                                  //| 12  17  
                                                  //| 13  18  
                                                  //| 14  19  
                                                  //| 15  20  
  
  
  //-------- Operations --------------//
  
  // Elementwise addition
  v1 + v2                                         //> res0: breeze.linalg.DenseVector[Int] = DenseVector(12, 14, 16, 18, 20, 22, 2
                                                  //| 4, 26, 28, 30)
  println("\nm1 + m2:\n" + (m1 + m2))             //> 
                                                  //| m1 + m2:
                                                  //| 12  16  20  24  28  
                                                  //| 14  18  22  26  30  
  // with transposition
  println("\nm1 + m3:\n" + (m1 + m3.t))           //> 
                                                  //| m1 + m3:
                                                  //| 12  15  18  21  24  
                                                  //| 18  21  24  27  30  
  // Elementwise multiplication
  v1 :* v2                                        //> res1: breeze.linalg.DenseVector[Int] = DenseVector(11, 24, 39, 56, 75, 96, 1
                                                  //| 19, 144, 171, 200)
  println("\nm1 * m2:\n" + (m1 :* m2))            //> 
                                                  //| m1 * m2:
                                                  //| 11  39  75  119  171  
                                                  //| 24  56  96  144  200  
  // Elementwise comparison
  (v1 :< v2).toArray                              //> res2: Array[Boolean] = Array(true, true, true, true, true, true, true, true,
                                                  //|  true, true)
  (v1 :< v3).toArray                              //> res3: Array[Boolean] = Array(false, false, false, false, false, false, false
                                                  //| , true, true, true)
  (v1 :== v3).toArray                             //> res4: Array[Boolean] = Array(true, false, true, false, false, false, true, f
                                                  //| alse, false, false)
}