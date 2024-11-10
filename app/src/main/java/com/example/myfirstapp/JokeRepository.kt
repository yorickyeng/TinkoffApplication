package com.example.myfirstapp

class JokeRepository {
    fun getInitialJokes(): List<Joke> {
        return listOf(
            Joke(
                "Christmas",
                "What does Santa suffer from if he gets stuck in a chimney?",
                "Claustrophobia!",
                1
            ),
            Joke("Math", "What’s a math teacher’s favorite place in NYC?", "Times Square.", 2),
            Joke("Animals", "What do you call a fish wearing a bowtie?", "Sofishticated.", 3),
            Joke(
                "Tech",
                "What was the spider doing on the computer?",
                "He was making a web-site.",
                4
            ),
            Joke(
                "School",
                "Why did the student bring a ladder to school?",
                "Because he wanted to go to high school.",
                5
            ),
            Joke(
                "Science",
                "Why did the biologist break up with the physicist?",
                "There was no chemistry.",
                6
            ),
            Joke("Food", "What do you call cheese that isn’t yours?", "Nacho cheese.", 7)
        )
    }

    fun getUpdatedJokes(): List<Joke> {
        return listOf(
            Joke(
                "Christmas",
                "What does Santa suffer from if he gets stuck in a chimney?",
                "Claustrophobia!",
                1
            ),
            Joke("Animal", "Why did the chicken join a band?", "Because it had the drumsticks!", 2),
            Joke(
                "What",
                "Why did the scarecrow win an award?",
                "Because he was outstanding in his field!",
                3
            ),
            Joke("Food", "What do you call fake spaghetti?", " An impasta!", 5)
        )
    }
}