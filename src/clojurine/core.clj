(ns clojurine.core
  (:gen-class))

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
  [wordfile]
  (->> wordfile
       slurp
       clojure.string/split-lines))

(defn mung-map
  [wordlist]
  (loop [mungm {}
         keys (->> wordlist
                   (map filter-non-letter)
                   (map apply-str))]
    (if (empty? keys) mungm
        (recur
         (let [key (first keys)]
           (assoc mungm (mung key) key))
         (rest keys)))))

(defn -main
  "Find anigrams"
  [& args]
  (let [mungm (->> (first args)
                   get-words
                   mung-map)
        key (mung (second args))]
    (->> mungm
         (filter #(= key (first %)))
         (map second)
         println)))
