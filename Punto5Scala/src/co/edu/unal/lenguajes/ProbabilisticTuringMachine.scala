package co.edu.unal.lenguajes
import scala.collection.mutable.{ HashMap, MultiMap, Set, LinkedList }
class TuringMachine(private var input: String, private var state: String) {
  private val tape = new Tape(input)
  private val transition = new HashMap[(String, Char), Set[(String, Char, Direction.Value, Double)]] with MultiMap[(String, Char), (String, Char, Direction.Value, Double)]

  def addRule(tuple: ((String, Char), (String, Char, Direction.Value, Double))) {
    transition.addBinding(tuple._1, tuple._2)
  }

  def execute(): String = {
    while (state != "ACCEPTED" && state != "REJECTED") {
      val value = tape.getValue
      var funciones = transition((state, value)).toList
      var f = getTransitionFunction(funciones)
      state = f._1
      tape.setValue(f._2)
      tape.move(f._3)
    }
    print(s"Estado final = $state")
    return state
  }
  def getTransitionFunction(funciones: List[(String, Char, Direction.Value, Double)]): (String, Char, Direction.Value, Double) = {
    val p = Math.random()
    var cumulativeProbability = 0.0
    var m = (a: (String, Char, Direction.Value, Double)) => {
      cumulativeProbability += a._4
      p <= cumulativeProbability
    }
    var s = funciones.find(m)
    s.getOrElse(null)
  }

}