-class))

(defn filter-non-letter [x]
  "Filter words removing characters which aren't letter, uses Java's isLetter"
  (filter #(Character/isLetter %) x))

(defn apply-str [l]
  "Lazy-seq of chars to string"
  (apply str l))

(defn mung [w]
  "mung the word to produce a key, alphabetaical"
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
  (let [mword (mung word)] 
    #(if (= mword (mung %2)) (conj % %2) %)))

(defn -main
  "Find anigrams"
  [& args]
  (println (let [key (second args)
                 wordfile (first args)
                 words (get-words wordfile)
                 matches []
                 matcher (find-match key)]
             (reduce matcher matches words))))
