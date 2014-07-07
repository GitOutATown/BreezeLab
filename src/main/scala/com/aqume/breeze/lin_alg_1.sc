package com.aqume.breeze
import breeze.linalg._
import breeze.stats.distributions._

object lin_alg_1 {
	val gau = Gaussian(0.0, 1.0)              //> gau  : breeze.stats.distributions.Gaussian = Gaussian(0.0, 1.0)
	val gs1 = gau.sample(20)                  //> gs1  : IndexedSeq[Double] = Vector(-0.7327278452641603, 1.6190608020536241, 
                                                  //| -1.219857790783606, -0.8269856316525671, 0.263928391359541, -0.7115973701622
                                                  //| 132, 1.6434497673984516, -0.4527628985290974, -1.2830908404875712, -0.042800
                                                  //| 94181593492, 0.17392566199139237, -0.13406952261064478, 0.005152278715715969
                                                  //| , 0.408517470062798, 0.4525675973057914, -0.26167266079730434, -0.2661717378
                                                  //| 4548714, -1.0003071668183499, 0.5878303731057886, -1.0627245639311238)
  val v = DenseVector(gs1.toArray)                //> v  : breeze.linalg.DenseVector[Double] = DenseVector(-0.7327278452641603, 1.
                                                  //| 6190608020536241, -1.219857790783606, -0.8269856316525671, 0.263928391359541
                                                  //| , -0.7115973701622132, 1.6434497673984516, -0.4527628985290974, -1.283090840
                                                  //| 4875712, -0.04280094181593492, 0.17392566199139237, -0.13406952261064478, 0.
                                                  //| 005152278715715969, 0.408517470062798, 0.4525675973057914, -0.26167266079730
                                                  //| 434, -0.26617173784548714, -1.0003071668183499, 0.5878303731057886, -1.06272
                                                  //| 45639311238)
  v(1) = 0
  v                                               //> res0: breeze.linalg.DenseVector[Double] = DenseVector(-0.7327278452641603, 0
                                                  //| .0, -1.219857790783606, -0.8269856316525671, 0.263928391359541, -0.711597370
                                                  //| 1622132, 1.6434497673984516, -0.4527628985290974, -1.2830908404875712, -0.04
                                                  //| 280094181593492, 0.17392566199139237, -0.13406952261064478, 0.00515227871571
                                                  //| 5969, 0.408517470062798, 0.4525675973057914, -0.26167266079730434, -0.266171
                                                  //| 73784548714, -1.0003071668183499, 0.5878303731057886, -1.0627245639311238)
  v(1 to 3) := DenseVector(1.0, 1.5, 2.0)         //> Jun 29, 2014 9:42:04 PM com.github.fommil.netlib.BLAS <clinit>
                                                  //| WARNING: Failed to load implementation from: com.github.fommil.netlib.Native
                                                  //| SystemBLAS
                                                  //| Jun 29, 2014 9:42:04 PM com.github.fommil.netlib.BLAS <clinit>
                                                  //| WARNING: Failed to load implementation from: com.github.fommil.netlib.Native
                                                  //| RefBLAS
                                                  //| res1: breeze.linalg.DenseVector[Double] = DenseVector(1.0, 1.5, 2.0)
  v                                               //> res2: breeze.linalg.DenseVector[Double] = DenseVector(-0.7327278452641603, 1
                                                  //| .0, 1.5, 2.0, 0.263928391359541, -0.7115973701622132, 1.6434497673984516, -0
                                                  //| .4527628985290974, -1.2830908404875712, -0.04280094181593492, 0.173925661991
                                                  //| 39237, -0.13406952261064478, 0.005152278715715969, 0.408517470062798, 0.4525
                                                  //| 675973057914, -0.26167266079730434, -0.26617173784548714, -1.000307166818349
                                                  //| 9, 0.5878303731057886, -1.0627245639311238)
  v :> 0.0                                        //> res3: breeze.linalg.BitVector = BitVector(1, 2, 3, 4, 6, 10, 12, 13, 14, 18)
                                                  //| 
  (v :> 0.0).toArray                              //> res4: Array[Boolean] = Array(false, true, true, true, true, false, true, fal
                                                  //| se, false, false, true, false, true, true, true, false, false, false, true, 
                                                  //| false)
}