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
      | fat # толстый
      | thin # худой
      | snake # змея
    """.stripMargin

  val knownPairs2 =
    """
      | father # отец
      | mother # мать
      | sister # сестра
      | brother # брат
      | cousin # кузен, двоюродный брат, двоюродная сестра
      | nephew # племянник
      | niece # племянница
      | aunt # тетя
      | uncle # дядя
      | grandfather, granddad, grandpa # дедушка
      | grandmother, grandma # бабушка
      | stepfather # отчим
      | stepmother # мачеха
      | stepdaughter # падчерица
      | stepson # пасынок
      | mother-in-law # теща, свекровь
      | father-in-law # тесть, свекр
      | son-in-law # зять
      | daughter-in-law # невестка, сноха (жена сына)
      | brother-in-law # деверь, шурин
      | sister-in-law # золовка
      | ex-wife # бывшая жена
      | ex-husband # бывший муж
    """.stripMargin

  val knownPairs3 =
    """
      | my # мой
      | your # твой, ваш
      | his # его
      | her # её
      | its # его (неодушевленное), её (неодушевленное)
      | our # наш
      | their # их
      | retired # на пенсии
      | famous (be famous for) # известный
    """.stripMargin

  val knownPairs4 =
    """
      | angry # злой, сердитый
      | sad # грустный
      | happy # счастливый
      | thirsty # страдающий от жажды
      | tired # усталый, уставший
      | hungry # голодный
      | again # снова
      | short # короткий
      | half # половина
      | an so on # и так далее
      | try # пытаться, пробовать
    """.stripMargin

  lazy val vocabulary = Set(knownPairs, knownPairs2, knownPairs3, knownPairs4)
    .flatMap(p => parseVocabulary(p, english, russian))

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
