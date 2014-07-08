package com.aqume.breeze

import breeze.linalg._
//import breeze.numerics._

object QuickReference2 {

	// Matrix creation from array
  val m1 = new DenseMatrix(2, 3, Array(11,21,12,22,13,23))
                                                  //> m1  : breeze.linalg.DenseMatrix[Int] = 11  12  13  
                                                  //| 21  22  23  
  println("\n" + m1)                              //> 
                                                  //| 11  12  13  
                                                  //| 21  22  23  
  val m2 = new DenseMatrix(5, 5, (1 to 25).toArray)
                                                  //> m2  : breeze.linalg.DenseMatrix[Int] = 1  6   11  16  21  
                                                  //| 2  7   12  17  22  
                                                  //| 3  8   13  18  23  
                                                  //| 4  9   14  19  24  
                                                  //| 5  10  15  20  25  
  println("\n" + m2)                              //> 
                                                  //| 1  6   11  16  21  
                                                  //| 2  7   12  17  22  
                                                  //| 3  8   13  18  23  
                                                  //| 4  9   14  19  24  
                                                  //| 5  10  15  20  25  
  // Vector from function
  val v1 = DenseVector.tabulate(2 to 12 by 2)(i => i + 1)
                                                  //> v1  : breeze.linalg.DenseVector[Int] = DenseVector(3, 5, 7, 9, 11, 13)

  //----- Indexing and Slicing -------------------//
  
  // Basic indexing
  m1(0,1)                                         //> res0: Int = 12
  m1(1,2)                                         //> res1: Int = 23
  
  // Extract subset of vector
  v1(1 to 1)                                      //> res2: breeze.linalg.DenseVector[Int] = DenseVector(5)
  v1(1 to 4)                                      //> res3: breeze.linalg.DenseVector[Int] = DenseVector(5, 7, 9, 11)
  v1(1 until 5)                                   //> res4: breeze.linalg.DenseVector[Int] = DenseVector(5, 7, 9, 11)
  v1.slice(1,5)                                   //> res5: breeze.linalg.DenseVector[Int] = DenseVector(5, 7, 9, 11)
  
  // Extract by negative steps
  v1(4 to 1 by -1)                                //> res6: breeze.linalg.DenseVector[Int] = DenseVector(11, 9, 7, 5)
  
  // tail
  v1(1 to -1)                                     //> res7: breeze.linalg.DenseVector[Int] = DenseVector(5, 7, 9, 11, 13)
  // slice from index to end
  v1(2 to -1)                                     //> res8: breeze.linalg.DenseVector[Int] = DenseVector(7, 9, 11, 13)
  // last element
  v1(-1)                                          //> res9: Int = 13
  
  // Extract column of matrix (as col vector)
  m1(::,1)                                        //> res10: breeze.linalg.DenseVector[Int] = DenseVector(12, 22)
  // Extract row of matrix as row vector
  m1(1,::)                                        //> res11: breeze.linalg.Transpose[breeze.linalg.DenseVector[Int]] = Transpose(D
                                                  //| enseVector(21, 22, 23))
  //------ Other Manipulation --------------------//
  
  println(m1)                                     //> 11  12  13  
                                                  //| 21  22  23  
  // Reshaping
  println(m1.reshape(3, 2))                       //> 11  22  
                                                  //| 21  13  
                                                  //| 12  23  
  
  // Flatten matrix
  m1.toDenseVector                                //> res12: breeze.linalg.DenseVector[Int] = DenseVector(11, 21, 12, 22, 13, 23)
  
  // Copy lower triangle
  println(lowerTriangular(m2))                    //> 1  0   0   0   0   
                                                  //| 2  7   0   0   0   
                                                  //| 3  8   13  0   0   
                                                  //| 4  9   14  19  0   
                                                  //| 5  10  15  20  25  
  // Copy upper triangle
  println(upperTriangular(m2))                    //> 1  6  11  16  21  
                                                  //| 0  7  12  17  22  
                                                  //| 0  0  13  18  23  
                                                  //| 0  0  0   19  24  
                                                  //| 0  0  0   0   25  
  // Create view of matrix diagonal
  diag(m2)                                        //> res13: breeze.linalg.DenseVector[Int] = DenseVector(1, 7, 13, 19, 25)
  
