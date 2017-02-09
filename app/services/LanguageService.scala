package services

/**
  * Created by hunter on 08/02/2017.
  */
class LanguageService(dbService: DbService) {
  val english = dbService.languageForCode("en", "English")
  val russian = dbService.languageForCode("ru", "Russian")
}
