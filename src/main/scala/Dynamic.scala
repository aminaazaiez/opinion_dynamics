/*
 * Copyright (C) 2021 Romain Reuillon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import scala.util.Random
import better.files.*

def test = "test"




@main def dynamic(network: String) =
  val random = new Random(42)


  val mu = 0.4
  val d = 0.2

  val networkFile = File(network)
  val nbNodes = networkFile.lines.head.toInt

   val nodes: Array[Double] = Array.fill(nbNodes)(random.nextDouble())

   type Link = Array[Int]
 //
//  //val links: Array[Array[Int]] = Array.fill(300)(Array.fill(2)(random.nextInt(nbNodes)))
//  val links: Array[Link] = Array.fill(300) {
//    Array.fill(2)(random.nextInt(nbNodes))
//  }

  val links =
    networkFile.lines.drop(1).map { l =>
      l.split(",").map(_.toInt).toArray
    }.toArray

  //val begin = System.currentTimeMillis()

  for
    s <- 0 until 10
  do
    val l = links(random.nextInt(links.length))
    val i = l(0)
    val j = l(1)

    val xi = nodes(i)
    val xj = nodes(j)

    if
      math.abs(xi - xj) < d
    then
      nodes(i) = xi + mu * (xj - xi)
      nodes(j) = xj + mu * (xi - xj)

  //println(System.currentTimeMillis() - begin)

  nodes