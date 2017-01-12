# --- !Ups

CREATE TABLE language (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  code VARCHAR(31) NOT NULL
);

CREATE TABLE word (
  id SERIAL PRIMARY KEY,
  language_id INTEGER NOT NULL REFERENCES language(id),
  value VARCHAR(255)
);

CREATE TABLE word_set (
  id SERIAL PRIMARY KEY,
  title VARCHAR(255) NOT NULL
);

CREATE TABLE word_association (
  id SERIAL PRIMARY KEY,
  word_set_id INTEGER NOT NULL REFERENCES word_set(id)
);

CREATE TABLE word_association_to_word (
  word_association_id INTEGER NOT NULL REFERENCES word_association(id),
  word_id INTEGER NOT NULL REFERENCES word(id)
);

# --- !Downs

DROP TABLE word_association_to_word;
DROP TABLE word_association;
DROP TABLE word_set;
DROP TABLE word;
DROP TABLE language;
