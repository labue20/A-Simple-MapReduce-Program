# A-Simple-MapReduce-Program

**_Course Project for CS4348 - Operating System Concepts Summer 2019_**
**_University of Texas at Dallas_**

This program implement a simple word count program using map-reduce programming paradigm without using the Hadoop framework.

In this programming assignment, you will implement a simple word count program using map-reduce programming paradigm. You are not supposed to use an existing map-reduce framework (e.g. Hadoop).Instead, this project is intended to make you exercise your operating system skills by directly implementing this special case. More concretely, you will implement all the components of a real map-reduce framework,but specializing the components simplifies the problems and make them more manageable (and doable in a few days).

The program is broken down into ;

1. ## Driver
      A driver program runs 4 instances of splitter program to read 4 quarters of the file. The contents of each quarter is piped to another program called stemmer. Stemmer shall tokenize each chunk and remove stop words1. The output of stemmer should be piped to mappers. Each mapper tokenizes their input data into words and adds a 1 to each words (e.g., given the stemmed string “operating systems class,” the mapper shall produce “operating 1,systems 1,class 1”). 
      
2. ## Splitter
      Splitter receives 3 arguments from the command-line: (1) the name of the text file to read; (2) the total size of the file, in terms of the number of lines; (3) the quarter number N. The file simply reads the Nth quarter of the file and prints it on the standard output.

3. ## Stemmer
      Stemmer reads several lines from standard input, tokenizes the lines into words and removes stop words (words like “and”, “the”, “so”, and so on). Stemmed words are printed on standard output. Java programmers can use the method split of class String to tokenize lines into words.
      
4. ## Mapper
      Mapper is responsible for creating key-value pairs. It does so by reading lines from standard input, tokenizing the lines into words, and constructing key-value pairs by concatenating each word with the value 1. Mapper is supposed to print each key-value pair on standard output, each pair is separated by comma. You can also directly send these data to the reducer process (using socket programming). You need to know the IP address running reducer process and the port on which the reducer process listens

5. ## Reducer
6. ## Sender
