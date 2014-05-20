package co.edu.unal.lenguajes

class Tape(input: String) {
  private val tape: Array[Char] = Array.fill(65536)('_')
  private var head: Int = 0
  for (i <- 0 until input.length) {
    tape(i) = input(i)
  }

  def getValue() = tape(head)
  def setValue(c: Char) = tape(head) = c
  def move(d: Direction.Value) = head += d.id
}