  // Vector assignment to subset
  v1(1 to 4) := 5                                 //> res14: breeze.linalg.DenseVector[Int] = DenseVector(5, 5, 5, 5)
  v1                                              //> res15: breeze.linalg.DenseVector[Int] = DenseVector(3, 5, 5, 5, 5, 13)
  v1(1 to 3) := DenseVector(95, 96, 97)           //> res16: breeze.linalg.DenseVector[Int] = DenseVector(95, 96, 97)
  v1                                              //> res17: breeze.linalg.DenseVector[Int] = DenseVector(3, 95, 96, 97, 5, 13)
  
  // Matrix assignment to subset
  m2(0 to 2, 2 to 4) := 42                        //> res18: breeze.linalg.DenseMatrix[Int] = 42  42  42  
                                                  //| 42  42  42  
                                                  //| 42  42  42  
  println("\n" + m2)                              //> 
                                                  //| 1  6   42  42  42  
                                                  //| 2  7   42  42  42  
                                                  //| 3  8   42  42  42  
                                                  //| 4  9   14  19  24  
                                                  //| 5  10  15  20  25  
  // Matrix assignment to column
  m2(::,0) := 70                                  //> res19: breeze.linalg.DenseVector[Int] = DenseVector(70, 70, 70, 70, 70)
  println("\n" + m2)                              //> 
                                                  //| 70  6   42  42  42  
                                                  //| 70  7   42  42  42  
                                                  //| 70  8   42  42  42  
                                                  //| 70  9   14  19  24  
                                                  //| 70  10  15  20  25  
  // Matrix vertical concatinate
  val m3 = m2(3 to 4,::)                          //> m3  : breeze.linalg.DenseMatrix[Int] = 70  9   14  19  24  
                                                  //| 70  10  15  20  25  
  println("\n" + DenseMatrix.vertcat(m3, m2) + "\n")
                                                  //> 
                                                  //| 70  9   14  19  24  
                                                  //| 70  10  15  20  25  
                                                  //| 70  6   42  42  42  
                                                  //| 70  7   42  42  42  
                                                  //| 70  8   42  42  42  
                                                  //| 70  9   14  19  24  
                                                  //| 70  10  15  20  25  
                                                  //| 
  val m4 = m2(::, 3 to -1)                        //> m4  : breeze.linalg.DenseMatrix[Int] = 42  42  
                                                  //| 42  42  
                                                  //| 42  42  
                                                  //| 19  24  
                                                  //| 20  25  
  // Matrix horizontal concatinate
  println("\n" + DenseMatrix.horzcat(m2, m4))     //> 
                                                  //| 70  6   42  42  42  42  42  
                                                  //| 70  7   42  42  42  42  42  
                                                  //| 70  8   42  42  42  42  42  
                                                  //| 70  9   14  19  24  19  24  
                                                  //| 70  10  15  20  25  20  25  
  // Vector concatenate
  val v2 = DenseVector((1 to 5).toArray)          //> v2  : breeze.linalg.DenseVector[Int] = DenseVector(1, 2, 3, 4, 5)
  val v3 = DenseVector((6 to 12).toArray)         //> v3  : breeze.linalg.DenseVector[Int] = DenseVector(6, 7, 8, 9, 10, 11, 12)
  val v4 = DenseVector.vertcat(v2, v3)            //> v4  : breeze.linalg.DenseVector[Int] = DenseVector(1, 2, 3, 4, 5, 6, 7, 8, 
                                                  //| 9, 10, 11, 12)
  
  // play
  println(new DenseMatrix(3,4, v4.toArray))       //> 1  4  7  10  
                                                  //| 2  5  8  11  
                                                  //| 3  6  9  12  
}