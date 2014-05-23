'''
Created on 23/05/2014

@author: usuario4
'''
from lenguajes.TranscitionFunction import TranscitionFunction
from lenguajes.ProbabilisticTuringMachine import ProbabilisticTuringMachine
if __name__ == '__main__':
    
    even = "even"
    odd = "odd"
    accepted = "accepted"
    rejected = "rejected"

    blank = "_"
    input2 = "110101"
    moveDirection = 1;
    d1 = TranscitionFunction(even, "0", even, "0", moveDirection, 0.9);
    d2 = TranscitionFunction(even, '0', odd, '0', moveDirection, 0.1);
    d3 = TranscitionFunction(even, '1', odd, '1', moveDirection, 0.9);
    d4 = TranscitionFunction(even, '1', even, '1', moveDirection, 0.1);
    d5 = TranscitionFunction(even, blank, accepted, blank, moveDirection, 1);
    d6 = TranscitionFunction(odd, '0', odd, '0', moveDirection, 0.9);
    d7 = TranscitionFunction(odd, '0', even, '0', moveDirection, 0.1);
    d8 = TranscitionFunction(odd, '1', even, '1', moveDirection, 0.9);
    d9 = TranscitionFunction(odd, '1', odd, '1', moveDirection, 0.1);
    d10 = TranscitionFunction(odd, blank, rejected, blank, moveDirection, 1);
    funciones = [d1, d2, d3, d4, d5, d6, d7, d8, d9, d10]

    ptm = ProbabilisticTuringMachine(input2, blank, ["0", "1"]   , even, [accepted, rejected], [accepted, rejected], funciones)



    while not ptm.final():
        ptm.step()

    print("Result of the Turing machine calculation:")    
    ptm.printState()
