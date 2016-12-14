package model

/**
  * Created by hunter on 14/12/2016.
  */
object Model {
  case class Language(name: String)

  val english = Language("English")
  val russian = Language("Russian")

  case class Word(value: String, language: Language)

  case class WordAssociation(words: Set[Word])

  type Vocabulary = Set[WordAssociation]
}
