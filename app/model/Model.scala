package model

/**
  * Created by hunter on 14/12/2016.
  */
object Model {
  case class Language(id: Int, name: String, code: String)

  case class Word(id: Integer, value: String, language: Language)

  case class WordSet(id: Integer, title: String)

  case class WordAssociation(id: Integer, words: Set[Word], wordSet: WordSet)

  // legacy below

  type Vocabulary = Set[WordAssociation]

  val english = Language(-1, "English", "en")
  val russian = Language(-2, "Russian", "ru")
}
