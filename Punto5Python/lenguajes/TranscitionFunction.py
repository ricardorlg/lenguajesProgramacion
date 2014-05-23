'''
Created on 23/05/2014

@author: usuario4
'''

class TranscitionFunction(object):
    '''
    classdocs
    '''


    def __init__(self, originState,originSymbol,nextState,symbolWrite,moveDirection,probability):
        '''
        Constructor
        '''
        self._originState=originState
        self._originSymbol=originSymbol
        self._nextState=nextState
        self._symbolToWrite=symbolWrite
        self._moveDirection=moveDirection
        self._probability=probability
        
    
        