(ns clojurine.core
  (:gen-class))

(defn filter-non-letter
  "Filter words removing characters which aren't letter, uses Java's isLetter"
  [x]
  (filter #(Character/isLetter %) x))

(defn apply-str
  "Lazy-seq of chars to string"
  [l]
  (apply str l))

(defn mung
  "mung the word to produce a key, alphabetaical"
  [w]
;;Todo all to lowercase
  (apply-str (sort w)))

(defn get-words
  "Read wordlist into vector."
  [wordfile]
  (->> wordfile
       slurp
       clojure.string/split-lines))

(defn find-match
  "Returns function which takes vector and test word add if match."
  [word]
  (let [munged-word (mung word)] 
    #(if (= munged-word (mung %2)) (conj % %2) %)))

(defn -main
  "Find anigrams first argument wordfile second argument letters"
  [& args]
  (let [key (second args)
        wordfile (first args)
        words (get-words wordfile)
        matcher (find-match key)]
    (println (reduce matcher [] words))))
