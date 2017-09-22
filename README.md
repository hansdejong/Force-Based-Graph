# Force Based Graph
## A Scala.js program

This repository started out by cloning the [Scala.js tutorial](http://www.scala-js.org/doc/tutorial.html), and also contains some exercises following the [Hands-on Scala.js](http://www.lihaoyi.com/hands-on-scala-js/) tutorial by Li Haoyi.

But then I started porting an Java-applet I once made, so that is the main application it has grown into. You can see it working here, [FBG](http://hansdejong.github.io/statics/fbg/fbg.html), on my [blog](http://hansdejong.github.io/).<br>
The inspiration for the FBG came from this [blog](http://blog.ivank.net/force-based-graph-drawing-in-as3.html).


Of course it is scala code (you cannot mix Scala and Java as in JVM-Scala), but I  started by using a [Java to Scala converter](http://javatoscala.com/). Then I tried to make it more scala-ish.

It is my first serious Scala.js experience, and my main conclusion is that it can be used very well to make applet-like programs.<br>
In my opinion the value of easy browser-deployable GUI´s for Java and Scala is underestimated. The Java-applet occupied a very important niche for small applications exposing all kinds of creative and intellectual ideas, but now it is essentially killed for security reasons.

Most Scala(-js) tutorials are focussing on big web applications with server- and client side code. They also use nice but complicating tooling. But I experienced Scala.js (once setup, because that´s not really easy) as a lightweigt programming environment. I did not use jQuery, Node.js or Li Haoyi´s local webserver or Scalatags. Scala.js can fill the now empty Java-applet niche, but it requires programming in pure Scala.

My plan now is to port parts of a GA-program (genetic algorithm) I once made in Java.



For the GUI I used [webix](https://webix.com/tutorials/).
