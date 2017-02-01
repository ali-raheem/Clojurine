(ns clojurine.core
  (:gen-class))

(defn filter-non-letter
  "Filter words removing characters which aren't letter, uses Java's isLetter"
  [x]
  (filter #(Character/isLetter %) x))

(defn apply-str
  "Lazy-seq of chars to string"
  [lazy-chars]
  (apply str lazy-chars))

(defn mung
  "mung the word to produce a key, alphabetaical"
  [w]
;;Todo all to lowercase
  (->> w
       sort
       apply-str
       .toLowerCase))

(defn get-words
  "Read wordlist into vector."
  [wordfile]
  (->> wordfile
       slurp
       clojure.string/split-lines))

(defn add-match
  "Returns function which takes vector and test word add if match."
  [word]
  (let [munged-word (mung word)] 
    (fn [matches match-word]
      (if (= munged-word (mung match-word))
        (conj matches match-word)
        matches))))

(defn find-match
  [words key]
  (let [matcher (add-match key)]
    (reduce matcher [] words)))

(defn -main
  "Find anigrams first argument wordfile second argument letters"
  [& args]
  (let [words (get-words (first args))
        key (second args)]
    (println (find-match words key))))
