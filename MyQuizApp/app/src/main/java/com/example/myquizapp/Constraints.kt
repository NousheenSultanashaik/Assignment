@file:Suppress("UNREACHABLE_CODE")

package com.example.myquizapp

object Constraints {
    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()
        val que1 = Question(1, "what is my fav color",
            "blue", "black", "pink", "brown", 2)
        questionList.add(que1)
        return questionList
        val que2 = Question(2, "Which is my fav season",
            "summer", "winter", "rainy", "spring", 3)
        questionList.add(que2)
        return questionList
        val que3 = Question(3,"Which is my fav place",
            "america","goa","manali","karnataka",3)
        questionList.add(que3)
        return questionList
        val que4 = Question(4,"what is my nick name",
            "zoya","bubu","dudu","nashu",2)
        questionList.add(que4)
        return questionList
        val que5 = Question(5,"what is my bestfriend name",
            "nikitha","martha","bubu","bhavani",1)
        questionList.add(que5)
        return questionList
        val que6 = Question(6,"what is my diploma collage name",
            "snist","kprit","kmit","tkr",4)
        questionList.add(que6)
        return questionList
        val que7 = Question(7,"which religion i belong to ",
            "hindu","muslim","indian","panjabi",3)
        questionList.add(que7)
        return questionList
        val que8 = Question(8,"which app i use the most",
            "instragram","facebook","imo","whatsapp",3)
        questionList.add(que8)
        return questionList
        val que9 = Question(9,"which cartoon i watch the most",
            "doremon","sinchan","horried henery","mr.bean",4)
        questionList.add(que9)
        return questionList
    }
}