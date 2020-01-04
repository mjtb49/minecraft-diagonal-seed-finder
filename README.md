# minecraft-diagonal-seed-finder
Finds Minecraft 1.15 seeds which make the decorations in nearby chunks repeat.

## Building and Running
As this code is just a single `.java` file, you should be able to build with this line.
```sh
$ javac SeedFinder.java
```
You can run it with this line.
```sh
$ java SeedFinder > out.txt
```
This should produce the output in a file called `out.txt`.

The output file is also already precomputed and included in the repository, in case you just want the seeds without running the code.

## Output Format
Each line of the output has a seed, then the direction that the seed's decorator repeats. Due to the way the code searches for seeds, the only directions produced will be `-1 1` and `1 1`.

Because of the way minecraft seeds the game, all seeds that have the same least significant 48 bits have the same decorator behavior. This code only outputs seeds from 0 <= x < 2^48, so if you need more seeds with the same decorator properties, you can use other 64 bit numbers that have the same least significant 64 bits as any of the seeds in `out.txt`.
