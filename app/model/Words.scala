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
      | married # женат
      | divorced # в разводе
    """.stripMargin

  var knownPairs2Opt =
    """
      | stepfather # отчим
      | stepmother # мачеха
      | stepdaughter # падчерица
      | stepson # пасынок
      | mother-in-law # теща, свекровь
      | father-in-law # тесть, свекр
      | son-in-law # зять
      | daughter-in-law # невестка, сноха, жена сына
      | brother-in-law # муж сестры, брат жены
      | sister-in-law # жена брата, сестра мужа
      | ex-wife # бывшая жена
      | ex-husband # бывший муж
    """.stripMargin

  val knownPairs3 =
    """
      | my # мой
      | your # твой, ваш
      | his # его
      | her # ее
      | its # его (неодушевленное), ее (неодушевленное), этот
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
      | thirsty # страдающий от жажды, испытывающий жажду
      | tired # усталый, уставший
      | hungry # голодный
      | again # снова
      | short # короткий
      | half # половина
      | and so on # и так далее
      | try # пытаться, пробовать
      | turn # поворот
      | turn on # включить
      | turn off # выключить
    """.stripMargin

  val knownPairs5 =
    """
      | both # оба
      | one more # еще один
      | again # снова
      | once more # еще раз
      | a lot (of) # много
      | things # вещи
      | hour # час
      | try # пробовать, пытаться
      | want # хотеть
      | drive # водить (машину)
      | study # учить
      | another # другой
      | wear # носить
    """.stripMargin

  val knownPairs6 =
    """
      | first # первый
      | second # второй
      | third # третий
      | fourth # четвертый
      | fifth # пятый
      | sixth # шестой
      | seventh # седьмой
      | eighth # восьмой
      | ninth # девятый
      | tenth # десятый
      | twentieth # двадцатый
      | thirtieth # тридцатый
      | Easter # пасха
      | Christmas # рождество
      | century # век
      | different # отличающийся
      | different hours # другое время
      | until # до
      | timetable # расписание
    """.stripMargin

  lazy val vocabulary = Set(knownPairs, knownPairs2, knownPairs3, knownPairs4, knownPairs5, knownPairs6)
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
