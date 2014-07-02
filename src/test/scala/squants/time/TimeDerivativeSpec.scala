/*                                                                      *\
** Squants                                                              **
**                                                                      **
** Scala Quantities and Units of Measure Library and DSL                **
** (c) 2013-2014, Gary Keorkunian                                       **
**                                                                      **
\*                                                                      */

package squants.time

import org.scalatest.{ Matchers, FlatSpec }
import squants.motion.UsMilesPerHour
import squants.space.UsMiles
import squants.CustomMatchers
import scala.language.postfixOps

/**
 * @author  garyKeorkunian
 * @since   0.1
 *
 */
class TimeDerivativeSpec extends FlatSpec with Matchers with CustomMatchers {

  behavior of "Time Derivatives and Integrals as implemented in Distance and Velocity"

  it should "satisfy Derivative = Integral / Time" in {
    implicit val tolerance = UsMilesPerHour(0.0000000000001)
    println(UsMilesPerHour(55))
    println(UsMiles(55) / Hours(1) toUsMilesPerHour)
    UsMilesPerHour(55) should beApproximately(UsMiles(55) / Hours(1))
  }

  it should "satisfy Integral = Derivative * Time" in {
    implicit val tolerance = UsMiles(0.0000000000001)
    UsMiles(110) should beApproximately(UsMilesPerHour(55) * Hours(2))
    UsMiles(110) should beApproximately(Hours(2) * UsMilesPerHour(55))
  }

  it should "satisfy Time = Integral / Derivative" in {
    implicit val tolerance = Hours(0.0000000000001)
    Hours(2) should beApproximately(UsMiles(110) / UsMilesPerHour(55))
  }
}
