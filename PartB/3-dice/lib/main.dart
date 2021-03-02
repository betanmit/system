import 'dart:math';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  int diceOneValue = 1;
  int diceTwoValue = 1;

  void changeDiceFace() {
    setState(() {
      diceOneValue = Random().nextInt(6) + 1;
      diceTwoValue = Random().nextInt(6) + 1;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        theme: ThemeData(canvasColor: Colors.black),
        home: SafeArea(
          child: Scaffold(
            body: Center(
              child: Padding(
                padding: const EdgeInsets.all(8.0),
                child: Row(
                  children: [
                    Expanded(
                        child: FlatButton(
                      child: Image.asset('assets/images/dice$diceOneValue.png'),
                      onPressed: () {
                        print("Dice 1 is pressed");
                        changeDiceFace();
                      },
                    )),
                    SizedBox(
                      width: 10,
                    ),
                    Expanded(
                        child: FlatButton(
                      child: Image.asset("assets/images/dice$diceTwoValue.png"),
                      onPressed: () {
                        print("Dice 2 is pressed");
                        changeDiceFace();
                      },
                    )),
                  ],
                ),
              ),
            ),
          ),
        ));
  }
}
