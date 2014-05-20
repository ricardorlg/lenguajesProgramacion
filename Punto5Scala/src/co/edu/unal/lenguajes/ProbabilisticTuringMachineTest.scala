package co.edu.unal.lenguajes

object ProbabilisticTuringMachineTest extends App {
val ptm = new TuringMachine("1110", "even")
    ptm.addRule(("even", '0') -> ("even", '0', Direction.right, 1))
    ptm.addRule(("even", '1') -> ("odd", '1', Direction.right, 0.8))
    ptm.addRule(("even", '1') -> ("even", '1', Direction.right, 0.2))

    ptm.addRule(("even", '_') -> ("ACCEPTED", '_', Direction.right, 1))
    ptm.addRule(("odd", '0') -> ("odd", '0', Direction.right, 1))
    ptm.addRule(("odd", '1') -> ("even", '1', Direction.right, 1))
    ptm.addRule(("odd", '_') -> ("REJECTED", '_', Direction.right, 1))

    ptm.execute()
}