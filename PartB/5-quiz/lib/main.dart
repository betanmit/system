import 'package:flutter/material.dart';
import 'package:quiz/questions.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  int questionNumber = 0;
  int currentScore = 0;
  List<String> choice = [];
  Questions questions = Questions();
  void updateQuestionNumber() {
    setState(() {
      questionNumber = questionNumber + 1;
    });
  }

  void udpateCurrentScore(bool choice, int question_number) {
    if (questions.questionBank.length == question_number) {
      print("End of questions");
    } else {
      if (questions.questionBank[question_number].answer == choice) {
        setState(() {
          currentScore++;
        });
      }
    }
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: Container(
          width: double.infinity,
          margin: EdgeInsets.fromLTRB(20, 50, 20, 50),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: [
              Text(
            questionNumber < questions.questionBank.length ? questions.questionBank[questionNumber].questionText.toString() : "End of questions",
                style: TextStyle(fontSize: 30),
              ),
              Padding(
                padding: const EdgeInsets.all(8.0),
                child: RaisedButton(
                  onPressed: () {
                    if (questionNumber == questions.questionBank.length) {
                      print("End of questions");
                    } else {
                      setState(() {
                        choice.add("Question " + '${questionNumber + 1}:' + " true");
                      });
                      print("True pressed");
                      updateQuestionNumber();
                      udpateCurrentScore(true, questionNumber);
                    }
                  },
                  child: Text("True", style: TextStyle(fontSize: 20)),
                ),
              ),
              Padding(
                padding: const EdgeInsets.all(8.0),
                child: RaisedButton(
                  onPressed: () {
                    if (questionNumber == questions.questionBank.length) {
                      print("End of questions");
                    } else {
                      setState(() {
                        choice.add("Question " + '${questionNumber + 1}:' + " false");
                      });
                      // if (questions.questionBank.length < questionNumber) {
                      print("False pressed");
                      updateQuestionNumber();
                      udpateCurrentScore(false, questionNumber);
                    }
                  },
                  child: Text("False", style: TextStyle(fontSize: 20)),
                ),
              ),
              Padding(
                padding: const EdgeInsets.all(40.0),
                child: Center(
                  child: Text(
                    "Current Score is:",
                    style: TextStyle(fontSize: 30),
                  ),
                ),
              ),
              Padding(
                padding: const EdgeInsets.all(30.0),
                child: Center(
                  child: Text(
                    '${currentScore}',
                    style: TextStyle(fontSize: 30),
                  ),
                ),
              ),
              Padding(
                padding: const EdgeInsets.only(top: 20),
                child: Center(
                  child: Text(
                    "Your choices:",
                    style: TextStyle(fontSize: 30),
                  ),
                ),
              ),
              Expanded(
                child: Container(
                  child: ListView(
                    children: choice
                        .map((e) => Card(
                              elevation: 10,
                              child: ListTile(
                                title: Text(
                                  e.toString(),
                                ),
                              ),
                            ))
                        .toList(),
                  ),
                ),
              )
            ],
          ),
        ),
      ),
    );
  }
}
