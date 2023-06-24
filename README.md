# Project for automatons study / Projeto para estudo de automatos

Hello this is a project to reimplement college projects that i havent touched a while to recapitulate some stuff and have fun.

Olá, este é uma reimplementação de um projeto que fiz na faculdade, para passar um pouco do tempo me divertindo e recapitular alguns conceitos 😄

## Project Description / Descrição do projeto

### Deterministic Finite Automaton

The automatons in this project are based on deterministic finite automaton(dfa), push-down automatons(pda) and turing machines(tm), and it is an algorithms for a finite-state machine that accepts or rejects a given string of symbols.

The notation used for dfa in this project is like the following:

M (Q, Σ, δ, s, F )

Where:

◽ Q = all states the machine have;

◽ Σ = alphabet accepted by the automaton;

◽ δ = is the machine state transition, with the form of( actual state, next state, char. );

◽ s = the machine initial state;

◽ F = all the final states accepted by the machine;

---

### Automato Deterministico Finito

O autômato finito é composto de estados, que correspondem à memória do autômato,
há um alfabeto, que são os caracteres que representam as entradas do autômatos, e
com elas, o autômato irá testar uma cadeia, transições, que representam caminhos entre
os estados, e apresenta o estado para onde o autômato irá, e o caractere lido na entrada
do autômato, além de possuir o estado inicial, e os estados finais, estes últimos
indicando se a cadeia foi aceita ou não, e o primeiro, mostrando a configuração inicial do
autômato.

A notação usada para o autômato deterministico finito é da forma ,(Q, Σ, δ, s, F )M =
onde:

◽ Q = estados que o autômato possui;

◽ Σ = Alfabeto que o autômato aceita;

◽ δ = transições entre os estados, e possui, estado atual, próximo estado, e
caractere de leitura;

◽ s = estado inicial do autômato;

◽ F = conjunto de estados finais do autômato;

---

## Setup archives for the automaton

There is 3 different archives for the program, 2 inputs and 1 output.  
The input archives are the automaton setup file, and the string input tests for that automaton.  
The output file will have the results of the string inputs, step by step.

### Deterministic Finite Automaton setup file  

The automaton setup file have the following format:  
 ⚪ 1st line: all states separated by whitespace,  
 the first state is the initial state of the automaton,  
 and the final states are preceded by the * mark;  
 ⚪ 2nd line: the input alphabet that the automaton accepts.  
 ⚪ 3rd+ line: are the transitions for the automaton.  
 they have the format: (current state, character input, next state)

 example of an automaton:  

q0 *q1 q2 q3  
a b c d  
q0 a q1  
q1 b q2  
q2 c q3  
q3 c q3  
q3 d q0  

### The test input files  

they are character sequences and each test are separated by a break line.  
example of a test for the above automaton:  

abcdabc  
abdabcd

abcdabcccccda

---

## Arquivos de setup para o automaton

Há 3 tipos de arquivos necessários para rodar o programa, 2 arquivos de entrada e 1 de saida.  
Os arquivos de entrada são, o de setar o automato e para testar as entradas das cadeias de caracteres.  
O arquivos de saida conterá configuração dos automatos, assim como o resultado dos testes passo por passo.  

### Arquivo para setar o automato deterministico finito  

O arquivo para setar o automato terá o seguinte formato abaixo:  
 ⚪ primeira linha: todos os estados separados por um espaço,  
 o primeiro estado dessa linha será sempre o estado inicial,  
 e todos os estados finais deverão ser sinalizados com um *;  
 ⚪ segunda linha: contem o alfabeto aceito na entrada do automato.  
 ⚪ terceira linha em diante: aqui teremos todas as transições do automato.  
 As transicões terão o seguinte formato: (estado atual, caracter de entrada, próximo estado).

 exemplo para um automato de teste:  

q0 *q1 q2 q3  
a b c d  
q0 a q1  
q1 b q2  
q2 c q3  
q3 c q3  
q3 d q0  

### Arquivo de entrada para os testes  

O arquivo são simples sequencias de caracteres para cada teste, e cada teste é separado por uma quebra de linha.  
exemplo de teste para o automato acima:  

abcdabc  
abdabcd

abcdabcccccda

## Push-Down Automaton / Automaton de pilha

For the push-down automatons we are going to use the following notation:

◽ Q = set of states

◽ ∑ = set of input symbols

◽ Γ = set of pushdown symbols (which can be pushed and popped from stack)

◽ q0 = initial state

◽ Z = initial pushdown symbol (which is initially present in stack) -- for this project all initial pushdown symbol will be "^"

◽ F = set of final states

◽ δ = transition function which maps Q x {Σ ∪ ∈} x Γ into Q x Γ*. In a given state, PDA will read input symbol and stack symbol (top of the stack) and move to a new state and change the symbol of stack.

## About the project / Sobre projeto

This project will only use base java tools.

Este projeto apenas utilizará java tools básicos para sua contrução.
