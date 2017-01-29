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

(defn -main
  "Find anigrams"
  [& args]
  (def mungm  (loop [mungm {}
                     keys (->> args
                               first
                               slurp
                               clojure.string/split-lines 
                               (map filter-non-letter)
                               (map apply-str))]
                (if (empty? keys) mungm
                    (recur
                       (let [key (first keys)]
                         (assoc mungm (mung key) key))
                       (rest keys))
                    )))
  (println (map second  (filter #(= (mung (second args)) (first %)) mungm))))
