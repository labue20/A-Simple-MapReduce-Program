# A-Simple-MapReduce-Program
This program implement a simple word count program using map-reduce programming paradigm without using the Hadoop framework

The program is broken down into ;

1. ## Driver
      A driver program runs 4 instances of splitter program to read 4 quarters of the file. The contents of each quarter is piped to another program called stemmer. Stemmer shall tokenize each chunk and remove stop words1. The output of stemmer should be piped to mappers. Each mapper tokenizes their input data into words and adds a 1 to each words (e.g., given the stemmed string “operating systems class,” the mapper shall produce “operating 1,systems 1,class 1”). 
2. ## Splitter
3. ## Stemmer
4. ## Mapper
5. ## Reducer
6. ## Sender
