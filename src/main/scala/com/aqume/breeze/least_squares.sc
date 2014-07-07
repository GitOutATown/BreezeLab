package com.aqume.breeze

import breeze.linalg._
import breeze.stats.distributions._

object least_squares {
	val gau = Gaussian(0.0, 1.0)              //> gau  : breeze.stats.distributions.Gaussian = Gaussian(0.0, 1.0)
  val X = new DenseMatrix(1000, 5, gau.sample(5000).toArray)
                                                  //> X  : breeze.linalg.DenseMatrix[Double] = -0.3976967759888243   -1.1721979681
                                                  //| 511123   ... (5 total)
                                                  //| 0.590452704700019     1.3423638994234408    ...
                                                  //| -1.9033219099114373   -0.9128632449416996   ...
                                                  //| 0.28013044030633766   -0.34896416022001947  ...
                                                  //| -0.3238603561816882   0.6936305271968028    ...
                                                  //| 1.3850535260134251    0.34814614212995404   ...
                                                  //| -0.7127257087817452   -0.13051223522635366  ...
                                                  //| -0.5715334310332526   0.365457533025972     ...
                                                  //| 0.16630011840379574   0.38461136565203674   ...
                                                  //| -0.6570122442479193   -0.575844508576401    ...
                                                  //| -1.3851408533151963   -1.112921377425585    ...
                                                  //| 0.0696231970515924    0.32216902795872154   ...
                                                  //| -0.4897469068704971   -0.24787091034978992  ...
                                                  //| 0.6605338429056926    0.053265469482483944  ...
                                                  //| 0.49732073090663537   -0.17254706755161672  ...
                                                  //| 0.8160920465148793    1.887396582509466     ...
                                                  //| -0.9237942005900451   1.6708791383526953    ...
                                                  //| 0.019701435819291256  0.5229804826672602    ...
                                                  //| 0.68
                                                  //| Output exceeds cutoff limit.
  println("X dim: " + (X.rows, X.cols))           //> X dim: (1000,5)
  val b0 = linspace(1.0, 2.0, 5)                  //> b0  : breeze.linalg.DenseVector[Double] = DenseVector(1.0, 1.25, 1.5, 1.75, 
                                                  //| 2.0)
  println("\nb0 length: " + b0.length)            //> 
                                                  //| b0 length: 5
  val y0 = X * b0                                 //> Jun 30, 2014 7:22:45 PM com.github.fommil.netlib.BLAS <clinit>
                                                  //| WARNING: Failed to load implementation from: com.github.fommil.netlib.Native
                                                  //| SystemBLAS
                                                  //| Jun 30, 2014 7:22:45 PM com.github.fommil.netlib.BLAS <clinit>
                                                  //| WARNING: Failed to load implementation from: com.github.fommil.netlib.Native
                                                  //| RefBLAS
                                                  //| y0  : breeze.linalg.DenseVector[Double] = DenseVector(1.820142572113717, 4.8
                                                  //| 475355031196194, -4.80247654076181, -3.0190125825691294, -2.270486395936009,
                                                  //|  2.7656610664738785, -0.8576728563398228, 7.580435841823264, -5.697235461334
                                                  //| 209, 1.3766514510148693, -5.802366606122728, 4.504947583608965, -4.495842272
                                                  //| 221276, 4.242189406819003, 1.281818230800719, 2.2118422793599506, 5.14818338
                                                  //| 41578135, 0.0030017945610541358, 6.243071914037036, 2.543717118957694, -0.37
                                                  //| 754477376464, 3.6196336661256927, 5.800318453094374, -3.092732490925279, 4.7
                                                  //| 41703233504547, -6.258971164593019, -1.209499790821676, 11.43610016588559, 1
                                                  //| .38762510072735, -0.16055
                                                  //| Output exceeds cutoff limit.
  println("\ny0 length: " + y0.length)            //> 
                                                  //| y0 length: 1000
	val y = y0 + DenseVector(gau.sample(1000).toArray)
                                                  //> y  : breeze.linalg.DenseVector[Double] = DenseVector(1.6049954336247827, 4.8
                                                  //| 96358613738048, -4.642821449509513, -3.6359754853962345, -2.593140061230627,
                                                  //|  3.959055577632406, -1.6782797958546285, 8.01310445089392, -5.85826166964998
                                                  //| 7, 1.9311836462094554, -4.903840602852611, 2.5337837811440505, -3.3324567024
                                                  //| 071166, 4.935710992845609, 0.4237610137771506, 1.8227940859004776, 5.5057056
                                                  //| 29323305, 0.1784161342078605, 7.508367661386204, 3.2873002316406934, -0.8935
                                                  //| 066194976872, 3.857452051735054, 6.5562224915480005, -2.603383978078136, 3.3
                                                  //| 65156135403362, -5.325850778206011, -3.0673595451977924, 11.834356309488555,
                                                  //|  0.9280547725612055, -0.7783475104987622, 0.11564709008373195, 3.76770819420
                                                  //| 33266, 2.63127466674129, 2.2434303864984866, 5.73786914916322, -1.4889166915
                                                  //| 950904, -4.571144360793196, -1.0721753656265844, -4.719404211322432, -2.5396
                                                  //| 941255739494, -1.8352741446675729, 0.8317429207960026, -1.9876910804082017, 
                                                  //| -2.8340820208635957, 1.9
                                                  //| Output exceeds cutoff limit.
	
	println("\ny length: " + y.length)        //> 
                                                  //| y length: 1000
  // QR solver
  // /Users/hieronymus/Development/Machine Learning/ML/Using a QR Decomposition to Solve Linear Systems.pdf
  val b = X \ y                                   //> Jun 30, 2014 7:22:45 PM com.github.fommil.netlib.LAPACK <clinit>
                                                  //| WARNING: Failed to load implementation from: com.github.fommil.netlib.Native
                                                  //| SystemLAPACK
                                                  //| Jun 30, 2014 7:22:45 PM com.github.fommil.netlib.LAPACK <clinit>
                                                  //| WARNING: Failed to load implementation from: com.github.fommil.netlib.Native
                                                  //| RefLAPACK
                                                  //| b  : breeze.linalg.DenseVector[Double] = DenseVector(1.019967653303733, 1.23
                                                  //| 04957212980026, 1.527104868310748, 1.7961018872336207, 1.9984640173233204)
  println("\nb length: " + b.length)              //> 
                                                  //| b length: 5
}