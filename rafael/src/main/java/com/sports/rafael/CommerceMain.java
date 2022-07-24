package com.sports.rafael;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

/**
 * Replace comments marked as <code>{N}</code> placeholders with proper functions and implementation.
 * <p>
 * <b>Note:</b><ul>
 * <li>no overhead, most of them expect just proper function name or could be implemented in 1-2 lines</li>
 * <li>try to follow functional style where it gives benefits (in your opinion)</li>
 * <li>no additional libraries/dependencies expected, only native JDK functions</li></ul>
 */
public class CommerceMain {
    public static void main(final String[] args) throws ExecutionException, InterruptedException {
        final CompletionStage<Void/* {7} What type could be here?*/> twoJokesAsync =
                getTwoJokes().thenAccept(twoJokes -> System.out.println(twoJokes));
        twoJokesAsync.toCompletableFuture().get();
                //.(twoJokes -> System.out.println(twoJokes)/* {6} print each joke*/);
        /* {8} block application exit until the jokes are fetched and printed*/
    }
    private static CompletionStage<List<String>> getTwoJokes() {
        final CompletionStage<String> firstJokeAsync = CompletableFuture.supplyAsync(() -> getChuckNorrisJoke());
                //CompletableFuture.completedStage(getChuckNorrisJoke());
                /* {1} create async completion stage calling getChuckNorrisJoke)*/;
        final CompletionStage<String> secondJokeAsync = CompletableFuture.supplyAsync(() -> getChuckNorrisJoke());
                /* {2} create async completion stage calling getChuckNorrisJoke)*/;
        return firstJokeAsync.thenCombine(secondJokeAsync, (x,y) -> Arrays.asList(x, y));
        /* {3} combine two stages to one*/
        /* {4} aggregate two string jokes to list of jokes*/
    }
    /**
     * (<b>Slow</b>) thread blocking function to return a Chuck Norris joke.
     * <p>
     * <b>DON'T CHANGE THIS METHOD</b>
     *
     * @return random Chuck Norris joke after (<b>slow</b>) URL request.
     */
    private static String getChuckNorrisJoke() {
        try {
            HttpURLConnection con = (HttpURLConnection) new URL("http://api.icndb.com/jokes/random").openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();
            return response.toString();
        } catch (IOException e) {
            throw new IllegalStateException("Something is wrong: ", e);
        }
    }
}
