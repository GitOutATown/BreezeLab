package com.aqume.breeze
import breeze.linalg._

object Matrix_multiplication_lab_2 {
  // Matrix creation from array
  val m1 = new DenseMatrix(2, 3, Array(11, 12, 13, 21, 22, 23))
                                                  //> m1  : breeze.linalg.DenseMatrix[Int] = 11  13  22  
                                                  //| 12  21  23  
  println("\nm1:\n" + m1)                         //> 
                                                  //| m1:
                                                  //| 11  13  22  
                                                  //| 12  21  23  
  
  val m2 = new DenseMatrix(3, 2, Array(2, 4, 3, 1, 3, 2))
                                                  //> m2  : breeze.linalg.DenseMatrix[Int] = 2  1  
                                                  //| 4  3  
                                                  //| 3  2  
  println("\nm2:\n" + m2 + "\n")                  //> 
                                                  //| m2:
                                                  //| 2  1  
                                                  //| 4  3  
                                                  //| 3  2  
                                                  //| 
  m1 * m2                                         //> res0: breeze.linalg.DenseMatrix[Int] = 140  94   
                                                  //| 177  121  
  println("\nm1 * m2:\n" + m1 * m2)               //> 
                                                  //| m1 * m2:
                                                  //| 140  94   
                                                  //| 177  121  
  println("\nm2 * m1:\n" + m2 * m1)               //> 
                                                  //| m2 * m1:
                                                  //| 34  47   67   
                                                  //| 80  115  157  
                                                  //| 57  81   112  
}