## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

Hello this is a project to reimplement college projects that i havent touched a while to recapitulate some stuff and have fun.

Olá, este é uma reimplementação de um projeto que fiz na faculdade, para passar um pouco do tempo me divertindo e recapitular alguns conceitos 😄

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Project Description / Descrição do projeto

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

## About the project / Sobre projeto

This project will only use base java tools.

Este projeto apenas utilizará java tools básicos para sua contrução.
