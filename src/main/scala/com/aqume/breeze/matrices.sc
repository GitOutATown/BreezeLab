package com.aqume.breeze
import breeze.linalg._

object matrices {
	val m = new DenseMatrix(5, 4, linspace(1.0, 20.0, 20).toArray)
                                                  //> m  : breeze.linalg.DenseMatrix[Double] = 1.0  6.0   11.0  16.0  
                                                  //| 2.0  7.0   12.0  17.0  
                                                  //| 3.0  8.0   13.0  18.0  
                                                  //| 4.0  9.0   14.0  19.0  
                                                  //| 5.0  10.0  15.0  20.0  
  println("\n" + m)                               //> 
                                                  //| 1.0  6.0   11.0  16.0  
                                                  //| 2.0  7.0   12.0  17.0  
                                                  //| 3.0  8.0   13.0  18.0  
                                                  //| 4.0  9.0   14.0  19.0  
                                                  //| 5.0  10.0  15.0  20.0  
  (m.rows, m.cols)                                //> res0: (Int, Int) = (5,4)
  
  println(m(::,1))                                //> DenseVector(6.0, 7.0, 8.0, 9.0, 10.0)
  
  m(1,::)                                         //> res1: breeze.linalg.Transpose[breeze.linalg.DenseVector[Double]] = Transpose
                                                  //| (DenseVector(2.0, 7.0, 12.0, 17.0))
  m(1,::) := linspace(1.0,2.0,4).t                //> Jun 29, 2014 10:15:49 PM com.github.fommil.netlib.BLAS <clinit>
                                                  //| WARNING: Failed to load implementation from: com.github.fommil.netlib.Native
                                                  //| SystemBLAS
                                                  //| Jun 29, 2014 10:15:49 PM com.github.fommil.netlib.BLAS <clinit>
                                                  //| WARNING: Failed to load implementation from: com.github.fommil.netlib.Native
                                                  //| RefBLAS
                                                  //| res2: breeze.linalg.Transpose[breeze.linalg.DenseVector[Double]] = Transpose
                                                  //| (DenseVector(1.0, 1.3333333333333333, 1.6666666666666665, 2.0))
  val n = m.t                                     //> n  : breeze.linalg.DenseMatrix[Double] = 1.0   1.0                 3.0   4.0
                                                  //|    5.0   
                                                  //| 6.0   1.3333333333333333  8.0   9.0   10.0  
                                                  //| 11.0  1.6666666666666665  13.0  14.0  15.0  
                                                  //| 16.0  2.0                 18.0  19.0  20.0  
  println("\n" + n)                               //> 
                                                  //| 1.0   1.0                 3.0   4.0   5.0   
                                                  //| 6.0   1.3333333333333333  8.0   9.0   10.0  
                                                  //| 11.0  1.6666666666666665  13.0  14.0  15.0  
                                                  //| 16.0  2.0                 18.0  19.0  20.0  
  val o = m * n                                   //> o  : breeze.linalg.DenseMatrix[Double] = 414.0              59.3333333333333
                                                  //| 3  482.0              516.0              550.0              
                                                  //| 59.33333333333333  9.555555555555555  71.33333333333333  77.33333333333333  
                                                  //| 83.33333333333333  
                                                  //| 482.0              71.33333333333333  566.0              608.0              
                                                  //| 650.0              
                                                  //| 516.0              77.33333333333333  608.0              654.0              
                                                  //| 700.0              
                                                  //| 550.0              83.33333333333333  650.0              700.0              
                                                  //| 750.0              
  println("\nm dim:" + (m.rows, m.cols))          //> 
                                                  //| m dim:(5,4)
  println("\nn dim:" + (n.rows, n.cols))          //> 
                                                  //| n dim:(4,5)
  println("\no:" + (o.rows, o.cols))              //> 
                                                  //| o:(5,5)
  println("\n" + o)                               //> 
                                                  //| 414.0              59.33333333333333  482.0              516.0              
                                                  //| 550.0              
                                                  //| 59.33333333333333  9.555555555555555  71.33333333333333  77.33333333333333  
                                                  //| 83.33333333333333  
                                                  //| 482.0              71.33333333333333  566.0              608.0              
                                                  //| 650.0              
                                                  //| 516.0              77.33333333333333  608.0              654.0              
                                                  //| 700.0              
                                                  //| 550.0              83.33333333333333  650.0              700.0              
                                                  //| 750.0              
}