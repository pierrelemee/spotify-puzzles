# spotify-puzzles

My contribution on the Spotify puzzles. I had fun coding it thank you guys! If you like what you've seen, you definitely
have to visit [my personal website](https://www.pierrelemee.fr)

## Installing

I used Java 8 (to take advantage of [lambdas](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html) 
and [streams](http://www.oracle.com/technetwork/articles/java/ma14-java-se-8-streams-2177646.html)) and built my project 
with Maven. To build, just run:

```
mvn package
```

If succesful, you should obtain an über jar file named `puzzles-1.1-SNAPSHOT.jar` (standalone jar containing all my code
and its required dependencies) in the `target/`directory.

To skip the (impressively verbose) unit tests run during packaging stage, you may use:
 
```
mvn -Dmaven.test.skip=true package
```

## Running

The application is CLI program that only requires one argument: the name of the puzzle to play.

Accepted values are:
- reversebinary
- zipfsong

### Reverse binary

To perform reverse binary based on suggested input, you can use the Shell wrapper script and the plain text sample files
(used for unit tests):

```
cd <path_to_projetc>
./puzles reversebinary < ./src/test/resources/reversebinary/sample1
```

### Zipfsong

To compute the Zipfsong's top based, run this:

```
cd <path_to_projetc>
./puzles zipfsong < ./src/test/resources/zipfsong/sample2
```

Or any other file / UNIX pipeline of your choice

### Cats vs. Dogs

To optimize the number of viewers for the Cats. vs Dogs TV show, it's as easy:

```
cd <path_to_projetc>
./puzles catsvsdogs < ./src/test/resources/catsvsdogs/sample1
```

Or any other file / UNIX pipeline of your choice
