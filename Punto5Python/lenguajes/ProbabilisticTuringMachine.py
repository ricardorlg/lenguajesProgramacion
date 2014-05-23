'''
Created on 23/05/2014

@author: usuario4
'''
from lenguajes.Tape import Tape
import random
class ProbabilisticTuringMachine(object):
    def __init__(self,
                 tape="",
                 blank_symbol=" ",
                 tape_alphabet=["0", "1"],
                 initial_state="",
                 accepting_states=[],
                 final_states=[],
                 transition_functions=[]):
        self.__tape = Tape(blank_symbol, tape)
        self.__head_position = 0
        self.__blank_symbol = blank_symbol
        self.__current_state = initial_state
        self.__transition_functions = transition_functions
        self.__tape_alphabet = tape_alphabet
        self.__final_states = final_states
        
    def show_tape(self): 
        print(self.__tape)
        return True
    
    def step(self):
        char_under_head = self.__tape[self.__head_position]
        funciones = self.getFunciones(char_under_head)
        if funciones:
            x = self.getFunctionBasedOnProb(funciones)
            self.__tape[self.__head_position] = x._symbolToWrite
            self.__head_position += x._moveDirection
            self.__current_state = x._nextState
            
    def getFunciones(self, char_under_head):
        resultado = []
        for f in self.__transition_functions:
            if f._originState == self.__current_state and f._originSymbol == char_under_head:
                resultado.append(f)
        return resultado
    
    def getFunctionBasedOnProb(self, funciones):
        r = random.random()
        cumulative = 0.0
        for candidate in funciones:
            cumulative += candidate._probability
            if(r <= cumulative):
                return candidate
        return 
                
    def printState(self):
        print(self.__current_state)
          
        

    def final(self):
        if self.__current_state in self.__final_states:
            return True
        else:
            return False
