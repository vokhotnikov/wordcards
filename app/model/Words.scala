package model

import model.Model._

/**
  * Created by hunter on 14/12/2016.
  */
object Words {
  val knownPairs =
    """
      | safe # безопасный
      | dangerous # опасный
      | dirty # грязный
      | easy # легкий, легко, простой, просто
      | difficult # трудный, сложный
      | empty # пустой
      | full # полный
      | expensive # дорогой
      | cheap # дешевый
      | fast # быстрый
      | high # высокий
      | low # низкий
      | rich # богатый
      | poor # бедный
      | wet # мокрый
      | ugly # некрасивый, безобразный
      | lawyer # юрист
      | nurse # медсестра
      | waiter # официант
      | letter # буква
      | word # слово
      | sentence # предложение
      | I # я
      | you # ты, вы
      | he # он
      | she # она
      | it # это
      | we # мы
      | they # они
      | where # где
      | there # там
      | here # здесь
      | when # когда
      | then # тогда
      | never # никогда
      | often # часто
      | rarely # редко
      | who # кто
      | what # что
      | why # почему
      | than # чем
      | how # как
      | how many # сколько (исчислимое)
      | how much # сколько (неисчислимое)
      | same # такой же
      | other # другой
    """.stripMargin

  lazy val vocabulary = parseVocabulary(knownPairs, english, russian)

  def parseVocabulary(rawPairs: String, firstLanguage: Language, secondLanguage: Language): Vocabulary = {
    def parseWord(raw: String, language: Language): Set[Word] = {
      raw.split(',').map(w => Word(w.trim, language)).toSet
    }

    rawPairs.trim.split("\r\n".toArray).filter(_.trim.nonEmpty).map { s =>
      val parts = s.split('#')
      WordAssociation(parseWord(parts(0), firstLanguage) ++ parseWord(parts(1), secondLanguage))
    }.toSet
  }
}
