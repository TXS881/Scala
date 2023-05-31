class StringCase {

  // This Function will change the character case of a string
      def swapCase(word: String): String = {
        if (word != null) {
          val swapped = word.map { case x if (x.isUpper) => x.toLower
                                   case y if (y.isLower) => y.toUpper
                                   case z if (!z.isLetterOrDigit) => z
                                  }
          swapped.mkString
        } else
        {
          null
        }
      }

  // it will does the title case of a string
      def titleCase(word:String)={
          if(word != null)
            {
              var title = word.split("\\s+")
                .map{case i if (i.nonEmpty) => i(0).toUpper+i.substring(1,i.length).toLowerCase}
                .mkString(" ")

              title
            }
          else null
      }

  // this will does capitalize to a string
      def capitalize(word:String)={
        var cap = word(0).toUpper+word.substring(1,word.length)
        cap
      }

  //it will filter all the letter or number from a string
      def getAlOrNum( word: String,arg: String=null): String = {
        val alpha = word.filter{case x if x.isLetter => true
                                case _ => false}.mkString
        val num = word.filter(_.isDigit).mkString
        val myChoice = arg match {
          case "alpha" => alpha
          case "num"   => num
          case  _      => null
        }
        myChoice
      }

  // check if the full string are either numeric or String
      def isAlphaNumeric(word:String)= {
        // for string
            var isAlpha:String=>Boolean = (str: String) =>
            {
              var flag = true
              word.foreach { i =>
                if (!i.isLetter) flag = false
                else flag
              }
              flag
            }
        // for numeric
              var isNumeric: String => Boolean = (str: String) => {
                var flag = true
                word.foreach { i =>
                  if (!i.isDigit) flag = false
                  else flag
                }
                flag
              }
            isAlpha(word)||isNumeric(word)
      }



  // extract either alphabets or numeric if length of any one is more
      def extractLongestAlphaNum(word:String):String=
      {
          var longAlNum = word.groupBy{case i if i.isLetter => "letter"
                                        case j if j.isDigit => "Digit"
                                        case _ => "other"}
          if(longAlNum.apply("letter").length >longAlNum.apply("Digit").length)
            longAlNum.apply("letter")
          else if(longAlNum.apply("letter").length ==longAlNum.apply("Digit").length)
            longAlNum.apply("letter")+" "+longAlNum.apply("Digit")
          else
            longAlNum.apply("Digit")
      }
}

object wordFunction
{
  def main(args:Array[String])=
    {
      val obj = new StringCase
      val result = obj.extractLongestAlphaNum("65878jsdjggfwjfwifh65461535465")
      println(result)
    }
}

