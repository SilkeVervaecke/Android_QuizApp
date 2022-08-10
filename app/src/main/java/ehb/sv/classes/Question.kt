package ehb.sv.classes

class QuestAndAnswer (val question: String){

}


enum class Category (val strng: String, val number: Int){
    ANY("Any Category", 0),
    GEN("General Knowledge", 9),
    BOOK("Entertainment: Books", 10),
    FILM("Entertainment: Film", 11),
    MUSIC("Entertainment: Music", 12),
    THEATRE("Entertainment: Musicals & Theatres", 13),
    TV("Entertainment: Television", 14),
    VIDGAME("Entertainment: Video Games", 15),
    BOARDGAME("Entertainment: Board Games", 16),
    SCIENSE("Science & Nature", 17),
    COMPUTER("Science: Computers", 18),
    MATH("Science: Mathematics", 19),
    MYTH("Mythology", 20),
    SPORT("Sports", 21),
    GEO("Geography", 22),
    HISTORY("History", 23),
    POLITIC("Politics", 24),
    ART("Art", 25),
    CELEB("Celebrities", 26),
    ANIMAL("Animals", 27),
    VEHICLE("Vehicles", 28),
    COMICS("Entertainment: Comics", 29),
    GADGET("Science: Gadgets", 30),
    ANIME("Entertainment: Japanese Anime & Manga", 31),
    CARTOON("Entertainment: Cartoon & Animations", 32)
}

enum class Type (val strng: String){
    MULTIPLE("multiple"),
    BOOLEAN("boolean")
}

enum class Difficulty (val strng: String){
    EASY("easy"),
    MEDIUM("medium"),
    HARD("hard")
}

class apiAnswer(var category: Category, var type: Type, var difficulty: Difficulty,
                var question: String, var correct_answer: String,
                var incorrect_answers: List<String>){
//    val category: Category
//    val type: Type
//            "multiple",
//    val difficulty :
////            "medium",
//    val question :
////            "What is the fourth book of the Old Testament?",
//    val correct_answer :
////            "Numbers",
//    val incorrect_answers
//    : [    "Genesis",    "Exodus",    "Leviticus"    ]
}