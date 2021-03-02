import 'package:quiz/question.dart';

class Questions {
  List<Question> questionBank = [
    Question(
      questionText: "NMIT is located in Bengaluru",
      answer: true,
    ),
    Question(
      questionText: "Are you studying at NMIT",
      answer: true,
    ),
    Question(
      questionText: "Bangalore is located in J&K",
      answer: false,
    ),
    Question(
      questionText: "Current year is 2020",
      answer: false,
    )
  ];
}
