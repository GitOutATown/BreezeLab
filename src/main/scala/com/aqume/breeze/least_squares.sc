package com.aqume.breeze

import breeze.linalg._
import breeze.stats.distributions._

object least_squares {
	val gau = Gaussian(0.0, 1.0)              //> gau  : breeze.stats.distributions.Gaussian = Gaussian(0.0, 1.0)
  val X = new DenseMatrix(1000, 5, gau.sample(5000).toArray)
                                                  //> X  : breeze.linalg.DenseMatrix[Double] = 0.7439617220289693     1.2867140650
                                                  //| 868243     ... (5 total)
                                                  //| 0.3369589515633971     0.70869630546839       ...
                                                  //| -0.14993478567298915   -0.31374392208850715   ...
                                                  //| 0.36446098843954083    -1.5723739551615123    ...
                                                  //| 0.7512499127338763     -0.09546080620820357   ...
                                                  //| -0.3281806455605599    1.1487346146394253     ...
                                                  //| 1.0408697299314067     -0.5508419585282808    ...
                                                  //| 1.0621887091200486     -1.4182466485995266    ...
                                                  //| 0.3579449328019267     -0.23518967938244426   ...
                                                  //| 0.7126334350518776     2.1189574152925883     ...
                                                  //| -0.37005093808186024   0.677897625865663      ...
                                                  //| 0.3910595351022247     -0.972940856779964     ...
                                                  //| 1.7526513948337163     0.7379809490588441     ...
                                                  //| -2.3410647903293387    -0.07776747334415027   ...
                                                  //| 0.16482961937520116    0.7334995593220149     ...
                                                  //| 1.1055375760941066     -0.6801319407250598    ...
                                                  //| -0.7502450176055273    -0.5851454607704991    ...
                                                  //| 1.2382686337351874    
                                                  //| Output exceeds cutoff limit.
  println("X dim: " + (X.rows, X.cols))           //> X dim: (1000,5)
  val b0 = linspace(1.0, 2.0, 5)                  //> b0  : breeze.linalg.DenseVector[Double] = DenseVector(1.0, 1.25, 1.5, 1.75, 
                                                  //| 2.0)
  println("\nb0 length: " + b0.length)            //> 
                                                  //| b0 length: 5
  val y0 = X * b0                                 //> Jul 19, 2014 11:10:58 AM com.github.fommil.netlib.BLAS <clinit>
                                                  //| WARNING: Failed to load implementation from: com.github.fommil.netlib.Native
                                                  //| SystemBLAS
                                                  //| Jul 19, 2014 11:10:58 AM com.github.fommil.netlib.BLAS <clinit>
                                                  //| WARNING: Failed to load implementation from: com.github.fommil.netlib.Native
                                                  //| RefBLAS
                                                  //| y0  : breeze.linalg.DenseVector[Double] = DenseVector(7.961139634329593, 3.5
                                                  //| 11328339358215, -0.9386541064088153, 0.07034426239133063, -0.979800204803991
                                                  //| 8, -1.3768812412240417, -0.48017748943057526, -1.892931384234537, -0.7212508
                                                  //| 69372859, 6.082052785019662, 0.10021526130746783, 1.3466840582774857, 1.8977
                                                  //| 86756912005, -2.0428732279740647, 1.8999552286912418, 2.386521807866349, -3.
                                                  //| 8177997467086624, 4.514472700363436, -1.015734283879383, -1.0917550794300488
                                                  //| , -2.5183108187416843, 3.3445226488469126, -0.2572780645696273, -0.132058568
                                                  //| 03440508, 3.0946345671659428, 0.7527898785742795, 1.410712179196541, 3.80440
                                                  //| 78780453408, -3.8097447
                                                  //| Output exceeds cutoff limit.
  
  println("\ny0 length: " + y0.length)            //> 
                                                  //| y0 length: 1000
	val y = y0 + DenseVector(gau.sample(1000).toArray)
                                                  //> y  : breeze.linalg.DenseVector[Double] = DenseVector(8.495546974226855, 1.60
                                                  //| 90434040631691, 0.5049195799299958, 0.017454200204195622, -1.356660702979271
                                                  //| , -2.5258143683975325, 0.7433984712255384, -0.46908179655457527, 1.461342566
                                                  //| 8649627, 5.61539681797072, 0.3558362803250042, 1.6401063404009584, 2.8105986
                                                  //| 72903318, -2.319954667344258, 3.8447186180244395, 2.6465952638048265, -2.828
                                                  //| 1730431022964, 4.672372943752095, -1.7564565591043277, -0.7062257327373981, 
                                                  //| -0.9812774218971703, 2.7213186661667197, -0.6755985354945129, 0.345747494667
                                                  //| 2395, 3.8563606889789637, 1.6385354864595256, 2.580841042760926, 3.309328928
                                                  //| 995565, -3.71619998636585, -1.3431645806382673, -2.8536681857432997, -3.4402
                                                  //| 18754440621, 2.163750061876705, 2.976077799107262, 1.6614426177115604, -2.53
                                                  //| 8454266653919, 1.9810896586757114, -1.0633494750824168, -3.3266687579224294,
                                                  //|  5.819422830790614, -2.307234846318564, 2.134975130835314, -4.65864060710859
                                                  //| 7, 0.8225374834180639, 3
                                                  //| Output exceeds cutoff limit.
	
	println("\ny length: " + y.length)        //> 
                                                  //| y length: 1000
  // QR solver
  // /Users/hieronymus/Development/Machine Learning/ML/Using a QR Decomposition to Solve Linear Systems.pdf
  val b = X \ y                                   //> Jul 19, 2014 11:10:58 AM com.github.fommil.netlib.LAPACK <clinit>
                                                  //| WARNING: Failed to load implementation from: com.github.fommil.netlib.Native
                                                  //| SystemLAPACK
                                                  //| Jul 19, 2014 11:10:58 AM com.github.fommil.netlib.LAPACK <clinit>
                                                  //| WARNING: Failed to load implementation from: com.github.fommil.netlib.Native
                                                  //| RefLAPACK
                                                  //| b  : breeze.linalg.DenseVector[Double] = DenseVector(0.9807501540179859, 1.2
                                                  //| 33165244864526, 1.5461623506042617, 1.7203551053825539, 2.0405911040376927)
  println("\nb length: " + b.length)              //> 
                                                  //| b length: 5
}