'''
Created on 23/05/2014

@author: usuario4
'''

class Tape(object):
    
    blank_symbol = ""
    def __init__(self, blanck, input2=""):
        self.__tape = {}
        self.blank_symbol = blanck
        for i in range(len(input2)):
            self.__tape[i] = input2[i]
        
    def __str__(self):
        s = ""
        min_used_index = min(self.__tape.keys()) 
        max_used_index = max(self.__tape.keys())
        for i in range(min_used_index, max_used_index):
            s += self.__tape[i]
        return s    
    
   
    def __getitem__(self, index):
        if index in self.__tape:
            return self.__tape[index]
        else:
            return self.blank_symbol

    def __setitem__(self, pos, char):
        self.__tape[pos] = char 

        
