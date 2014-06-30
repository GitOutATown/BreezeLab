package com.aqume.breeze

import breeze.optimize.linear.LinearProgram
import breeze.linalg.DenseVector

object LinearProg_lab_1 extends App {
	val lp = new LinearProgram()
	import lp._
	
	val x0 = Real()
	val x1 = Real()
	val x2 = Real()
	
	val lpp = (   ( x0 +      x1 * 2 + x2 * 3       )
		subjectTo ( x0 * -1 + x1     + x2     <= 20 )
		subjectTo ( x0       -x1 * 3 + x2     <= 30 )
		subjectTo ( x0                        <= 40 )
	)
	
	val result = maximize(lpp)
	println(result.result)
	assert((result.result - DenseVector(40.0, 17.5, 42.5)).norm(2) < 1E-4)
}